package utils;

/**
 * Helper. This class can be removed after some alterations in InputChecker.class
 * Copies CommandsParser method parseLine()
 */
public class Helper {
    /**
     * Parses a line without trimming it
     * @return String parsed line
     */
    public String nextLineWithNoTrim(){
        return CommandsParser.parseLineWithNoTrim();
    }
    /**
     * Parses a line and trims it
     * @return String parsed line
     */
    public String nextLine(){
        return CommandsParser.parseLine();
    }
}
