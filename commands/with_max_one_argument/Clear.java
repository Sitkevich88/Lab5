package commands.with_max_one_argument;


import java.util.Collection;

/**
 * Command 'clear'. Clears the collection.
 */

public class Clear {

    /**
     *
     * Executes the command.
     * @param collection - old collection
     * @return empty collection.
     */

    public Collection<?> invoke(Collection<?> collection){
        try {
            collection.clear();
        }catch (NullPointerException e){}

        return collection;
    }
}
