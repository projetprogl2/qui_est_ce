package app;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController extends Game implements IGlobalFunctions {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	 ImageView img_background = new ImageView();
	@FXML
	 ImageView img_flame = new ImageView();
	@FXML
	 ImageView img_play = new ImageView();

	@FXML
	Text menu_text;

	@FXML
	Button btn_play = new Button();
	@FXML
	Button btn_menu = new Button();
	@FXML
	Button btn_quit = new Button();

	public void initialize() {

		initImgFont();
		menu_text.setText("Current Game Mode: " + game.getDifficulty());
	}

	public void initImgFont()
	{
		setDifficulty("Normal");

		setImageView("files/images/UI/menu/background.png", 700, 400, img_background);
		setImageView("files/images/UI/menu/flame_gif.gif", 700, 400, img_flame);
		setImageView("files/images/UI/menu/play.png", 405, 72, img_play);
	}

	public void switchScene_Selection(ActionEvent event) throws IOException {
		if (game.getDifficulty() == null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error.");
				alert.setHeaderText(null);
				alert.setContentText("Please, select a difficulty before starting the game.\n(Go to option, select difficulty and Apply !)");
		
				alert.showAndWait();
		}
		else {
			switch_scene(event, "/app/Selection", stage, scene, false);
		}
	}
	public void switchScene_Options(ActionEvent event) throws IOException {
		switch_scene(event, "/app/Options", stage, scene, false);
	}
	public void quitGame(ActionEvent event) {
		Platform.exit();
	}


}
