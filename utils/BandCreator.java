package utils;

import data.Album;
import data.Coordinates;
import data.MusicBand;
import data.MusicGenre;
import java.time.ZonedDateTime;

/**
 * Band creator. Creates a band
 */

public class BandCreator {


    private InputChecker checker = new InputChecker();

    /**
     * Executes the command.
     * @return MusicBand new band
     */

    public MusicBand invoke(){

        String name = checker.nextLine("Insert the name: ", false, false);
        long x = checker.nextLong("Insert the coordinate x: ");
        Integer y = checker.nextInt("Insert the coordinate y: ", false,false);
        Integer numberOfParticipants = checker.nextInt("Insert the number of participants : ", true, true);
        String description = checker.nextLine("Insert the description : ", true, true);
        ZonedDateTime establishmentDate = checker.nextZonedDateTime("Insert the establishment date : ");
        MusicGenre genre = checker.nextMusicGenre("Choose the music genre : ");
        String albumName = checker.nextLine("Insert the name of their best album : ", false, false);
        int tracks = checker.nextInt("Insert the number of tracks in their best album : ", false, true).intValue();
        int length = checker.nextInt("Insert the length of their best album : ", false, true).intValue();
        Float sales = checker.nextFloat("Insert the sales of their best album : ", true,true);
        MusicBand band = new MusicBand(name, new Coordinates(x, y), numberOfParticipants, description, establishmentDate, genre, new Album(albumName, tracks, length, sales));

        return band;
    }

}
