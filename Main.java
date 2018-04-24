package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numberCount;
        ArrayList<String> romanNumbersList = new ArrayList();

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many Roman Numbers you want add?");
        numberCount = scanner.nextInt();

        for(int i=0; i<numberCount; i++){
            System.out.println("Enter the " + (i+1) + "st number please.");
            String romanNumber = scanner.next();
            while(!romanNumbers.rulesControl(romanNumber)){
                System.out.println("Enter the " + (i+1) + "st number again please.");
                romanNumber = scanner.next();
            }
            romanNumbers newRoman = new romanNumbers(romanNumber);
            romanNumbersList.add(newRoman.getRomanNumber());
        }

        if(!romanNumbers.biggerThan3000Rule(romanNumbersList)){
            System.out.println("Sums of those " + romanNumbersList.size() + " Roman Numbers = " + romanNumbers.addRomanNumbers(romanNumbersList));
        }    }
}
