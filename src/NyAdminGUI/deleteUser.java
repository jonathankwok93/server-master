package NyAdminGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import model.QueryBuild.QueryBuilder;
import databaseMethods.SwitchMethods;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class deleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField textDeleteUser, textCalendarName;


	public deleteUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRemoveEvent = new JButton("Remove user");
		btnRemoveEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//searchresult.getSelecetedIndex();
				//Logic.removeUser();
				dispose();
			}
		});
		btnRemoveEvent.setBounds(372, 643, 146, 29);
		contentPane.add(btnRemoveEvent);

		textDeleteUser = new JTextField("Which user should be deleted?");
		textDeleteUser.setBounds(139, 64, 368, 28);
		contentPane.add(textDeleteUser);
		textDeleteUser.setColumns(10);

		JLabel lblSearchEvent = new JLabel("Enter username");
		lblSearchEvent.setBounds(20, 70, 130, 20);
		contentPane.add(lblSearchEvent);

		JButton btnSearch = new JButton("Destroy user");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent r){
				try {
					if(Logic.deleteUser(textDeleteUser.getText())){
					//if(true){	
						errorMessage em = new errorMessage("The user " + textDeleteUser.getText() + " has not been deleted");
						em.setVisible(true);
						dispose();
					}else{
						errorMessage em = new errorMessage("The user " + textDeleteUser.getText() + " has been deleted");
						em.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnSearch.setBounds(226, 93, 206, 29);
		contentPane.add(btnSearch);
		
		JLabel lblCreateCalendar = new JLabel("Create name");
		lblCreateCalendar.setBounds(20, 170, 130, 20);
		contentPane.add(lblCreateCalendar);

		textCalendarName = new JTextField("Name of calendar to create:");
		textCalendarName.setBounds(140, 170, 375, 30);
		contentPane.add(textCalendarName);
		textCalendarName.setColumns(10);
		
		JButton btnCreateCalendar = new JButton("Create calendar");
		btnCreateCalendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				String calendarName = textCalendarName.getText();
				String Active = "1";
				String CreatedBy = "Admin";
				String PrivatePublic = "1";

				System.out.println("Nu er vi nået til else-metoden");
				QueryBuilder qb = new QueryBuilder();
				String[] kolonner = { "Name", "CreatedBy", "PrivatePublic", "Active", };
				String[] Values = { calendarName, CreatedBy, PrivatePublic, Active};
				try {
					qb.insertInto("Calendar", kolonner ).values(Values).Execute();

					System.out.println("Calendar has been succesfully added!");


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCreateCalendar.setBounds(226, 200, 206, 29);
		contentPane.add(btnCreateCalendar);
		


	
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnReturnToMenu.setBounds(400, 280, 135, 30);
		contentPane.add(btnReturnToMenu);
		

	}
}
