/*
 * This class creates the all the variable needed to take userinput
 * super method takes the user input and displays it when called.
 * 
 * Assignment# :  9,Q-2
 * Name: Kishan Patel
 * Date: 10/28/2021 
*/

import java.text.DecimalFormat;

public abstract class Loan implements LoanConstants {
   protected int loanNum;
   protected String lastName;
   protected double amount;
   protected double rate;
   protected int term;

   public Loan(int num, String name, double amt, int yrs) {
       this.loanNum=num;
       this.lastName=name;
       this.amount=amt;
       this.term=yrs;
   }
  

   public String toString() {
       // DecimalFormat class is used to format the output
               DecimalFormat df = new DecimalFormat(".0");
       String str="Loan #"+loanNum+" Name: "+lastName+" $"+df.format(amount)+" for "+term+" year(s)";
       return str;
   }

   public boolean equals(Loan loan) {
       if(this.loanNum==loan.loanNum && lastName.equals(loan.lastName) && amount==loan.amount && term==loan.term)
           return true;
       else
           return false;
   }
}