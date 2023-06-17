package application;
import java.awt.*;
import javax.swing.*;

public class panel extends JPanel{
	Image image;
	
	panel(){
		image = new ImageIcon("5453998.jpg").getImage();
		this.setPreferredSize(new Dimension(800,800));
		
	}
	public void paint (Graphics y){
		Graphics2D n= (Graphics2D) y;
		 n.drawImage(image, 0, 0, null);
	}

}
