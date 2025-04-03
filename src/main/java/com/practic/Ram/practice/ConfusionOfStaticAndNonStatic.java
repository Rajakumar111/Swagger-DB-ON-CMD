package com.practic.Ram.practice;

public class ConfusionOfStaticAndNonStatic {

    public static void main(String[] args) {

        ConfusionOfStaticAndNonStatic a1 = new ConfusionOfStaticAndNonStatic();

        int test = ConfusionOfStaticAndNonStatic.test();
        int test1 = a1.test();

        System.out.println(test);
        System.out.println(test1);

    }

    public static int test(){
//        System.out.println("hey");
        return 100;

    }
}
