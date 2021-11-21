/*
 * This GUI program takes the input from users to create either business or personal loans.
 * It takes pre defined intrest methods and applys it on user choice based on term and amount. 
 * It displays all the infromation by calling diffrent class.
 * 
 * Assignment# :  
 * Name: Kishan Patel
 * Date: 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 */
/**
 *
 * @author User
 */
public class MainFrame extends JFrame implements ActionListener {

    private JButton businessButton = new JButton("Add business loan");
    private JButton personalButton = new JButton("Add Personal loan");
    private JButton outputButton = new JButton("Output");
    private double primeInterestRate;
    private JTextArea outText = new JTextArea(24, 12);
    private Loan loans[] = new Loan[10];
    private int loanCount = 0;

    public MainFrame() {
        super("Loans App");
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        JPanel panel = new JPanel();
        panel.add(businessButton);
        businessButton.addActionListener(this);
        personalButton.addActionListener(this);
        outputButton.addActionListener(this);
        panel.add(personalButton);
        panel.add(outputButton);

        JScrollPane jp = new JScrollPane(outText);
        this.getContentPane().add(jp, BorderLayout.CENTER);
        this.getContentPane().add(panel, BorderLayout.SOUTH);
        String input = JOptionPane.showInputDialog(this, "Enter the current prime interest rate as a decimal number(0.5,1) : ");
        primeInterestRate = Double.parseDouble(input);
        //addComponentsToPane(frame.getContentPane());

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int accNo, term;
        String name;
        double loanAmt;
        if (ae.getSource() == businessButton || ae.getSource() == personalButton) {

            if (loanCount >= loans.length) {
                JOptionPane.showConfirmDialog(this, "List Full");
                return;
            }

            //System.out.print("Enter account number : ");
            String input = JOptionPane.showInputDialog(this, "Enter account number : ");
            accNo = Integer.parseInt(input);
            name = JOptionPane.showInputDialog(this, "Enter name : ");
            while (true) {

                input = JOptionPane.showInputDialog(this, "Enter loan amount : $");
                loanAmt = Double.parseDouble(input);
                if (loanAmt > LoanConstants.MAXLOAN) {
                    JOptionPane.showConfirmDialog(this, "Invalid. Loan amount must be $" + LoanConstants.MAXLOAN + " lower.");
                } else {
                    break;
                }
            }
            if (ae.getSource() == personalButton) {

                input = JOptionPane.showInputDialog(this, "Enter term : ");
                term = Integer.parseInt(input);

                //PersonalLoan pl = new PersonalLoan(accNo, name, loanAmt, term, primeInterestRate);
                loans[loanCount++] = new PersonalLoan(accNo, name, loanAmt, term, primeInterestRate);
            } else {
                while (true) {
                    input = JOptionPane.showInputDialog(this, "Enter term 1 3 5 : ");
                    term = Integer.parseInt(input);
                    if (term != LoanConstants.SHORT_TERM && term != LoanConstants.MEDIUM_TERM && term != LoanConstants.LONG_TERM) {
                        JOptionPane.showConfirmDialog(this, "\n  ** Invalid.Must be either 1 or 3 or 5 **");
                    } else {
                        break;
                    }
                }
                loans[loanCount++] = new BusinessLoan(accNo, name, loanAmt, term, primeInterestRate);

            }

        } else if (ae.getSource() == outputButton) {
            String outputStr = "";
            outputStr += LoanConstants.COMPANY + "\n";
            for (int i = 0; i < loanCount; i++) {
                outputStr += loans[i] + "\n";
            }
            outText.setText(outputStr);
        }
    }

}
