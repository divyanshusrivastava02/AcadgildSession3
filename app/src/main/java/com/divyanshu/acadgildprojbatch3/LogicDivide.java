package com.divyanshu.acadgildprojbatch3;

import java.text.DecimalFormat;
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
public class LogicDivide {
    public static String question;

    double questionDigitA;
    double questionDigitB;

    public static double optionA;
    public static  double optionB;
    public static double optionC;
    public static double optionD;

    public static  double answer;

    // ADDITION = 0
    //SUBTRACTION = 1
    //MULTIPLY =3
    // DIVIDE = 4

    double min;
    double max;
    double method;

    LogicDivide(double min, double max, double method){
        this.min = min;
        this.max =max;
        this.method = method;

        LogicMaker(min,max,method);
    }
    public void LogicMaker(double min, double max, double method){
        try {
            questionDigitA = getRandomNumber(min, max);
            questionDigitB = getRandomNumber(min, max);
               System.out.println("                                           ");
            System.out.println("                                           ");
             System.out.println("Value of A :"+questionDigitA);
             System.out.println("Value of B :"+questionDigitB);

            if (method == 0)
                answer = questionDigitA + questionDigitB;
            else if (method == 1)
                answer = questionDigitA - questionDigitB;
            else if (method == 2)
                answer = questionDigitA * questionDigitB;
            else if (method == 3)
                answer = questionDigitA / questionDigitB;

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Answer :"+Double.valueOf(df.format(answer)));
            answer = Double.valueOf(df.format(answer));
            int answerLength = (int) Math.log10(answer) + 1;
            System.out.println("answerLength :"+answerLength);


            double start = answerLength;
            double end = answerLength+1;
            final Set<Double> intSet = new HashSet<>();
            double random;
            double options;
            while (intSet.size() < 3) {
                random = new Random().nextDouble();
                options = start + (random * (end - start));
                System.out.println("options "+options);
                DecimalFormat df1 = new DecimalFormat("#.##");
                options =Double.valueOf(df1.format(options));
                if (options != answer)
                    intSet.add(options);
            }

            final Double[] ints = new Double[intSet.size()];
            final Iterator<Double> iter = intSet.iterator();
            for (int i = 0; iter.hasNext(); ++i) {
                ints[i] = iter.next();
            }
        System.out.println(Arrays.toString(ints));

            List<Double> solution = new ArrayList<>(4);
            solution.add(answer);
            for (int i = 0; i <= ints.length - 1; i++) {
                solution.add(ints[i]);
            }
            Collections.shuffle(solution);

            question = (questionDigitA) + " ÷" + questionDigitB + "";
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
        }catch (Exception e){
            e.printStackTrace();
            LogicMaker(min,max,method);
        }
    }



    public double getRandomNumber(double min, double max) {
        return (double) Math.floor(Math.random() * (max - min + 1)) + min;
    }

}