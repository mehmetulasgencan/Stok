package stok;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

public class Add_Record extends JFrame
implements ActionListener{
		
	private String[] namestr={"Turkish Coffee","Nescafe","Tea","Coke","Water","Hot Choclate "};
	
	
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	
	JComboBox name=new JComboBox();
	JTextField buy=new JTextField(10);
	JTextField sell=new JTextField(10);
	JTextField total=new JTextField(10);
	JTextField price=new JTextField(10);
	
	JLabel lname=new JLabel("Product Name  : ");
	JLabel ltotal=new JLabel("Total         : ");
	JLabel lbuy=new JLabel("Buy  : ");
	JLabel lsell=new JLabel("Sell         : ");
	JLabel lprice=new JLabel("Price         : ");
	JButton Buttonadd=new JButton("ADD RECORD");
	JButton returnn=new JButton("RETURN BACK");
	 Connection conn; 
	 Statement stat; 
	    ResultSet result;  

	public static void main(String[] args) {
		
Add_Record record=new Add_Record();

	}
	
	
	public Add_Record()
	  {
	    setLayout(new FlowLayout());
	    setSize(580,290);
	    setTitle("Form");
	    setDefaultCloseOperation(3);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    setResizable(true);
	   
	    add(lname);
	    add(name);
	    add(panel2);
	   
	    add(lprice);
	    add(price);
	    add(lbuy);
	    add(buy);
	   add(lsell);
	    add(sell);
	    add(ltotal);
	    add(total);
	    
	    add(panel1);
	  panel1.add(Buttonadd);
	  panel1.add(returnn);
	  
	  Buttonadd.addActionListener(this);
	  returnn.addActionListener(this);
	  for(int i=0; i<=6; i++)
	  {
		  name.addItem(namestr[i].toString());
		  
	  }
	
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
		
		if(e.getSource()==Buttonadd)
		{
			
	    	  
	    		   try{ 	
	    		  
	      	 Class.forName("org.sqlite.JDBC");
	            
Connection conn = DriverManager.getConnection("jdbc:sqlite:src//data.db"); 

Statement komut =  conn.createStatement();
	             
	              String sorgu=("insert into Stok (product_name,price,buy,sell,total)"
 + "VALUES ('" +  name.getSelectedItem() + "','" + price.getText() + "','" + buy.getText() + "','" + sell.getText() + "','" + total.getText() + "')");
	    	        
	        	  JOptionPane.showMessageDialog(null,"RECORDS ADDED...");
	    	         komut.executeUpdate(sorgu); 
	    	         
	    	         
	    	         
	              conn.close();
	              
	             
	           	          }
	          catch (Exception s)
	          {
	        	  JOptionPane.showMessageDialog(null,"RECORD NOT REGISTER..");
	              System.out.print(s.getMessage());
	          }
	    	
		      		    	
			
	        
		}
	       
		
	            } 
	    	         
	                      
       
		}
	


	
	
	
	
	


