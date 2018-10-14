
import java.awt.event.*; 
import java.util.*; 
import java.awt.*; 
import javax.swing.*; 
import java.util.Scanner; 
 
class AccountType 
{ 
   private String name; 
 
   private long amount; 
 
   AccountType(String name, long amount) 
   { 
      this.name = name; 
      setAmount(amount); 
   } 
 
   void deposit(long amount) 
   { 
      this.amount += amount; 
   } 
 
   String getName() 
   { 
      return name; 
   } 
 
   long getAmount() 
   { 
      return amount; 
   } 
 
   void setAmount(long amount) 
   { 
      this.amount = amount; 
   } 
} 
class SavingsAccount extends AccountType 
{ 
   SavingsAccount(long amount) 
   { 
      super("Savings Account", amount); 
   } 
   void withdraw(long amount) 
   { 
      setAmount(getAmount() - amount); 
   } 
   void deposit(long amount) 
   { 
    setAmount(getAmount() + amount); 
   } 
} 
class CheckingAccount extends AccountType 
{ 
   CheckingAccount(long amount) 
   { 
      super("Checking Account", amount); 
   } 
 
   void withdraw(long amount) 
   { 
      setAmount(getAmount() - amount); 
   } 
   void deposit(long amount) 
   { 
    setAmount(getAmount() + amount); 
   } 
} 
class Loan extends AccountType{ 
   Loan(long amount) 
   { 
     super("Loan", amount); 
   } 
    void withdraw1(long amount) 
    { 
       setAmount(getAmount() - amount); 
    } 
    Loan(String name, long amount) 
    { 
       super(name, amount); 
    } 
 } 
class Mortgage extends Loan 
{ 
 
 Mortgage(String name, long amount) 
 { 
  super("Mortgage", amount); 
 } 
  
 void withdraw(long amount) 
 { 
  setAmount(getAmount()-amount); 
 }  
} 
class CarLoan extends Loan 
{ 
 
 CarLoan(String name,long amount) 
 { 
  super("Car Loan", amount); 
 } 
  
 void withdraw(long amount) 
 { 
  setAmount(getAmount()-amount); 
 }  
} 
class StudentLoan extends Loan 
{ 
 
 StudentLoan(String name, long amount) 
 { 
  super("Student Loan", amount); 
 } 
  
 void withdraw(long amount) 
 { 
  setAmount(getAmount()-amount); 
 }  
} 
class PersonalLoan extends Loan 
{ 
 
 PersonalLoan(String name, long amount) 
 { 
  super("Personal Loan", amount); 
 } 
  
 void withdraw(long amount) 
 { 
  setAmount(getAmount()-amount); 
 }  
} 
 
public class ATM extends JFrame implements ActionListener{ 
  
 JPanel pnl= new JPanel(); 
 JPanel pnl1=new JPanel(); 
 JPanel pnl2=new JPanel(); 
 JLabel lab=new JLabel("Enter 4-digit PIN: "); 
 JPasswordField pw=new JPasswordField(4); 
 JButton btn1 = new JButton( "Checking Account" ) ;  
 JButton btn2 = new JButton( "Savings Account" ) ; 
 JButton btn3 = new JButton( "Loan" ) ; 
 JButton btn4 = new JButton( "Deposit" ) ;  
 JButton btn5 = new JButton( "Withdraw" ) ; 
 
