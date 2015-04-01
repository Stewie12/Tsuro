package application;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        
        Label label = new Label();
        label.setText(
                visualBounds.getWidth() + " x " + visualBounds.getHeight());
 
        StackPane root = new StackPane();
        root.getChildren().add(label);
         
        Scene scene = new Scene(root, 
                visualBounds.getWidth(), visualBounds.getHeight());
         
        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
