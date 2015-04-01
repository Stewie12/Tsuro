package application;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	
	// Percentage of tile space vs entire board
	public final double tilePercent = 0.1577181208;
	
	public final Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			root.setCenter(addGridPane());
			
			StackPane stackPaneLeft = new StackPane();
			StackPane stackPaneRight = new StackPane();
			
			stackPaneLeft.setMinWidth(visualBounds.getWidth() / 4);
			stackPaneRight.setMinWidth(visualBounds.getWidth() / 4);
			
			root.setLeft(stackPaneLeft);
			root.setRight(stackPaneRight);
			
			Scene scene = new Scene(root,visualBounds.getWidth(),visualBounds.getHeight());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public GridPane addGridPane() {
	    GridPane grid = new GridPane();
	    
	    Image boardPic = new Image("file:gameboard.jpg",visualBounds.getWidth() / 2,visualBounds.getHeight(),false,false);
	    BackgroundImage board = new BackgroundImage(boardPic,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
	    grid.setBackground(new Background(board));
	    
	    Pane topLeftCorner = new Pane();
	    topLeftCorner.setPrefSize(50, 60);
	    grid.add(topLeftCorner, 0, 0);
	    Pane topRightCorner = new Pane();
	    topRightCorner.setPrefSize(50, 60);
	    grid.add(topRightCorner, 7, 0);
	    Pane bottomLeftCorner = new Pane();
	    bottomLeftCorner.setPrefSize(50, 55);
	    grid.add(bottomLeftCorner, 0, 7);
	    Pane bottomRightCorner = new Pane();
	    bottomRightCorner.setPrefSize(50, 55);
	    grid.add(bottomRightCorner, 7, 7);
	    
	    for(int i=1;i<7;i++) {
	    	Pane newPane = new Pane();
	    	newPane.setPrefSize(115, 60);
	    	grid.add(newPane, i, 0);
	    }
	    
	    for(int i=1;i<7;i++) {
	    	Pane newPane = new Pane();
	    	newPane.setPrefSize(115, 60);
	    	grid.add(newPane, i, 7);
	    }
	    
	    for(int i=1;i<7;i++) {
	    	Pane newPane = new Pane();
	    	newPane.setPrefSize(55, 117);
	    	grid.add(newPane, 0, i);
	    }
	    
	    for(int i=1;i<7;i++) {
	    	Pane newPane = new Pane();
	    	newPane.setPrefSize(55, 117);
	    	grid.add(newPane, 7, i);
	    }
	    
	    placeTile(grid, 7, 3,3);
	    placeTile(grid, 28, 1,1);
	    placeTile(grid, 30, 1,2);
	    placeTile(grid, 35, 6,6);
	    
	    //grid.setGridLinesVisible(true);
	    
	    return grid;
	}
	
	public GridPane placeTile(GridPane grid, int tileNumber, int row, int col) {
		Image tile = new Image("file:piece"+Integer.toString(tileNumber)+".jpg", Math.ceil((visualBounds.getWidth() / 2) * tilePercent), Math.ceil(visualBounds.getHeight() * tilePercent),false,false);
		ImageView tileView = new ImageView(tile);
		grid.add(tileView, col, row);
		return grid;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}