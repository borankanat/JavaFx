package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
/**
 * @author Akif
 *
 */

public class LoadTile {

	public static Image base, Starter, Empty, Free, VEnd, HEnd, VStatic, HStatic, Static01, HPipe, VPipe, Pipe01, Pipe00;

	public LoadTile(Image img) {
		this.base = img;
	}
	
	public static Image crop(int x, int y, int w, int h) {
		PixelReader pixRead = basePic.getPixelReader();
		WritableImage cropped = new WritableImage(pixRead, x, y, w, h);
		return cropped;
	}
	
	static Image basePic = new Image(LoadTile.class.getResourceAsStream("AllTiles.jpg"));
	
	public static LoadTile allTile = new LoadTile(basePic);
	
	public static Image getStarter() {
		Starter = LoadTile.crop(384, 256, 128, 128);
		return Starter;
	}
	
	public static Image getVEnd() {
		VEnd = LoadTile.crop(0, 256, 128, 128);
		return VEnd;
	}
	
	public static Image getEmpty() {
		Empty = LoadTile.crop(256, 0, 128, 128);
		return Empty;
	}
	public static Image getFree() {
		Free = LoadTile.crop(256, 128, 128, 128);
		return Free;
	}
	public static Image getHEnd() {
		HEnd = LoadTile.crop(384, 0, 128, 128);
		return HEnd;
	}
	public static Image getVStatic() {
		VStatic = LoadTile.crop(256, 256, 128, 128);
		return VStatic;
	}
	public static Image getHStatic() {
		HStatic = LoadTile.crop(128, 128, 128, 128);
		return HStatic;
	}
	public static Image getHPipe() {
		HPipe = LoadTile.crop(0, 128, 128, 128);
		return HPipe;
	}
	public static Image getVPipe() {
		VPipe = LoadTile.crop(128, 256, 128, 128);
		return VPipe;
	}
	public static Image getPipe01() {
		Pipe01 = LoadTile.crop(128, 0, 128, 128);
		return Pipe01;
	}
	public static Image getPipe00() {
		Pipe00 = LoadTile.crop(0, 0, 128, 128);
		return Pipe00;
	}
	public static Image getStatic01() {
		Static01 = LoadTile.crop(384, 128, 128, 128);
		return Static01;
	}
	
}
