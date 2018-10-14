
//Mohmedamir Arther Student: programmer
import java.awt.*;			//to use class Container 
import javax.swing.*;			//to use swing components
import java.awt.event.*;		
//to allow use of the ActionListener
import javax.swing.JOptionPane;
import java.util.InputMismatchException;
//to allow use of a message box


class GUIExample1 extends JFrame implements ActionListener 
{
	//class definition, which inherits from class JFrame

	//define interface components
	JLabel numberLabel;
	JTextField numberTextField;
	JButton displayButton;

    public GUIExample1()
    {
	  //class constructor will "construct" the user interface
	  //components to a content pane are placed in the order 	  //that they are added
	  Container pane = getContentPane();
	  pane.setLayout(new FlowLayout());
	  //The getContentPane() method sets up the content pane. 	  //The FlowLayout manager lays out the components in a 	  //free flowing, left to right order.
	  numberLabel = new JLabel("Enter a number:");
	  numberTextField = new JTextField(4);
	  displayButton = new JButton("Enter");

	  pane.add(numberLabel);
	  pane.add(numberTextField);
	  pane.add(displayButton);
	  displayButton.addActionListener(this);

	  //The add() method adds components into the content pane

	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setTitle("GUI Example");
	  pack();
	  setVisible(true);
	}
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
try{
      if (source == displayButton)
      {
        double result = Integer.parseInt(numberTextField.getText());
        JOptionPane.showMessageDialog(null, "you entered " + (int)(result), "Hello", JOptionPane.PLAIN_MESSAGE);
          System.exit(0);	
      }
    }
    catch(NumberFormatException ex) {                            
    	JOptionPane.showMessageDialog(null,"Please enter a number", "Error", JOptionPane.PLAIN_MESSAGE);       
     }          
}

	public static void main(String[] args)
	{
	  new GUIExample1();
	}
}

