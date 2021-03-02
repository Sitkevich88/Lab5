package commands.without_argumets;

import data.MusicBand;
import utils.CollectionAnalyzer;
import java.util.Collection;

/**
 * Command 'info'. Prints a short piece of information about the collection
 */

public class Info {

    /**
     * Executes the command.
     * @param collection - examinable collection
     */

    public Info(Collection<MusicBand> collection){

        System.out.println("Тип коллекции: " + collection.getClass().getSimpleName() +
        "\nРазмер коллекции: " + collection.size() +
        "\nДата инициализации: " + CollectionAnalyzer.InitializationTracker.getLastInit());
    }
}
