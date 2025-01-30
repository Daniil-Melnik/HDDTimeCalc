package frames;

import Enums.TimeSets;
import Utils.CalcUtils;
import Utils.FrameUtils;
import frames.Components.InputFieldSets;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputForm extends JFrame {


    private JLabel [] labels;
    private JLabel [] modeLabels;
    private JPanel [] colorPanels;
    private JComboBox<TimeSets> timeModeCombo;
    private JCheckBox modeCheckBox;
    private final String [] rectangleColors = {"LIGHT_GRAY", "GRAY", "DARK_GRAY", "GREEN", "ORANGE"};
    private final String [] modeLabelsStr = {"Режим", "Выбор:", "Свой:"};
    private static final int MODE_NUM = 3;
    private static final int IMPUT_NUM = 5;

    public InputForm() {
        setTitle("Время диска");
        setBackground(Color.WHITE);
        setSize(205, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        InputFieldSets inputFieldsSet = new InputFieldSets();
        inputFieldsSet.setBounds(75, 0, 105, 120);
        mainPanel.add(inputFieldsSet);


        labels = new JLabel[IMPUT_NUM];
        colorPanels = new JPanel[IMPUT_NUM];
        modeLabels = new JLabel[MODE_NUM];

        modeCheckBox = new JCheckBox();

        for (int i = 0; i < MODE_NUM; i++){
            modeLabels[i] = new JLabel(modeLabelsStr[i]);
        }

        for (int i = 0; i < IMPUT_NUM; i++){
            labels[i] = new JLabel(String.format("Метка %d:", i + 1));
            colorPanels[i] = FrameUtils.createColorRectangle(rectangleColors[i]);
        }

        timeModeCombo = new JComboBox<>(TimeSets.values());

        int currentInputY = 20;

        for (int i = 0; i < IMPUT_NUM; i++){
            labels[i].setBounds(10, currentInputY, 50, 20);
            colorPanels[i].setBounds(62, currentInputY + 1, 10, 18);
            currentInputY += 20;
        }

        timeModeCombo.setBounds(55,145,125,25);
        modeLabels[0].setBounds(75, 125, 50, 20);
        modeLabels[1].setBounds(5, 145, 50, 20);
        modeLabels[2].setBounds(5, 170, 50, 20);
        modeCheckBox.setBounds(55, 171, 20, 20);


        mainPanel.add(timeModeCombo);
        mainPanel.add(modeCheckBox);

        for (int i = 0; i < IMPUT_NUM; i++) {
            mainPanel.add(labels[i]);
            mainPanel.add(colorPanels[i]);
        }

        for (int i = 0; i < MODE_NUM; i++){
            mainPanel.add(modeLabels[i]);
        }

        JButton submitButton = new JButton("счёт");
        submitButton.setBounds(55, 195, 80, 25);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JTextField [][] textFields = inputFieldsSet.getTextFields();
                    int [] numberValues = FrameUtils.getIntArrFromFields(textFields[1]);
                    float [] indexValues = FrameUtils.getFloatArrFromFields(textFields[0]);
                    String result = String.format("Итог: %.6f", CalcUtils.getOperatingTime(numberValues, indexValues));
                    JOptionPane.showMessageDialog(InputForm.this, result);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(InputForm.this, "Поля заполнены некорректно");
                }
                // TimeSets ts = (TimeSets) timeModeCombo.getSelectedItem();
                // System.out.println(ts.name());
            }
        });
        mainPanel.add(submitButton);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InputForm();
            }
        });
    }
}