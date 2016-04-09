package poker.app.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import poker.app.MainApp;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class RootLayoutController implements Initializable {

	// Reference to the main application
	private MainApp mainApp;

	@FXML
	private MenuBar mb;

	@FXML
	private Menu mnuGame;

	@FXML
	private ToggleGroup tglGames;

	@FXML
	private RadioMenuItem Omaha = new RadioMenuItem();

	@FXML
	private RadioMenuItem Texas = new RadioMenuItem();

	// Five Card Draw
	@FXML
	private RadioMenuItem FCD = new RadioMenuItem();

	// Seven Card Draw
	@FXML
	private RadioMenuItem SCD = new RadioMenuItem();

	@FXML
	private RadioMenuItem oneJoker = new RadioMenuItem();

	@FXML
	private RadioMenuItem twoJoker = new RadioMenuItem();

	public String getRuleName()
	{	
		String strRuleName = null;
		for (Menu m: mb.getMenus())
		{
			if (m.getText() == "Games")
			{
				for (MenuItem mi: m.getItems())
				{
					if (mi.getClass().equals(RadioMenuItem.class))
					{
						RadioMenuItem rmi = (RadioMenuItem)mi;
						if (rmi.isSelected() == true)
						{
							strRuleName = rmi.getText();
							break;
						}
					}
				}
			}
		}
		
		return strRuleName;
	}
	
	public void initialize(URL location, ResourceBundle resources) {

		Menu m = new Menu();
		m.setText("Games");
		mb.getMenus().add(0,m);

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}


	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("AddressApp");
		alert.setHeaderText("About");
		alert.setContentText("Author: Bert Gibbons");

		alert.showAndWait();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}


	public ToggleGroup getTglGames() {
		return tglGames;
	}
	
	

	public void setTglGames(ToggleGroup tglGames) {
		this.tglGames = tglGames;
	}

	

}