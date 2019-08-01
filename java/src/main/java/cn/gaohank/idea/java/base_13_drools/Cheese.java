package cn.gaohank.idea.java.base_13_drools;

import lombok.Data;

@Data
public class Cheese {
    private String type;
    private int    price;

    public Cheese() {

    }
    public Cheese(final String type,
                  final int price) {
        super();
        this.type = type;
        this.price = price;
    }
}
