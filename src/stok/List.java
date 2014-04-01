package stok;

import java.awt.BorderLayout; 

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.Vector; 
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 

@SuppressWarnings("serial")
public class List extends JFrame
implements ActionListener{ 
		
   JButton Add_Record =new JButton("Add Record") ;
   JButton Delete_Record =new JButton("Delete Record") ;
   JPanel p = new JPanel();
   JPanel panel=new JPanel();
    JTable table; 
    Connection connnection; 
    Statement stat; 
    ResultSet result; 
    
    
    @SuppressWarnings("unchecked")
	public List() throws Exception { 
    	
        
     setLayout(new FlowLayout());
       setSize(160, 170);
        setTitle("List");
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
       
		
		        
	    
        setResizable(true);
        setLayout(new GridLayout(2, 1, 2, 10));
    	setSize(new Dimension(560, 350));
    	
    	
    	
    	
      
    	
     	
     	 
     	baglantiKur(); 
     	
           Object[] sutunAdlari={"ID","Product Name","Price","Buy","Sell","Total"}; 
            result=stat.executeQuery("SELECT * FROM Stok"); 
          
    
            @SuppressWarnings("rawtypes")
			Vector satirlar=new Vector(); 
            while(result.next()){ 
               Object[] degerler={result.getInt(1),result.getString(2),result.getInt(3),
                		          result.getInt(4), result.getInt(5), result.getInt(6)}; 
               satirlar.add(degerler); 
             
            } 
            Object[][] satirDegerleri=new Object[satirlar.size()][3]; 
            for(int i=0;i<satirlar.size();i++){ 
                satirDegerleri[i]=(Object[]) satirlar.get(i); 
                
            } 
            
            table=new JTable(satirDegerleri,sutunAdlari); 
            JScrollPane scrollpaneli=new JScrollPane(table); 
            panel.add(scrollpaneli,BorderLayout.CENTER); 
            table.setPreferredScrollableViewportSize(new Dimension(510,100));
            scrollpaneli.setVisible(true);
            
           
            
            
            add(panel);
       add(p);    
     
      
       p.add(Add_Record);
       p.add(Delete_Record);

        Add_Record.addActionListener(this);
        
        Delete_Record.addActionListener(this);
      
        baglantiKes();
        
        setVisible(true);
        
    } 
    
    public void baglantiKur() throws Exception { 
    	Class.forName("org.sqlite.JDBC"); 
    	connnection = DriverManager.getConnection("jdbc:sqlite:src//data.db"); 
    	stat=connnection.createStatement(); 
    } 
    public void baglantiKes() throws Exception { 
    	connnection.close(); 
    	stat.close(); 
    } 
    public static void main(String[] main){ 
    	
        try { 
           @SuppressWarnings("unused")
           
		List lists= new List(); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
        
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.Add_Record   )
		    {
		    	 
			 @SuppressWarnings("unused")
			Add_Record adds = new Add_Record();
		      dispose();
		    }
		 else if (e.getSource() == this.Delete_Record  )
		    {
				@SuppressWarnings("unused")
				Delete_Record deletes = new Delete_Record();
							 dispose();
		    }
	} 
}  