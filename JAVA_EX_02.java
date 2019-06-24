package application;

import javafx.application.Application;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JAVA_EX_02 extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the limit number.");
		int limitNumber = scan.nextInt();
		int counter=1;
		
		if(limitNumber<2) {
			System.out.println("There is no Prime number under 2.");
		}
			
		else System.out.println("Prime Numbers until the limit number:\n2 ");
		
		for(int i=3 ; i<=limitNumber; i+=2) {
			int j=2;
			for(; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					break;
					}
				if(i%j!=0) {
					continue;
				}
			}
			if(j>Math.sqrt(i)) {
				System.out.println(i);
				counter++;
			}
		}
		if(limitNumber>=2) {
			System.out.println("Total prime numbers = " + counter);
		}
		
	}
	
}
