package commands.without_argumets;


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
        collection.clear();
        return collection;
    }
}
