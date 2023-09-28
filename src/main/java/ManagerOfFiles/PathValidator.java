package ManagerOfFiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 13:51
 */
public class PathValidator {
    public boolean ValidatePath(String s) {
        List<String> path = new ArrayList<>(Arrays.asList(s.split("\\\\")));
        String oldPath = s.substring(0, s.length() - path.get(path.size() - 1).length() - 1);
        File file = new File(oldPath);
        if(!Files.exists(file.toPath())){
            System.out.println("Вы ошиблись в пути, попробуйте еще раз");
        }
        return Files.exists(file.toPath());
    }

    public boolean ValidateForCreate(String path) {
        File file = new File(path);
        if(file.canRead() && file.isFile()){
            return true;
        }else{
            System.out.println("Нельзя читать");
            return false;
        }
    }

    public boolean ValidateForWrite(String path) {
        File file = new File(path);
        if(file.canWrite() && file.isFile()){
            return true;
        }else{
            System.out.println("Нельзя писать");
            return false;
        }
    }

    public boolean ValidateThirdArgument(String thirdArgument) {
        if(thirdArgument == null || thirdArgument.length() < 3 || thirdArgument.charAt(0) != '\"'
                || thirdArgument.charAt(thirdArgument.length() - 1) != '\"'){
            System.out.println("Введите текст третьим аргументом вида: \"Ваш текст\"");
            return false;
        }
        return true;
    }
}
