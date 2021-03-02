package utils;


import commands.with_arguments.*;
import commands.without_argumets.*;
import data.MusicBand;
import java.util.Collection;

/**
 * Interaction. Invokes the commands
 */

public class Interaction {

    private Collection<MusicBand> collection;
    private CollectionSaver collectionSaver;

    public Interaction(Collection<MusicBand> collection, CollectionSaver collectionSaver) {
        this.collection = collection;
        this.collectionSaver = collectionSaver;
        new Help();
    }

    /**
     * Makes the app run
     */
    public void run() {

        while (true){
            String[] str = CommandsParser.parseArguments();

            switch (str[0]){
                case("help"):
                    new Help();
                    break;
                case("info"):
                    new Info(collection);
                    break;
                case("show"):
                    new Show(collection);
                    break;
                case("add"):
                    Add adder = new Add();
                    collection = adder.updateCollection((Collection<MusicBand>) collection);
                    break;
                case("update"):
                    try {
                        long id = Long.valueOf(str[1]).longValue();
                        UpdateId updater = new UpdateId();
                        collection = updater.invoke(collection, id);
                    }catch (Exception e){}
                    break;
                case ("remove_by_id"):
                    try {
                        long id = Long.valueOf(str[1]).longValue();
                        RemoveById remover = new RemoveById();
                        collection = remover.invoke(collection, id);
                    }catch (Exception e){}
                    break;
                case("clear"):
                    Clear clearer = new Clear();
                    collection = (Collection<MusicBand>) clearer.invoke(collection);
                    break;
                case("save"):
                    new Save(collection, collectionSaver);
                    break;
                case("execute_script"):
                    try {
                        ExecuteScript executor = new ExecuteScript(str[1]);
                        executor.execute(this);
                    }catch (Exception e){}
                    break;
                case("exit"):
                    new Exit();
                case ("insert_at"):
                    try {
                        int index = Integer.valueOf(str[1]).intValue();
                        InsertAt insertAt = new InsertAt();
                        collection = insertAt.invoke(collection, index);
                    }catch (Exception e){
                        //
                    }
                    break;
                case ("remove_greater"):
                    try {
                        int index = Integer.valueOf(str[1]).intValue();
                        RemoveGreater removeGreater = new RemoveGreater();
                        collection = removeGreater.invoke(collection, index);
                    }catch (Exception e){ }
                    break;
                case ("sort"):
                    Sort sorter = new Sort();
                    collection = sorter.invoke(collection);
                    break;
                case("sum_of_number_of_participants"):
                    SumOfNumberOfParticipants sum = new SumOfNumberOfParticipants();
                    sum.print((Collection<MusicBand>) collection);
                    break;
                case ("count_greater_than_best_album"):
                    CountGreaterThanBestAlbum countGreaterThanBestAlbum = new CountGreaterThanBestAlbum();
                    countGreaterThanBestAlbum.invoke(collection, str[1]);
                    break;
                case ("print_field_ascending_description"):
                    PrintFieldAscendingDescription printer = new PrintFieldAscendingDescription();
                    printer.invoke(collection);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    /**
     * Loads script to CollectionParser.buffer
     * @param input String script
     */
    public void run(String input) {
        CommandsParser.loadScript(input);
    }

}
