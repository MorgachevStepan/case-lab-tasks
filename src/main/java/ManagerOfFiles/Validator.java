package ManagerOfFiles;

import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 13:49
 */
public class Validator {
    private final PathValidator pathValidator;
    private final CommandValidator commandValidator;

    public Validator() {
        this.pathValidator = new PathValidator();
        this.commandValidator = new CommandValidator();
    }

    public boolean Validate(List<String> command){
        boolean result = true;
        if(command.size() > 3 || command.size() < 2) {
            System.out.println("Введите корректную команду");
            return false;
        }
        result &= pathValidator.ValidatePath(command.get(0));
        result &= commandValidator.ValidateCommand(command.get(1));
        return result;
    }
}
