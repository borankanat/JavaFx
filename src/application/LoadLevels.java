package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Akif
 *
 */
public class LoadLevels {
	
	public static GridPane board = new GridPane();
	
	static ImageView viewEmpty0 = new ImageView(LoadTile.getEmpty());
	static ImageView viewEmpty1 = new ImageView(LoadTile.getEmpty());
	static ImageView viewEmpty2 = new ImageView(LoadTile.getEmpty());
	static ImageView viewEmpty3 = new ImageView(LoadTile.getEmpty());
	static ImageView viewEmpty4 = new ImageView(LoadTile.getEmpty());
	static ImageView viewEmpty5 = new ImageView(LoadTile.getEmpty());
	static ImageView viewEmpty6 = new ImageView(LoadTile.getEmpty());
	static ImageView viewEmpty7 = new ImageView(LoadTile.getEmpty());
	static ImageView viewFree0 = new ImageView(LoadTile.getFree());
	static ImageView viewFree1 = new ImageView(LoadTile.getFree());
	static ImageView viewFree2 = new ImageView(LoadTile.getFree());
	static ImageView viewFree3 = new ImageView(LoadTile.getFree());
	static ImageView viewFree4 = new ImageView(LoadTile.getFree());
	static ImageView viewHPipe0 = new ImageView(LoadTile.getHPipe());
	static ImageView viewHPipe1 = new ImageView(LoadTile.getHPipe());
	static ImageView viewVPipe0 = new ImageView(LoadTile.getVPipe());
	static ImageView viewVPipe1 = new ImageView(LoadTile.getVPipe());
	static ImageView viewVStarter = new ImageView(LoadTile.getStarter());
	static ImageView viewVStatic = new ImageView(LoadTile.getVStatic());
	static ImageView viewHStatic = new ImageView(LoadTile.getHStatic());
	static ImageView viewStatic01 = new ImageView(LoadTile.getStatic01());
	static ImageView viewHEnd = new ImageView(LoadTile.getHEnd());
	static ImageView viewVEnd = new ImageView(LoadTile.getVEnd());
	static ImageView viewPipe00 = new ImageView(LoadTile.getPipe00());
	static ImageView viewPipe01 = new ImageView(LoadTile.getPipe01());
	
	public static void levelLoader(Tiles[] tileArray) {
		
		ImageView viewVPipe = new ImageView(LoadTile.getVPipe());
		ImageView viewHPipe = new ImageView(LoadTile.getHPipe());
		board.setStyle("-fx-border-color: white");
		board.setPadding(new Insets(20,20,20,20));
		board.setHgap(2);
		board.setVgap(2);
		
		int a=0;
		int b=0;
		int emptyCount = 0;
		int freeCount= 0;
		int hPipeCount = 0;
		int vPipeCount = 0;
		for(int i=0; i<tileArray.length; i++) {
			switch(tileArray[i].getType() + tileArray[i].getProperty()) {
			
			case "StarterVertical" :
				GridPane.setConstraints(viewVStarter,a,b);
				board.getChildren().add(viewVStarter);
				break;
			case "Emptynone" :
				GridPane.setConstraints(emptyViewMaker(emptyCount),a,b);
				board.getChildren().add(emptyViewMaker(emptyCount));
				emptyCount++;
				break;
			case "PipeVertical":
				GridPane.setConstraints(vPipeViewMaker(vPipeCount), a, b);
				board.getChildren().add(vPipeViewMaker(vPipeCount));
				vPipeCount++;
				break;
			case "PipeHorizontal":
				GridPane.setConstraints(hPipeViewMaker(hPipeCount), a, b);
				board.getChildren().add(hPipeViewMaker(hPipeCount));
				hPipeCount++;
				break;
			case "Pipe01":
				GridPane.setConstraints(viewPipe01, a, b);
				board.getChildren().add(viewPipe01);
				break;
			case "Pipe00":
				GridPane.setConstraints(viewPipe00, a, b);
				board.getChildren().add(viewPipe00);
				break;
			case "PipeStaticHorizontal":
				GridPane.setConstraints(viewHStatic, a, b);
				board.getChildren().add(viewHStatic);
				break;
			case "PipeStaticVertical":
				GridPane.setConstraints(viewVStatic, a, b);
				board.getChildren().add(viewVStatic);
				break;
			case "EndHorizontal":
				GridPane.setConstraints(viewHEnd, a, b);
				board.getChildren().add(viewHEnd);
				break;
			case "EndVertical":
				GridPane.setConstraints(viewVEnd, a, b);
				board.getChildren().add(viewVEnd);
				break;
			case "EmptyFree":
				GridPane.setConstraints(freeViewMaker(freeCount), a, b);
				board.getChildren().add(freeViewMaker(freeCount));
				freeCount++;
				break;
			case "PipeStatic01":
				GridPane.setConstraints(viewStatic01, a, b);
				board.getChildren().add(viewStatic01 );
				break;
			}	
			a++;
			if(a>3) {
				a=0;
				b++;
			}
		}
		
		
	}
	
	public static ImageView emptyViewMaker(int num) {
		if(num == 0) {
			return viewEmpty0;	}
		else if(num == 1) {
			return viewEmpty1;	}
		else if(num == 2) {
			return viewEmpty2; }
		else if(num ==3) {
			return viewEmpty3;	}
		else if(num ==4) {
			return viewEmpty4;	}
		else if(num ==5) {
			return viewEmpty5;	}
		else if(num ==6) {
			return viewEmpty6;	}
		else if(num ==7) {
			return viewEmpty7;	}
		else
			return null;
	}
	
	public static ImageView freeViewMaker(int num) {
		if(num == 0) {
			return viewFree0;	}
		else if(num == 1) {
			return viewFree1;	}
		else if(num == 2) {
			return viewFree2; }
		else if(num ==3) {
			return viewFree3;	}
		else if(num ==4) {
			return viewFree4;	}
		else
			return null;
	}
	
	public static ImageView hPipeViewMaker(int num) {
		if(num == 0) {
			return viewHPipe0;	}
		else if(num == 1) {
			return viewHPipe1;	}
		else
			return null;
	}
	
	public static ImageView vPipeViewMaker(int num) {
		if(num == 0) {
			return viewVPipe0;	}
		else if(num == 1) {
			return viewVPipe1;	}
		else
			return null;
	}
	
	
	
	
	

}
