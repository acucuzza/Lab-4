package poker.app.view;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Collections;

import pokerBase.Player;
import pokerBase.Table;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import exceptions.DeckException;
import exceptions.HandException;
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
import pokerBase.HandScore;
import pokerBase.Table;

public class PokerTableController {

	boolean bPlay = false;
	
	boolean bP1Sit = false;
	boolean bP2Sit = false;
	boolean bP3Sit = false;
	boolean bP4Sit = false;

	Table gameTable = new Table();

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
	
	
	public PokerTableController(){ 
	}

	@FXML
	private void initialize() {
	}

	// Handle The Play Button
	@FXML
	private void handlePlay(ActionEvent event) {
		//Variables + Constructors
		Deck D1 = new Deck();
		Hand hP1 = new Hand();
		Hand hP2 = new Hand();
		Hand hP3 = new Hand();
		Hand hP4 = new Hand();
			
		ArrayList<Hand> hands = new ArrayList<Hand>();
			
		boolean bP1Win = false;
		boolean bP2Win = false;
		boolean bP3Win = false;
		boolean bP4Win = false;
			
		// Deal Cards
		for (int i = 0; i > 5; i++){
			if (btnP1SitLeave.isSelected() == true){
				try {
					hP1.Draw(D1);
				} catch (DeckException e) {
					e.printStackTrace();
				}
			}
			if (btnP2SitLeave.isSelected() == true){
				try {
					hP2.Draw(D1);
				} catch (DeckException e) {
					e.printStackTrace();
				}
			}
			if (btnP3SitLeave.isSelected() == true){
				try {
					hP3.Draw(D1);
				} catch (DeckException e) {
					e.printStackTrace();
				}
			}
			if (btnP4SitLeave.isSelected() == true){
				try {
					hP4.Draw(D1);
				} catch (DeckException e) {
					e.printStackTrace();
				}
			}
		}
			
		//Evaluate Hands
		if (btnP1SitLeave.isSelected() == true){
			try {
				hP1 = pokerBase.Hand.Evaluate(hP1);
				hands.add(hP1);
			} catch (HandException e) {
				e.printStackTrace();
			}
		}
		if (btnP2SitLeave.isSelected() == true){
			try {
				hP2 = pokerBase.Hand.Evaluate(hP2);
				hands.add(hP2);
			} catch (HandException e) {
				e.printStackTrace();
			}
		}
		if (btnP3SitLeave.isSelected() == true){
			try {
				hP3 = pokerBase.Hand.Evaluate(hP3);
				hands.add(hP3);
			} catch (HandException e) {
				e.printStackTrace();
			}
		}
		if (btnP4SitLeave.isSelected() == true){
			try {
				hP4 = pokerBase.Hand.Evaluate(hP4);
				hands.add(hP4);
			} catch (HandException e) {
				e.printStackTrace();
			}
		}
			
			//Sort Best Hand
			Collections.sort(hands, Hand.HandRank);
			
			//Determine Winner
			if (hands.get(0) == hP1){
				bP1Win = true;
				System.out.println("1");
			}
			if (hands.get(0) == hP2){
				bP2Win = true;
				System.out.println("2");
			}
			if (hands.get(0) == hP3){
				bP3Win = true;
				System.out.println("3");
			}
			if (hands.get(0) == hP4){
				bP4Win = true;
				System.out.println("4");
			}
			
		}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//Add Player 1
	@FXML
	private void handleP1SitLeave(ActionEvent event) {
		Player P1 = new Player(txtP1Name.getText());
	    if (btnP1SitLeave.isSelected()) {
	        gameTable.AddPlayerToTable(P1);
	    }
	}

	//Add Player 2
	@FXML
	private void handleP2TSitLeave(ActionEvent event) {
		Player P2 = new Player(txtP2Name.getText());
	    if (btnP1SitLeave.isSelected()) {
	        gameTable.AddPlayerToTable(P2);
	    }
	}

	//Add Player 3
	@FXML
	private void handleP3SitLeave(ActionEvent event) {
		Player P3 = new Player(txtP3Name.getText());
	    if (btnP1SitLeave.isSelected()) {
	        gameTable.AddPlayerToTable(P3);
	    }
	}
	
	//Add Player 4
	@FXML
	private void handleP4itLeave(ActionEvent event) {
		Player P4 = new Player(txtP4Name.getText());
	    gameTable.AddPlayerToTable(P4);
	}
	
	
}