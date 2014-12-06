package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.QueryBuild.QueryBuilder;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class showAllUsers extends JFrame {

	private JPanel contentPane;

	QueryBuilder qb = new QueryBuilder();

	/**
	 * Create the frame.
	 */
	public showAllUsers() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnReturnToMenu.setBounds(447, 793, 147, 29);
		contentPane.add(btnReturnToMenu);
		
		JLabel lblDisplayingAllUsers = new JLabel("Displaying all users");
		lblDisplayingAllUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDisplayingAllUsers.setBounds(18, 19, 247, 36);
		contentPane.add(lblDisplayingAllUsers);
	
		//Users should be pulled from DB, of course
		String[] columnNames = {"Username", "Date Created", "Class"};
		Object [][] data = {
				{},
		};
		
		
	
		JTable showAllUsers = new JTable(data, columnNames);
		showAllUsers.setShowGrid(true);
		showAllUsers.setBounds(18, 95, 553, 686);
		showAllUsers.setRowHeight(20);
		contentPane.add(showAllUsers);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUsername.setBounds(18, 67, 90, 16);
		contentPane.add(lblUsername);
		
		JLabel lblDateAdded = new JLabel("Date added");
		lblDateAdded.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDateAdded.setBounds(202, 67, 90, 16);
		contentPane.add(lblDateAdded);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblClass.setBounds(389, 67, 61, 16);
		contentPane.add(lblClass);
	}

}
