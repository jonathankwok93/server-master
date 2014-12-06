package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import databaseMethods.SwitchMethods;
import model.QueryBuild.QueryBuilder;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class showAllUsers extends JFrame {

	private JPanel contentPane;

	QueryBuilder qb = new QueryBuilder();
	SwitchMethods SW = new SwitchMethods();
	ArrayList user;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public showAllUsers() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		


//		JButton btnRemoveEvent = new JButton("Remove user");
//		btnRemoveEvent.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				//searchresult.getSelecetedIndex();
//				//Logic.removeUser();
//				dispose();
//			}
//		});
//		btnRemoveEvent.setBounds(372, 643, 146, 29);
//		contentPane.add(btnRemoveEvent);

//		textField = new JTextField();
//		textField.setBounds(139, 64, 368, 28);
//		contentPane.add(textField);
//		textField.setColumns(10);

//		JLabel lblSearchEvent = new JLabel("Enter username");
//		lblSearchEvent.setBounds(19, 70, 129, 16);
//		contentPane.add(lblSearchEvent);

//		JButton btnSearch = new JButton("Search and destroy");
//		btnSearch.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e){

//				try {
////					if(Logic.showAllUsers(textField.getText())){
//					//if(true){	
//						errorMessage em = new errorMessage("The user " + textField.getText() + " has been deleted");
//						em.setVisible(true);
//						dispose();
//					}else{
//						errorMessage em = new errorMessage("The user " + textField.getText() + " is not found");
//						em.setVisible(true);
//					}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

//			}
//		});
		
//		btnSearch.setBounds(226, 93, 206, 29);
//		contentPane.add(btnSearch);

		String [] columnNames = {"List of users: "};

	
		// opretter plads til 200 users til visning.
		String data [][] = {
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null}
		};	

		
		try {
			user = SW.getAllUsers();
			for (int i=0; i< user.size();i++)
			{
//				user.size()+
				String udskrift = user.get(i).toString();
				System.out.println(udskrift);
				data[i][0] =udskrift;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JTable searchResult = new JTable (data, columnNames);
		searchResult.setBounds(20, 50, 500, 500);
		contentPane.add(searchResult);
		searchResult.setRowHeight(30);

		JLabel lblEventName = new JLabel("List of users:");
		lblEventName.setBounds(20, 25, 100, 20);
		contentPane.add(lblEventName);

//		JLabel lblCreatedBy = new JLabel("Date created");
//		lblCreatedBy.setBounds(269, 138, 95, 16);
//		contentPane.add(lblCreatedBy);

//		JLabel lblForceRemoveEvent = new JLabel("Force remove user");
//		lblForceRemoveEvent.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//		lblForceRemoveEvent.setBounds(19, 18, 256, 34);
//		contentPane.add(lblForceRemoveEvent);

		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnReturnToMenu.setBounds(19, 643, 146, 29);
		contentPane.add(btnReturnToMenu);


		
		
//		JButton btnReturnToMenu = new JButton("Return to menu");
//		btnReturnToMenu.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				dispose();
//			}
//		});
//		btnReturnToMenu.setBounds(400, 800, 150, 30);
//		contentPane.add(btnReturnToMenu);
		
//		JLabel lblDisplayingAllUsers = new JLabel("Displaying all users");
//		lblDisplayingAllUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//		lblDisplayingAllUsers.setBounds(50, 50, 250, 30);
//		contentPane.add(lblDisplayingAllUsers);
	
		//Users should be pulled from DB, of course
//		String[] columnNames = {"Username", "Date Created", "Class"};
//		Object [][] data = {
//				{},
//		};
		



		
//	
//		JTable showAllUsers = new JTable(data, columnNames);
//		showAllUsers.setShowGrid(true);
//		showAllUsers.setBounds(18, 95, 553, 686);
//		showAllUsers.setRowHeight(20);
//		contentPane.add(showAllUsers);
//		
//		JLabel lblUsername = new JLabel("Username");
//		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 13));
//		lblUsername.setBounds(18, 67, 90, 16);
//		contentPane.add(lblUsername);
//		
//		JLabel lblDateAdded = new JLabel("Date added");
//		lblDateAdded.setFont(new Font("Lucida Grande", Font.BOLD, 13));
//		lblDateAdded.setBounds(202, 67, 90, 16);
//		contentPane.add(lblDateAdded);
//		
//		JLabel lblClass = new JLabel("Class");
//		lblClass.setFont(new Font("Lucida Grande", Font.BOLD, 13));
//		lblClass.setBounds(389, 67, 61, 16);
//		contentPane.add(lblClass);
	}

}
