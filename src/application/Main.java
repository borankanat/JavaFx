package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main  extends Application {
	Stage window;
	static Label score = new Label();
    static int moves = 0;
    static Button btnBack = new Button("PREVIOUS LVL");
    static Button btnNext = new Button("NEXT LVL");
    
    //booleans that will be used for the button that lets the use
    //play the next level if the previous one has been completed
    static boolean lv2 = false;
	static boolean lv3 = false;
	static boolean lv4 = false;
	static boolean lv5 = false;
    
    static int levelCount=1;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	//Set the window
        window = primaryStage;
        window.setTitle("ROLL THE BALL");
        window.setResizable(false);
        
        //Create a root pane
        StackPane root = new StackPane();
        //Create a counter for the number of moves to the root
        score.setText("NUMBER OF MOVES: " + moves);
    	score.setTranslateX(-10);
    	score.setTranslateY(-295);
    	score.setFont(Font.font(20));
    	score.toFront();
    	
    	//call the method that adjusts and controls buttons that let the user change the level
    	buttons();
    	
    	root.getChildren().addAll(score,btnBack,btnNext);
    	
    	root.setPadding(new Insets(40, 20 , 20 ,20 ));
        root.getChildren().add(LoadLevels.board);
        Scene scene = new Scene(root, 600, 600);
        window.setScene(scene);
        
        //Start the game by revoking a chain of necessary methods
        initiateTheGame();
        window.show();
    }
    
    public static void initiateTheGame() {
    	moves = 0;
    	score.setText("NUMBER OF MOVES: " + moves);
    	LoadLevels.board.getChildren().clear();
    	LevelTxtLoad.levelText = "";
    	
    	LevelTxtLoad.TextLoader(LevelTxtLoad.getCurrentLevel(levelCount));
        LoadLevels.levelLoader(LevelTxtLoad.tilesFinal);
        PlayLevel.moveTile();
    }
    
    public static void buttons() {
    	
    	btnBack.setTranslateX(-220);
    	btnBack.setTranslateY(-295);
    	btnNext.setTranslateX(230);
    	btnNext.setTranslateY(-295);
    	
    	btnBack.setOnAction(e ->{
    		if(levelCount > 1) {
    			--levelCount;
    			initiateTheGame();
    		}
    	});
    	
    	btnNext.setOnAction(e -> {
    		if(levelCount < 5) {
    			if(levelCount+1 == 2 && lv2) {
    				levelCount++;
        			initiateTheGame();
    			} else if(levelCount+1 == 3 && lv3) {
    				levelCount++;
        			initiateTheGame();
    			} else if(levelCount+1 == 4 && lv4) {
    				levelCount++;
        			initiateTheGame();
    			} else if(levelCount+1 == 5 && lv5) {
    				levelCount++;
        			initiateTheGame();
    			} 
    		}
    		
    	});
    }
    
 
    

    

}