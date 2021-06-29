package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * @author Akif
 *
 */

public class Tiles {
	
	private boolean movable;
	private String type, property;
	private ImageView graphic;
	
	public Tiles(String type, String property, ImageView graphic, boolean movable) {
		this.type = type;
		this.property = property;
		this.graphic = graphic;
		this.movable = movable;
	}
	
	static Tiles vertStarter = new Tiles("Starter" , "Vertical" , new ImageView(LoadTile.getStarter()), false);
	static Tiles verticalEnd = new Tiles("End" , "Vertical" , new ImageView(LoadTile.getVEnd()), false );
	static Tiles horizontalEnd = new Tiles("End" , "Horizontal" , new ImageView(LoadTile.getHEnd()), false);
	static Tiles Empty = new Tiles("Empty" , "none" , new ImageView(LoadTile.getEmpty()), false);
	static Tiles Free = new Tiles("Empty", "Free", new ImageView(LoadTile.getFree()), true);
	static Tiles verticalStatic = new Tiles("PipeStatic" , "Vertical" , new ImageView(LoadTile.getVStatic()), false);
	static Tiles horizontalStatic = new Tiles("PipeStatic" , "Horizontal" , new ImageView(LoadTile.getHStatic()), false);
	static Tiles verticalPipe = new Tiles("Pipe" , "Vertical" , new ImageView(LoadTile.getVPipe()), false);
	static Tiles horizontalPipe = new Tiles("Pipe" , "Horizontal" , new ImageView(LoadTile.getHPipe()), false);
	static Tiles Curved01 = new Tiles("Pipe" , "01", new ImageView(LoadTile.getPipe01()), false);
	static Tiles Curved00 = new Tiles("Pipe" , "00", new ImageView(LoadTile.getPipe00()), false);
	static Tiles Static01 = new Tiles("PipeStatic" , "01" , new ImageView(LoadTile.getStatic01()), false);

	public boolean isMovable() {
		return movable;
	}
	public String getType() {
		return type;
	}
	public String getProperty() {
		return property;
	}
	public ImageView getGraphic() {
		return graphic;
	}
	
	public static String toString(Tiles[] x) {
		String temp = "";
		for(int i=0; i<16; i++) {
		temp+= x[i].getType() + x[i].getProperty() +"\n";
		}
		return temp;
	}
	
}











