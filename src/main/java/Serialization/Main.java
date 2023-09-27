package Serialization;

import java.io.*;

/**
 * @author Stepan Morgachev
 * @date 27.09.2023 12:11
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person1 = new Person("Ivan", 14);
        Person person2 = new Person("Dmitriy", 2);
        Person person3 = new Person("Mariya", 6);
        Person person4 = new Person("Anatoliy", 22);
        Person person5 = new Person("Alexey", 47);
        Person person6 = new Person("Yan", 66);

        ListOfPeople listOfPeople = new ListOfPeople();

        listOfPeople.addPerson(person1);
        listOfPeople.addPerson(person2);
        listOfPeople.addPerson(person3);
        listOfPeople.addPerson(person4);
        listOfPeople.addPerson(person5);
        listOfPeople.addPerson(person6);

        FileOutputStream outputStream = new FileOutputStream("file.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(listOfPeople);
        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("file.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        ListOfPeople restoredList = (ListOfPeople) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(restoredList);
    }
}
