package be.intecbrussel.robotishere;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AanwezigWritting {

    public static void main(String[] args) {



        String DATE_FORMATTER = "HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        int minute=0;
        int hour=0;

        FunctionsRobotTyping functionsRobotTyping = new FunctionsRobotTyping();

        while(true) {
            minute = LocalTime.now().getMinute();
            hour = LocalTime.now().getHour();

//            System.out.print(LocalTime.now().format(formatter) + "\r");
            // put the time to type Aanwezig on teams
            if(hour ==9 && minute ==9 ){

                functionsRobotTyping.action();
                break;
            }

        }







    }
}
