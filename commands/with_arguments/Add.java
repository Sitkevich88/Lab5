package commands.with_arguments;


import data.MusicBand;
import utils.BandCreator;
import java.util.Collection;

/**
 * Command 'add'. Adds a new element to collection.
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

        collection.add(band);

        return collection;
    }

}
