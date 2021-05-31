package com.github.straightth.graphic.editor.view.menubar.menus;

import com.github.straightth.graphic.editor.view.menubar.menus.canvas.SetCanvasZoomMenu;
import javafx.scene.control.Menu;

public class CanvasMenu extends Menu {
    public CanvasMenu() {
        super("Canvas");

        SetCanvasZoomMenu setCanvasZoom = new SetCanvasZoomMenu();

        getItems().add(setCanvasZoom);
    }
}
