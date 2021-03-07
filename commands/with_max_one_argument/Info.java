package commands.with_max_one_argument;

import data.MusicBand;
import utils.CollectionAnalyzer;
import java.util.Collection;

/**
 * Command 'info'. Prints a short piece of information about the collection
 */

public class Info {

    /**
     * Executes the command.
     * @param collection - collection to examine
     */

    public void invoke(Collection<MusicBand> collection){
        try{
            System.out.println("Тип коллекции: " + collection.getClass().getSimpleName() +
                    "\nРазмер коллекции: " + collection.size() +
                    "\nДата инициализации: " + CollectionAnalyzer.InitializationTracker.getLastInit());
        }catch (NullPointerException e){
            System.out.println("Тип коллекции: неопределен" +
                    "\nРазмер коллекции: 0" +
                    "\nДата инициализации: " + CollectionAnalyzer.InitializationTracker.getLastInit());
        }
    }
}
