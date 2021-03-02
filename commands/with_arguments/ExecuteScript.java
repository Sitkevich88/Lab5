package commands.with_arguments;



import utils.Interaction;
import java.io.File;
import java.io.FileReader;



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
        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                commands.append((char) content);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        return commands.toString();
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
