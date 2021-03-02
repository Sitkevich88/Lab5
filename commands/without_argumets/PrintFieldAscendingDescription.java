package commands.without_argumets;

import data.MusicBand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Command 'print_field_ascending_description'. Prints all descriptions in ascending alphabetical order
 */

public class PrintFieldAscendingDescription {

    /**
     * Executes the command.
     * @param collection - examinable collection
     */

    public void invoke(Collection<MusicBand> collection){

        List<String> list = new ArrayList<>();

        for (MusicBand band : collection){

            if (band.getDescription().length()!=0){
                list.add(band.getDescription().toLowerCase());
            }
        }

        java.util.Collections.sort(list);

        for (String s : list) {
            System.out.println(s);
        }

    }

}
