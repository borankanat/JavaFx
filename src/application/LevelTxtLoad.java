package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
/**
 * @author Akif
 *
 */

public class LevelTxtLoad {

	public static Tiles[] tilesFinal = new Tiles[16];
	static String levelText = "";
	
	static String currentLevel = "";
	
	public static String getCurrentLevel(int levelCount) {
		if(levelCount == 1) {
			currentLevel = "level1.txt";
			return currentLevel;
		}
		else if(levelCount ==2) {
			currentLevel = "level2.txt";
			return currentLevel;
		}
		else if(levelCount ==3) {
			currentLevel = "level3.txt";
			return currentLevel;
		}
		else if(levelCount ==4) {
			currentLevel = "level4.txt";
			return currentLevel;
		}
		else if(levelCount ==5) {
			currentLevel = "level5.txt";
			return currentLevel;
		}
		else
			System.exit(0);
			return null;
		
	}
	 
	public static void TextLoader(String levelName) {
		tilesFinal = new Tiles[tilesFinal.length];

		try {
			Scanner sc = new Scanner(new File(levelName));
			while (sc.hasNext())
				levelText += sc.next() + "\n";
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Tiles> tileLst = new ArrayList<>();
		tileLst.add(Tiles.verticalEnd);	tileLst.add(Tiles.horizontalEnd);
		tileLst.add(Tiles.vertStarter);	tileLst.add(Tiles.horizontalStatic);
		tileLst.add(Tiles.Free);	tileLst.add(Tiles.Empty);
		tileLst.add(Tiles.horizontalPipe);	tileLst.add(Tiles.verticalPipe);
		tileLst.add(Tiles.Curved01);	tileLst.add(Tiles.Curved00);
		tileLst.add(Tiles.verticalStatic); tileLst.add(Tiles.Static01);
		
		String[] tempSplit = levelText.split(",|\\s");
		int m = 0;
		for (int j = 1; j < 49; j += 3) {
			int k = j + 1;
			for (int i = 0; i < tileLst.size(); i++) {
				if (tempSplit[j].equals(tileLst.get(i).getType())
						&& tempSplit[k].equals(tileLst.get(i).getProperty())) {
					tilesFinal[m] = tileLst.get(i);
					m++;
				}
			}
		}
	}
	
	
	
	

}
