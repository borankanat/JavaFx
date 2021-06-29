package application;

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class LevelCompleted {
	
	public static Circle circle = new Circle(8, 8,8);
	
	public static void level123Completed() {
		 circle.setFill(Color.YELLOW); 
		    
		   Path path= new Path();
		   //bu  topun baslangic yeri
			path.getElements().add(new MoveTo(60.0, 30));
		   //duz cizgi çiziyor ama metod noktaya dogru gidiyor
		   //duz olmasa egri gider yani
			path.getElements().add(new LineTo(60 , 330));
			
			ArcTo arcTone = new ArcTo();
			//xin gidecegi yer 
			arcTone.setX(105 );
			//y nin gidecegi yer
			arcTone.setY(400);
			//aci
			arcTone.setRadiusY(90.0);
			arcTone.setRadiusX(90.0);	
			 path.getElements().add(arcTone);
			 path.getElements().add(new LineTo(450,400));
			  
			   PathTransition pathNew= new PathTransition();
			   
			   pathNew.setDuration(Duration.millis(4000));
			   pathNew.setPath(path);
			   pathNew.setNode(circle);
			   LoadLevels.board.getChildren().add(circle);
			   
			   pathNew.setOnFinished(e -> {
				   
				   Main.levelCount++;
				   if(Main.levelCount == 2) {
					   Main.lv2 = true;
				   }
				   else if(Main.levelCount == 3) {
					   Main.lv2 = true;
				   }
				   Main.initiateTheGame();
			   });
			   pathNew.play();
	}
	
	public static void level45Completed() {
		
		//Im setting a circle
	    Circle circle = new Circle(8, 8,8);
	   circle.setFill(Color.YELLOW); 
	   
		LoadLevels.board.getChildren().add(circle);
	   
	    //Im setting a new path so I can use LineTo, MoveTo methods
	   Path path= new Path();
		path.getElements().add(new MoveTo(60.0, 30));
	
		path.getElements().add(new LineTo(60, 210));
		
		ArcTo arcTone = new ArcTo();
		arcTone.setX(110.0);
		arcTone.setY(270.0);
		arcTone.setRadiusY(90.0);
		arcTone.setRadiusX(90.0);	
		
		 path.getElements().add(arcTone);
		 path.getElements().add(new LineTo(410,270));
		 
		  ArcTo arcTwo = new ArcTo();
		  arcTwo.setX(455.0);
		  arcTwo.setY(210.0);
		  arcTwo.setRadiusY(90.0);
		  arcTwo.setRadiusX(90.0);
		  
		  path.getElements().add(arcTwo);
		  path.getElements().add(new LineTo(455 , 150));
		   PathTransition pathNew= new PathTransition();
		   
		   pathNew.setDuration(Duration.millis(4000));
		   pathNew.setPath(path);
		   pathNew.setNode(circle);
		   
		   pathNew.setOnFinished(e -> {
			   
			   Main.levelCount++;
			   if(Main.levelCount == 4) {
				   Main.lv2 = true;
			   } else if(Main.levelCount == 5) {
				   Main.lv2 = true;
			   }
			 
			   Main.initiateTheGame();
		   });
		   
		   pathNew.play();
	}
}
