package com.example.iramirez.myapplicationfirst;

import java.util.Random;

/**
 * Created by IVANROCK on 13-Feb-16.
 */
public class Utils {


   public static int GetRandomNumber(){

        int min = 1;
        int max = 999;

        Random r = new Random();
        int numberRdmBtton = r.nextInt(max - min + 1) + min;

        return (int)numberRdmBtton;
    }

    public static int GetNumberRandomButton(){

        int min = 1;
        int max = 3;

        Random r = new Random();
        int numberRdmBtton = r.nextInt(max - min + 1) + min;

        return (int)numberRdmBtton;
    }


}
