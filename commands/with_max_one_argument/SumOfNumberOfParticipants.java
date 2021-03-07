package commands.with_max_one_argument;

import data.MusicBand;
import java.util.Collection;

/**
 * Command 'sum_of_number_of_participants'. Counts the total amount of participants
 */

public class SumOfNumberOfParticipants {

    /**
     * Executes the command but does not print the result.
     * @param collection - collection to be examined
     * @return long total amount of participants
     */

    public long invoke(Collection<MusicBand> collection){
        if (collection==null){return 0;}
        long counter = 0;
        for (MusicBand band : collection){
            if (band.getNumberOfParticipants()!=null){
                counter+=band.getNumberOfParticipants().longValue();
            }
        }
        return counter;
    }

    /**
     * Executes the command and prints the result.
     * @param collection - collection to be examined
     */

    public void print(Collection<MusicBand> collection){
        long counter = invoke(collection);
        System.out.println(counter + " participants in total");
    }
}
