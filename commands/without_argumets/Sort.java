package commands.without_argumets;

import data.MusicBand;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Command 'sort'. Sorts collection by band name
 */

public class Sort {

    /**
     *
     * @param collection - collection to be sorted
     * @return sorted collection
     */

    public Collection<MusicBand> invoke(Collection<MusicBand> collection){
        Collections.sort((List<MusicBand>)collection);
        return (Stack<MusicBand>)collection;
    }
}
