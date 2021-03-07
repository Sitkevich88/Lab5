package commands.with_two_arguments;

import data.MusicBand;
import java.util.Collection;

/**
 * Command 'remove_greater'. Inserts an element into the collection at the specific index
 */

public class RemoveGreater {

    /**
     * Executes the command.
     * @param collection - old collection
     * @param number - int specific index
     * @return updated collection
     */

    public Collection<MusicBand> invoke(Collection<MusicBand> collection, int number){

        try {
            int initialLength = collection.size();

            for (int i = initialLength-1; (i > number)&&(i>=0) ; i-- ){
                collection.remove(i);
            }

            if (initialLength==collection.size()){
                throw new NullPointerException();
            }

        }catch (NullPointerException e){
            System.out.println("Nothing has been removed. The id is out of range.");
        }
        return collection;
    }
}
