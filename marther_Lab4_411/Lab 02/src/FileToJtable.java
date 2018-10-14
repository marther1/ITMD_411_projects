/** 
 * @author Amir
 * 4/3/18
 * FileToJtable.java
 * Lab 4
 * This program first makes a connection to a database.
 * Then creates a table in which the data is then inserted.
 * Then the inserted data is retrieved from the database. 
 * And finally it outputs the retrieved data in the console and a GUI frame.   
 * 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class FileToJtable {

    public void run_jtable() {
        Runnable run = new Runnable() {

            public void run() {
                new FileToJtable().createUI();
            }
        };

        EventQueue.invokeLater(run);
    }
    
    //method creates the actual table

    private void createUI() {

        try {
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            JTable table = new JTable();

            String readLine = null;

            CustomerTableModel tableModel = new CustomerTableModel();
            File file = new File("jtable.csv");

            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            List<Customer> customerList = new ArrayList<Customer>();
            
            //reads the file while separating by ","
            while((readLine = br.readLine()) != null) {
                String[] splitData = readLine.split(",");

                Customer customer = new Customer();
                customer.setID(splitData[0]);
                customer.setIncome(splitData[1]);
                customer.setPep(splitData[2]);
                
                customerList.add(customer);
            }

            tableModel.setList(customerList);
            table.setModel(tableModel);

            table.setAutoCreateRowSorter(true);
            
            //table properties GUI
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(table));
            frame.setTitle("BankRecords");
            frame.pack();
            frame.setVisible(true);

        } catch(IOException e) {
        	e.printStackTrace();
        }
    }

    
   //sets and gets the values for the rows
    class Customer {

        private String id;
        private String income;
        private String pep;

        public String getID() {
            return id;
        }
        public void setID(String id) {
            this.id = id;
        }
        
        
        public String getIncome() {
            return income;
        }
        public void setIncome(String income) {
            this.income = income;
        }
        
        
        
        public String getPep() {
        	return pep;
        }
        public void setPep(String pep) {
        	this.pep = pep;
        }
        
        
    }
    
    //defines the column names and sizes

    class CustomerTableModel extends AbstractTableModel {

        private List<Customer> list = new ArrayList<Customer>();
        private String[] columnNames = {"ID", "Income", "Pep"};

        public void setList(List<Customer> list) {
            this.list = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
            return list.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIdx, int colIdx) {
            switch (colIdx) {
            case 0:
                return list.get(rowIdx).getID();
            case 1:
                return list.get(rowIdx).getIncome();
            case 2:
            	return list.get(rowIdx).getPep();
            default:
                return null;
            }
        }
    }
}