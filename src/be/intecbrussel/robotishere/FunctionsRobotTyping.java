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

    public void action(){

        //This is my style :

//         "user.home" use it if you don't know the %userprofile% path
        String path = System.getProperty("user.home");
        String pathTeamsExe = (path + "\\AppData\\Local\\Microsoft\\Teams\\current\\Teams.exe");

//         if the Teams.exe is found then let's make it work otherwise we have to leave (:

            try {
                if(checkIfExist(pathTeamsExe)) {
                // lets run,open or start the Teams.exe with this processBuilder.Start and Runtime.exec methods
                Process processObj = Runtime.getRuntime().exec("cmd /c start /wait " + pathTeamsExe);
                processObj.waitFor(); // Thanks for waiting ;)

                // This is array of keycode in order to type: row call
                // we made it like this to make easy it to read
                int[] row_call = {
                        KeyEvent.VK_R,
                        KeyEvent.VK_O,
                        KeyEvent.VK_W,
                        KeyEvent.VK_SPACE,
                        KeyEvent.VK_C,
                        KeyEvent.VK_A,
                        KeyEvent.VK_L,
                        KeyEvent.VK_L,
                        KeyEvent.VK_DOWN,
                        KeyEvent.VK_DOWN,
                        KeyEvent.VK_DOWN,
                        KeyEvent.VK_ENTER};

                // This array to type (Aanwezig) inside the application and send
                int[] writeAanwezig = {
                        KeyEvent.VK_A,
                        KeyEvent.VK_A,
                        KeyEvent.VK_N,
                        KeyEvent.VK_W,
                        KeyEvent.VK_E,
                        KeyEvent.VK_Z,
                        KeyEvent.VK_I,
                        KeyEvent.VK_G,
                        KeyEvent.VK_SPACE}; // add KeyEvent.VK_ENTER in the end if you want to send the text

                // Here we hold our breath for 3 seconds
                Thread.sleep(3000);

                //First we execute this method to reach the right place
                execute(row_call);

                Thread.sleep(3000);
                // then we use this method to type (AANWIZEG)
                typeIt(writeAanwezig);

                }else {
                    System.out.println("Teams.exe is not found.. Spijtig genoeg..!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

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
