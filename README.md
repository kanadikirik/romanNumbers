# romanNumbers
Roman Numbers Processes

# You can create a romanNumber object with 3 ways.

1) romanNumbers()

2) romanNumbers(String romanNumber) 
  - If you create a romanNumber object with this constructor, automatically your romanNumber turns a normalNumber and you can use it like "object.getNormalNumber()"
3) romanNumbers(ArrayList<String> romanNumbers)
  - You can get sum of all roman numbers of given ArrayList with this constructor. You can use it like "object.getSumOfRomanNumbers()"
  
# Roman Numbers Rules

1) rulesControl(String romanNumber)
- You can control your romanNumber with this method. If your roman number keep the rules, this method will return true. It contains all of rules. 
2) biggerThan10TimesRule(String romanNumber)
3) biggerThanTripleRule(String romanNumber)
4) only1NumberMinus1NumberRule(String romanNumber)
5) VorLorDCantMinusRule(String romanNumber)
6) lettersRule(String romanNumber)
7) biggerThan3000Rule(String romanNumber)
8) biggerThan3000Rule(ArrayList<String> romanNumbers)
  
# Roman Numbers Processes

1) letterToNumber(char letter)
  - You can turn your letter to number with this method. If your letter doesn't keep the lettersRule this method will return 0.
2) toNormalNumber(String romanNumber)
  - You can turn your roman number to normal number with this method.
3) toRomanNumber(int normalNumber)
  - You can turn your normal number to roman number with this method.
4) addRomanNumbers(ArrayList<String> romanNumbers) 
  - You cant get sum of roman numbers of given ArrayList.
