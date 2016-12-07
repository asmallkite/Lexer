package com.company.bean;

/**
 * Created by 10648 on 2016/12/7 0007.
 */
public class Word extends Token{
    public String lexeme = "";

    public Word(int tag, String lexeme) {
        super(tag);
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return lexeme;
    }

    public static final Word
    and = new Word(Tag.AND, "&&"),
    eq = new Word(Tag.EQ, "=="),
    ne = new Word(Tag.NE, "!="),
    ge = new Word(Tag.GE, ">="),
    le = new Word(Tag.LE, "<=");
}
