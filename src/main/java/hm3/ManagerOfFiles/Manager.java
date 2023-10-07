package hm3.ManagerOfFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 22:58
 */
public class Manager {
    private final Scanner scanner;
    private final Validator validator;
    private final CommandCenter commandCenter;
    private List<String> command;
    private String thirdArgument;

    public Manager() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.commandCenter = new CommandCenter(new PathValidator());
        this.command = null;
    }

    public void run(){
        while(true) {
            enterCommand();
            callCommand();
        }
    }

    private void enterCommand() {
        thirdArgument = "";
        boolean stop = false;
        boolean isWrite = false;
        while(!stop){
            isWrite = false;
            System.out.println("Введите комманду");
            command = getCommand();
            if(command.size() > 2){
                isWrite = true;
            }
            stop =  validator.Validate(command);
        }
        if(isWrite) {
            thirdArgument = makeThirdArgument();
        }
    }

    private void callCommand() {
        while(!commandCenter.makeCommand(command.get(0), command.get(1), thirdArgument)){
            System.out.println("Попробуйте еще раз");
            enterCommand();
        }
    }

    private String makeThirdArgument() {
        String result = command.get(2);
        for(int i = 3; i < command.size(); i++){
            result += " ";
            result += command.get(i);
        }
        return result;
    }

    private List<String> getCommand(){
        String[] stringCommand = scanner.nextLine().split(" ");
        List<String> command = new ArrayList<>(Arrays.asList(stringCommand));
        return command;
    }
}
