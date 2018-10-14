import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class JavaMenus extends JFrame { 

	class MyCanvas extends JComponent {

		  public void paint(Graphics g) {
			  int[] x = new int[]{100,200,300,400};
			    int[] y = new int[]{400,300,300,100};
			    g.drawPolygon (x, y, x.length);   
		  }
		}
	

	public JavaMenus()
	{
		super("Java Menu Example");
		
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		
		JMenu file2 = new JMenu("Menu");
		file.setMnemonic('M');
		
		JMenuItem ItemWelcome = new JMenuItem("Welcome");
		ItemWelcome.setMnemonic('W');
		file2.add(ItemWelcome);
		
		JMenuItem ItemAbout = new JMenuItem("About");
		ItemAbout.setMnemonic('W');
		file2.add(ItemAbout);
		
		JMenuItem ItemNew = new JMenuItem("New");
		ItemNew.setMnemonic('N');
		file.add(ItemNew);
		
		JMenuItem ItemOpen = new JMenuItem("Open");
		ItemOpen.setMnemonic('O');
		file.add(ItemOpen);	
		
		JMenuItem ItemEdit = new JMenuItem("Edit");
		ItemEdit.setMnemonic('E');
		file.add(ItemEdit);
		
		JMenuItem ItemExit = new JMenuItem("Exit");
		ItemExit.setMnemonic('x');
		file.add(ItemExit);
		
		final JLabel label1 = new JLabel(" Welcome");
	     	add(label1);
	      	this.setSize(100, 100);
		setVisible(true);
								
		ItemNew.addActionListener(
		 new ActionListener() {
		  public void actionPerformed(ActionEvent e)
		  {
			label1.setText(" New");
			 ImageIcon icon = new ImageIcon(JavaMenus.class.getResource("DJ.png"));
			 JOptionPane.showMessageDialog(null,"Major Key Alert","Image", JOptionPane.INFORMATION_MESSAGE,icon);
			 }
			}
		);
		
		ItemOpen.addActionListener(
		  new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {
		    	label1.setText(" Open");
		    	JFrame window = new JFrame();
			    window.setBounds(20, 20, 450, 450);
			    window.getContentPane().add(new MyCanvas());
			    window.setVisible(true);
		    }
		  }
		);
		
		ItemEdit.addActionListener(
				  new ActionListener(){
				    public void actionPerformed(ActionEvent e)
				    {
					label1.setText(" Edit");
					String input = JOptionPane.showInputDialog("Enter your name");
					 JOptionPane.showMessageDialog(null,input, "User's Name", JOptionPane.INFORMATION_MESSAGE);
				    }
				   }
				);
		
		ItemExit.addActionListener(
		  new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {
			label1.setText(" Exit");
			System.exit(0);
		    }
		  }
		);				
		
		ItemWelcome.addActionListener(
		  new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {
			label1.setText(" Welcome");
			JOptionPane.showMessageDialog(null, "This program illustrates an example of the power of a graphical user interface by using 	Java swing components.", 
			   "Welcome", JOptionPane.PLAIN_MESSAGE);
		    }
		  }
		);		
		
		ItemAbout.addActionListener(
				  new ActionListener(){
				    public void actionPerformed(ActionEvent e)
				    {
					label1.setText(" About");
					JOptionPane.showMessageDialog(null, "Programmer: Mohmedamir Arther"
							+ "\n4.6.2", 
					   "About", JOptionPane.PLAIN_MESSAGE);
				    }
				  }
				);		

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(file);
		bar.add(file2);
		
		getContentPane();
		setSize(250, 250);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		JavaMenus appMenu = new JavaMenus();
		appMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
