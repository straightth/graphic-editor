package com.github.straightth.graphic.editor;

import com.github.straightth.graphic.editor.draw.CanvasLayout;
import com.github.straightth.graphic.editor.view.Appearance;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GraphicEditor extends Application {
    private static CanvasLayout canvasLayout;

    @Override
    public void start(Stage primaryStage) {
        canvasLayout = new CanvasLayout();
        stageInitialization(primaryStage);
        sceneInitialization(primaryStage);
        primaryStage.show();
    }

    private void stageInitialization(Stage stage) {
        stage.setScene(new Scene(new Appearance(), Appearance.getWidth(), Appearance.getHeight()));
        stage.setTitle("Graphic Editor");
        stage.setResizable(false);
    }

    private static void sceneInitialization(Stage stage) {
        stage.getScene().setFill(Appearance.getBackground());
    }

    public static CanvasLayout getCanvasLayout() {
        return canvasLayout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
