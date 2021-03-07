package commands.with_two_arguments;

import data.MusicBand;
import utils.BandCreator;
import java.util.Collection;
import java.util.List;

/**
 * Command 'insert_at'. Inserts an element into the collection at the specific index
 */

public class InsertAt {

    /**
     * Executes the command.
     * @param collection - old collection
     * @param index - specific index
     * @return - Updated collection with newly inserted element
     */

    public Collection<MusicBand> invoke(Collection<MusicBand> collection, int index){

        List<MusicBand> list = (List<MusicBand>) collection;

        try{

            if (index >= collection.size()){
                System.out.println("Индекс выходит за рамки коллекции");
                return collection;
            }

            BandCreator bandCreator = new BandCreator();

            MusicBand band = bandCreator.invoke();

            list.add(index, band);

        }catch (IndexOutOfBoundsException e){
            System.out.println("Индекс выходит за рамки коллекции");
        }catch (NullPointerException e){
            System.out.println("Коллекция пуста");
        }
        return (Collection<MusicBand>) list;
    }
}
