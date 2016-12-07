package com.company.bean;

/**
 * Created by 10648 on 2016/12/7 0007.
 */
public class Num extends Token{
    private final int value;

    public Num(int value) {
        super(Tag.NUM);
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
