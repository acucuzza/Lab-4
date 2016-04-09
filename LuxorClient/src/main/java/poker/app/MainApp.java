package poker.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import poker.app.view.PokerTableController;
import poker.app.view.RootLayoutController;
import pokerBase.Player;
import pokerBase.Table;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private Table tbl;
	public RootLayoutController rootController = null;
	private int iGameType;
	
	

	public static void main(String[] args) {
		launch(args);		
	}
	
	@Override
	public void start(Stage primaryStage) {

		tbl = new Table();
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 1300, 500);

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Poker");

		// Set the application icon.
		//this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/img/26.png")));

		this.primaryStage.setScene(scene);
		this.primaryStage.show();

		initRootLayout();
		
		showPokerTable();

	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			//RootLayoutController controller = loader.getController();
		    rootController = loader.getController();
			
			
		    rootController.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void showPokerTable() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PokerTable.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);

			// Give the controller access to the main app.
			PokerTableController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
