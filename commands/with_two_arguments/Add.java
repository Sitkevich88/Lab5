package commands.with_two_arguments;


import data.MusicBand;
import utils.BandCreator;
import java.util.Collection;
import java.util.Stack;

/**
 * Command 'add'. Adds a new element to the collection.
 */

public class Add {

    BandCreator bandCreator = new BandCreator();

    /**
     * Executes the command.
     * @param collection - old collection
     * @return Collection. Updated collection with newly added element.
     */

    public Collection<MusicBand> updateCollection(Collection<MusicBand> collection){
        MusicBand band = bandCreator.invoke();
        try{
            collection.add(band);
        }catch (NullPointerException e){
            collection = new Stack<MusicBand>();
            collection.add(band);
        }
        return collection;
    }

}
