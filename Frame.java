package Main;
import javax.swing.*;
import javax.swing.border.EmptyBorder; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{
	JButton bsearch;
	JButton loan; 
	JButton fine; 
	JButton manage; 
	JButton exit; 
	JFrame frame;
	
	Frame(){
			
		frame = new JFrame();
        frame.setTitle("Welcome to the Library");
		
        //creating object for gridbag
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        frame.setSize(500, 300);
        frame.setLayout(bagLayout);
        
        bagConstraints.insets = new Insets(10, 0, 0, 0);//Setting the padding between the components and neighboring components
 
        //Setting the properties for each button needed for the assignment
        bsearch = new JButton("Book Search");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        bagConstraints.ipadx = 50;
        bagConstraints.ipady = 50;
        frame.add(bsearch, bagConstraints);
        
        loan = new JButton("Book Loan");
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 0;
        bagConstraints.ipadx = 50;
        bagConstraints.ipady = 50;
        frame.add(loan, bagConstraints);
            
        manage = new JButton("Management");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 50;
        bagConstraints.ipady = 50;
        frame.add(manage, bagConstraints);
        
        fine = new JButton("Book Fine");
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 50;
        bagConstraints.ipady = 50;
        frame.add(fine, bagConstraints);
        
        exit = new JButton("Exit");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 3;
        bagConstraints.ipadx = 100;
        bagConstraints.ipady = 50;
        frame.add(exit, bagConstraints);
        
        frame.setVisible(true);
        frame.validate();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        
        setLayout(new FlowLayout());
    
		bsearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== bsearch) { 
					SearchWindow bookSearch = new SearchWindow();
				}
			}
		});
			
		loan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== loan ) {
					//LoanWindow loan_window = new LoanWindow();
				}
			}
			
		});
		
		manage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == manage ) {
					//ManageWindow mgmt_window = new ManageWindow();
				}	
			}			
		});
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				if(JOptionPane.showConfirmDialog(frame, "Do You Want To Exit Now?","EXIT", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}				
			}
		});			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}	
}