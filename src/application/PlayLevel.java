package application;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * @author Akif
 *
 */

public class PlayLevel extends LoadLevels {

	// Starting position of the selected tile
	public static double startingX, startingY;

	public static void moveTile() {
		
		//ArrayList to store the tiles that are not static in order to make adding
		//them mouse handlers with a shorter, easier to eye code
		ArrayList<ImageView> movableTiles = new ArrayList<>();
		movableTiles.add(viewEmpty0);	movableTiles.add(viewEmpty1);	movableTiles.add(viewEmpty2);
		movableTiles.add(viewEmpty3);	movableTiles.add(viewEmpty4);	movableTiles.add(viewEmpty5);
		movableTiles.add(viewEmpty6);	movableTiles.add(viewEmpty7);	movableTiles.add(viewFree0);
		movableTiles.add(viewFree1);	movableTiles.add(viewFree2);	movableTiles.add(viewFree3);
		movableTiles.add(viewFree4);	movableTiles.add(viewHPipe0);	movableTiles.add(viewHPipe1);
		movableTiles.add(viewVPipe0);	movableTiles.add(viewVPipe1);	movableTiles.add(viewPipe00);
		movableTiles.add(viewPipe01);
		
		for(ImageView i: movableTiles) {
			// Add event handlers for mouse pressed gesture to tiles
			i.addEventHandler(MouseEvent.MOUSE_PRESSED, MouseEventHandlers.pressHandler);
			// Add event handlers for mouse dragged gesture to tiles
			i.addEventHandler(MouseEvent.MOUSE_DRAGGED, MouseEventHandlers.dragHandler);
			// Add event handlers for mouse released gesture to tiles
			i.addEventHandler(MouseEvent.MOUSE_RELEASED, MouseEventHandlers.releaseHandler);
		}
	
	}

	// Method that gets the node in a specific column and row index of the GridPane
	public static ImageView getNodeByColumnRow(GridPane gPane, int column, int row) {
		ImageView result = null;
		ObservableList<Node> nodesOfPane = gPane.getChildren();
		for (Node node : nodesOfPane) {
			if (gPane.getColumnIndex(node) == column && gPane.getRowIndex(node) == row) {
				result = (ImageView) node;
				break;
			}
		}
		return result;
	}
	

	// Gets called when the target tile is not free
	public static void moveFailed(ImageView imageview) {
		imageview.setTranslateX(0);
		imageview.setTranslateY(0);
		System.out.println("Can only move to free tiles");
	}

	// Method to "swap" a couple of ImageViews
	public static void swap(ImageView i1, ImageView i2) {
		i1.setTranslateX(0);
		i1.setTranslateY(0);
		GridPane.setConstraints(i1, getConstraintsX(i2), getConstraintsY(i2));
		i2.setTranslateX(0);
		i2.setTranslateY(0);
		GridPane.setConstraints(i2, getConstraintsX(i1), getConstraintsY(i1));
		// Increments the number of moves if the tile has actually moved.
		if (  !( ( getConstraintsX(i1) == getConstraintsX(i2) ) && ( getConstraintsY(i2) == getConstraintsY(i1) ) ) ) {
		Main.moves++;
		Main.score.setText("NUMBER OF MOVES: " + Main.moves);
		
		 //Checks if the level is completed for levels 1,2 and 3 
  		if(Main.levelCount == 1 || Main.levelCount == 2 || Main.levelCount == 3) {
  			checkLevelComplete123();
  		}
  		//... or levels 4 and 5
  		else if(Main.levelCount == 4) {
  			checkLevelComplete4();
  		}
  		else if(Main.levelCount == 5) {
  			checkLevelComplete5();
  		}
	}
		
	}
	
		//Checks if the level is completed for the levels 1, 2 and 3
		//If the tiles are positioned correctly the level is done and the animation 
		public static void checkLevelComplete123() {
			if( ( (getNodeByColumnRow(board,0,1)).equals(viewVPipe0) || (getNodeByColumnRow(board,0,1)).equals(viewVPipe1)  ) 
				&& ( (getNodeByColumnRow(board,0,2)).equals(viewVPipe0) || (getNodeByColumnRow(board,0,2) ).equals(viewVPipe1) ) 
				&& (getNodeByColumnRow(board,0,3)).equals(viewPipe01) && (getNodeByColumnRow(board,1,3)).equals(viewHPipe0))  {
				
				LevelCompleted.level123Completed();
			}
		}
		
