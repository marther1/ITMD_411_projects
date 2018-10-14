import javax.swing.*;

class Buttons extends JFrame 
{
	JPanel pnl = new JPanel();

	ClassLoader ldr = this.getClass().getClassLoader();

	java.net.URL NorthURL = ldr.getResource("North.png");
	java.net.URL SouthURL = ldr.getResource("South.png");
	java.net.URL EastURL = ldr.getResource("East.png");
	java.net.URL WestURL = ldr.getResource("West.png");
	java.net.URL CenterURL = ldr.getResource("Center.png");
	
	ImageIcon North = new ImageIcon( NorthURL );
	ImageIcon South = new ImageIcon( SouthURL );
	ImageIcon East = new ImageIcon( EastURL );
	ImageIcon West = new ImageIcon( WestURL );
	ImageIcon Center = new ImageIcon( CenterURL );

	//ImageIcon North = new ImageIcon( "North.png" );
	//ImageIcon cross = new ImageIcon( "cross.png" );

	JButton btn = new JButton(  );
	JButton NorthBtn = new JButton( "Contact - 132-465-7842", North );
	JButton SouthBtn = new JButton( "Garden Supply Product", South );
	JButton EastBtn = new JButton( "Garden tips", East );
	JButton WestBtn = new JButton( "Plants sold", West );
	JButton CenterBtn = new JButton( "Combo box", Center );
	
	public Buttons()
	{
		super("Swing Window");
		setSize( 500,200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		add(pnl);
		
		pnl.add( btn );
		pnl.add( NorthBtn );
		pnl.add( SouthBtn );
		pnl.add( EastBtn );
		pnl.add( WestBtn );
		pnl.add( CenterBtn );

		setVisible( true );
	}

	public static void main ( String[] args )
	{
		Buttons gui = new Buttons();
	} 

static class Items extends JFrame 
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
	JComboBox box1 = new JComboBox(South);
	
	//create another item called a listbox
	JList lst1 = new JList(South);

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
}

