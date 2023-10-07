package hm3.ManagerOfFiles;

/**
 * @author Stepan Morgachev
 * @date 28.09.2023 14:08
 */
public enum Commands {
    CREATE("-create"),
    REMOVE("-remove"),
    WRITE("-write"),
    READ("-cat");

    private String command;


    Commands(String command) {
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
