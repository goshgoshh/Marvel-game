package application;

//package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Video extends Main {
	public Video(Stage mainstage) {
	    ImageView video= new ImageView("R.gif");
	    video.setFitHeight(900);
	    video.setFitWidth(1440);
	    video.setOpacity(0.7);
	    Button button9 = new Button();
		button9.setOpacity(0);
		button9.setPrefSize(1440,900);
	    
	    HBox v = new HBox(video);
	    
	   
	     StackPane layout70 = new StackPane();
	     layout70.getChildren().addAll(v,button9);
	    Scene scene70= new Scene(layout70, 1440, 900);
	    mainstage.setScene(scene70);
	    button9.setOnAction(e-> new Initialize(mainstage));
	}

}


