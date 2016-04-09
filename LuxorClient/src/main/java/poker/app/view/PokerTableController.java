package poker.app.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;



import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import poker.app.MainApp;
import pokerBase.Card;
import pokerBase.Deck;
import pokerBase.Hand;
import pokerBase.Player;


public class PokerTableController {

	boolean bPlay = false;
	
	boolean bP1Sit = false;
	boolean bP2Sit = false;
	boolean bP3Sit = false;
	boolean bP4Sit = false;

	// Reference to the main application.
	private MainApp mainApp;
	private Timer timer;
	private int iCardDrawn = 0;
	private int iCardDrawnPlayer = 0;
	private int iCardDrawnCommon = 0;
	private int iTransFinished = 0;
	private int iDrawCount = 0;
	
	private long legnthOfTransitions = 450;

	@FXML
	public AnchorPane APMainScreen;

	private ImageView imgTransCardP1 = new ImageView();
	private ImageView imgTransCardP2 = new ImageView();
	private ImageView imgTransCardP3 = new ImageView();
	private ImageView imgTransCardP4 = new ImageView();
	private ImageView imgTransCardCommon = new ImageView();
	
	@FXML
	public HBox HboxCommonArea;

	@FXML
	public HBox HboxCommunityCards;

	@FXML
	public HBox hBoxP1Cards;
	@FXML
	public HBox hBoxP2Cards;
	@FXML
	public HBox hBoxP3Cards;
	@FXML
	public HBox hBoxP4Cards;

	@FXML
	public TextField txtP1Name;
	@FXML
	public TextField txtP2Name;
	@FXML
	public TextField txtP3Name;
	@FXML
	public TextField txtP4Name;

	@FXML
	public Label lblP1Name;
	@FXML
	public Label lblP2Name;
	@FXML
	public Label lblP3Name;
	@FXML
	public Label lblP4Name;

	@FXML
	public Label winner1;
	@FXML
	public Label winner2;
	@FXML
	public Label winner3;
	@FXML
	public Label winner4;

	@FXML
	public ToggleButton btnP1SitLeave;
	@FXML
	public ToggleButton btnP2SitLeave;
	@FXML
	public ToggleButton btnP3SitLeave;
	@FXML
	public ToggleButton btnP4SitLeave;

	@FXML
	public Button btnDraw;

	@FXML
	public Button btnPlay;
	
	
	private ToggleGroup tglGame;
	
	
	public PokerTableController() {
	}

	@FXML
	private void initialize() {
	}



	@FXML
	private void handleP1SitLeave() {

	}

	
	@FXML
	private void handlePlay() {

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;


	}
	
	

}
