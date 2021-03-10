package utils;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import data.MusicBand;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Stack;

/**
 * Collection saver. Saves file to collection and vice versa
 */
public class CollectionSaver {


    private String path;


    public CollectionSaver(String path){
        this.path=path;
    }

    /**
     *
     * @return String path to the file
     */
    public String getPath() {
        return path;
    }


    /**
     * Saves file to the collection
     * @return created collection
     */
    public Collection<MusicBand> saveFileToCollection() {

        StringBuilder jsonString = new StringBuilder();
        InputChecker checker = new InputChecker();
        File file;
        boolean shouldChangePath;
        do {
            shouldChangePath = false;
            file = new File(path);
            if (!file.exists()){
                System.out.println("This file does not exist");
                shouldChangePath = true;
            }else if (!file.canRead()){
                System.out.println("There are no rights to read from this file");
                shouldChangePath = true;
            }
            if (shouldChangePath){
                path = checker.nextLine("Write new path to the file: ", false, false );
            }
        }while(shouldChangePath);

        Stack<MusicBand> collection = null;
        Gson gson = Converters.registerZonedDateTime(new GsonBuilder()).setPrettyPrinting().create();
        Type listType =  new TypeToken<Stack<MusicBand>>() {}.getType();

        try {
            FileReader fr = new FileReader(file);
            int content;
            while ((content = fr.read()) != -1) {
                jsonString.append((char) content);
            }
            collection = gson.fromJson(jsonString.toString(), listType);

        } catch (IOException e) {

            System.out.println("Unexpected error");
            e.printStackTrace();
            System.exit(1);

        } catch (JsonSyntaxException e){

            JsonFixer fixer = new JsonFixer();
            String fixedJson = fixer.fixAll(jsonString.toString());
            collection = gson.fromJson(fixedJson, listType);

        }

        CollectionAnalyzer analyzer = new CollectionAnalyzer(collection);
        GeneratorId.setMaxExistingId(analyzer.findMaxId());
        CollectionAnalyzer.InitializationTracker.updateLastInit();
        return collection;
    }

    /**
     * Saves collection to the file
     * @param collection - collection to be saved
     */

    public void saveCollectionToFile(Collection<?>collection){
        Gson gson = Converters.registerZonedDateTime(new GsonBuilder()).setPrettyPrinting().create();
        String json = gson.toJson(collection);
        BufferedOutputStream outputStream;
        InputChecker checker = new InputChecker();
        File file;
        boolean shouldChangePath;
        do {
            shouldChangePath = false;
            file = new File(path);
            if (!file.exists()){
                System.out.println("This file does not exist");
                shouldChangePath = true;
            }else if (!file.canWrite()){
                System.out.println("There are no rights to write in the file");
                shouldChangePath = true;
            }
            if (shouldChangePath){
                path = checker.nextLine("Write new path to the file: ", false, false );
            }
        }while(shouldChangePath);

        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(path));
            byte[] buffer = json.getBytes();
            outputStream.write(buffer,0, buffer.length);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Source file has not been found");
        } catch (IOException e){
            System.out.println("Not enough rights");
        }
    }
}
