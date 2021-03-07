package utils;


import data.MusicBand;
import java.util.Stack;

/**
 * @author Valerii Sitkevich
 * @version 1.2
 * @since 2021-03-01
 */


public class Main {

    /**
     * Main method
     * @param args String array[0] is path to the saved collection in json file
     */

    public static void main(String[] args){

        try{
            //CollectionSaver collectionSaver = new CollectionSaver(".\\src\\data\\bands.json");
            CollectionSaver collectionSaver = new CollectionSaver(args[0]);
            Stack<MusicBand> bands = (Stack<MusicBand>) collectionSaver.saveFileToCollection();
            Interaction app = new Interaction(bands, collectionSaver);
            app.run();
        }catch (IndexOutOfBoundsException e){
            System.out.println("File path is not detected");
            System.exit(1);
        }

    }
}