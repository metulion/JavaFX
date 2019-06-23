package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.jdbc.driver.Const;

public class MainController {
	
	   
	
	@FXML
	private Label firstNameLabel1;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label universityLabel;
	@FXML
	private Label departmentLabel;
	@FXML
	private Label yearLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label resultLabel;
	
	
	@FXML
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private TextField universityTextField;
	@FXML
	private TextField departmentTextField;
	@FXML
	private TextField yearTextField;
	@FXML
	private TextField cityTextField;
	

	
	public void saveToDatabase (ActionEvent event)  {
		String insertStudent = "INSERT INTO STUDENT"
				+ " (FIRST_NAME,LAST_NAME,UNIVERSITY,DEPARTMENT,YEAR,CITY) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			
		
		Connection conn = getConnection();
		
		PreparedStatement preparedStatement = conn.prepareStatement(insertStudent);
		
		preparedStatement.setString(1, firstNameTextField.getText());
		preparedStatement.setString(2, lastNameTextField.getText());
		preparedStatement.setString(3, universityTextField.getText());
		preparedStatement.setString(4, departmentTextField.getText());
		preparedStatement.setLong(5, Long.parseLong(yearTextField.getText()));
		preparedStatement.setString(6, cityTextField.getText());
		
		preparedStatement.executeUpdate();
		
		resultLabel.setText("Insertion Successful");
		
		}
		catch (SQLException se) {
		se.printStackTrace();
	     resultLabel.setText("Connection error.");
		}
		catch (Exception e) {
		e.printStackTrace();
		resultLabel.setText("Insertion Failed.");
		} 
		
	}
	
	
	public Connection getConnection () throws SQLException {
		Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.99.100:32769:", "SYSTEM", "oracle");
		return conn;

	
	}
	
	
}