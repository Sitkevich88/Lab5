package commands.with_two_arguments;

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

            if (index >= collection.size()||index<0){
                System.out.println("There is no such index in the collection");
                return collection;
            }

            BandCreator bandCreator = new BandCreator();

            MusicBand band = bandCreator.invoke();

            list.add(index, band);

        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no such index in the collection");
        }catch (NullPointerException e){
            System.out.println("The collection is empty");
        }
        return (Collection<MusicBand>) list;
    }
}
