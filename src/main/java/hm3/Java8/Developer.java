package hm3.Java8;

import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 01.10.2023 10:37
 */
public class Developer {
    private String name;
    private List<String> languages;

    public Developer(String name, List<String> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", languages=" + languages +
                '}';
    }
}
