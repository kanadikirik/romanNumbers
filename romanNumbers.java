package com.company;

import java.util.ArrayList;

public class romanNumbers {

    private String romanNumber;
    private int normalNumber;
    private ArrayList<String> romanNumbers;
    private String sumOfRomanNumbers;

    //CONSTRUCTORS
    romanNumbers(){}
    romanNumbers(String romanNumber){
        this.romanNumber = romanNumber.trim().toUpperCase();
        normalNumber = toNormalNumber(romanNumber);
    }
    romanNumbers(ArrayList<String> romanNumbers){

        for(String number : romanNumbers){
            number.trim().toUpperCase();
        }

        this.romanNumbers = romanNumbers;
        sumOfRomanNumbers = addRomanNumbers(romanNumbers);
    }

    //RULES FOR ROMAN NUMBERS
    public static boolean rulesControl(String romanNumber){
        if(lettersRule(romanNumber) && !biggerThan10TimesRule(romanNumber) && only1NumberMinus1NumberRule(romanNumber) && VorLorDCantMinusRule(romanNumber)
                && !biggerThanTripleRule(romanNumber) && !biggerThan3000Rule(romanNumber)){
            return true;
        } else{
            return false;
        }
    }

    public static boolean biggerThan10TimesRule(String romanNumber){

        boolean biggerThan10Times = false;
        romanNumber = romanNumber.trim().toUpperCase();

        if(romanNumber.length()>=2){
            for(int i=0; i<romanNumber.length()-1; i++){
                int controllingLetter = letterToNumber(romanNumber.charAt(i));
                int nextLetter = letterToNumber(romanNumber.charAt(i+1));
                if(controllingLetter<nextLetter){
                    if((controllingLetter*10)<nextLetter){
                        biggerThan10Times = true;
                        System.out.println("ERROR ! = A number can't subtract from number which bigger than itself 10 times or bigger");
                        break;
                    } else{
                        biggerThan10Times = false;
                    }
                } else{
                    biggerThan10Times = false;
                }
            }
        }
        return biggerThan10Times;
    }

    public static boolean biggerThanTripleRule(String romanNumber) {

        boolean biggerThantriple = false;
        romanNumber = romanNumber.trim().toUpperCase();

        if (romanNumber.length() >= 4) {
            for (int i = 0; i<romanNumber.length() - 3; i++) {
                char controlingLetter = romanNumber.charAt(i);
                if (controlingLetter == romanNumber.charAt(i+1) && controlingLetter == romanNumber.charAt(i+2) && controlingLetter == romanNumber.charAt(i+3)) {
                    biggerThantriple = true;
                    System.out.println("ERROR ! = A number can't be typed more than 3 times");
                    break;
                } else {
                    biggerThantriple = false;
                }
            }
        } else{
            biggerThantriple = false;
        }
        return biggerThantriple;
    }

    public static boolean only1NumberMinus1NumberRule(String romanNumber){

        boolean only1NumberMinus1Number = true;
        romanNumber = romanNumber.trim().toUpperCase();

        if(romanNumber.length()>=3){
            for(int i=0; i<romanNumber.length()-2; i++){
                int controllingLetter = letterToNumber(romanNumber.charAt(i));
                int nextLetter = letterToNumber(romanNumber.charAt(i+1));
                int twoNextLetter = letterToNumber(romanNumber.charAt(i+2));
                if(controllingLetter <= nextLetter && twoNextLetter>nextLetter){
                    only1NumberMinus1Number = false;
                    System.out.println("ERROR ! = Only 1 number can subtract from 1 number");
                    break;
                } else{
                    only1NumberMinus1Number = true;
                }
            }
        } else{
            only1NumberMinus1Number = true;
        }
        return only1NumberMinus1Number;
    }

    public static boolean VorLorDCantMinusRule(String romanNumber){

        boolean VorLcantMinus = true;
        romanNumber = romanNumber.trim().toUpperCase();

        if(romanNumber.length()>=2){
            for(int i=0; i<romanNumber.length()-1; i++){
                char controllingLetter = romanNumber.charAt(i);
                if (controllingLetter == 'V' || controllingLetter == 'L' || controllingLetter == 'D'){
                    char nextLetter = romanNumber.charAt(i+1);
                    if(letterToNumber(controllingLetter)<letterToNumber(nextLetter)){
                        VorLcantMinus = false;
                        System.out.println("ERROR ! = Only 10's powers can usable for subtraction process");
                        break;
                    } else{
                        VorLcantMinus = true;
                    }
                }
            }
        }
        return VorLcantMinus;
    }

