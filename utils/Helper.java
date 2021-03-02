package utils;

/**
 * Helper. This class can be removed after some alterations in InputChecker.class
 * Copies CommandsParser method parseLine()
 */
public class Helper {
    /**
     * Parses a line
     * @return String parsed line
     */
    public String nextLine(){
        return CommandsParser.parseLine();
    }
}
