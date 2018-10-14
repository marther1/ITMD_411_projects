import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

class Items extends JFrame 
{
	//declare the variables (objects) and method(s)
	//create the panel to place objects such as checkboxes
	JPanel pnl = new JPanel();
	
	//create a String Array
	String[] South = { "Garden tools", "Fertilizer","Pest Control" } ;

	//create the checkboxes
	JCheckBox chk1 = new JCheckBox( South[0] ) ;
	JCheckBox chk2 = new JCheckBox( South[1] ) ; 
	JCheckBox chk3 = new JCheckBox( South[2] ) ;
	

	//create another array for other choices
	String[] Center = { "Garden tips", "Garden supplies", "Garden plants - Flowers", "Garden plants - Fruit trees", "Garden plants - Vegetables" } ;	

	//create a combobox
	JComboBox box1 = new JComboBox(Center);
	
	//create another item called a listbox
	JList lst1 = new JList(Center);

	//create the class method Items()
	public Items()
	{
		//create the window/panel
		super( "Swing Window" );
		setSize( 500,200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		add(pnl);
		

		//add the different checkboxes to the panel
		pnl.add( chk1 ) ;
		pnl.add( chk2 ) ;
		pnl.add( chk3 ) ;
				
		//add the combobox
		box1.setSelectedIndex(0);
		pnl.add( box1 ) ;
		
		pnl.add( lst1 ) ; 

		setVisible( true );
	}

	public static void main (String[] args)
	{
		Items gui = new Items();
	} 
}

