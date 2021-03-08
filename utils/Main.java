package utils;


import data.MusicBand;
import java.util.Stack;

/**
 * @author Valerii Sitkevich
 * @version 1.3
 * @since 2021-03-01
 */


public class Main {

    /**
     * Main method
     * @param args String args[0] the is the path to the saved collection in a json file
     */

    public static void main(String[] args){

        try{
            //CollectionSaver collectionSaver = new CollectionSaver(".\\src\\data\\bands.json");
            CollectionSaver collectionSaver = new CollectionSaver(args[0]);
            Stack<MusicBand> bands = (Stack<MusicBand>) collectionSaver.saveFileToCollection();
            Interaction app = new Interaction(bands, collectionSaver);
            app.run();
        }catch (IndexOutOfBoundsException e){
            //System.out.println("File path has not been detected");
            CollectionSaver collectionSaver = new CollectionSaver(" ");
            Stack<MusicBand> bands = (Stack<MusicBand>) collectionSaver.saveFileToCollection();
            Interaction app = new Interaction(bands, collectionSaver);
            app.run();
        }

    }
}