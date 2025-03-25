package fr.anthonyquere.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static List<String> startFizzBuzz(int count) {
        List<String> result = new ArrayList<>();

        for(int index = 1; index <= count; index++){
            String strToAdd = "";
            if(index % 3 == 0 && index % 5 == 0){
                strToAdd = "FizzBuzz";
            } else if(index % 3 == 0){
                strToAdd = "Fizz";
            } else if(index % 5 == 0){
                strToAdd = "Buzz";
            } else {
                strToAdd = String.valueOf(index);
            }

            result.add(strToAdd);
        }

        return result;
    }
}