			//Checks if the level is completed for the level4
			//If the tiles are positioned correctly the level is done and the animation 
			public static void checkLevelComplete4() {
				if( ( (getNodeByColumnRow(board,1,2)).equals(viewHPipe0) || (getNodeByColumnRow(board,1,2)).equals(viewHPipe1)  ) 
					&& ( (getNodeByColumnRow(board,2,2)).equals(viewHPipe0) || (getNodeByColumnRow(board,2,2) ).equals(viewHPipe1) )
					&& (getNodeByColumnRow(board,0,2)).equals(viewPipe01) && (getNodeByColumnRow(board,3,2) ).equals(viewPipe00))  {
					
					LevelCompleted.level45Completed();
				}
			}
			
			//Checks if the level is completed for the level4
			//If the tiles are positioned correctly the level is done and the animation 
			public static void checkLevelComplete5() {
				if( ( (getNodeByColumnRow(board,0,1)).equals(viewVPipe0) || (getNodeByColumnRow(board,0,1)).equals(viewVPipe1)  ) 
					&& ( (getNodeByColumnRow(board,1,2)).equals(viewHPipe0) || (getNodeByColumnRow(board,1,2) ).equals(viewHPipe1) )
					&& (getNodeByColumnRow(board,3,2) ).equals(viewPipe00)
					&& ( (getNodeByColumnRow(board,2,2)).equals(viewHPipe0) || (getNodeByColumnRow(board,2,2) ).equals(viewHPipe1) ) )  {
					
					LevelCompleted.level45Completed();
				}
			}
	
	//Methods that get the Column/Raw corresponding to the cursor position on screen. 
	//Will be used to check if target tile is diagonal to the current tile
	public static int getColumnByMousePos(double CursorX) {
		int column = ( (int) (CursorX- 30 ) / 128);
		return column;
	}
	public static int getRowByMousePos(double CursorY) {
		int rown = ( (int) (CursorY - 30 ) / 128);
		return rown;
	}

	// Method to get the current column of the ImageView
	public static int getConstraintsX(ImageView ImVi) {
		int constraintX;
		constraintX = ((int) (ImVi.getLayoutX() - 20.8) / 128);
		return constraintX;
	}

	// Method to get the current row of the ImageView
	public static int getConstraintsY(ImageView ImVi) {
		int constraintX;
		constraintX = ((int) (ImVi.getLayoutY() - 20.8) / 128);
		return constraintX;
	}

	// Check for tiles that are not "Static" but also are not "Free"
	// Checks if the dragging target is "Free" and gives a green light if it is
	public static boolean nonFreeChecker(MouseEvent e) {
		boolean greenLight = false;
		int x = 0;
		int y = 0;
		if( e.getSceneX() < 558 && e.getSceneY() < 568 ) {
			x = (int) (e.getSceneX() - 42) / 128;
			y = (int) (e.getSceneY() - 42) / 128;
			if ((getNodeByColumnRow(board, x, y)).equals(viewFree0) || (getNodeByColumnRow(board, x, y)).equals(viewFree1)
					|| (getNodeByColumnRow(board, x, y)).equals(viewFree2)
					|| (getNodeByColumnRow(board, x, y)).equals(viewFree3)
					|| (getNodeByColumnRow(board, x, y)).equals(viewFree4)) {
				greenLight = true;
			}
		}
		return greenLight;
	}

