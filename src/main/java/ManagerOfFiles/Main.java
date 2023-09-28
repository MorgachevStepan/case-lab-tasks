package ManagerOfFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 13:30
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Validator validator = new Validator();
        CommandCenter commandCenter = new CommandCenter();
        List<String> command = null;
        boolean stop = false;
        while (!stop){
            System.out.println("Введите комманду");
            command = getCommand();
            stop =  validator.Validate(command);
        }

        commandCenter.makeCommand(command.get(0), command.get(1));
    }

    private static List<String> getCommand(){
        String[] stringCommand = scanner.nextLine().split(" ");
        List<String> command = new ArrayList<>(Arrays.asList(stringCommand));
        return command;
    }
}
