package calendar;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDate {
  public static void main(String[] argv) throws Exception {

    Calendar xmas = new GregorianCalendar(2011, Calendar.DECEMBER, 25);
    Date date = xmas.getTime();
    System.out.println(date);
    String[] weekdays = new DateFormatSymbols().getWeekdays(); // Get day names
    for(String s: weekdays){
      System.out.println(s);
    }
  }
}