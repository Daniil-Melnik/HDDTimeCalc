package frames.Components;

import Utils.FrameUtils;

import javax.swing.JPanel;

public class ColorPanelSet extends JPanel {
    private static final int INPUT_NUM = 5;
    private final String [] rectangleColors = {"LIGHT_GRAY", "GRAY", "DARK_GRAY", "GREEN", "ORANGE"};
    private JPanel [] colorPanels;

    public ColorPanelSet(){
        super(null);
        colorPanels = new JPanel[INPUT_NUM];
        int currentInputY = 0;
        setSize(10, 100);
        for (int i = 0; i < INPUT_NUM; i++){
            colorPanels[i] = FrameUtils.createColorRectangle(rectangleColors[i]);
            colorPanels[i].setBounds(0, currentInputY + 1, 10, 18);
            add(colorPanels[i]);
            currentInputY += 20;
        }
    }
}
