package com.github.straightth.graphic.editor.draw;

import com.github.straightth.graphic.editor.control.Controller;
import com.github.straightth.graphic.editor.control.tool.Tool;
import com.github.straightth.graphic.editor.draw.buffer.BufferedImage;
import com.github.straightth.graphic.editor.draw.events.MyKeyEvent;
import com.github.straightth.graphic.editor.draw.shapes.MyLine;
import com.github.straightth.graphic.editor.draw.shapes.RectangleWithPivot;
import com.github.straightth.graphic.editor.draw.selection.SelectionCanvas;
import com.github.straightth.graphic.editor.draw.selection.SelectionRectangleWithPivot;
import com.github.straightth.graphic.editor.draw.text.TextRectangleWithPivot;
import com.github.straightth.graphic.editor.utils.Coordinate;
import com.github.straightth.graphic.editor.utils.TextSizeEvaluator;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import static com.github.straightth.graphic.editor.control.Controller.*;
import static com.github.straightth.graphic.editor.draw.Drawer.*;

public class CanvasLayout extends Pane {
    private final Canvas canvas = new Canvas();

    private int scale = 1;

    private final MyLine line = new MyLine();

    private final RectangleWithPivot rectangle = new RectangleWithPivot();

    private final TextRectangleWithPivot textRectangle = new TextRectangleWithPivot();

    private final SelectionRectangleWithPivot selectionRectangle = new SelectionRectangleWithPivot();

    private final SelectionCanvas selectionCanvas = new SelectionCanvas();

    private final BufferedImage bufferedImage = new BufferedImage();

    public CanvasLayout() {
        super();

        line.setVisible(false);

        rectangle.setVisible(false);

        textRectangle.setVisible(false);

        selectionRectangle.setVisible(false);

        getChildren().addAll(canvas, selectionCanvas, line, rectangle, textRectangle, bufferedImage, selectionRectangle);

        eventHandlersInitialization();
    }

