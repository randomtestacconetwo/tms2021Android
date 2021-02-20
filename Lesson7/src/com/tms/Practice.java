package com.tms;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        String s1 = "string";
        String s2 = new String();
        String s3 = new String("qwerty");
        String s4 = new String(new char[]{'s', 't', 'r', 'i', 'n', 'g'});
        String s5 = new String(new byte[] {-48, -80, -48, -79, -47, -122});

        System.out.println("at");
        System.out.println("asd" == "asd");
        System.out.println("asd" == new String("asd"));
        System.out.println("asd".equals(new String("asd")));
        System.out.println("asd" == new String("asd").intern());
//        System.out.println(s5);

//        System.out.println(s4);
//        System.out.println(s4.length());
//        System.out.println("абц".length());
//
//        s4 = "";
//        System.out.println(s4.isEmpty());
//        System.out.println(s4.isBlank());
//
//        s4 = "    ";
//        System.out.println(s4.isEmpty());
//        System.out.println(s4.isBlank());
//
////        System.out.println(Arrays.toString("абц".getByt_es()));
//
//        String result = s1.concat(s3).concat("another");
//        System.out.println(result);
//
//        System.out.println(1 + 2 + "3" + 4); //33 / 123
//        System.out.println(1 + "2" + 3 + 4); // 123
//
//        System.out.println(String.join(";", s1, s2, s3, "custom"));
//        String[] strings = {s1, s2, s3, s4, "'", null};
//
//        doSmth(s1, s2, s3, s4, "'", null);
//        doSmth(strings);
        //qwerty
//        System.out.println(s3.indexOf("err"));
//        System.out.println(s3.indexOf('i'));
//        System.out.println(s3.indexOf("er", 1));
//        System.out.println(s3.indexOf("er", 3));
//        System.out.println(s3.lastIndexOf("ab"));
//        System.out.println(s3.indexOf("ab"));
//        System.out.println(s3.indexOf(97));
//        System.out.println(s3.endsWith("cab"));
//        System.out.println(s3.startsWith("asd"));
//        System.out.println(s3.replaceFirst("abc", "???"));
//        s3 = " \tabcabcab\t    ";
//        System.out.println("|" + s3 + "|" );
//        System.out.println("|" + s3.trim() + "|" );
//        s3 = "heLLo. can you hear me. I was wondering ...";
//        System.out.println(s3.replace(" ", ""));
//        System.out.println(s3.substring(1)); //ello
//        System.out.println(s3.substring(1, 3)); //el
//        System.out.println(s3.toLowerCase());
//        System.out.println(s3.toUpperCase());
        String[] strings = s3.split("\\.");
//        System.out.println(Arrays.toString(strings));

        ///////////SB////////////
        StringBuilder sb = new StringBuilder();
        sb = new StringBuilder(10);
        sb = new StringBuilder("asdas");
        sb = new StringBuilder(s3);
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        System.out.println(sb.toString());
        System.out.println(sb);
        char[] chars = new char[4];
        sb.getChars(0, 4, chars, 0);
        System.out.println(chars);
        sb.append("asdasd").append(12);
        System.out.println(sb);
        sb.insert(1, "!!!");
        System.out.println(sb);
        sb.delete(1, 4);
        System.out.println(sb);
        System.out.println(sb.reverse());

        sb.setLength(52313123);
        System.out.println(sb);
        sb = new StringBuilder("one two three");
        sb.replace(4, 7, "fouasdasdsdar");
        System.out.println(sb);
    }

    static void doSmth(String... s) {
        System.out.println(s.length);
        System.out.println(s[0]);
    }
}
