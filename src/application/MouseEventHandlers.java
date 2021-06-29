package application;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * @author Akif
 *
 */

//Class to store the custom MouseEvent handlers
//to not make PlayLevel class any more bloated
public class MouseEventHandlers extends PlayLevel{
	
	// MouseEvent handler that lets the user drag the tile around
		static EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				((ImageView) e.getSource()).toFront();
				((ImageView) e.getSource()).setTranslateX(e.getSceneX() - startingX);
				((ImageView) e.getSource()).setTranslateY(e.getSceneY() - startingY);
				if(e.getSceneX() < 0 || e.getSceneX() > 610 || e.getSceneY() < 0 || e.getSceneY() > 610 ) {
					((ImageView) e.getSource()).setTranslateX(0);
					((ImageView) e.getSource()).setTranslateY(0);
				}
			}
		};
		
		// MouseEvent handler that checks the conditions for a tile swap operation and
		static EventHandler<MouseEvent> releaseHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getSource().equals(viewPipe00)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewPipe00, e);
					} else {
						//if the target tile is not free, place the dragged pile back
						//to where it was and print an info message
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewPipe01)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewPipe01, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewHPipe0)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewHPipe0, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewHPipe1)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewHPipe1, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewVPipe0)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewVPipe0, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewVPipe1)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewVPipe1, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty0)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty0, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty1)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty1, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty2)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty2, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty3)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty3, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty4)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty4, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty5)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty5, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty6)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty6, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				} else if (e.getSource().equals(viewEmpty7)) {
					if (nonFreeChecker(e)) {
						dragCompleted(viewEmpty7, e);
					} else {
						moveFailed(((ImageView) e.getSource()));
					}
				}
				else if (e.getSource().equals(viewFree0)) {
					dragCompleted(viewFree0, e);
				} else if (e.getSource().equals(viewFree1)) {
					dragCompleted(viewFree1, e);
				} else if (e.getSource().equals(viewFree2)) {
					dragCompleted(viewFree2, e);
				} else if (e.getSource().equals(viewFree3)) {
					dragCompleted(viewFree3, e);
				} else if (e.getSource().equals(viewFree4)) {
					dragCompleted(viewFree4, e);
				}
			}
		};
		
		
		// MouseEvent handler that gets the position of the cursor at the moment that
		// it's pressed
		static EventHandler<MouseEvent> pressHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				startingX = e.getSceneX();
				startingY = e.getSceneY();
				
			}
		};
}