 public ATM() 
 { 
  super( "Swing Window" ); 
  setSize( 400,100 ); 
  setDefaultCloseOperation( EXIT_ON_CLOSE ); 
  pnl1.add(lab); 
  pnl1.add(pw); 
  String[] options= new String[] {"OK", "Cancel"}; 
  boolean out=false; 
  do{ 
  int option = JOptionPane.showOptionDialog(null, pnl1, "Welcome", 
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
                null, options, options[0]); 
  if(option==0) 
  { 
   char[] pin=pw.getPassword(); 
    if(pin.length<4 || pin.length>4) 
    { 
     JOptionPane.showMessageDialog(null, "Please enter a 4-digit PIN.",  
          "Result", JOptionPane.ERROR_MESSAGE); 
     out=true; 
    } 
    else 
    { 
     out=false; 
    } 
  } 
  if(option==1) 
  { 
   System.exit(0); 
  } 
  }while(out); 
   
  add(pnl); 
  pnl.add( btn1 ) ;    
  pnl.add( btn2 ) ; 
  pnl.add( btn3 ) ; 
  btn1.addActionListener(this);   
  btn2.addActionListener(this); 
  btn3.addActionListener(this); 
 
  setVisible( true ); 
 } 
 
 
 public void actionPerformed(ActionEvent e)  
 { 
  if(e.getSource()== btn1) 
  { 
   CheckingAccount ca= new CheckingAccount(4000); 
   boolean out=false; 
   do{ 
    String dw=JOptionPane.showInputDialog( this,"Please press 1 to deposit, 2 to withdraw and 3 to quit.", 
    
     "Options",JOptionPane.YES_NO_CANCEL_OPTION); 
   int dw1=Integer.parseInt(dw); 
   switch(dw1) 
   { 
    case 1: 
    String money=JOptionPane.showInputDialog( this,"Please enter the amount:", 
      "Deposit",JOptionPane.YES_NO_CANCEL_OPTION); 
    long dm=Long.parseLong(money); 
    ca.deposit(dm); 
    out=true; 
    break; 
     
    case 2: 
    String money1=JOptionPane.showInputDialog( this,"Please enter the amount:", 
      "Withdraw",JOptionPane.YES_NO_CANCEL_OPTION); 
    long wm=Long.parseLong(money1); 
    ca.withdraw(wm); 
    out=true; 
    break; 
     
    default: 
     JOptionPane.showMessageDialog(null, "Transaction Completed.", "", JOptionPane.PLAIN_MESSAGE); 
     out=false; 
    break; 
   } 
   JOptionPane.showMessageDialog(null, "Your new balance in your Checking Account is " + ca.getAmount() , "", JOptionPane.PLAIN_MESSAGE); 
   if (ca.getAmount()<200) 
   { 
    JOptionPane.showMessageDialog(null,"Your account balance is now below $200!");   
   } 
   }while(out); 
  } 
   
  if(e.getSource()== btn2) 
  { 
   SavingsAccount sa= new SavingsAccount(4000); 
   boolean out = false; 
   do{ 
   String dw=JOptionPane.showInputDialog( this,"Please press 1 to deposit, 2 to withdraw, and 3 to quit.", 
     "Options",JOptionPane.YES_NO_CANCEL_OPTION); 
   int dw1=Integer.parseInt(dw); 
   switch(dw1) 
   { 
    case 1: 
    String money=JOptionPane.showInputDialog( this,"Please enter the amount:", 
      "Deposit",JOptionPane.YES_NO_CANCEL_OPTION); 
    long dm=Long.parseLong(money); 
    sa.deposit(dm); 
    out=true; 
    break; 
     
    case 2: 
    String money1=JOptionPane.showInputDialog( this,"Please enter the amount:", 
      "Withdraw",JOptionPane.YES_NO_CANCEL_OPTION); 
    long wm=Long.parseLong(money1); 
    sa.withdraw(wm); 
    out=true; 
    break; 
     
    default: 
     JOptionPane.showMessageDialog(null, "Transaction Completed.", "", JOptionPane.PLAIN_MESSAGE); 
     out=false; 
    break; 
   } 
   JOptionPane.showMessageDialog(null, "Your new balance in your saving account is " + sa.getAmount() , "", JOptionPane.PLAIN_MESSAGE); 
   if (sa.getAmount()<200) 
   { 
    JOptionPane.showMessageDialog(null,"Your account balance is now below $200!");   
   } 
   }while(out); 
  } 
   
  if(e.getSource()== btn3) 
  { 
   StudentLoan sl= new StudentLoan("sl",75000); 
   Mortgage ml=new Mortgage("ml",350000); 
   CarLoan cl= new CarLoan("cl",35000); 
   PersonalLoan pl= new PersonalLoan("pl",5000); 
    
   boolean out = false; 
   do{ 
   String dw=JOptionPane.showInputDialog( this,"Please press 1 for Mortgage, 2 for Student Loan, 3 for Auto Loan, 4 for Personal Loan, 5 to quit.", 
     "Options",JOptionPane.YES_NO_CANCEL_OPTION); 
   int dw1=Integer.parseInt(dw); 
   switch(dw1) 
   { 
    case 1: 
    String money=JOptionPane.showInputDialog( this,"Please enter the number of months:", 
      "Mortgage",JOptionPane.YES_NO_CANCEL_OPTION); 
    long mm=Long.parseLong(money); 
    int mm1=(int) (mm * 3500); 
    ml.withdraw(mm1); 
    JOptionPane.showMessageDialog(null, "Your remaining balance in your mortgage is " + ml.getAmount() , "", JOptionPane.PLAIN_MESSAGE); 
    if (ml.getAmount()<mm1) 
    { 
     JOptionPane.showMessageDialog(null,"Your account balance is not enough.");   
    } 
    out=true; 
    break; 
     
    case 2: 
    String money1=JOptionPane.showInputDialog( this,"Please enter the number of months:", 
      "Student Loan",JOptionPane.YES_NO_CANCEL_OPTION); 
    long sm=Long.parseLong(money1); 
    int sm1=(int) (sm*250); 
    sl.withdraw(sm1); 
    JOptionPane.showMessageDialog(null, "Your remaining balance in your student loan is " + sl.getAmount() , "", JOptionPane.PLAIN_MESSAGE); 
    if (sl.getAmount()<sm1) 
    { 
     JOptionPane.showMessageDialog(null,"Your account balance is not enough.");   
    } 
    out=true; 
    break; 
     
    case 3: 
     String money2=JOptionPane.showInputDialog( this,"Please enter the number of months:", 
       "Auto Loan",JOptionPane.YES_NO_CANCEL_OPTION); 
     long am=Long.parseLong(money2); 
     int am1=(int)(am*500); 
     cl.withdraw(am1); 
     JOptionPane.showMessageDialog(null, "Your remaining balance in your auto loan is " + cl.getAmount() , "", JOptionPane.PLAIN_MESSAGE); 
     if (cl.getAmount()<am1) 
     { 
      JOptionPane.showMessageDialog(null,"Your account balance is not enough.");   
     } 
     out=true; 
     break; 
      
    case 4: 
     String money3=JOptionPane.showInputDialog( this,"Please enter the number of months:", 
       "Personal Loan",JOptionPane.YES_NO_CANCEL_OPTION); 
     long pm=Long.parseLong(money3); 
     int pm1=(int) (pm*1000); 
     pl.withdraw(pm1); 
     JOptionPane.showMessageDialog(null, "Your current balance in your Personal Loan is " + pl.getAmount() , "", JOptionPane.PLAIN_MESSAGE); 
     if (pl.getAmount()<pm1) 
     { 
      JOptionPane.showMessageDialog(null,"Your account balance is not enough.");   
     } 
     out=true; 
     break; 
     
    default: 
     JOptionPane.showMessageDialog(null, "Loan Payment Completed.", "", JOptionPane.PLAIN_MESSAGE); 
     out=false; 
    break; 
   } 
   }while(out); 
  } 
   
 } 
  
 public static void main( String[] args ) 
 { 
  ATM gui = new ATM(); 
 } 
 
 
} 