	// Method that places the dragged tile to the row/column on the GridPane
	// corresponding to
	// the cursor placement at the moment that the mouse is released
	public static void dragCompleted(ImageView tileImage, MouseEvent e) {
		//Check if the mouse is inside board borders
		if ( ( e.getSceneX() < 558 && e.getSceneY() < 568  ) &&
				// Check if the target location neighbors the current location ->
				(Math.abs(e.getSceneX() - startingX) < 200 && Math.abs(e.getSceneY() - startingY) < 200)
				// -> and is not diagonal to it
				&&  (    (getColumnByMousePos(startingX) == getColumnByMousePos(e.getSceneX()))  ||
						 (getRowByMousePos(startingY) == getRowByMousePos(e.getSceneY()))   )   )   {
			
			// Check if the target tile is a static tile, proceed if it isn't
			if ( !getNodeByColumnRow(board, getColumnByMousePos(e.getSceneX()), getRowByMousePos(e.getSceneY())).equals(viewVStarter)
					&&	!getNodeByColumnRow(board, getColumnByMousePos(e.getSceneX()), getRowByMousePos(e.getSceneY())).equals(viewVStatic) 
					&&  !getNodeByColumnRow(board, getColumnByMousePos(e.getSceneX()), getRowByMousePos(e.getSceneY())).equals(viewHStatic) 
					&&	!getNodeByColumnRow(board, getColumnByMousePos(e.getSceneX()), getRowByMousePos(e.getSceneY())).equals(viewVEnd)
					&&	!getNodeByColumnRow(board, getColumnByMousePos(e.getSceneX()), getRowByMousePos(e.getSceneY())).equals(viewHEnd) ){
				// if statements check where the cursor that's dragging the tile is
				// Then calls the swap method according to the column/row corresponding to the
				// cursor location
				if (e.getSceneX() < 178 && e.getSceneX() > 30 && e.getSceneY() < 178 && e.getSceneY() > 30) {
					swap(tileImage, getNodeByColumnRow(board, 0, 0));
				} else if (e.getSceneX() < 178 && e.getSceneX() > 30 && e.getSceneY() < 316 && e.getSceneY() > 158) {
					swap(tileImage, getNodeByColumnRow(board, 0, 1));
				} else if (e.getSceneX() < 178 && e.getSceneX() > 30 && e.getSceneY() < 434 && e.getSceneY() > 296) {
					swap(tileImage, getNodeByColumnRow(board, 0, 2));
				} else if (e.getSceneX() < 178 && e.getSceneX() > 30 && e.getSceneY() < 562 && e.getSceneY() > 414) {
					swap(tileImage, getNodeByColumnRow(board, 0, 3));
				} else if (e.getSceneX() < 306 && e.getSceneX() > 158 && e.getSceneY() < 178 && e.getSceneY() > 30) {
					swap(tileImage, getNodeByColumnRow(board, 1, 0));
				} else if (e.getSceneX() < 306 && e.getSceneX() > 158 && e.getSceneY() < 292 && e.getSceneY() > 158) {
					swap(tileImage, getNodeByColumnRow(board, 1, 1));
				} else if (e.getSceneX() < 306 && e.getSceneX() > 158 && e.getSceneY() < 434 && e.getSceneY() > 286) {
					swap(tileImage, getNodeByColumnRow(board, 1, 2));
				} else if (e.getSceneX() < 306 && e.getSceneX() > 158 && e.getSceneY() < 562 && e.getSceneY() > 414) {
					swap(tileImage, getNodeByColumnRow(board, 1, 3));
				} else if (e.getSceneX() < 434 && e.getSceneX() > 286 && e.getSceneY() < 178 && e.getSceneY() > 30) {
					swap(tileImage, getNodeByColumnRow(board, 2, 0));
				} else if (e.getSceneX() < 434 && e.getSceneX() > 286 && e.getSceneY() < 306 && e.getSceneY() > 158) {
					swap(tileImage, getNodeByColumnRow(board, 2, 1));
				} else if (e.getSceneX() < 434 && e.getSceneX() > 286 && e.getSceneY() < 434 && e.getSceneY() > 286) {
					swap(tileImage, getNodeByColumnRow(board, 2, 2));
				} else if (e.getSceneX() < 434 && e.getSceneX() > 286 && e.getSceneY() < 562 && e.getSceneY() > 414) {
					swap(tileImage, getNodeByColumnRow(board, 2, 3));
				} else if (e.getSceneX() < 562 && e.getSceneX() > 414 && e.getSceneY() < 178 && e.getSceneY() > 30) {
					swap(tileImage, getNodeByColumnRow(board, 3, 0));
				} else if (e.getSceneX() < 562 && e.getSceneX() > 414 && e.getSceneY() < 306 && e.getSceneY() > 158) {
					swap(tileImage, getNodeByColumnRow(board, 3, 1));
				} else if (e.getSceneX() < 562 && e.getSceneX() > 424 && e.getSceneY() < 424 && e.getSceneY() > 296) {
					swap(tileImage, getNodeByColumnRow(board, 3, 2));
				} else if (e.getSceneX() < 562 && e.getSceneX() > 424 && e.getSceneY() < 552 && e.getSceneY() > 424) {
					swap(tileImage, getNodeByColumnRow(board, 3, 3));
				}
			} else  {
				// Gets called if the target is a static tile i.e it's not supposed to move
				// Places the dragged tile back to where it was and prints an info message
				tileImage.setTranslateX(0);
				tileImage.setTranslateY(0);
				System.out.println("Static tiles can not move");
			}
		} else {
			// Gets revoked if the target tile does not share a border with the tile that's
			// being moved right now
			tileImage.setTranslateX(0);
			tileImage.setTranslateY(0);
			System.out.println("Can only move to a neighboring tile.");
		}
	}
}
