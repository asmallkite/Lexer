package com.company.bean;

/**
 * Created by 10648 on 2016/12/7 0007.
 */
public class Real extends Token {
    public final float value;

    public Real(float value) {
        super(Tag.NUM);
        this.value = value;
    }

    @Override
    public String toString() {
        return " " + value;
    }
}
