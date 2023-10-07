package hm3.Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author Stepan Morgachev
 * @date 27.09.2023 11:47
 */
public class Person implements Serializable {
    private String name;
    private int age;
    transient private TypeOfActivity typeOfActivity;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        typeOfActivity = calculateActivity(age);
    }

    private TypeOfActivity calculateActivity(int age) {
        if(age >= 0 && age <= 3){
            return TypeOfActivity.SITTING_AT_HOME;
        } else if (age > 3 && age <= 7) {
            return TypeOfActivity.GOES_TO_KINDERGARTEN;
        } else if (age > 7 && age <= 18) {
            return TypeOfActivity.GOES_TO_SCHOOL;
        } else if (age > 18 && age <= 23) {
            return TypeOfActivity.GOES_TO_UNIVERSITY;
        } else if (age > 23 && age <= 65) {
            return TypeOfActivity.WORKING;
        }else{
            return TypeOfActivity.RETIRED;
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        typeOfActivity = calculateActivity(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeOfActivity getTypeOfActivity() {
        return typeOfActivity;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", typeOfActivity=" + typeOfActivity +
                '}';
    }
}
