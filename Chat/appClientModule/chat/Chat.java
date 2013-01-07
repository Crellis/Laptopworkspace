package chat;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.*;

/*
 * Craig Ellis
 * 02/11/11
 * Type Commands:
 *    /exit : close connection and exit
 *    /nickname xxxx : change user's name
 *    /join xxxx : change user's room
 */
public class Chat implements MessageListener
{
	private Destination currentDestination = null;
	private Session jmsSession;
	private Connection jmsConnection;
	private ConnectionFactory jmsConnectionFactory = null;
	private MessageConsumer jmsConsumer;
	private MessageProducer jmsProducer;
	private TextMessage jmsMessage;

	private String nickname = null;

	public Chat()
	{
		createSession();
		try
		{
			nickname = jmsConnection.getClientID();
		} catch (Exception e) {}
	}

	public void onMessage(Message message)
	{
		try
		{
			if (! (message instanceof TextMessage) )
			{
				System.out.println("onMessage() received an unhandled: " + message.getClass().getName());
			}
			TextMessage textMessage = (TextMessage) message;
			System.out.println(textMessage.getText());
		}
		catch (Throwable t)
		{
			System.err.println((t instanceof JMSException) ? "JMSException" : "Throwable" + " Caught in onMessage(): " + t.getMessage());
		}
	}

	private void createSession()
	{
		try
		{
			Context jndiContext = null;

			try
			{
				jndiContext = new InitialContext();
			}
			catch (NamingException e)
			{
				System.out.println("Could not create JNDI API context: " + e.toString());
				System.exit(1);
			}

			try
			{
				jmsConnectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");
			}
			catch (Exception e)
			{
				System.out.println("Connection: JNDI API lookup failed: " + e.toString());
				e.printStackTrace();
				System.exit(1);
			}

			jmsConnection = jmsConnectionFactory.createConnection();

			// create a session
			this.jmsSession = jmsConnection.createSession(
					false /* not transacted */, Session.AUTO_ACKNOWLEDGE);

			joinRoom("public");

			// to start a connection
			jmsConnection.start();

			jmsMessage = jmsSession.createTextMessage();

		}
		catch (JMSException ex)
		{
			System.out.println("Error running program");
			ex.printStackTrace();
		}
	}

	private void joinRoom(String room)
	{
		// prefix all room's name with chat.
		room = "chat." + room;

		if (currentDestination != null)
		{
			try
			{
				jmsConsumer.close();
				jmsProducer.close();
			}
			catch (Exception e)
			{
			}
		}
		try
		{
			currentDestination = jmsSession.createTopic(room);

			jmsConsumer = jmsSession.createConsumer(currentDestination);
			jmsConsumer.setMessageListener(this); 			

			// create a producer
			jmsProducer = jmsSession.createProducer(currentDestination);
		}
		catch (Exception e)
		{
		}
	}

	private void sendMsg(String msg)
	{
		try
		{
			jmsMessage.setText(nickname+": "+ msg);
			jmsProducer.send(jmsMessage);
		}
		catch (JMSException ex)
		{
			System.out.println("Error running program");
			ex.printStackTrace();
		}
	}

	public void start() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true)
		{
			String str;
			try
			{
				str = in.readLine();
			}
			catch (IOException e)
			{
				break;
			}

			if (str.isEmpty())
				continue;

			if (str.equalsIgnoreCase("/exit"))
				break;
			if (str.startsWith("/nick"))
			{
				String tmp = str.substring(6);
				str = "was known as " + nickname;
				nickname = tmp;
			}
			if (str.startsWith("/join"))
			{
				sendMsg("is leaving this room...");
				joinRoom(str.substring(6));
				str = "is entering this room...";
			}
			sendMsg(str);
		}
	}

	private void closeSession()
	{
		try
		{
			jmsSession.close();
			jmsConnection.close();
		} catch (JMSException ex) {
			System.out.println("Error running program");
			ex.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		Chat client = new Chat();
		client.start();
		client.closeSession();
	}
}