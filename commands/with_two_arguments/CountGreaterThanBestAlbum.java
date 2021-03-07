package commands.with_two_arguments;


import data.MusicBand;
import java.util.Collection;

/**
 * Command 'count_greater_than_best_album'. Counts the amount of albums which are further down the alphabet by title than albumName.
 */

public class CountGreaterThanBestAlbum {

    /**
     * Executes the command.
     * @param collection - collection to be examined
     * @param albumName - the name of an album we compare albums in collection with
     */


    public void invoke(Collection<MusicBand> collection, String albumName){

        int counter = 0;

        try {
            for (MusicBand band : collection){
                if (band.getBestAlbum().getName().compareToIgnoreCase(albumName)>0){
                    counter++;
                    System.out.println(band.getBestAlbum().getName());
                }
            }
        }catch (NullPointerException e){ }

        System.out.println(counter + " albums are greater");
    }
}
