package application;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.opencv.videoio.VideoCapture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXController {

	public void start(Stage primaryStage){
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FXHelloCV.fxml"));
		BorderPane root = (BorderPane) loader.load();
		FXController controller = loader.getController();
		
		@FXML 
		private Button button;
		@FXML 
		private ImageView currentFrame;
		@FXML
		public void startCamera(ActionEvent event){ 
			private VideoCapture capture = new VideoCapture();
			Runnable frameGrabber = new Runnable() {
			}
			this.timer = Executors.newSingleThreadScheduledExecutor();
				this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
			
		}
	}
}
