package Utils;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
public class FrameUtils {
    private static final int SIZE = 5;
    public static JPanel createColorRectangle(String color) {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setSize(10, 20);
        switch (color){
            case "GREEN":
                panel.setBackground(Color.GREEN);
                break;
            case "GRAY":
                panel.setBackground(Color.GRAY);
                break;
            case "DARK_GRAY":
                panel.setBackground(Color.DARK_GRAY);
                break;
            case "ORANGE":
                panel.setBackground(new Color(255, 140, 0));
                break;
            case "LIGHT_GRAY":
                panel.setBackground(Color.LIGHT_GRAY);
                break;
        }

        panel.setPreferredSize(new Dimension(100, 25));
        return panel;
    }

    public static float [] getFloatArrFromFields(JTextField [] textFields) throws NumberFormatException {
        float[] result = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            result[i] = Float.parseFloat(textFields[i].getText());
        }
        return result;
    }

    public static int [] getIntArrFromFields(JTextField [] textFields) throws NumberFormatException{
        int [] result = new int[SIZE];
        for (int i = 0; i < SIZE; i++){
            result[i] = Integer.parseInt(textFields[i].getText());
        }
        return result;
    }
}
