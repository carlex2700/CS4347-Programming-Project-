package Main;



import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;
import java.lang.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchWindow extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Search");
    JFrame frame_two = new JFrame("Results");
    JTextField search = new JTextField();
    JLabel search_label = new JLabel("Enter a book or author to search for");
    JButton submit = new JButton();
    JLabel results = new JLabel();
    String submit_collected;
    JTable table;
    DefaultTableModel defaultTableModel;

    SearchWindow(){
        JPanel panel = new JPanel(new GridLayout(2,2,50,50));
        panel.add(search_label);
        panel.add(search);
        panel.add(submit);
        
        setLayout(new FlowLayout());
        
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource() == submit) {
                	submit_collected = search.getText();
                	
                	frame_two.setLayout(new FlowLayout());
                	frame_two.setSize(1000,1000);
                	
                	//setting the properties of jtable and defaulttablemodel
                	defaultTableModel = new DefaultTableModel();
                	table = new JTable(defaultTableModel);
                	table.setPreferredScrollableViewportSize(new Dimension(1000,100));
                	table.setFillsViewportHeight(true);
                	frame_two.add(new JScrollPane(table));
                	defaultTableModel.addColumn("ISBN10");
                	defaultTableModel.addColumn("ISBN13");
                	defaultTableModel.addColumn("TITLE");
        	
                	try {
                		Class.forName("com.mysql.jdbc.Driver");
                		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true", "root", "Thecrow_69");
                		
                		String sql = "SELECT * FROM book WHERE title LIKE '%" + submit_collected + " %';";
                		PreparedStatement pstmt = conn.prepareStatement(sql);            		
                		ResultSet rs = pstmt.executeQuery();

                		while(rs.next()) {
                			String isbn10 = rs.getString("isbn10");
                            String isbn13 = rs.getString("isbn13");
                            String title = rs.getString("title");
                            defaultTableModel.addRow(new Object[] {isbn10,isbn13,title});
                            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                            table.setDefaultRenderer(String.class, centerRenderer);
                            frame_two.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame_two.setVisible(true);
                            frame_two.validate();
                            
                		}
                		
                	} catch(Exception e1) {
                		JOptionPane.showMessageDialog(null, e1);
                	}	
                }
            }

        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(true);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}