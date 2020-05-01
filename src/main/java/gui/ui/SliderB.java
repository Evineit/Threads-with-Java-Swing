package gui.ui;


import javax.swing.*;
import java.awt.*;

public class SliderB extends JSlider {
    public SliderB() {
    }

    public SliderB(int orientation) {
        super(orientation);
    }

    public SliderB(int min, int max) {
        super(min, max);
    }

    public SliderB(int min, int max, int value) {
        super(min, max, value);
    }

    public SliderB(int orientation, int min, int max, int value) {
        super(orientation, min, max, value);
        setBackground(Color.black);
    }

    public SliderB(BoundedRangeModel brm) {
        super(brm);
    }
}
