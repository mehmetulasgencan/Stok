package stok;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class Delete_Record extends JFrame
implements ActionListener{
	
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	
	
	
	JTextField id=new JTextField(10);
	
	JLabel lid=new JLabel("Product Id  : ");

	JButton Delete=new JButton("DELETE RECORD");
	JButton returnn=new JButton("RETURN BACK");
	 int did;
	

	public static void main(String[] args) {
		
Delete_Record record=new Delete_Record();

	}
	
	
	public Delete_Record()
	  {
		 setLayout(new FlowLayout());
		    setSize(420,290);
		    setTitle("Form");
		    setDefaultCloseOperation(3);
		    setLocationRelativeTo(null);
		    setVisible(true);
		    setResizable(true);
		   
		    
		    
		    panel2.add(lid);
		    panel2.add(id);
		    add(panel2);
		   
		   
		    add(panel1);
		  panel1.add(Delete);
		  panel1.add(returnn);
		  
		  Delete.addActionListener(this);
		  returnn.addActionListener(this);
		  
		  
		  }
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==returnn)
		{
			try {
				List list=new List();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			
		}
		
		if(e.getSource()==Delete)
		{
			
			try
	          {
				
  	    	
  	    		 
  	    	    	
  	    	    	this.did = Integer.parseInt(this.id.getText());
  	    	    	
  	    	    	Class.forName("org.sqlite.JDBC");
  		            
  	    	    	Connection conn = DriverManager.getConnection("jdbc:sqlite:src//data.db"); 
  	    	    	
  	    	       Statement komut = conn.createStatement();
  	    	     
  	    	    String sorgu="DELETE FROM Stok WHERE product_id= '" + did + "'"; 
  	    	    JOptionPane.showMessageDialog(null,"RECORD DELETED....");
  	    	    komut.executeUpdate(sorgu);
  	    	        
  	    	       
  	    	        conn.close();
  	    	        id.setText("");
  		          }
  	    	 catch (Exception s)
  		          {
  		        	  JOptionPane.showMessageDialog(null,"PLEASE ENTER PRODUCT ID...");
  		              System.out.print(s.getMessage());
  		          }
			
			
			
			
			
			
		}
	}


	
	}
	
	
	


