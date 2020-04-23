package be.intecbrussel.robotishere;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class FunctionsRobotTyping {

    private Robot robot;
    // Here we put the speed of typing in case we gonna use it in many places but I don't think so ;)
    private static final int SPEED = 300;

    public FunctionsRobotTyping() {
    }


    // This method is to execute the array of letters ,
    // in other word the array of keycode of letters
    public void execute(int[] letter) {
        try {
            this.robot = new Robot();

            //Here we use clt+shift+f to go directly to filter field
            // first hold
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_F);
            Thread.sleep(1000);
            // then release
            robot.keyRelease(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_SHIFT);

            clearText();

            // Here we print out the array look like human press and release
            for (int value : letter) {
                this.robot.delay(SPEED);
                this.robot.keyPress(value);
                this.robot.keyRelease(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //This method is to clear the exists text in the selected field
    private void clearText() throws Exception{
        // in case there's other word written before ..
        // we have to delete it to make everything goes well..:)
        //first Hold
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_HOME);
        Thread.sleep(500);
        //then release
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_HOME);


    }

    // This method is to type aanwezig
    public void typeIt(int[] letter){
        try{
            this.robot= new Robot();
            clearText();
            // Here we print out the array look like human press and release
            for (int value : letter) {
                this.robot.delay(SPEED);
                this.robot.keyPress(value);
                this.robot.keyRelease(value);
            }


        }catch (Exception e){
            e.getStackTrace();
        }

    }

    // check if its exists or not
    public boolean checkIfExist(String fileExe){
        return new File(fileExe).exists(); // This is shortcut
    }
}
