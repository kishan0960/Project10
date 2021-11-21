/*
 * This class uses userinput prime intrest rate, amount and term to calculate
 * the final intrest and display all the information by calling super method. 
 * 
 * Assignment# :  9,Q-2
 * Name: Kishan Patel
 * Date: 10/28/2021 
*/

public class BusinessLoan extends Loan {
   private double interestRate;

   public BusinessLoan(int num, String name, double amt, int yrs, double prime) {
       super(num, name, amt, yrs);
       this.interestRate = (prime*100) + 1;
   }

   @Override
   public String toString() {
       return "Business "+ super.toString() + " at " + (int)interestRate + "% interest";
   }


}