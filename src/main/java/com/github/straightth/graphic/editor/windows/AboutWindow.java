package com.github.straightth.graphic.editor.windows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutWindow {
    private static final int INDENT = 5;

    private static final String LINK = "https://github.com/straightth/graphic-editor";

    private static final Stage stage = new Stage();

    private AboutWindow() {
        throw new IllegalStateException("Utility class");
    }

    public static void show() {
        stage.setResizable(false);
        stage.setTitle("About");

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);

        Hyperlink hyperlink = new Hyperlink(LINK);
        hyperlink.setOnAction(actionEvent -> {
            try {
                new ProcessBuilder("x-www-browser", LINK).start();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                stage.close();
            }
        });

        hBox.getChildren().add(hyperlink);

        stage.setScene(new Scene(hBox,
                new Text(LINK).getLayoutBounds().getWidth() + INDENT * 3,
                new Text("").getLayoutBounds().getHeight() + INDENT * 3));

        stage.show();
    }
}
