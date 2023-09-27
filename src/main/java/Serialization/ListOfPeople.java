package Serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 27.09.2023 12:09
 */
public class ListOfPeople implements Serializable {
    private List<Person> personList;

    public ListOfPeople(){
        personList = new ArrayList<>();
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void removePerson(Person person){
        personList.remove(person);
    }

    @Override
    public String toString() {
        return "ListOfPeople{" +
                "personList=" + personList +
                '}';
    }
}
