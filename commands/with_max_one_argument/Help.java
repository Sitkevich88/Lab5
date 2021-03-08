package commands.with_max_one_argument;

import java.util.ArrayList;

/**
 * Command 'help'. Prints all available commands with description
 */

public class Help{

    public Help(){

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        ArrayList<String> commands = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        commands.add("info");
        commands.add("show");
        commands.add("add");
        commands.add("update id");
        commands.add("remove_by_id id");
        commands.add("clear");
        commands.add("save");
        commands.add("execute_script file_name");
        commands.add("exit");
        commands.add("insert_at index");
        commands.add("remove_greater");
        commands.add("sort");
        commands.add("sum_of_number_of_participants");
        commands.add("count_greater_than_best_album bestAlbum");
        commands.add("print_field_ascending_description");


        description.add("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        description.add("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        description.add("добавить новый элемент в коллекцию");
        description.add("обновить значение элемента коллекции, id которого равен заданному");
        description.add("удалить элемент из коллекции по его id");
        description.add("очистить коллекцию");
        description.add("сохранить коллекцию в файл");
        description.add("считать и исполнить скрипт из указанного файла");
        description.add("завершить программу (без сохранения в файл)");
        description.add("добавить новый элемент в заданную позицию");
        description.add("удалить из коллекции все элементы, превышающие заданный");
        description.add("отсортировать коллекцию в естественном порядке");
        description.add("вывести сумму значений поля numberOfParticipants для всех элементов коллекции");
        description.add("вывести количество элементов, значение поля bestAlbum которых больше заданного");
        description.add("вывести значения поля description всех элементов в порядке возрастания");

        for (int i = 0; i < commands.size(); i++){
            System.out.println(ANSI_GREEN + commands.get(i) + ANSI_PURPLE + " - " + description.get(i));
        }
        System.out.print(ANSI_RESET);

    }
}