    public void setCanvasSize(double width, double height) {
        canvas.setWidth(width);
        canvas.setHeight(height);
        selectionCanvas.setWidth(width);
        selectionCanvas.setHeight(height);
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void eventHandlersInitialization() {
        copyEventHandlersInitialization();
        pasteEventHandlersInitialization();
        drawEventHandlersInitialization();
        lineEventHandlersInitialization();
        rectangleEventHandlersInitialization();
        textEventHandlersInitialization();
        selectEventHandlersInitialization();
        freeFormSelectEventHandlersInitialization();
    }

    private void drawEventHandlersInitialization() {
        Coordinate mouseLocation = new Coordinate(0, 0);

        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.PENCIL || getTool() == Tool.ERASER) {
                mouseLocation.x = mouseEvent.getX();
                mouseLocation.y = mouseEvent.getY();
                drawPixel(canvas.getGraphicsContext2D(), mouseLocation, getTool().getSize(), getTool().getColor());
            }
        });

        addEventHandler(MouseEvent.MOUSE_DRAGGED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.PENCIL || getTool() == Tool.ERASER) {
                drawLine(canvas.getGraphicsContext2D(),
                        mouseLocation, new Coordinate(mouseEvent.getX(), mouseEvent.getY()),
                        getTool().getSize(), getTool().getColor());
                mouseLocation.x = mouseEvent.getX();
                mouseLocation.y = mouseEvent.getY();
            }
        });
    }

    private void lineEventHandlersInitialization() {
        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.LINE) {
                if (!line.isVisible()) {
                    line.setStart(mouseEvent);
                    line.setEnd(mouseEvent);
                    line.setStrokeWidth(Tool.LINE.getSize());
                    line.setStroke(Tool.LINE.getColor());
                    line.setVisible(true);
                }
            }
        });

        addEventHandler(MouseEvent.MOUSE_DRAGGED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.LINE) {
                if (line.isVisible()) {
                    if (mouseEvent.getX() > 0 && mouseEvent.getX() < canvas.getWidth()) {
                        line.setEndX(mouseEvent.getX());
                    }
                    if (mouseEvent.getY() > 0 && mouseEvent.getY() < canvas.getHeight()) {
                        line.setEndY(mouseEvent.getY());
                    }
                }
            }
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.LINE) {
                if (line.isVisible()) {
                    drawLine(canvas.getGraphicsContext2D(),
                            line.getStart(), line.getEnd(), Tool.LINE.getSize(), Tool.LINE.getColor());
                    line.setVisible(false);
                }
            }
        });
    }

    private void rectangleEventHandlersInitialization() {
        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.RECTANGLE) {
                if (!rectangle.isVisible()) {
                    rectangle.setPivot(mouseEvent.getX(), mouseEvent.getY());
                    rectangle.setStrokeWidth(Tool.RECTANGLE.getSize() + 0.5);
                    rectangle.setStroke(Tool.RECTANGLE.getColor());
                    rectangle.setVisible(true);
                }
            }
        });

        addEventHandler(MouseEvent.MOUSE_DRAGGED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.RECTANGLE) {
                if (rectangle.isVisible()) {
                    rectangle.resize(mouseEvent.getX(), mouseEvent.getY(), canvas.getWidth(), canvas.getHeight());
                }
            }
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.RECTANGLE) {
                if (rectangle.isVisible()) {
                    drawRectangle(canvas.getGraphicsContext2D(), new Coordinate(rectangle.getX(), rectangle.getY()),
                            rectangle.getWidth(), rectangle.getHeight(),
                            Tool.RECTANGLE.getSize(), Tool.RECTANGLE.getColor());
                    rectangle.setVisible(false);
                    rectangle.setWidth(0);
                    rectangle.setHeight(0);
                }
            }
        });
    }

    private void textEventHandlersInitialization() {
        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.TEXT) {
                if (textRectangle.isVisible()) {
                    Controller.setDisableToolSizeControls(false);
                    Controller.setDisableToolColorControls(false);
                    drawText(canvas.getGraphicsContext2D(),
                            textRectangle.getText(), new Coordinate(textRectangle.getX(), textRectangle.getY()),
                            TextSizeEvaluator.toolSizeToFontSize(Tool.TEXT.getSize()), Tool.TEXT.getColor());
                    textRectangle.reset();
                }
            }
        });

        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.TEXT) {
                textRectangle.setPivot(mouseEvent.getX(), mouseEvent.getY());
                textRectangle.setFontSize(TextSizeEvaluator.toolSizeToFontSize(Tool.TEXT.getSize()));
                textRectangle.setTextColor(Tool.TEXT.getColor());
                textRectangle.setVisible(true);
            }
        });

        addEventHandler(MouseEvent.MOUSE_DRAGGED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.TEXT
                    && Math.abs(mouseEvent.getX() - textRectangle.getPivot().x) > 3
                    && Math.abs(mouseEvent.getY() - textRectangle.getPivot().y) > 3 ) {
                Controller.setDisableToolSizeControls(true);
                Controller.setDisableToolColorControls(true);
                textRectangle.resize(mouseEvent.getX(), mouseEvent.getY(), canvas.getWidth(), canvas.getHeight());
            }
        });
    }

    private void selectEventHandlersInitialization() {
        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.SELECT && selectionRectangle.isResizeable()) {
                if (selectionRectangle.isVisible()) {
                    selectionRectangle.reset();
                }
                selectionRectangle.setPivot(mouseEvent.getX(), mouseEvent.getY());
                selectionRectangle.setVisible(true);
            }
        });

        addEventHandler(MouseEvent.MOUSE_DRAGGED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.SELECT
                    && selectionRectangle.isResizeable()
                    && Math.abs(mouseEvent.getX() - selectionRectangle.getPivot().x) > 3
                    && Math.abs(mouseEvent.getY() - selectionRectangle.getPivot().y) > 3) {
                selectionRectangle.resize(mouseEvent.getX(), mouseEvent.getY(), canvas.getWidth(), canvas.getHeight());
            }
        });
    }

    private void freeFormSelectEventHandlersInitialization() {
        Coordinate mouseLocation = new Coordinate(0, 0);

        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.FREE_FORM_SELECT && selectionRectangle.isResizeable()) {
                if (selectionRectangle.isVisible()) {
                    selectionRectangle.reset();
                }
                selectionCanvas.setVisible(true);
                mouseLocation.x = mouseEvent.getX();
                mouseLocation.y = mouseEvent.getY();
                drawPixel(selectionCanvas.getGraphicsContext2D(), mouseLocation,
                        Tool.FREE_FORM_SELECT.getSize(), Tool.FREE_FORM_SELECT.getColor());
                selectionCanvas.setLowestCoordinate(mouseLocation.clone());
                selectionCanvas.setHighestCoordinate(mouseLocation.clone());
            }
        });

        addEventHandler(MouseEvent.MOUSE_DRAGGED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.FREE_FORM_SELECT && selectionRectangle.isResizeable()) {
                drawLine(selectionCanvas.getGraphicsContext2D(),
                        mouseLocation, new Coordinate(mouseEvent.getX(), mouseEvent.getY()),
                        Tool.FREE_FORM_SELECT.getSize(), Tool.FREE_FORM_SELECT.getColor());
                mouseLocation.x = mouseEvent.getX();
                mouseLocation.y = mouseEvent.getY();
                Coordinate.fillInTheBoundaryCoordinates(mouseLocation,
                        selectionCanvas.getLowestCoordinate(), selectionCanvas.getHighestCoordinate());
            }
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, (
                final MouseEvent mouseEvent) -> {
            if (getTool() == Tool.FREE_FORM_SELECT && selectionRectangle.isResizeable()) {
                if (!selectionRectangle.isVisible()) {
                    selectionRectangle.setPivot(selectionCanvas.getSelectionPivot());
                    selectionRectangle.setX(selectionCanvas.getLowestCoordinate().x);
                    selectionRectangle.setY(selectionCanvas.getLowestCoordinate().y);
                    selectionRectangle.setWidth(selectionCanvas.getSelectionWidth());
                    selectionRectangle.setHeight(selectionCanvas.getSelectionHeight());
                    selectionRectangle.setVisible(true);
                }
                selectionCanvas.setVisible(false);
                selectionCanvas.clear();
            }
        });
    }

    public void copyEventHandlersInitialization() {
        addEventHandler(MyKeyEvent.KEY_PRESSED, (
                final MyKeyEvent keyEvent) -> {
            if (selectionRectangle.isVisible() && keyEvent.isControlDown() && keyEvent.getKeyCode() == KeyCode.C) {
                bufferedImage.setVisible(false);
                bufferedImage.snapshot(canvas, selectionRectangle.getX(),
                        selectionRectangle.getY(), selectionRectangle.getWidth(), selectionRectangle.getHeight());
            }
        });
    }

    public void pasteEventHandlersInitialization() {
        addEventHandler(MyKeyEvent.KEY_PRESSED, (
                final MyKeyEvent keyEvent) -> {
            if (keyEvent.isControlDown() && keyEvent.getKeyCode() == KeyCode.V && !bufferedImage.isEmpty()) {
                bufferedImage.xProperty().bind(selectionRectangle.xProperty());
                bufferedImage.yProperty().bind(selectionRectangle.yProperty());
                selectionRectangle.reset();
                selectionRectangle.setWidth(bufferedImage.getImage().getWidth());
                selectionRectangle.setHeight(bufferedImage.getImage().getHeight());
                selectionRectangle.setVisible(true);
                bufferedImage.setVisible(true);
            }
        });

        addEventHandler(MouseEvent.MOUSE_PRESSED, (
                final MouseEvent mouseEvent) -> {
            if (bufferedImage.isVisible() && selectionRectangle.isResizeable()) {
                bufferedImage.setVisible(false);
                Drawer.drawImage(canvas.getGraphicsContext2D(),
                        bufferedImage.getImage(), bufferedImage.getX(), bufferedImage.getY());
                bufferedImage.xProperty().unbindBidirectional(selectionRectangle.xProperty());
                bufferedImage.yProperty().unbindBidirectional(selectionRectangle.yProperty());
            }
        });
    }

    public int getScale() {
        return scale;
    }

    void setScale(int scale) {
        this.scale = scale;
    }

    public void zoom(int scale) {
        Magnifier.scale(this, scale);
    }

    public void resetTools() {
        textRectangle.reset();
        selectionRectangle.reset();
    }

    public void drawImage(Image image) {
        Drawer.drawImage(canvas.getGraphicsContext2D(), image, 0, 0);
    }
}
