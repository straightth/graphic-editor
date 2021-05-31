package com.github.straightth.graphic.editor.draw.text;

import com.github.straightth.graphic.editor.draw.selection.SelectionRectangleWithPivot;
import com.github.straightth.graphic.editor.utils.CSSHandler;
import com.github.straightth.graphic.editor.utils.Coordinate;
import com.github.straightth.graphic.editor.utils.TextSizeEvaluator;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import org.fxmisc.richtext.InlineCssTextArea;

import java.util.Objects;

import static com.github.straightth.graphic.editor.utils.Binder.bindWidth;
import static com.github.straightth.graphic.editor.utils.Binder.bindHeight;
import static com.github.straightth.utils.Loop.range;

public class TextRectangleWithPivot extends Group {
    private final SelectionRectangleWithPivot rectangle = new SelectionRectangleWithPivot();

    private final InlineCssTextArea textArea = new InlineCssTextArea();

    private double fontSize;

    public TextRectangleWithPivot() {
        super();

        getChildren().addAll(rectangle, textArea);

        textArea.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        textArea.setWrapText(true);
        textArea.getStylesheets().add(
                Objects.requireNonNull(getClass().getResource("color/black.css")).toExternalForm());

        bindWidth(textArea, rectangle.widthProperty());
        bindHeight(textArea, rectangle.heightProperty());
    }

    public void setPivot(double x, double y) {
        rectangle.setPivot(x, y);
    }

    public Coordinate getPivot() {
        return rectangle.getPivot();
    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public void resize(double x, double y, double borderWidth, double borderHeight) {
        resize(new Coordinate(x, y), borderWidth, borderHeight);
    }

    public void resize(Coordinate target, double borderWidth, double borderHeight) {
        rectangle.resize(target, borderWidth, borderHeight);
        textArea.setLayoutX(rectangle.getX());
        textArea.setLayoutY(rectangle.getY());
    }

    public void setWidth(double width) {
        rectangle.setWidth(width);
    }

    public void setHeight(double height) {
        rectangle.setHeight(height);
    }

    public String getText() {
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();
        StringBuilder text = new StringBuilder(textArea.getText());
        double lineWidth = 0;
        double lineHeight = 0;
        for (var i : range(0, text.length())) {
            lineWidth += TextSizeEvaluator.getWidthByCharacter(text.charAt(i), fontSize);
            double characterHeight = TextSizeEvaluator.getHeightByCharacter(text.charAt(i), fontSize);
            if (lineHeight < characterHeight) {
                lineHeight = characterHeight;
            }
            if (lineWidth > width) {
                text.insert(i, "\n");
                height -= lineHeight;
                if (height - lineHeight < 0) {
                    text = new StringBuilder(text.substring(0, i));
                    break;
                }
                lineWidth = 0;
                lineHeight = 0;
            }
        }
        return text.toString();
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
        textArea.getStylesheets().add(CSSHandler.getFontSizeStyle(fontSize, this));
    }

    public void setTextColor(Color color) {
        textArea.getStylesheets().add(CSSHandler.getTextColorStyle(color, this));
    }

    public void reset() {
        setVisible(false);
        rectangle.setX(0);
        rectangle.setY(0);
        rectangle.setWidth(0);
        rectangle.setHeight(0);
        textArea.clear();
    }
}
