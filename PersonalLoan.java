/*
 * This class is calculate and apply the user choice of term and prime intrest
 * for personal loan and displays the information using the super method.
 * 
 * Assignment# :  9,Q-2
 * Name: Kishan Patel
 * Date: 10/28/2021 
*/

public class PersonalLoan extends Loan {
   private double interestRate;

   public PersonalLoan(int num, String name, double amt, int yrs, double prime) {
       super(num, name, amt, yrs);
       this.interestRate = prime*100 + 2;
   }

   @Override
   public String toString() {
       return "Personal" + super.toString() + " at " + (int)interestRate + "% interest";
   }


}