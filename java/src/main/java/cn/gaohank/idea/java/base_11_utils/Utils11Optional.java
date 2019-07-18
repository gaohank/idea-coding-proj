package cn.gaohank.idea.java.base_11_utils;

import java.util.Optional;

public class Utils11Optional {
    String name;

    public Utils11Optional(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Utils11Optional utils11Optional = new Utils11Optional("hello");
        String name = Optional.ofNullable(utils11Optional.getName()).orElse("empty");
        System.out.println(name);
    }
}