    public static boolean lettersRule(String romanNumber){

        boolean lettersRule = true;
        romanNumber = romanNumber.trim().toUpperCase();

        for(int i=0; i<romanNumber.length(); i++){
            char controllingLetter = romanNumber.charAt(i);
            if(!(controllingLetter == 'I') && !(controllingLetter == 'V') && !(controllingLetter == 'X') && !(controllingLetter == 'L') && !(controllingLetter == 'C')
                    && !(controllingLetter == 'D') && !(controllingLetter == 'M')){
                lettersRule = false;
                System.out.println("ERROR ! = A Roman Number can contains just those letters: 'I','V','X','L','C','D','M' ");
                break;
            }
        }
        return lettersRule;
    }

    public static boolean biggerThan3000Rule(String romanNumber){
        if(toNormalNumber(romanNumber)>3000){
            System.out.println("You can enter value until just 3000");
            return true;
        } else{
            return false;
        }
    }

    public static boolean biggerThan3000Rule(ArrayList<String> romanNumbers){

        int sum = 0;
        for(String number : romanNumbers){
            sum+= toNormalNumber(number);
        }
        if(sum>3000){
            System.out.println("Sum of Roman Numbers cant be more than 3000");
            return true;
        } else{
            return false;
        }

    }

    //PROCESSES FOR ROMAN NUMBERS
    public static int letterToNumber(char letter) {

        if (letter == 'I') {
            return 1;
        } else if (letter == 'V') {
            return 5;
        } else if (letter == 'X') {
            return 10;
        } else if (letter == 'L') {
            return 50;
        } else if (letter == 'C') {
            return 100;
        } else if (letter == 'D') {
            return 500;
        } else if (letter == 'M') {
            return 1000;
        } else{
            return 0;
        }
    }

    public static int toNormalNumber(String romanNumber){

        int normalNumber = 0;
        romanNumber = romanNumber.trim().toUpperCase();

        for(int i=0; i<romanNumber.length(); i++){
            int firstNumber = letterToNumber(romanNumber.charAt(i));
            if(i+1 < romanNumber.length()){
                int secondNumber = letterToNumber(romanNumber.charAt(i+1));
                if(firstNumber >= secondNumber){
                    normalNumber+= firstNumber;
                } else{
                    normalNumber = normalNumber + secondNumber - firstNumber;
                    i++;
                }
            } else{
                normalNumber+= firstNumber;
            }
        }
        return normalNumber;
    }

    public static String toRomanNumber(int normalNumber){

        String romanNumber = "";

        while(normalNumber >= 1000){
            romanNumber+="M";
            normalNumber-=1000;
        }
        while(normalNumber>= 900){
            romanNumber+="CM";
            normalNumber-=900;
        }
        while(normalNumber >= 500){
            romanNumber+="D";
            normalNumber-=500;
        }
        while(normalNumber>= 400){
            romanNumber+="CD";
            normalNumber-=400;
        }
        while(normalNumber >= 100){
            romanNumber+="C";
            normalNumber-=100;
        }
        while(normalNumber>= 90){
            romanNumber+="XC";
            normalNumber-=90;
        }
        while(normalNumber >= 50){
            romanNumber+="L";
            normalNumber-=50;
        }
        while(normalNumber>= 40){
            romanNumber+="XL";
            normalNumber-=40;
        }
        while(normalNumber >= 10){
            romanNumber+="X";
            normalNumber-=10;
        }
        while(normalNumber>= 9){
            romanNumber+="IX";
            normalNumber-=9;
        }
        while(normalNumber >= 5){
            romanNumber+="V";
            normalNumber-=5;
        }
        while(normalNumber>= 4){
            romanNumber+="IV";
            normalNumber-=4;
        }
        while(normalNumber >= 1){
            romanNumber+="I";
            normalNumber-=1;
        }

        return romanNumber;
    }

    public static String addRomanNumbers(ArrayList<String> romanNumbers){

        String sumOfRomanNumbers = "";
        int sumOfNormalNumbers = 0;

        for(int i=0; i<romanNumbers.size(); i++){
            sumOfNormalNumbers+= toNormalNumber(romanNumbers.get(i));
        }

        return toRomanNumber(sumOfNormalNumbers);
    }

    // GETTER METHODS AND SETTER METHODS
    public String getRomanNumber() {
        return romanNumber;
    }

    public void setRomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    public int getNormalNumber() {
        return normalNumber;
    }

    public void setNormalNumber(int normalNumber) {
        this.normalNumber = normalNumber;
    }

    public ArrayList<String> getRomanNumbers() {
        return romanNumbers;
    }

    public void setRomanNumbers(ArrayList<String> romanNumbers) {
        this.romanNumbers = romanNumbers;
    }

    public String getSumOfRomanNumbers() {
        return sumOfRomanNumbers;
    }

    public void setSumOfRomanNumbers(String sumOfRomanNumbers) {
        this.sumOfRomanNumbers = sumOfRomanNumbers;
    }


}
