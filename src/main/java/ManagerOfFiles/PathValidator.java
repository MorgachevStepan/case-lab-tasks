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
}
