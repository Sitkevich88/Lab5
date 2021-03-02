package commands.without_argumets;

import java.util.Collection;

/**
 * Command 'show'. Prints all objects of the collection
 */

public class Show {
    /**
     * Executes the command.
     * @param collection - collection to be shown
     */
    public Show(Collection<?> collection){
        System.out.println(collection);
    }
}
