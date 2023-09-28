package ManagerOfFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 14:49
 */
public class CommandCenter {
    public void makeCommand(String path, String command) {
        if(command.equals(Commands.CREATE.getCommand())){
            try {
                makeCreate(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (command.equals(Commands.READ.getCommand())){
            //makeRead(path);
        }else if(command.equals(Commands.REMOVE.getCommand())){
            //makeRemove(path);
        }else{
            //makeWrite(path);
        }
    }

    private void makeCreate(String path) throws IOException {
        File file = new File(path);
        if(Files.exists(file.toPath())){
            System.out.println("Файл с таким именем существует");
            return;
        }

        if(file.createNewFile()) {
            System.out.println("Файл создан");
        }
        else {
            System.out.println("Файл не создан");
        }
    }
}
