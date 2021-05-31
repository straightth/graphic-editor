package com.github.straightth.graphic.editor.utils;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class TextBlock extends VBox {

    private final ArrayList<Text> texts = new ArrayList<>();

    public void addText(Text text) {
        getChildren().add(text);
        texts.add(text);
    }

    public void addAllTexts(Text... texts) {
        getChildren().addAll(texts);
        this.texts.addAll(Arrays.asList(texts));
    }

    public double getTextWidth() {
        double width = 0;
        for (var text : texts) {
            if (text.getLayoutBounds().getWidth() > width) {
                width = text.getLayoutBounds().getWidth();
            }
        }
        return width;
    }

    public double getTextHeight() {
        double height = getSpacing() * texts.size() - 1;
        for (var text : texts) {
            height += text.getLayoutBounds().getHeight();
        }
        return height;
    }
}

