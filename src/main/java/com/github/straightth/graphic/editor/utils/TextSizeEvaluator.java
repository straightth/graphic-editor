package com.github.straightth.graphic.editor.utils;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextSizeEvaluator {
    private TextSizeEvaluator() {
        throw new IllegalStateException("Utility class");
    }

    public static double toolSizeToFontSize(int toolSize) {
        return getDefaultFontSize() * (0.75 + toolSize * 0.25);
    }

    public static double getDefaultFontSize() {
        return new Text("").getFont().getSize();
    }

    public static double getWidthByCharacter(char character, double fontSize) {
        return getTextByCharacter(character, fontSize).getLayoutBounds().getWidth();
    }

    public static double getHeightByCharacter(char character, double fontSize) {
        return getTextByCharacter(character, fontSize).getLayoutBounds().getHeight();
    }

    private static Text getTextByCharacter(char character, double fontSize) {
        Text text = new Text(Character.toString(character));
        text.setFont(new Font(text.getFont().getName(), fontSize));
        return text;
    }
}
