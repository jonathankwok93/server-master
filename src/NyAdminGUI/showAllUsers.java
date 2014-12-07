package NyAdminGUI;



import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import databaseMethods.SwitchMethods;
import model.QueryBuild.QueryBuilder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class showAllUsers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8645870175642344766L;

	private JPanel contentPane;

	QueryBuilder qb = new QueryBuilder();
	SwitchMethods SW = new SwitchMethods();
	ArrayList user, userActive;
	
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
		
		String [] columnNames = {"List of active users: "};
		// opretter plads til 200 users til visning.
		String data [][] = {
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
				{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},{null},
		};	
		
		//Laver en try og et for-loop, hvor vi henter alle brugernes id. Hvis deres aktiv er 1, så gemmer vi dem i data array'et for at vise det til admin.
		try {
			user = SW.getAllUsers();
			userActive = SW.getAllActiveUsers();
			String aktiv = "1";
			int j = 0;
			for (int i=0; i< user.size();i++)
			{
				String aktivBruger = userActive.get(i).toString();
				String brugerNavn = user.get(i).toString();
				if (aktivBruger.equals(aktiv))
				{
					data[j][0] =brugerNavn;
					System.out.println(brugerNavn + " Aktiv? " + aktivBruger);
					j++;
				}
				else 
				{
					System.out.println("Denne er ikke med: " + brugerNavn + " " + aktiv);
				}

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JTable searchResult = new JTable (data, columnNames);
		searchResult.setBounds(20, 50, 500, 1000);
		contentPane.add(searchResult);
		searchResult.setRowHeight(15);

		JLabel lblEventName = new JLabel("List of users:");
		lblEventName.setBounds(20, 25, 100, 20);
		contentPane.add(lblEventName);

		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnReturnToMenu.setBounds(19, 643, 146, 29);
		contentPane.add(btnReturnToMenu);

		
	}

}
