package com.company.bean;

/**
 * Created by 10648 on 2016/12/7 0007.
 */
public class Token {
    public final int tag;

    public Token(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + (char)tag;
    }
}
