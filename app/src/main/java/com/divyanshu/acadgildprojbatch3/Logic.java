package com.divyanshu.acadgildprojbatch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Divyanshu on 23-07-2016.
 */
public class Logic {

   public static String question;

    int questionDigitA;
    int questionDigitB;

    int questionDigitC;

    public static int optionA;
    public static  int optionB;
    public static int optionC;
    public static int optionD;

    public static  int answer;

    // ADDITION = 0
    //SUBTRACTION = 1
    //MULTIPLY =3
    // DIVIDE = 4

    int min;
    int max;
    int method;
    boolean enabler;

    Logic(int min, int max, int method,boolean enabler){
        this.min = min;
        this.max =max;
        this.method = method;
        this.enabler = enabler;

        LogicMaker(min,max,method);
    }
   public void LogicMaker(int min, int max, int method){
        try {
            questionDigitA = getRandomNumber(min, max);
            questionDigitB = getRandomNumber(min, max);
            questionDigitC = getRandomNumber(min, max);
            System.out.println("                                           ");
            System.out.println("                                           ");
            System.out.println("                                           ");
            System.out.println("                                           ");
            // System.out.println("Value of A :"+questionDigitA);
            // System.out.println("Value of B :"+questionDigitB);

            if(enabler) {
                if (method == 0)
                    answer = questionDigitA + questionDigitB + questionDigitC;
                else if (method == 1)
                    answer = questionDigitA - questionDigitB - questionDigitC;
                else if (method == 2)
                    answer = questionDigitA * questionDigitB * questionDigitC;
                else if (method == 3)
                    answer = questionDigitA / questionDigitB;
            }else{
                if (method == 0)
                    answer = questionDigitA + questionDigitB ;
                else if (method == 1)
                    answer = questionDigitA - questionDigitB;
                else if (method == 2)
                    answer = questionDigitA * questionDigitB;
                else if (method == 3)
                    answer = questionDigitA / questionDigitB;
            }

            // answer = 4 + 3;
            // System.out.println("Answer :"+answer);

            int answerLength = (int) Math.log10(answer) + 1;
            // System.out.println("Answer Length :"+answerLength);

            String arraySize = "1";
            for (int j = 0; j < answerLength; j++) {
                arraySize = arraySize + "0";
            }
            // System.out.println("arraySize Number :"+arraySize);
            int finalArraySize = Integer.parseInt(arraySize);
//        System.out.println("finalArraySize Number :"+finalArraySize);
//        System.out.println("Highest Number :"+(finalArraySize-1));
//        System.out.println("Lowest Number :"+(finalArraySize-99));




            final Random random = new Random();
            final Set<Integer> intSet = new HashSet<>();
            while (intSet.size() < 3) {//Total Options
                int val = 0;
                if(method==0)
                 val =  random.nextInt((finalArraySize - 1)) + 1;
                else if(method==1) {
                    val = random.nextInt(min + max) - min;                  //ORIGINAL
                    val *= Math.floor(Math.random() * 2) == 1 ? 1 : -1; // this will add minus sign in 50% of cases
                    //  val =random.nextInt(min+max) - max;
                }
                else if(method==3)
                    val =random.nextInt(min+max) - min;
                else
                    val =  random.nextInt((finalArraySize - 1)) + 1;
                if (val != answer)
                    intSet.add(val);

                double num = Math.floor(Math.random()*max) + 1; // this will get a number between 1 and 99;
                num *= Math.floor(Math.random()*2) == 1 ? 1 : -1; // this will add minus sign in 50% of cases
                System.out.println("num"+num);

            }
            final int[] ints = new int[intSet.size()];
            final Iterator<Integer> iter = intSet.iterator();
            for (int i = 0; iter.hasNext(); ++i) {
                ints[i] = iter.next();
            }
//        System.out.println(Arrays.toString(ints));

            // ints[intSet.size()+1]= answer;


            List<Integer> solution = new ArrayList<>(4);
            solution.add(answer);
            for (int i = 0; i <= ints.length - 1; i++) {
                solution.add(ints[i]);
            }
            Collections.shuffle(solution);

//        × (Multiplication Symbol)	ALT+0215	----
//        ÷ (Division Symbol)	ALT+0247	ALT+246
//        ¹ (Superscript 1)	ALT+0185	----
//        ² (Superscript 2)	ALT+0178	ALT+253
//        ³ (Superscript 3)	ALT+0179	----

            if(enabler) {
                if (method == 0)
                    question = (questionDigitA) + " + " + questionDigitB + " + " + questionDigitC + "";
                else if (method == 1)
                    question = (questionDigitA) + " - " + questionDigitB + " - " + questionDigitC + "";
                else if (method == 2)
                    question = (questionDigitA) + " × " + questionDigitB + " × " + questionDigitC + "";
                else if (method == 3)
                    question = (questionDigitA) + " ÷" + questionDigitB + "";
            }else {
                if (method == 0)
                    question = (questionDigitA) + " + " + questionDigitB  + "";
                else if (method == 1)
                    question = (questionDigitA) + " - " + questionDigitB + "";
                else if (method == 2)
                    question = (questionDigitA) + " × " + questionDigitB  + "";
                else if (method == 3)
                    question = (questionDigitA) + " ÷" + questionDigitB + "";
            }


            optionA = solution.get(0);
            optionB = solution.get(1);
            optionC = solution.get(2);
            optionD = solution.get(3);

            System.out.println("Question :" + question);
            System.out.println("Answer :" + answer);
            System.out.println("Option A :" + optionA);
            System.out.println("Option B :" + optionB);
            System.out.println("Option C :" + optionC);
            System.out.println("Option D :" + optionD);

            for (int i = 0; i <= solution.size() - 1; i++) {
                //System.out.println("Final digits :"+solution.get(i));
            }


        }catch (Exception e){
            e.printStackTrace();
            LogicMaker(min,max,method);
        }
    }



    public int getRandomNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

}
