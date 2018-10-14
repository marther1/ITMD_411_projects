
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;		
//to allow use of the ActionListener

import javax.swing.JOptionPane;
//to allow use of a message box

//Mohmedamir Arther Student : Programmer

class Addition extends JFrame implements ActionListener
{	
	JLabel enterLabel, answerLabel;
	JTextField num1TextField, num2TextField, answerTextField;
	JButton addButton;

    public Addition()
    {
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());

		enterLabel = new JLabel("<< enter a number >>");
		answerLabel = new JLabel("Answer:");
		num1TextField = new JTextField(4);
		num2TextField = new JTextField(4);
		answerTextField = new JTextField(4);
		addButton = new JButton("Add");
		
		pane.add(num1TextField);
		pane.add(enterLabel);
		pane.add(num2TextField);
		pane.add(addButton);
		pane.add(answerLabel);
		pane.add(answerTextField);
		addButton.addActionListener(this);
		
		setTitle("Addition Calculator");

		pack();

		setVisible(true); //allows the frame to be visible
	}
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();

      if (source == addButton)
      {
        double result = Integer.parseInt(num1TextField.getText());
        double result1 = Integer.parseInt(num2TextField.getText());
        double result2 = result + result1;
        answerTextField.setText(String.valueOf(result2));
      }
    }
    
	public static void main(String[] args)
	{
		new  Addition();
	}
}
