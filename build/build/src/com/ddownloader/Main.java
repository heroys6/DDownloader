package com.ddownloader;

import java.io.IOException;

import com.ddownloader.view.MainLayoutController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("DDownloader");
		this.primaryStage.getIcons().add(new Image("file:Resources/Img/main-icon.png"));
		this.primaryStage.setResizable(false);
		
		loadMainLayout();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void loadMainLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(Main.class.getResource("view/MainLayout.fxml"));
			
			AnchorPane anchorPane = (AnchorPane) loader.load();
			
			Scene scene = new Scene(anchorPane);
			
			primaryStage.setScene(scene);
			
			MainLayoutController controller = loader.getController();
			
			controller.setMainLink(this);
			
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}