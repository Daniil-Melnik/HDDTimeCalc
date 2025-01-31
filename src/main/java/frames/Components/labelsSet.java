package frames.Components;

import javax.swing.*;

public class LabelsSet extends JPanel {
    private final static int INPUT_NUM = 5;
    private JLabel[] labels;

    public LabelsSet(){
        super(null);
        setSize(50, 100);
        labels = new JLabel[INPUT_NUM];

        int currentInputY = 0;

        for (int i = 0; i < INPUT_NUM; i++){
            labels[i] = new JLabel(String.format("Метка %d:", i + 1));
            labels[i].setBounds(0, currentInputY, 50, 20);
            add(labels[i]);
            currentInputY += 20;
        }
    }
}
