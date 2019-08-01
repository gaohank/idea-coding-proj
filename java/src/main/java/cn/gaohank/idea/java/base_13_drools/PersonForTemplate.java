package cn.gaohank.idea.java.base_13_drools;

import lombok.Data;

@Data
public class PersonForTemplate {
    private String name;
    private String likes;
    private int age;
    private char sex;
    private boolean alive;
    private String status;

    public PersonForTemplate() {

    }

    public PersonForTemplate(final String name) {
        this(name,
                "",
                0);
    }

    public PersonForTemplate(final String name,
                             final String likes) {
        this(name,
                likes,
                0);
    }

    public PersonForTemplate(final String name,
                             final String likes,
                             final int age) {
        this.name = name;
        this.likes = likes;
        this.age = age;
    }


    public String toString() {
        return "[Person name='" + this.name + "']";
    }
}
