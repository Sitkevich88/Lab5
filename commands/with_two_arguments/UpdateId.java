package commands.with_two_arguments;


import data.Album;
import data.Coordinates;
import data.MusicBand;
import data.MusicGenre;
import utils.InputChecker;
import java.time.ZonedDateTime;
import java.util.Collection;


/**
 * Command 'update'. Updates an element with specific id in the collection
 */


public class UpdateId {


    private InputChecker checker = new InputChecker();

    /**
     * Executes the command.
     * @param collection - old collection
     * @param id - long specific id
     * @return collection with the updated element
     */

    public Collection<MusicBand> invoke(Collection<MusicBand> collection, long id){


        try {
            for (MusicBand band : collection){

                if (band.getId()==id){

                    String name = checker.nextLine("Insert the name: ", false);
                    long x = checker.nextLong("Insert the coordinate x: ");
                    Integer y = checker.nextInt("Insert the coordinate y: ", false,false);
                    Integer numberOfParticipants = checker.nextInt("Insert the number of participants : ", true, true);
                    String description = checker.nextLine("Insert the description : ", true);
                    ZonedDateTime establishmentDate = checker.nextZonedDateTime("Insert the establishment date : ");
                    MusicGenre genre = checker.nextMusicGenre("Choose the music genre : ");
                    String albumName = checker.nextLine("Insert the name of their best album : ", false);
                    int tracks = checker.nextInt("Insert the number of tracks in their best album : ", false, true).intValue();
                    int length = checker.nextInt("Insert the length of their best album : ", false, true).intValue();
                    Float sales = checker.nextFloat("Insert the sales of their best album : ", true,true);



                    band.setName(name);
                    band.setCoordinates(new Coordinates(x,y));
                    band.setNumberOfParticipants(numberOfParticipants);
                    band.setDescription(description);
                    band.setEstablishmentDate(establishmentDate);
                    band.setGenre(genre);
                    band.setBestAlbum(new Album(albumName, tracks, length, sales));

                    break;
                }
            }
        }catch (NullPointerException e){ }

        return collection;
    }
}
