package ManagerOfFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 14:49
 */
public class CommandCenter {
    private final PathValidator pathValidator;

    public CommandCenter(PathValidator pathValidator) {
        this.pathValidator = pathValidator;
    }

    public boolean makeCommand(String path, String command) {
        boolean isSuccessful = false;
        if(command.equals(Commands.CREATE.getCommand())){
            isSuccessful = makeCreate(path);
        }else if (command.equals(Commands.READ.getCommand())){
            isSuccessful = makeRead(path);
        }else if(command.equals(Commands.REMOVE.getCommand())){
            isSuccessful = makeRemove(path);
        }else{
            //makeWrite(path);
        }
        return isSuccessful;
    }

    private boolean makeRemove(String path) {
        try {
            Files.delete(Paths.get(path));
            System.out.println("Файл удален");
            return true;
        }catch (IOException e){
            System.err.println("Такой файл нельзя удалить");
            return false;
        }
    }

    private boolean makeRead(String path) {
        boolean canRead = pathValidator.ValidateForCreate(path);
        if(canRead) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                reader.lines().forEach(System.out::println);
                return true;
            } catch (IOException e) {
                System.err.println("Не удалось прочитать");
                return false;
            }
        }
        return false;
    }

    private boolean makeCreate(String path){
        File file = new File(path);
        if(Files.exists(file.toPath())){
            System.out.println("Файл с таким именем существует");
            return false;
        }
        try {
            file.createNewFile();
            System.out.println("Файл создан");
            return true;
        } catch (IOException e) {
            System.err.println("Файл не удалось создать");
            return false;
        }
    }
}
