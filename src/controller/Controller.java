package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Model;

public class Controller extends Model {

	private PreparedStatement saveNotes = null;


	public Controller() {
		super();

		try {
			saveNotes = conn.prepareStatement("INSERT INTO notes VALUES(?,?);");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void saveNotes(String text, String created) {

		try {
			saveNotes.setString(4, text);
			saveNotes.setString(5, created);
			saveNotes.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}


}
