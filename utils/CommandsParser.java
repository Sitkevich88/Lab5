package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Commands Parser. Parses commands from buffer. If buffer is empty, then parses from console
 */

public class CommandsParser {

    private static String buffer = "";

    /**
     * Parses a line
     * @return String parsed line
     */
    public static String parseLine(){
        String line = "";
        if (buffer.length()==0){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("Unable to raed file");
            }
        }else{
            String[] lines = buffer.split("\\r?\\n",2);
            line = lines[0].trim();
            buffer = lines[1];
            System.out.println(line);
        }
        return line;
    }

    /**
     * Adds script to the buffer
     * @param script String commands on separated lines
     */
    public static void loadScript(String script){
        if (script.length()!=0){
            buffer = script + "\n" + buffer;
        }
    }

    /**
     * Parses a line and splits it into 2 arguments
     * @return String array with max 2 arguments
     */
    public static String[] parseArguments(){
        String arguments = parseLine();
        return arguments.split("\\s",2);
    }

    /**
     *
     * @param line String parsed line
     * @return max 2 String in array split by space
     */
    public static String[] convertLineToArguments(String line){
        return line.split("\\s", 2);
    }

}
