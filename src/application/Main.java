
package application;
	
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import engine.Game;
import engine.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.*;




public class Main extends Application {
	Button button;
	Stage window;
	Scene scene1,scene2;
	public void playSound (String soundFile) throws LineUnavailableException, MalformedURLException, UnsupportedAudioFileException, IOException {
	    File f = new File("./" + soundFile);
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioIn);
	    clip.start();
		}

	@Override
	public void start(Stage primaryStage) throws Exception  {
		window=primaryStage;
		window.getFullScreenExitKeyCombination();
		window.setMaximized(true);
		window.setMaxHeight(900);
		window.setMaxWidth(1440);
		try {
			playSound("Alan Silvestri - Portals (From _Avengers_ Endgame__Audio Only) (1).wav");
		} catch (LineUnavailableException | UnsupportedAudioFileException
				| IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
			
			StackPane layout= new StackPane();
			
			scene2 = new Scene(layout,1440,900);
			Image img= new Image ("finalKhara2.png");
			 BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
			 Background bGround = new Background(bImg);
		        layout.setBackground(bGround);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene2);
			primaryStage.show();
			primaryStage.setTitle("Marvel- Ultimate War");
			primaryStage.setMaximized(true);
			primaryStage.resizableProperty();
			button = new Button();
			button.setOpacity(0);
			button.setOnAction(e-> new Video(window));
			button.setPrefSize(1440,900);
//			
		    ImageView img2= new ImageView ("R.png");
		    img2.setFitHeight(150);
		    img2.setFitWidth(250);
		    img2.setTranslateX(630);
		    img2.setTranslateY(600);
		    ImageView img3= new ImageView("megz.png");
			img3.setFitHeight(900);
			img3.setFitWidth(1200);
			 img3.setTranslateX(-100);
			 img3.setTranslateY(-200);
			Label l= new Label("press anywhere to start");
		   HBox n= new HBox();
		   n.getChildren().addAll(img2,img3);
		  // n.getChildren().add(l);
		   
			layout.getChildren().addAll(n,button);
	}
	
	
	
	public static void main(String[] args) {
		launch(args);

	}


	
		
	    }

