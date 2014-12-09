package NyAdminGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.QueryBuild.QueryBuilder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class createCalendar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public createCalendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterCalendarName = new JLabel("Enter Calendar name");
		lblEnterCalendarName.setBounds(30, 121, 129, 16);
		contentPane.add(lblEnterCalendarName);
		
		JLabel lblCreateNewCalendar = new JLabel("Create new Calendar");
		lblCreateNewCalendar.setBounds(6, 6, 251, 16);
		contentPane.add(lblCreateNewCalendar);
		
		JButton btnCreateCalendar = new JButton("Create calendar");
		btnCreateCalendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				String calendarName = textField.getText();
				String Active = "1";
				String CreatedBy = "Admin";
				String PrivatePublic = "1";

				System.out.println("Nu er vi nået til else-metoden");
				QueryBuilder qb = new QueryBuilder();
				String[] kolonner = { "Name", "CreatedBy", "PrivatePublic", "Active", };
				String[] Values = { calendarName, CreatedBy, PrivatePublic, Active};
				try {
					System.out.println("Nu er vi nået til qb.insertInto");
					qb.insertInto("Calendar", kolonner ).values(Values).Execute();

					System.out.println("Calendar has been succesfully added!");


				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCreateCalendar.setBounds(283, 243, 161, 29);
		contentPane.add(btnCreateCalendar);
		
		JButton btnNewButton = new JButton("Return to menu¨");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(6, 243, 161, 29);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(171, 115, 273, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
