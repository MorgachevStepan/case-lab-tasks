package ManagerOfFiles;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 13:51
 */
public class CommandValidator {
    public boolean ValidateCommand(String s) {
        for(Commands command: Commands.values()){
            if(command.getCommand().equals(s)){
                return true;
            }
        }
        System.out.println("Вы ошиблись в названии команды, попробуйте еще раз");
        return false;
    }
}
