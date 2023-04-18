package PP2;

import static java.lang.Math.toIntExact;

public class Validation {


  // Return true if the card number is valid, otherwise returns false, this method is already implemented
  public boolean aValidNumber(String n) {
    long number = Long.parseLong(n);
	  return (numLength(number) >= 13) && (numLength(number) <= 16)
        && (prefixCheck(number, 4) || prefixCheck(number, 5) || prefixCheck(number, 6) || prefixCheck(number, 37)) 
        && (totalEevenNumbers(number) + totalOddNumbers(number)) 
        % 10 == 0;
  }// end of aValidNumber method

  //get the sum of even places numbers, Starting from the second digit from right
  private int totalEevenNumbers(long number) {
    long sumOfEvens = 0, doubledDigit = 0, digit = 0;
    int i=0;
    // check until it becomes between 0 and 1 at which point it will return 0
    while(number>0){
      if(i%2 != 0){
        digit = number%10;
        doubledDigit = 2*digit;
        sumOfEvens = sumOfEvens + singleDigit(toIntExact(doubledDigit));
      }
      number = number/10;
      i++;
    }
	  return (int)sumOfEvens;
	  
  }// end of totalEevenNumbers method

  // Return the same number if it is a single digit, otherwise, return the sum of
  // the two digits in this number
  private int singleDigit(int number) {
    return (number>9)? (1 + number%10): number; 
  } // end of singleDigit method

  // Return the sum of odd place digits in number
  private int totalOddNumbers(long number) {
    long sumOfOdds = 0, digit = 0;
    int i=0;
    // check until it becomes between 0 and 1 at which point it will return 0
    while(number>0){
      if(i%2 == 0){
        digit = number%10;
        sumOfOdds = sumOfOdds + toIntExact(digit);
      }
      number = number/10;
      i++;
    }
    return (int)sumOfOdds;

  }// end of totalOddNumbers method

  // Return true if the digit d is a prefix for number
  private boolean prefixCheck(long number, int d) {
    return numPrefix(number, numLength(d)) == d;


    // long prefix = 0L;
    // while(number>0){
    //   if((int)number == d){
    //     return true;
    //   }
    //   prefix = number%10;
    //   number = number/10;
    // }
    // return (int)prefix == d;

  }// end of prefixCheck method


  // Return the number of digits in this number parameter
  private int numLength(long number) {
    int numberLength=0;
    // check until it becomes between 0 and 1 at which point it will return 0
    while(number>0){
      number = number/10;
      numberLength++;
    }
    return numberLength;
  }// end of numLength method

  // Return the first k number of digits from number, which is either a first digit or first two digits
  // Depending on the card type
  private long numPrefix(long number, int k) {
    long prefix = 0L;

    while(number>0){
      if(numLength(number) == k){
        return number;
      }
      prefix = number%10;
      number = number/10;
    }
    return prefix;


    // long onesDigit = 0L;
    // long tensDigit = 0L;
    // long res = 0L;

    // while(number>0){
    //   onesDigit = number%10;
    //   if(k==2 && number>0){
    //     number = number/10;
    //     tensDigit = number%10;
    //   }
    //   else{
    //     number = number/10;
    //   }
    // }

    // if(k==2){
    //   res = tensDigit*10 + onesDigit;
    // }
    // else{
    //   res = onesDigit;
    // }

    // return res;

  }// end of numPrefix method

}// end of the class
