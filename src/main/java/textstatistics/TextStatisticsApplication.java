package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.awt.*;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        HBox bottomHBox = new HBox();
        bottomHBox.setSpacing(10);
        bottomHBox.getChildren().add(new Label("Letters: 0"));
        bottomHBox.getChildren().add(new Label("Words: 0"));
        bottomHBox.getChildren().add(new Label("The longest word is:"));

        layout.setCenter(new TextArea(""));
        layout.setBottom(bottomHBox);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

}
