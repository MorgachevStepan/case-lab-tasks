package ManagerOfFiles;

import java.io.File;
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
        CommandCenter commandCenter = new CommandCenter(new PathValidator());
        List<String> command = null;
        String thirdArgument = "";
        boolean stop = false;
        boolean isWrite = false;
        while (!stop){
            System.out.println("Введите комманду");
            command = getCommand();
            if(command.size() > 2){
                isWrite = true;
            }
            stop =  validator.Validate(command);
        }

        if(isWrite){
            thirdArgument += command.get(2);
            for(int i = 3; i < command.size(); i++) {
                thirdArgument += " ";
                thirdArgument += command.get(i);
            }
        }

        while(!commandCenter.makeCommand(command.get(0), command.get(1), thirdArgument)){
            System.out.println("Попробуйте еще раз");
            stop = false;
            while (!stop){
                System.out.println("Введите комманду");
                command = getCommand();
                stop =  validator.Validate(command);
            }
        }
    }

    private static List<String> getCommand(){
        String[] stringCommand = scanner.nextLine().split(" ");
        List<String> command = new ArrayList<>(Arrays.asList(stringCommand));
        return command;
    }
}
