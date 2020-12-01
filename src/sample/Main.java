package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new GridPane(), 1400,1000);
        stage.setScene(scene);
        stage.show();

        layout();
    }

    public void layout(){
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50,30,50,30));

        stage.setTitle("Image View");

        ImageView imageView = new ImageView();

        Button button = new Button("Browse");
        button.setFont(Font.font(50));
        button.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null){
                Image image = new Image("file:" + file.getAbsolutePath());
                imageView.setImage(image);
            }
        });
        root.getChildren().addAll(button,imageView);
        stage.getScene().setRoot(root);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
