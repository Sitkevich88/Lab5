package commands.with_arguments;


import data.MusicBand;
import java.util.Collection;

/**
 * Command 'count_greater_than_best_album'. Counts the amount of albums which are further down the alphabet by title than albumName.
 */

public class CountGreaterThanBestAlbum {

    /**
     * Executes the command.
     * @param collection - examinable collection
     * @param albumName - the name of an album we compare albums in collection with
     */


    public void invoke(Collection<MusicBand> collection, String albumName){

        int counter = 0;

        for (MusicBand band : collection){
            if (band.getBestAlbum().getName().compareToIgnoreCase(albumName)>0){
                counter++;
                System.out.println(band.getBestAlbum().getName());
            }
        }
        System.out.println(counter + " albums are greater");
    }
}
