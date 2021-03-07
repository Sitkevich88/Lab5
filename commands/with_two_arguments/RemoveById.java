package commands.with_two_arguments;


import data.MusicBand;
import java.util.Collection;

/**
 * Command 'remove_by_id'. Removes an element by id from the collection
 */

public class RemoveById {

    /**
     * Executes the command.
     * @param collection - old collection
     * @param id - specific id
     * @return updated collection
     */

    public Collection<MusicBand> invoke(Collection<MusicBand> collection, long id){
        int initialLength = 0;
        try{
            initialLength = collection.size();
            for (MusicBand band : collection){
                if (band.getId()==id){
                    collection.remove(band);
                    break;
                }
            }
        }catch (NullPointerException e){
            return collection;
        }

        if (initialLength==collection.size()){
            System.out.println("This id does not exist");
        }
        return collection;
    }
}
