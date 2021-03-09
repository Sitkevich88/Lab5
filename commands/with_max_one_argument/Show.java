package commands.with_max_one_argument;

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
        if (collection!=null){
            System.out.println(collection);
        }else {
            System.out.println("The collection is empty");
        }
    }
}
