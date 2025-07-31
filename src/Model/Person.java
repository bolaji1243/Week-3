package Model;

import Libary.Com.Library;


public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void requestBook(Library library) {
        library.requestBook(this);
    }
}
