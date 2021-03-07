package utils;


import commands.with_two_arguments.*;
import commands.with_max_one_argument.*;
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
            //String[] str = CommandsParser.parseArguments();
            String line = CommandsParser.parseLine();

            switch (line){
                case("help"):
                    new Help();
                    break;
                case("info"):
                    Info info = new Info();
                    info.invoke(collection);
                    break;
                case("show"):
                    new Show(collection);
                    break;
                case("add"):
                    Add adder = new Add();
                    collection = adder.updateCollection((Collection<MusicBand>) collection);
                    break;
                case("clear"):
                    Clear clearer = new Clear();
                    collection = (Collection<MusicBand>) clearer.invoke(collection);
                    break;
                case("save"):
                    new Save(collection, collectionSaver);
                    break;
                case("exit"):
                    new Exit();
                case ("sort"):
                    Sort sorter = new Sort();
                    collection = sorter.invoke(collection);
                    break;
                case("sum_of_number_of_participants"):
                    SumOfNumberOfParticipants sum = new SumOfNumberOfParticipants();
                    sum.print((Collection<MusicBand>) collection);
                    break;
                case ("print_field_ascending_description"):
                    PrintFieldAscendingDescription printer = new PrintFieldAscendingDescription();
                    printer.invoke(collection);
                    break;



                default:
                    String[] str = CommandsParser.convertLineToArguments(line);
                    try{
                        switch(str[0]){
                            case("update"):
                                long idToUpdate = Long.valueOf(str[1]).longValue();
                                UpdateId updater = new UpdateId();
                                collection = updater.invoke(collection, idToUpdate);
                                break;
                            case ("remove_by_id"):
                                long idToRemove = Long.valueOf(str[1]).longValue();
                                RemoveById remover = new RemoveById();
                                collection = remover.invoke(collection, idToRemove);
                                break;
                            case("execute_script"):
                                ExecuteScript scriptExecutor = new ExecuteScript(str[1]);
                                scriptExecutor.execute(this);
                                break;
                            case ("insert_at"):
                                int index = Integer.valueOf(str[1]).intValue();
                                InsertAt insertAt = new InsertAt();
                                collection = insertAt.invoke(collection, index);
                                break;
                            case ("remove_greater"):
                                int indexToRemove = Integer.valueOf(str[1]).intValue();
                                RemoveGreater removeGreater = new RemoveGreater();
                                collection = removeGreater.invoke(collection, indexToRemove);
                                break;
                            case ("count_greater_than_best_album"):
                                CountGreaterThanBestAlbum countGreaterThanBestAlbum = new CountGreaterThanBestAlbum();
                                countGreaterThanBestAlbum.invoke(collection, str[1]);
                                break;
                            default:
                                System.out.println("Unknown command");
                        }
                    }catch (Exception e){
                        System.out.println("Incorrect argument");
                    }
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
