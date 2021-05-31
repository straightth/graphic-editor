package com.github.straightth.graphic.editor.windows;

import com.github.straightth.graphic.editor.utils.TextBlock;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelpWindow {
    private static final int INDENT = 35;

    private static final Stage stage = new Stage();

    private HelpWindow() {
        throw new IllegalStateException("Utility class");
    }

    public static void show() {
        stage.setResizable(false);
        stage.setTitle("Help");

        TextBlock textBlock = new TextBlock();
        textBlock.setAlignment(Pos.CENTER);
        textBlock.setSpacing(5);

        Text help = new Text("Saving the drowning is the work of the drowning themselves");

        textBlock.addText(help);

        stage.setScene(new Scene(textBlock,
                textBlock.getTextWidth() + INDENT,
                textBlock.getTextHeight() + INDENT));

        stage.show();
    }
}
