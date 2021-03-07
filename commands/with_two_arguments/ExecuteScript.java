package commands.with_two_arguments;



import utils.Interaction;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Command 'execute_script'. Executes script from a file.
 */


public class ExecuteScript {


    private String path;

    /**
     *
     * @param path - script path
     */

    public ExecuteScript(String path){
        this.path = path;
    }

    /**
     * Saves script from a file to a String.
     * @param path - script path
     * @return String script
     */

    private String readScript(String path){

        StringBuilder commands = new StringBuilder();
        String script;
        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                commands.append((char) content);
            }
            script = commands.toString();
        } catch (FileNotFoundException e){
            System.out.println("The file is not found");
            script = "";
        }catch (IOException e){
            System.out.println("There are not enough rights to open this file");
            script = "";
        }
        return script;
    }

    /**
     * Executes the command.
     * @param app - interaction panel
     */

    public void execute(Interaction app){
        String input = readScript(path);
        app.run(input);
    }

}
