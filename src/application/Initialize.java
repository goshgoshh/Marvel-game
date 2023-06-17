package application;

import java.awt.Color;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.abilities.*;
import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.scene.input.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.stage.StageStyle;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;


public class Initialize extends Main {
	static Player first; 
	static Player second;
	Game game;
     //Object[][] finalBoard;
	int counter=0;
	int counter2=0;
	Stage primarystage;
	Button button1A;
	Button button2A;
	Button button3A;
	Scene scene;
	StackPane layout55= new StackPane();

	public Initialize(Stage primarystage) {
		this.primarystage=primarystage;
		TextField text= new TextField();
		text.setPromptText("Enter Your Name:");
		text.setMaxHeight(40);
		text.setMaxWidth(250);
		text.setTranslateX(60);
		text.setTranslateY(150);
		
		 Label commentlabel = new Label("Player One");
		 commentlabel.setTranslateX(-160);
		 commentlabel.setTranslateY(70);
		 commentlabel.setFont(new Font("Impact",40));
	     commentlabel.setTextFill(Paint.valueOf("yellow"));
	       		           
	    TextField text2= new TextField();
	    text2.setPromptText("Enter Your Name:");
		text2.setMaxHeight(40);
	    text2.setMaxWidth(250);
		text2.setTranslateX(-340);
		text2.setTranslateY(380);
		
		 Label commentlabel2 = new Label("Player Two");
		 commentlabel2.setTranslateX(-550);
		 commentlabel2.setTranslateY(300);
		 commentlabel2.setTextFill(Paint.valueOf("yellow"));	           
		 commentlabel2.setFont(new Font("Impact",40));
		 
		Button button1= new Button ("Lets get started!");	
        button1.setFont(new Font ("Impact", 20));
		button1.setTranslateX(-190);
		button1.setTranslateY(600);
		button1.setTextFill(Paint.valueOf("red"));
		HBox layout1= new HBox(20);
		layout1.getChildren().addAll(text,commentlabel,text2,commentlabel2,button1);
		scene1= new Scene(layout1,1440,900);
		Image img1= new Image ("mourad.png");
		 BackgroundImage bImg1 = new BackgroundImage(img1,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		 Background bGround1 = new Background(bImg1);
		 
        layout1.setBackground(bGround1);
       // Scene scene90= new Scene(layout1,1440,900);
        primarystage.setScene(scene1);
        button1.setOnAction(e->{
        	  first= new Player(text.getText());
        	  second= new Player(text2.getText());
        	  new Game(first, second);
        	  //finalBoard=Game.getBoard();
        	try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
			} catch (IOException e1) {

			}
        	SelectChampions(primarystage);
        	
        });

	}
	//
	public String getPath(Champion c) {
		String s="";
		switch(c.getName()) {
		case "Captain America": s+="america.jpg";
		break;
		case "Deadpool": s+="deadpoool.jpg";
		break;
		case "Dr Strange": s+="dr strange.jfif";
		break; 
		case "Electro":s+="electro.jpg";
		break;
		case "Ghost Rider":s+="ghost.jpg";
		break; 
		case "Hela":s+="helaa.jpg";
		break;
		case "Hulk":s+="hulkkk.jpg";
		break; 
		case "Iceman":s+="iceman.jfif";
		break;
		case "Ironman":s+="ironm.jpg";
		break;
		case "Loki":s+="lokiii.jpg";
		break;
		case"Quicksilver":s+="Quicksilver.jfif";
		break;
		case "Spiderman":s+="spider.jpg";
		break;
		case "Thor":s+="thor.jpg";
		break; 
		case"Venom":s+="venom.jpg";
		break; 
		case"Yellow Jacket":s+="yellow jacket.jfif";
		break;
		}
		return s; 
	}
	public void SelectChampions(Stage primarystage) {
		StackPane layoutready= new StackPane();
	       HBox ready = new HBox();
			Image img5= new Image ("readyFinalpng.png");
			 BackgroundImage bImg5 = new BackgroundImage(img5,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround5 = new Background(bImg5);
			 ready.setBackground(bGround5);
			 Button readyB= new Button("Next");
			 readyB.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20;");
			 readyB.setTranslateY(300);
			 Scene ReadyScene= new Scene(layoutready, 1440, 900);
			 Label L =new Label(first.getName()+" Get Ready To Chose Your Champions!");
			 L.setTranslateY(-400);
			 L.setStyle("-fx-text-fill:WHITE; -fx-font-size: 60;");
			 layoutready.getChildren().addAll(ready,readyB,L);
			 primarystage.setScene(ReadyScene);
			 //button9.setOnAction(e-> primaryStage.setScene(ReadyScene));
			 
			 
		   StackPane layoutreadyy= new StackPane();
	       HBox ready1 = new HBox();
			Image img6= new Image ("readyFinalpng.png");
			 BackgroundImage bImg6 = new BackgroundImage(img6,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround6 = new Background(bImg6);
			 ready1.setBackground(bGround6);
			 Button readyA= new Button("Next");
			 readyA.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20;");
			 readyA.setTranslateY(300);
			 Label L1 =new Label(second.getName()+" Get Ready To Chose Your Champions!");
			 L1.setStyle("-fx-text-fill:WHITE; -fx-font-size: 60;");
			 L1.setTranslateY(-400);
			 Scene ReadyScenee= new Scene(layoutreadyy, 1440, 900);
			 layoutreadyy.getChildren().addAll(ready1,readyA,L1);
			 
		GridPane gameboard= new GridPane();
		gameboard.setAlignment(Pos.TOP_LEFT);
		
		Button button10=new Button();
		Button button11=new Button();
		Button button12=new Button();
		Button button13=new Button();
		Button button14=new Button();
		Button button15=new Button();
		Button button16=new Button();
		Button button17=new Button();
		Button button18=new Button();
		Button button19=new Button();
		Button button20=new Button();
		Button button21=new Button();
		Button button22=new Button();
		Button button23=new Button();
		Button button24=new Button();
		
		ImageView ironman = new ImageView("ironm.jpg");
		ironman.setFitHeight(240);
		ironman.setFitWidth(250);
		button18.setGraphic(ironman);
		ImageView yellow = new ImageView("yellow jacket.jfif");
		yellow.setFitHeight(240);
		yellow.setFitWidth(250);
		button24.setGraphic(yellow);
		ImageView ca = new ImageView("america.jpg");
		ca.setFitHeight(240);
		ca.setFitWidth(250);
		button10.setGraphic(ca);
		ImageView dp = new ImageView("deadpoool.jpg");
		dp.setFitHeight(240);
		dp.setFitWidth(250);
		button11.setGraphic(dp);
		ImageView ds = new ImageView("dr strange.jfif");
		ds.setFitHeight(240);
		ds.setFitWidth(250);
		button12.setGraphic(ds);
		ImageView electro = new ImageView("electro.jpg");
		electro.setFitHeight(240);
		electro.setFitWidth(250);
		button13.setGraphic(electro);
		ImageView ghost = new ImageView("ghost.jpg");
		ghost.setFitHeight(240);
		ghost.setFitWidth(250);
		button14.setGraphic(ghost);
		ImageView hela = new ImageView("helaa.jpg");
		hela.setFitHeight(240);
		hela.setFitWidth(250);
		button15.setGraphic(hela);
		ImageView hulk = new ImageView("hulkkk.jpg");
		hulk.setFitHeight(240);
		hulk.setFitWidth(250);
		button16.setGraphic(hulk);
		ImageView ice = new ImageView("iceman.jfif");
		ice.setFitHeight(240);
		ice.setFitWidth(250);
		button17.setGraphic(ice);
		ImageView loki = new ImageView("lokiii.jpg");
		loki.setFitHeight(240);
		loki.setFitWidth(250);
		button19.setGraphic(loki);
		ImageView qs = new ImageView("Quicksilver.jfif");
		qs.setFitHeight(240);
		qs.setFitWidth(250);
		button20.setGraphic(qs);
		ImageView spider = new ImageView("spider.jpg");
		spider.setFitHeight(240);
		spider.setFitWidth(250);
		button21.setGraphic(spider);
		ImageView thor = new ImageView("thor.jpg");
		thor.setFitHeight(240);
		thor.setFitWidth(250);
		button22.setGraphic(thor);
		ImageView venom = new ImageView("venom.jpg");
		venom.setFitHeight(240);
		venom.setFitWidth(250);
		button23.setGraphic(venom);
		
		
		button10.setPrefSize(150,150);
		button11.setPrefSize(150,150);
		button12.setPrefSize(150,150);
		button13.setPrefSize(150,150);
		button14.setPrefSize(150,150);
		button15.setPrefSize(150,150);
		button16.setPrefSize(150,150);
		button17.setPrefSize(150,150);
		button18.setPrefSize(150,150);
		button19.setPrefSize(150,150);
		button20.setPrefSize(150,150);
		button21.setPrefSize(150,150);
		button22.setPrefSize(150,150);
		button23.setPrefSize(150,150);
		button24.setPrefSize(150,150);
		gameboard.setHgap(10);
		gameboard.setVgap(45);
				
	   gameboard.add(button10, 0, 0, 1, 1);
	   gameboard.add(button11, 0, 1, 1, 1);
    gameboard.add(button12, 0, 2, 1, 1);
    gameboard.add(button13, 1, 0, 1, 1);
    gameboard.add(button14, 1, 1, 1, 1);
    gameboard.add(button15, 1, 2, 1, 1);
    gameboard.add(button16, 2, 0, 1, 1);
    gameboard.add(button17, 2, 1, 1, 1);
    gameboard.add(button18, 2, 2, 1, 1);
    gameboard.add(button19, 3, 0, 1, 1);
    gameboard.add(button20, 3, 1, 1, 1);
    gameboard.add(button21, 3, 2, 1, 1);
    gameboard.add(button22, 4, 0, 1, 1);
    gameboard.add(button23, 4, 1, 1, 1);
    gameboard.add(button24, 4, 2, 1, 1);
    gameboard.setAlignment(Pos.TOP_CENTER);
    gameboard.setTranslateX(30);
    gameboard.setTranslateY(30);
    Button test= new Button();
    test.setPrefSize(1400, 900);
    test.setOpacity(0);

    HBox hb = new HBox();
		Image img4= new Image ("backk3.jpg");
		 BackgroundImage bImg4 = new BackgroundImage(img4,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		 Background bGround4 = new Background(bImg4);
		 hb.setBackground(bGround4);
    hb.getChildren().addAll(gameboard,test);
     
       button10.setOnAction(e -> {   
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
//     	  alert.setContentText("\n Name: Captin America \n \n Type: Hero \n \n MaxHP= 1500 \n \n Mana= 1000 \n \n Action Points= 6 \n \n Speed= 80 \n \n Attack Range= 1 \n \n Attack Damage= 100 \n \n "
//			       		+ "Ability 1: Sheild Throw \n \n Ability 2: I can do this all day \n \n Ability 3: Sheild Up ");
     	  alert.setContentText(Game.getAvailableChampions().get(0).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {

	        		   if (counter<3) {
	        			   counter++;
	        			   getFirst().getTeam().add(Game.getAvailableChampions().get(0));
	        			  // getFirst().getTeam().add(null);
//	        			   System.out.println(Game.getAvailableChampions().get(0).getName());
	        			   button10.setDisable(true);
	        			   if (counter==3) {
		        			  
		        			   primarystage.setScene(ReadyScenee);
		        			   counter=4;
	        			   }
	        		   }else if(counter2<3) {
	        			   counter2++;
	        			   getSecond().getTeam().add(Game.getAvailableChampions().get(0));
	        			   button10.setDisable(true);
	        			   if(counter2==3) {
	        				   Next(primarystage);
		        			   //primarystage.setScene(ReadyScenee);
	        			   }
	        		   }

     		}

	    	   });
       button11.setOnAction(e -> {    	
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
     	  alert.setContentText(Game.getAvailableChampions().get(1).toString());
     	  //alert.showAndWait();
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(1));
     			   button11.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(1));
     			   button11.setDisable(true);
     			   if(counter2==3) {
     				  Next(primarystage);
	        			   //primarystage.setScene(ReadyScenee);
     			   }
     		   }
     			
     		}

       });
       button12.setOnAction(e -> {    	       
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
     	  alert.setContentText(Game.getAvailableChampions().get(2).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(2));
     			   button12.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(2));
     			   button12.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     		}

	    	   });
       button13.setOnAction(e -> {   
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
     	  alert.setContentText(Game.getAvailableChampions().get(3).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(3));
     			   button13.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(3));
     			   button13.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
	    	   });
       button14.setOnAction(e -> {    	
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
     	  alert.setContentText(Game.getAvailableChampions().get(4).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(4));
     			   button14.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(4));
     			   button14.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
	    	   });
    
       button15.setOnAction(e -> {  
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
     	  alert.setContentText(Game.getAvailableChampions().get(5).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(5));
     			   button15.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(5));
     			   button15.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			  // primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
	    	   });
       button16.setOnAction(e -> {  
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
     	  alert.setContentText(Game.getAvailableChampions().get(6).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(6));
     			   button16.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(6));
     			   button16.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
	    	   });
       button17.setOnAction(e -> {    	  
     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
     	  alert.initStyle(StageStyle.UTILITY);
     	  alert.setTitle("success");
     	  alert.setHeaderText(null);
     	  alert.setContentText(Game.getAvailableChampions().get(7).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(7));
     			   button17.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(7));
     			   button17.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }}
	    	   });
    button18.setOnAction(e -> {   
 	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
 	   alert.initStyle(StageStyle.UTILITY);
 	   alert.setTitle("success");
 	   alert.setHeaderText(null);
 	   alert.setContentText(Game.getAvailableChampions().get(8).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(8));
     			   button18.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(8));
     			   button18.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
 	   });
    button19.setOnAction(e -> {  
 	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
 	   alert.initStyle(StageStyle.UTILITY);
 	   alert.setTitle("success");
 	   alert.setHeaderText(null);
 	   alert.setContentText(Game.getAvailableChampions().get(9).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(9));
     			   button19.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(9));
     			   button19.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
 	   });
    button20.setOnAction(e -> {    	
 	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
 	   alert.initStyle(StageStyle.UTILITY);
 	   alert.setTitle("success");
 	   alert.setHeaderText(null);
 	   alert.setContentText(Game.getAvailableChampions().get(10).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(10));
     			   button20.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(10));
     			   button20.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			  // primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
 	   });
    button21.setOnAction(e -> {
 	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
 	   alert.initStyle(StageStyle.UTILITY);
 	   alert.setTitle("success");
 	   alert.setHeaderText(null);
 	   alert.setContentText(Game.getAvailableChampions().get(11).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(11));
     			   button21.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(11));
     			   button21.setDisable(true);
     			   if(counter2==3) {
     				    Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
 	   });
    button22.setOnAction(e -> {   
 	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
 	   alert.initStyle(StageStyle.UTILITY);
 	   alert.setTitle("success");
 	   alert.setHeaderText(null);
 	   alert.setContentText(Game.getAvailableChampions().get(12).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(12));
     			   button22.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(12));
     			   button22.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
    });
    button23.setOnAction(e -> { 
 	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
 	   alert.initStyle(StageStyle.UTILITY);
 	   alert.setTitle("success");
 	   alert.setHeaderText(null);
 	   alert.setContentText(Game.getAvailableChampions().get(13).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(13));
     			   button23.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(13));
     			   button23.setDisable(true);
     			   if(counter2==3) {
     				    Next(primarystage);
     				  // game=new Game(first, second);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }
 	   });
    button24.setOnAction(e -> {    
 	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
     	  alert.getButtonTypes().clear();
     	  alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
 	   alert.initStyle(StageStyle.UTILITY);
 	   alert.setTitle("success");
 	   alert.setHeaderText(null);
 	   alert.setContentText(Game.getAvailableChampions().get(14).toString());
     	  Optional<ButtonType> result = alert.showAndWait();
     	   if(result.get() == ButtonType.YES) {
     		   if (counter<3) {
     			   counter++;
     			   getFirst().getTeam().add(Game.getAvailableChampions().get(14));
     			   button24.setDisable(true);
     			   if (counter==3) {
	        			  
	        			   primarystage.setScene(ReadyScenee);
	        			   counter=4;
     			   }
     		   }else if(counter2<3) {
     			   counter2++;
     			   getSecond().getTeam().add(Game.getAvailableChampions().get(14));
     			   button24.setDisable(true);
     			   if(counter2==3) {
     				   Next(primarystage);
     				   //game=new Game(first, second);
	        			   //primaryStage.setScene(ReadyScenee);
     			   }
     		   }
     	   }    
 	   });


    

    
    
        Scene scene = new Scene(hb,1800,900);
        
        readyB.setOnAction(e-> primarystage.setScene(scene));
        readyA.setOnAction(e-> primarystage.setScene(scene));
		
	}
	public static Player getFirst() {
		return first;
	}
	public static Player getSecond() {
		return second;
	}
	public void Next(Stage primarystage) {
		//System.out.println(Initialize.getFirst().getTeam().get(0).getName());
//		for (int i=0; i<first.getTeam().size();i++) {
//			System.out.println(first.getTeam().get(i).getName());
//		}
		   StackPane layoutready1= new StackPane();
		       HBox ready12 = new HBox();
				Image img7= new Image ("ready.jpg");
				 BackgroundImage bImg7 = new BackgroundImage(img7,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
				 Background bGround7 = new Background(bImg7);
				 ready12.setBackground(bGround7);
				 Button readyA1= new Button();
				 readyA1.setOpacity(0);
				 readyA1.setMinSize(1440, 900);
				    ImageView img2= new ImageView ("next-button.png");
				    img2.setFitHeight(150);
				    img2.setFitWidth(150);
//				    img2.setTranslateX(630);
//				    img2.setTranslateY(600);
				 Scene ReadyScene1= new Scene(layoutready1, 1440, 900);
					
				 Label commentlabel = new Label(first.getName()+" get ready to choose your leader!");
				 commentlabel.setTranslateX(-110);
				 commentlabel.setTranslateY(-170);
				 commentlabel.setFont(new Font("Impact",50));
			     commentlabel.setTextFill(Paint.valueOf("black"));
				 layoutready1.getChildren().addAll(ready12,readyA1,commentlabel, img2);
				 primarystage.setScene(ReadyScene1);
				 readyA1.setOnAction(e-> firstLeader(primarystage));
				 //System.out.println(first.getTeam().size());
	}
	public void Next2(Stage primarystage) {
		//System.out.println(Initialize.getFirst().getTeam().get(0).getName());
//		for (int i=0; i<first.getTeam().size();i++) {
//			System.out.println(first.getTeam().get(i).getName());
//		}
		   StackPane layoutready1= new StackPane();
		       HBox ready12 = new HBox();
				Image img7= new Image ("ready.jpg");
				 BackgroundImage bImg7 = new BackgroundImage(img7,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
				 Background bGround7 = new Background(bImg7);
				 ready12.setBackground(bGround7);
				 Button readyA1= new Button();
				 readyA1.setMinSize(1440, 900);
				 readyA1.setOpacity(0);
				// readyA1.setStyle("-fx-text-fill:BLACK; -fx-font-size: 20;");
				 Scene ReadyScene1= new Scene(layoutready1, 1440, 900);
					
				 Label commentlabel = new Label(second.getName()+" get ready to choose your leader!");
				 commentlabel.setTranslateX(-110);
				 commentlabel.setTranslateY(-170);
				 commentlabel.setFont(new Font("Impact",50));
			     commentlabel.setTextFill(Paint.valueOf("black"));
				    ImageView img2= new ImageView ("next-button.png");
				    img2.setFitHeight(150);
				    img2.setFitWidth(150);
				 layoutready1.getChildren().addAll(ready12,readyA1,commentlabel);
				layoutready1.getChildren().add(img2);
				 primarystage.setScene(ReadyScene1);
				 readyA1.setOnAction(e-> secondLeader(primarystage));
				 //System.out.println(first.getTeam().size());
	}
	public void firstLeader(Stage primarystage) {
		Button button1=new Button(first.getTeam().get(0).getName());
		Button button2=new Button(first.getTeam().get(1).getName());
		Button button3=new Button(first.getTeam().get(2).getName());
		button1.setMaxSize(250,250);
		button2.setMaxSize(250,250);
		button3.setMaxSize(250,250);
		String s1=getPath(first.getTeam().get(0));
		String s2=getPath(first.getTeam().get(1));
		String s3=getPath(first.getTeam().get(2));
		
		ImageView img2= new ImageView (s1);
		ImageView img3= new ImageView (s2);
		ImageView img4= new ImageView (s3);
		img2.setFitHeight(240);
		img2.setFitWidth(250);
		img3.setFitHeight(240);
		img3.setFitWidth(250);
		img4.setFitHeight(240);
		img4.setFitWidth(250);
		button1.setGraphic(img2);
		button2.setGraphic(img3);
		button3.setGraphic(img4);
		GridPane leaderboard= new GridPane();
		leaderboard.add(button1, 0, 0, 1, 1);
		leaderboard.add(button2, 1, 0, 1, 1);
	    leaderboard.add(button3, 2, 0, 1, 1);
	    Button next= new Button("Lessgooo!!");
	    next.setPrefSize(100, 50);
	    next.setTranslateX(-100);
	    next.setTranslateY(500);
	    next.setDisable(true);
	    BorderPane b= new BorderPane();
	    b.setCenter(leaderboard);
	    HBox hb = new HBox();
			Image img= new Image ("backk3.jpg");
			 BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround4 = new Background(bImg);
			 hb.setBackground(bGround4);
	    hb.getChildren().addAll(b, next);
		Scene Scene= new Scene(hb, 1440, 900);
		primarystage.setScene(Scene);
		
		button1.setOnAction(e->{
			first.setLeader(first.getTeam().get(0));
			next.setDisable(false);
			
		});
		button2.setOnAction(e->{
			first.setLeader(first.getTeam().get(1));
			next.setDisable(false);
			
		});
		button3.setOnAction(e->{
			first.setLeader(first.getTeam().get(2));
			next.setDisable(false);
			
		});
		next.setOnAction(e->Next2(primarystage));
		
		
		
	}
	public void secondLeader(Stage primarystage) {
		Button button1=new Button(second.getTeam().get(0).getName());
		Button button2=new Button(second.getTeam().get(1).getName());
		Button button3=new Button(second.getTeam().get(2).getName());
		button1.setMaxSize(250,250);
		button2.setMaxSize(250,250);
		button3.setMaxSize(250,250);
		String s1=getPath(second.getTeam().get(0));
		String s2=getPath(second.getTeam().get(1));
		String s3=getPath(second.getTeam().get(2));
		
		ImageView img2= new ImageView (s1);
		ImageView img3= new ImageView (s2);
		ImageView img4= new ImageView (s3);
		img2.setFitHeight(240);
		img2.setFitWidth(250);
		img3.setFitHeight(240);
		img3.setFitWidth(250);
		img4.setFitHeight(240);
		img4.setFitWidth(250);
		button1.setGraphic(img2);
		button2.setGraphic(img3);
		button3.setGraphic(img4);
		GridPane leaderboard= new GridPane();
		leaderboard.add(button1, 0, 0, 1, 1);
		leaderboard.add(button2, 1, 0, 1, 1);
	    leaderboard.add(button3, 2, 0, 1, 1);
	    Button next= new Button("Lessgooo!!");
	    next.setPrefSize(100, 50);
	    next.setTranslateX(-100);
	    next.setTranslateY(500);
	    next.setDisable(true);
	    next.setDisable(true);
	    BorderPane b= new BorderPane();
	    b.setCenter(leaderboard);
	    HBox hb = new HBox();
			Image img= new Image ("backk3.jpg");
			 BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround4 = new Background(bImg);
			 hb.setBackground(bGround4);
	    hb.getChildren().addAll(b, next);
		Scene Scene= new Scene(hb, 1440, 900);
		primarystage.setScene(Scene);
		
		button1.setOnAction(e->{
			second.setLeader(second.getTeam().get(0));
			next.setDisable(false);
			
		});
		button2.setOnAction(e->{
			second.setLeader(second.getTeam().get(1));
			next.setDisable(false);
			
		});
		button3.setOnAction(e->{
			second.setLeader(second.getTeam().get(2));
			next.setDisable(false);
			
		});
		next.setOnAction(e->Next3(primarystage));
		game= new Game(first, second);

		
		
		
	}
	public void Next3(Stage primarystage) {

		StackPane layout= new StackPane();
		
		scene2 = new Scene(layout,1440,900);
		Image img= new Image ("finalKhara2.png");
		 BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		 Background bGround = new Background(bImg);
	        layout.setBackground(bGround);
		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primarystage.setScene(scene2);
		primarystage.show();
		primarystage.setTitle("Marvel- Ultimate War");
		primarystage.setMaximized(true);
		primarystage.resizableProperty();
		button = new Button();
		button.setOpacity(0);
		button.setOnAction(e-> Board());
		button.setPrefSize(1440,900);
		
	    ImageView img2= new ImageView ("R.png");
	    img2.setFitHeight(150);
	    img2.setFitWidth(250);
	    img2.setTranslateX(630);
	    img2.setTranslateY(600);
	    ImageView img3= new ImageView("frame55.png");
		img3.setFitHeight(900);
		img3.setFitWidth(1200);
		 img3.setTranslateX(-100);
		 img3.setTranslateY(-200);
		Label l= new Label("press anywhere to start");
	   HBox n= new HBox();
	   n.getChildren().addAll(img2,img3);
	   //n.getChildren().add(l);
	   
		layout.getChildren().addAll(n,button);
	}
	public void Board() {
		
		GridPane board = new GridPane();
		 BorderPane borderPane = new BorderPane();
		 borderPane.setCenter(board);
		 VBox left= new VBox();
			Image img= new Image ("leftt.jfif");
			 BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround = new Background(bImg);
		        left.setBackground(bGround);
		 left.setPrefWidth(345);
		 Label currChampD = new Label(game.getCurrentChampion().toString2());
		 currChampD.setFont(new Font("Impact",25));
		 currChampD.setStyle("-fx-text-fill:WHITE;");
		 Label currChampE = new Label("Applied Effects"+game.getCurrentChampion().toStringE());
		 currChampE.setFont(new Font("Impact",25));
		 currChampE.setStyle("-fx-text-fill:WHITE;");
		 //left.setStyle("-fx-background-color: #000000");
		 left.getChildren().addAll(currChampD, currChampE);
		 borderPane.setLeft(left);
		 
		 
		 
		 
		 Champion c = (Champion) game.getTurnOrder().peekMin();
		 game.getTurnOrder().remove();
		 VBox top= new VBox();
		 Label currChamp = new Label("Current Champion: "+c.getName());
		 currChamp.setStyle("-fx-text-fill:WHITE;");
			Image img1= new Image ("top.jpg");
			 BackgroundImage bImg1 = new BackgroundImage(img1,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround1 = new Background(bImg1);
		        top.setBackground(bGround1);
		 currChamp.setFont(new Font("Impact",30));
     if (!(game.getTurnOrder().isEmpty())) {
		 Champion c2= (Champion) game.getTurnOrder().peekMin();
		 game.getTurnOrder().insert(c);
		 Label nextChamp = new Label("Next Champion: "+c2.getName());
		 nextChamp.setStyle("-fx-text-fill:WHITE;");
     	 nextChamp.setFont(new Font("Impact",15));
		 Label firstPlayer= new Label("First Player; "+ first.getName());
		 firstPlayer.setTranslateX(1140);
		 firstPlayer.setStyle("-fx-text-fill:WHITE;");
		 firstPlayer.setFont(new Font("Impact",15));
		 Label secondPlayer= new Label("Second Player: "+second.getName());
		 Label firstAbility= new Label("first Leader Ability used: "+game.isFirstLeaderAbilityUsed());
		 Label secondAbility= new Label("Second Leader Ability used: "+game.isSecondLeaderAbilityUsed());
		 firstAbility.setStyle("-fx-text-fill:WHITE;");
		 secondAbility.setStyle("-fx-text-fill:WHITE;");
		 secondPlayer.setTranslateX(1140);
		 secondPlayer.setFont(new Font("Impact",15));
		 secondPlayer.setStyle("-fx-text-fill:WHITE;");
		 top.getChildren().addAll(currChamp, nextChamp, firstPlayer,secondPlayer,firstAbility, secondAbility);
		 top.setPrefHeight(70);
		 //top.setStyle("-fx-background-color: #ffff00");
		 borderPane.setTop(top);
         }else {
    		 //Champion c2= (Champion) game.getTurnOrder().peekMin();
    		 game.getTurnOrder().insert(c);
    		 Label nextChamp = new Label("Next Champion: ");
         	 nextChamp.setFont(new Font("Impact",15));
         	 nextChamp.setStyle("-fx-text-fill:WHITE;");
    		 Label firstPlayer= new Label("First Player; "+ first.getName());
    		 firstPlayer.setStyle("-fx-text-fill:WHITE;");
    		 firstPlayer.setTranslateX(1140);
    		 firstPlayer.setFont(new Font("Impact",15));
    		 Label secondPlayer= new Label("Second Player: "+second.getName());
    		 secondPlayer.setTranslateX(1140);
    		 secondPlayer.setStyle("-fx-text-fill:WHITE;");
    		 secondPlayer.setFont(new Font("Impact",15));
    		 Label firstAbility= new Label("first Leader Ability used: "+game.isFirstLeaderAbilityUsed());
    		 Label secondAbility= new Label("Second Leader Ability used: "+game.isSecondLeaderAbilityUsed());
    		 firstAbility.setStyle("-fx-text-fill:WHITE;");
    		 secondAbility.setStyle("-fx-text-fill:WHITE;");
    		 top.getChildren().addAll(currChamp, nextChamp, firstPlayer,secondPlayer,firstAbility, secondAbility);
    		 top.setPrefHeight(70);
    		// top.setStyle("-fx-background-color: #ffff00");
    		 borderPane.setTop(top);
         }
     
     //borderPane.setTop(top);
     
		 
		 
		 
		 
		 VBox down= new VBox();
		 down.setPrefHeight(70);
		 down.setStyle("-fx-background-color: #ff00ff");
		// borderPane.setBottom(down);
		 
		 
		 
		 
		 
		 
		 VBox right= new VBox();
		 right.setPrefWidth(345);
			Image img2= new Image ("rightt.jfif");
			 BackgroundImage bImg2 = new BackgroundImage(img2,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround2 = new Background(bImg2);
		        right.setBackground(bGround2);
		 //right.setStyle("-fx-background-color: #000000");
		 Button button4 = new Button();
		 button4.setText(first.getName()+" use Leader Ability?");
		 Button button5 = new Button();
		 button5.setText(second.getName()+" use Leader Ability?");

		 Button button1 = new Button();
		 button1.setText(game.getCurrentChampion().getAbilities().get(0).getName()+" Type: "+game.getCurrentChampion().getAbilities().get(0).getCastArea());
		 Button button2 = new Button();
		 button2.setText(game.getCurrentChampion().getAbilities().get(1).getName()+" Type: "+game.getCurrentChampion().getAbilities().get(1).getCastArea());
		 Button button3 = new Button();
		 button3.setText(game.getCurrentChampion().getAbilities().get(2).getName()+" Type: "+game.getCurrentChampion().getAbilities().get(2).getCastArea());
		
		 right.getChildren().addAll(button1, button2, button3,button4,button5);
		 borderPane.setRight(right);
		 button4.setOnAction(e->{
			 UseLeaderAbility();
		 });
		 Label L= new Label("Turn Order:");
		 L.setStyle("-fx-text-fill:WHITE; -fx-font-size: 30;");
    	 right.getChildren().add(L);
	     PriorityQueue temp = new PriorityQueue(game.getTurnOrder().size());
	     PriorityQueue temp2 = new PriorityQueue(game.getTurnOrder().size());
	     while (!game.getTurnOrder().isEmpty()) {
	    	 temp.insert(game.getTurnOrder().peekMin());
	    	 temp2.insert(game.getTurnOrder().peekMin());
	    	 game.getTurnOrder().remove();
	    	 
	     }
	     while (!temp2.isEmpty()) {
	    	 game.getTurnOrder().insert(temp2.peekMin());
	    	 temp2.remove();
	     }
	     while (!temp.isEmpty()) {
	    	 Champion champ=(Champion) temp.peekMin();
	    	 Label Cha=new Label(champ.getName()+" Current Hp: "+champ.getCurrentHP());
	    	 Cha.setStyle("-fx-text-fill:WHITE; -fx-font-size: 20;");
	    	 right.getChildren().add(Cha);
	    	 temp.remove();
	     }
		 button1.setTooltip(new Tooltip(game.getCurrentChampion().getAbilities().get(0).toString()));
		 button2.setTooltip(new Tooltip(game.getCurrentChampion().getAbilities().get(1).toString()));
		 button3.setTooltip(new Tooltip(game.getCurrentChampion().getAbilities().get(2).toString()));
		 button1.setOnAction(e->{
			 switch(game.getCurrentChampion().getAbilities().get(0).getCastArea()) {
			 case DIRECTIONAL:
			      Alert dialog = new Alert(AlertType.CONFIRMATION);
			      dialog.getButtonTypes().clear();
			      dialog.setTitle("Casting Directional Ability");
			      dialog.setHeaderText(null);
			      dialog.setContentText("Chose the desired Direction");
			      ButtonType type = new ButtonType("up");
			      ButtonType type1 = new ButtonType("down");
			      ButtonType type2= new ButtonType("left");
			      ButtonType type3 = new ButtonType("right");
			      //dialog.setContentText("This is a sample dialog");
			      dialog.getDialogPane().getButtonTypes().addAll(type,type1,type2,type3);
			      Optional<ButtonType> result = dialog.showAndWait();
			      if (result.get()==type) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(0),Direction.UP);
			      }else if (result.get()==type1) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(0),Direction.DOWN);
			      }else if (result.get()==type2) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(0),Direction.LEFT);
			      }else if (result.get()==type3) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(0),Direction.RIGHT);
			      }

				 break;
			 case SINGLETARGET:
				 TextInputDialog dialog11 = new TextInputDialog("Tran");

				 dialog11.setTitle("Casting Single Target Ability");
				 dialog11.setHeaderText("Choose X coordinate");
				 dialog11.setContentText("Choose X coordinate");

				 Optional<String> result11 = dialog11.showAndWait();
				 int x=Integer.parseInt(result11.get());
				 TextInputDialog dialog12 = new TextInputDialog("Tran");

				 dialog12.setTitle("Casting Single Target Ability");
				 dialog12.setHeaderText("Choose y coordinate");
				 dialog12.setContentText("Choose y coordinate");

				 Optional<String> result12 = dialog12.showAndWait();
				 int y=Integer.parseInt(result12.get());
				 castAS(game.getCurrentChampion().getAbilities().get(0),x,y);
			default:
				castA(game.getCurrentChampion().getAbilities().get(0));
				
			 }
		 });
		 button2.setOnAction(e->{
			 switch(game.getCurrentChampion().getAbilities().get(1).getCastArea()) {
			 case DIRECTIONAL:
			      Alert dialog = new Alert(AlertType.CONFIRMATION);
			      dialog.getButtonTypes().clear();
			      dialog.setTitle("Casting Directional Ability");
			      dialog.setHeaderText(null);
			      dialog.setContentText("Chose the desired Direction");
			      ButtonType type = new ButtonType("up");
			      ButtonType type1 = new ButtonType("down");
			      ButtonType type2= new ButtonType("left");
			      ButtonType type3 = new ButtonType("right");
			      dialog.setContentText("This is a sample dialog");
			      dialog.getDialogPane().getButtonTypes().addAll(type,type1,type2,type3);
			      Optional<ButtonType> result = dialog.showAndWait();
			      if (result.get()==type) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(1),Direction.UP);
			      }else if (result.get()==type1) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(1),Direction.DOWN);
			      }else if (result.get()==type2) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(1),Direction.LEFT);
			      }else if (result.get()==type3) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(1),Direction.RIGHT);
			      }

				 
				 break;
			 case SINGLETARGET:
				 TextInputDialog dialog11 = new TextInputDialog("Tran");

				 dialog11.setTitle("Casting Single Target Ability");
				 dialog11.setHeaderText("Choose X coordinate");
				 dialog11.setContentText("Choose X coordinate");

				 Optional<String> result11 = dialog11.showAndWait();
				 int x=Integer.parseInt(result11.get());
				 TextInputDialog dialog12 = new TextInputDialog("Tran");

				 dialog12.setTitle("Casting Single Target Ability");
				 dialog12.setHeaderText("Choose y coordinate");
				 dialog12.setContentText("Choose y coordinate");

				 Optional<String> result12 = dialog12.showAndWait();
				 int y=Integer.parseInt(result12.get());
				 castAS(game.getCurrentChampion().getAbilities().get(1),x,y);
				// castAS();
			default:
				castA(game.getCurrentChampion().getAbilities().get(1));
				
			 }
		 });
		 button3.setOnAction(e->{
			 switch(game.getCurrentChampion().getAbilities().get(2).getCastArea()) {
			 case DIRECTIONAL:
			      Alert dialog = new Alert(AlertType.CONFIRMATION);
			      dialog.getButtonTypes().clear();
			      dialog.setTitle("Casting Directional Ability");
			      dialog.setHeaderText(null);
			      dialog.setContentText("Chose the desired Direction");
			      ButtonType type = new ButtonType("up");
			      ButtonType type1 = new ButtonType("down");
			      ButtonType type2= new ButtonType("left");
			      ButtonType type3 = new ButtonType("right");
			      dialog.setContentText("This is a sample dialog");
			      dialog.getDialogPane().getButtonTypes().addAll(type,type1,type2,type3);
			      Optional<ButtonType> result = dialog.showAndWait();
			      if (result.get()==type) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(2),Direction.UP);
			      }else if (result.get()==type1) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(2),Direction.DOWN);
			      }else if (result.get()==type2) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(2),Direction.LEFT);
			      }else if (result.get()==type3) {
			    	  castAD(game.getCurrentChampion().getAbilities().get(2),Direction.RIGHT);
			      }
				 break;
			 case SINGLETARGET:
				 TextInputDialog dialog11 = new TextInputDialog("Tran");

				 dialog11.setTitle("Casting Single Target Ability");
				 dialog11.setHeaderText("Choose X coordinate");
				 dialog11.setContentText("Choose X coordinate");

				 Optional<String> result11 = dialog11.showAndWait();
				 int x=Integer.valueOf(result11.get());
				 TextInputDialog dialog12 = new TextInputDialog("Tran");

				 dialog12.setTitle("Casting Single Target Ability");
				 dialog12.setHeaderText("Choose y coordinate");
				 dialog12.setContentText("Choose y coordinate");

				 Optional<String> result12 = dialog12.showAndWait();
				 int y=Integer.valueOf(result12.get());
				 castAS(game.getCurrentChampion().getAbilities().get(2),x,y);
				 //castAS();
			default:
				castA(game.getCurrentChampion().getAbilities().get(2));
				
			 }
		 });
		
		Object[][] initialBoard=game.getBoard();
		for (int i=0; i<Game.getBoardheight(); i++) {
			for (int j=0; j<Game.getBoardwidth();j++) {
				Button v= new Button();
				v.setStyle("-fx-background-color: #000000");
				v.setPrefHeight(150);
				v.setPrefWidth(150);
				//v.setOpacity(0);
				v.setStyle("-fx-border-color: #000000; -fx-border-width: 5px;");
				board.add(v, j, i, 1, 1);
				//background.setBackground(new BackGround(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY)));
				
				
			}
		}
	    int i1=0;
	    
		for (int i=Game.getBoardwidth()-1; i>=0; i--) {
			//int j1=0;
			for (int j=0; j<Game.getBoardheight();j++) {
				if (initialBoard[i][j]!=null) {
					if (initialBoard[i][j] instanceof Cover) {
						Cover cover= (Cover)(initialBoard[i][j]);
						int Hp= cover.getCurrentHP();
						ImageView cov= new ImageView("cov2.jpg");
						cov.setFitHeight(135);
						cov.setFitWidth(135);
						cov.setTranslateX(5);
						Label hp = new Label();
						hp.setGraphic(cov);
						hp.setTooltip( new Tooltip((Integer.toString(Hp))));
						hp.setPrefHeight(150);
						hp.setPrefWidth(150);
						hp.setStyle("-fx-border-color: black;");
						hp.setStyle("-fx-border-width: 2");
						hp.setText((Integer.toString(Hp)));
						hp.setAlignment(Pos.CENTER);
						board.add(hp, j, i1, 1, 1);
						
					}else if (initialBoard[i][j] instanceof Champion) {
						Champion champion= (Champion)(initialBoard[i][j]);
						Label name= new Label();
						name.setPrefHeight(150);
						name.setPrefWidth(150);
						name.setStyle("-fx-border-color: black;");
						name.setStyle("-fx-border-width: 2");
						ImageView img6= new ImageView(getPath(champion));
						img6.setFitHeight(140);
						img6.setFitWidth(140);
						img6.setTranslateX(5);
//						name.setText(champion.getName());
						
						//name.setAlignment(Pos.CENTER);
						board.add(img6, j, i1, 1, 1);
						
					}
				}else {
					Label hp = new Label();
					hp.setPrefHeight(150);
					hp.setPrefWidth(150);
					board.add(hp, j, i1, 1, 1);

					//board.add(null, j, i);
				}
				//board.add((Node) initialBoard[i][j], j, i);
				//j1++;
			}
			i1++;
		}
		board.setStyle("-fx-border-color: black");
		StackPane layout= new StackPane();
		layout.getChildren().add(borderPane);
	    scene= new Scene(layout, 1440,900);
		primarystage.setScene(scene);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				switch(event.getCode()){
				case E:EndTurn();
				
				       break;
				case I: Move(Direction.UP);
				        break; 
				case K: Move(Direction.DOWN);
				       break;    
				case L: Move(Direction.RIGHT);
				        break;    
				case J: Move(Direction.LEFT);
				break;
				case W: Attack(Direction.UP);
				break;
				case A: Attack(Direction.LEFT);
				break;
				case S:Attack(Direction.DOWN);
				break;
				case D: Attack(Direction.RIGHT);
				break;
				
			
				}
				
			}
			
		});
	
		
	}
	
	
	public void playSound (String soundFile) throws LineUnavailableException, MalformedURLException, UnsupportedAudioFileException, IOException {
	    File f = new File("./" + soundFile);
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioIn);
	    clip.start();
		}
	public void Move(Direction d) {
		try { 
			
			game.move(d);
			Board();
		} catch (NotEnoughResourcesException | UnallowedMovementException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 	   alert.initStyle(StageStyle.UTILITY);
		 	   alert.setTitle("Error");
		 	   alert.setHeaderText(null);
		 	   alert.setContentText(e.getMessage());
		 	  Optional<ButtonType> result = alert.showAndWait();
			
		}
		

	}
	public void Attack(Direction d) {
		try {
			try {
				playSound("Realistic Hit Sound Effect.wav");
			} catch (LineUnavailableException | UnsupportedAudioFileException
					| IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			game.attack(d);
			Player p=game.checkGameOver();
			if (p==null) {
				Board();
			}else {
				last(p);
			}
			
		} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 	   alert.initStyle(StageStyle.UTILITY);
		 	   alert.setTitle("Error");
		 	   alert.setHeaderText(null);
		 	   alert.setContentText(e.getMessage());
		 	  Optional<ButtonType> result = alert.showAndWait();
		}
	}
	public void EndTurn() {
		game.endTurn();
		Board();
	}
	public void castAD(Ability a,Direction d) {
		try {
			try {
				playSound("Bloons TD 6 Dark Knight Upgrade Sound Effect.wav");
			} catch (LineUnavailableException | UnsupportedAudioFileException
					| IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			game.castAbility(a,d);
			Player p=game.checkGameOver();
			if (p==null) {
				Board();
			}else {
				last(p);
			}
			
			
		}
		catch (Exception e){

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 	   alert.initStyle(StageStyle.UTILITY);
		 	   alert.setTitle("Error");
		 	   alert.setHeaderText(null);
		 	   alert.setContentText(e.getMessage());
		 	  Optional<ButtonType> result = alert.showAndWait();
		}
	}
	public void castAS(Ability a, int x, int y) {
		try {
			try {
				playSound("Bloons TD 6 Dark Knight Upgrade Sound Effect.wav");
			} catch (LineUnavailableException | UnsupportedAudioFileException
					| IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			game.castAbility(a,x,y);
			Player p=game.checkGameOver();
			if (p==null) {
				Board();
			}else {
				last(p);
			}

			
		}
		catch (Exception e){

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 	   alert.initStyle(StageStyle.UTILITY);
		 	   alert.setTitle("Error");
		 	   alert.setHeaderText(null);
		 	   alert.setContentText(e.getMessage());
		 	  Optional<ButtonType> result = alert.showAndWait();
		 	  System.out.println("Daret ya seya3");
		}
		
	}
	public void castA(Ability a) {
		try {
			try {
				playSound("Bloons TD 6 Dark Knight Upgrade Sound Effect.wav");
			} catch (LineUnavailableException | UnsupportedAudioFileException
					| IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			game.castAbility(a);
			Player p=game.checkGameOver();
			if (p==null) {
				Board();
			}else {
				last(p);
			}

			
		}
		catch (Exception e){

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 	   alert.initStyle(StageStyle.UTILITY);
		 	   alert.setTitle("Error");
		 	   alert.setHeaderText(null);
		 	   alert.setContentText(e.getMessage());
		 	  Optional<ButtonType> result = alert.showAndWait();
		}
	}
	public void UseLeaderAbility() {
		try {
			try {
				playSound("Bloons TD 6 Dark Knight Upgrade Sound Effect.wav");
			} catch (LineUnavailableException | UnsupportedAudioFileException
					| IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			game.useLeaderAbility();
			Player p=game.checkGameOver();
			if (p==null) {
				Board();
			}else {
				last(p);
			}
			
			
		} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException e) {
			// TODO Auto-generated catch block
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	 	   alert.initStyle(StageStyle.UTILITY);
	 	   alert.setTitle("Error");
	 	   alert.setHeaderText(null);
	 	   alert.setContentText(e.getMessage());
	 	  Optional<ButtonType> result = alert.showAndWait();
		}
	}
	
	public void last(Player p) {
		   StackPane layoutready66= new StackPane();
	       HBox ready12 = new HBox();
			Image img7= new Image ("ready.jpg");
			 BackgroundImage bImg7 = new BackgroundImage(img7,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround7 = new Background(bImg7);
			 ready12.setBackground(bGround7);
			 //Button readyA1= new Button();
			 Scene ReadyScene1= new Scene(layoutready66, 1440, 900);
				
			 Label commentlabel = new Label(p.getName()+" Won!");
			 commentlabel.setTranslateX(-110);
			 commentlabel.setTranslateY(-170);
			 commentlabel.setFont(new Font("Impact",50));
		     commentlabel.setTextFill(Paint.valueOf("black"));
			 layoutready66.getChildren().addAll(ready12,commentlabel);
			 primarystage.setScene(ReadyScene1);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
