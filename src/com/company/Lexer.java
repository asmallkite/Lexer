package com.company;

import com.company.bean.*;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by 10648 on 2016/12/7 0007.
 */
public class Lexer {
    public static int line = 1;
    char peek = ' ';
    Hashtable words = new Hashtable();
    void reserve(Word w) {
        words.put(w.lexeme, w);
    }

    public Lexer() {
    }
    void readch() {
        try {
            peek = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean readch(char c) {
        readch();
        if (peek != c) return false;
        peek = ' ';
        return true;
    }

    public Token scan() {
        for (; ; readch()) {
            if (peek == ' ' || peek == '\t') continue;
            else if (peek == '\n') line = line + 1;
            else break;
        }

        switch (peek) {
            case '&' :
                if (readch('&'))
                    return Word.and;
                else
                    return new Token('&');
            case '=':
                if (readch('='))
                    return Word.eq;
                else
                    return new Token('=');
            case '!':
                if (readch('='))
                    return Word.ne;
                else
                    return new Token('!');
            case '<':
                if (readch('='))
                    return Word.le;
                else
                    return new Token('<');
            case '>':
                if (readch('='))
                    return Word.ge;
                else
                    return new Token('>');
        }
        char temp = peek;
        switch (peek) {
            case '+':
            case '-':
                readch();
                if (!Character.isDigit(peek)) {
                    return new Token(temp);
                }
                // + —后面是数字的话
                int v = 0;
                do {
                    v = 10*v + Character.digit(peek, 10);
                    readch();
                } while (Character.isDigit(peek));
                if (peek != '.') {
                    String s = String.valueOf(temp) + String.valueOf(v);
                    return new Word(Tag.NUM, s);
                }
                float x = v; float d = 10;
                for (; ;) {
                    readch();
                    if (! Character.isDigit(peek)) break;
                    x = x + Character.digit(peek,10) / d ;
                    d = d * 10;
                }
                if (peek != 'e') {
                    String s = String.valueOf(temp) + String.valueOf(x);
                    return new Word(Tag.NUM, s);
                }

                String s = String.valueOf(temp) + String.valueOf(x) + "e";
                readch();
                if (!(peek == '+' || peek == '-' || Character.isDigit(peek))) {
                    readch();
                    return new Word(-1, "error");
                }
                s = s + peek;
                readch();
                while (Character.isDigit(peek)) {
                    s = s + peek;
                    readch();
                }
                return new Word(Tag.NUM, s);


        }

        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10*v + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));
            if (peek != '.') {
//                System.out.println("the" + peek);
                return new Num(v);
            }
            float x = v; float d = 10;
            for (; ;) {
                readch();
                if (! Character.isDigit(peek)) break;
                x = x + Character.digit(peek,10) / d ;
                d = d * 10;
            }
            return new Real(x);
        }

//        System.out.println("not digit" + peek);
        if (Character.isLetter(peek)) {
//            System.out.println("the" + peek);
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                readch();
            } while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = (Word) words.get(s);
            if (w != null) return w;
            w = new Word(Tag.ID, s);
            words.put(s, w);
            return w;
        }

        Token tok = new Token(peek);
        peek = ' ';
        return tok;
    }
}
