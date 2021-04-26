package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.Arrays;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea();

        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longest = new Label("The longest word is:");


        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            String longestWord = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            letters.setText("Letters: " + String.valueOf(characters));
            words.setText("Words: " + String.valueOf(parts.length));
            longest.setText("The longest word is: " + longestWord);
        });

        HBox bottomHBox = new HBox();
        bottomHBox.setSpacing(10);
        bottomHBox.getChildren().add(letters);
        bottomHBox.getChildren().add(words);
        bottomHBox.getChildren().add(longest);

        layout.setCenter(textArea);
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
