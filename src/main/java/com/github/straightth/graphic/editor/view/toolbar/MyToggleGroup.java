package com.github.straightth.graphic.editor.view.toolbar;

import javafx.scene.control.ToggleGroup;

public class MyToggleGroup extends ToggleGroup {
    public MyToggleGroup() {
        super();
        selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> {
            if (newVal == null)
                oldVal.setSelected(true);
        });
    }
}
