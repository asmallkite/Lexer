package com.company;

import com.company.bean.Num;
import com.company.bean.Tag;
import com.company.bean.Token;
import com.company.bean.Word;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        Token t;
        for (int i = 0; i < 100; i ++) {

            t = lexer.scan();
            if (t instanceof Num) {
                Num num = (Num)t;
                System.out.println("(" + num.tag +
                "," + num.toString() + ")");
            }  else if (t instanceof Word) {
                Word w = (Word)t;
                System.out.println("(" + w.tag +
                        "," + w.toString() + ")");
            } else {
                System.out.println( "(界符， " + t.toString() + ")");
            }
        }
    }
}
