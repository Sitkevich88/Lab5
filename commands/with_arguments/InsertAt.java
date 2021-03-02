package commands.with_arguments;

import data.MusicBand;
import utils.BandCreator;
import java.util.Collection;
import java.util.List;

/**
 * Command 'insert_at'. Inserts an element into the collection at the specific index
 */

public class InsertAt {

    /**
     * Executes the command.
     * @param collection - old collection
     * @param index - specific index
     * @return - Updated collection with newly inserted element
     */

    public Collection<MusicBand> invoke(Collection<MusicBand> collection, int index){

        List<MusicBand> list = (List<MusicBand>) collection;

        try{
            BandCreator bandCreator = new BandCreator();

            MusicBand band = bandCreator.invoke();

            list.add(index, band);

        }catch (IndexOutOfBoundsException e){
            System.out.println("The index is out of range");
        }
        return (Collection<MusicBand>) list;
    }
}
