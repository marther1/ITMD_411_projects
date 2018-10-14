
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;		
//to allow use of the ActionListener
//to allow use of a message box

//Mohmedamir Arther Student : Programmer

class Bank extends JFrame implements ActionListener
{	
		JButton SavingsButton, CheckingButton, LoanButton, DepositButton, WithdrawalButton;

    public Bank()
    {
    	//JLayeredPane pane = new JLayeredPane();
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());

		SavingsButton = new JButton("Savings Account");
		CheckingButton = new JButton("Checking Account");
		LoanButton = new JButton("Loan");
		pane.add(SavingsButton);
		pane.add(CheckingButton);
		pane.add(LoanButton);
		SavingsButton.addActionListener(this);
		CheckingButton.addActionListener(this);
		LoanButton.addActionListener(this);
		
		setTitle("Account Type");

		pack();

		setVisible(true); //allows the frame to be visible
	}
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();

      if (source == SavingsButton)
      {
    	Container pane = getContentPane();
  		pane.setLayout(new FlowLayout());
  		setVisible(false);
    	DepositButton = new JButton("Deposit Money");
  		WithdrawalButton = new JButton("Withdrawal Money"); 
  		pane.add(DepositButton);
		pane.add(WithdrawalButton);
		
		setTitle("Transaction");

		pack();

		setVisible(true);
        //double result = Integer.parseInt(num1TextField.getText());
        //double result1 = Integer.parseInt(num2TextField.getText());
        //double result2 = result + result1;
        //answerTextField.setText(String.valueOf(result2));
      }
    }
    
	public static void main(String[] args)
	{
		new  Bank();
	}
}
