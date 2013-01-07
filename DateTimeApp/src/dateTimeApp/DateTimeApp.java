package dateTimeApp;

import java.util.Date;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class DateTimeApp extends MIDlet {
	
	Alert timeAlert;
	
	public DateTimeApp() {
		timeAlert = new Alert("Alert!");
		timeAlert.setString(new Date().toString());
	}
	
	public void startApp() {
		Display.getDisplay(this).setCurrent(timeAlert);
	}
	
	public void pauseApp() {
	
	}
	
	public void destroyApp(boolean unconditional) {
		
	}
}
