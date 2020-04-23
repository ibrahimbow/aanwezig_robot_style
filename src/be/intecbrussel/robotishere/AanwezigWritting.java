package be.intecbrussel.robotishere;

import java.awt.event.KeyEvent;

public class AanwezigWritting {

    public static void main(String[] args) {

        //This is my style :)

        FunctionsRobotTyping functionsRobotTyping = new FunctionsRobotTyping();

        // "user.home" use it if you don't know the %userprofile% path
        String path = System.getProperty("user.home");
        String pathTeamsExe = (path + "\\AppData\\Local\\Microsoft\\Teams\\current\\Teams.exe");

        // if the Teams.exe is found then let's make it work otherwise we have to leave (:

            try {
                if(functionsRobotTyping.checkIfExist(pathTeamsExe)) {
                // lets run,open or start the Teams.exe with this processBuilder.Start and Runtime.exec methods
                Process processObj = Runtime.getRuntime().exec("cmd /c start /wait " + pathTeamsExe);
                processObj.waitFor(); // Thanks for waiting ;)

                // This is array of keycode in order to type: row call
                // we made it like this to make easy to read
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
                functionsRobotTyping.execute(row_call);

                Thread.sleep(3000);
                // then we use this method to type (AANWIZEG)
                functionsRobotTyping.typeIt(writeAanwezig);

                }else {
                    System.out.println("Teams.exe is not found.. Spijtig genoeg..!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
}
