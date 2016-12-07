package com.company;

import com.company.bean.*;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        Token t;
        for (int i = 0; i < 100; i ++) {

            t = lexer.scan();
            if (t instanceof Num) {
                Num num = (Num)t;
                System.out.println("(\t" + num.tag +
                "," + num.toString() + "\t)");
            } else if (t instanceof Real){
                Real real = (Real)t;
                System.out.println("(\t" + real.tag +
                        "," + real.toString() + "\t)");
            } else if (t instanceof Word) {
                Word w = (Word)t;
                System.out.println("(\t" + w.tag +
                        "," + w.toString() + "\t)");
            } else if (t.toString().equals("=")){
                System.out.println( "(\t21," + t.toString() + "\t)");
            }else if (t.toString().equals("+")){
                System.out.println( "(\t22," + t.toString() + "\t)");
            }else if (t.toString().equals("-")){
                System.out.println( "(\t23," + t.toString() + "\t)");
            }else if (t.toString().equals("*")){
                System.out.println( "(\t24," + t.toString() + "\t)");
            }else if (t.toString().equals("/")){
                System.out.println( "(\t25," + t.toString() + "\t)");
            }else if(t.toString().equals("(")) {
                System.out.println( "(\t26," + t.toString() + "\t)");
            }else if (t.toString().equals(")")){
                System.out.println( "(\t27," + t.toString() + "\t)");
            }else if (t.toString().equals("{")){
                System.out.println( "(\t28," + t.toString() + "\t)");
            }else if (t.toString().equals("}")){
                System.out.println( "(\t29," + t.toString() + "\t)");
            }else if (t.toString().equals(",")){
                System.out.println( "(\t30," + t.toString() + "\t)");
            }else if (t.toString().equals(";")){
                System.out.println( "(\t31," + t.toString() + "\t)");
            }else if (t.toString().equals(">")){
                System.out.println( "(\t32," + t.toString() + "\t)");
            }else if (t.toString().equals("<")){
                System.out.println( "(\t34," + t.toString() + "\t)");
            }else if (t.toString().equals("#")){
                System.out.println( "(\t0," + t.toString() + "\t)");
            } else {
                System.out.println( "(界符， " + t.toString() + ")");
            }


        }
    }
}
