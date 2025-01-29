package frames;

import Enums.TimeSets;
import Utils.CalcUtils;
import Utils.FrameUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputForm extends JFrame {

    private JTextField [] textFields0;
    private JTextField [] textFields1;
    private JLabel [] labels;
    private JLabel [] modeLabels;

    private JPanel [] colorPanels;

    private JComboBox<TimeSets> timeModeCombo;

    private final String [] rectangleColors = {"LIGHT_GRAY", "GRAY", "DARK_GRAY", "GREEN", "ORANGE"};
    private final String [] modeLabelsStr = {"Режим:", "Выбор:", "Свой:"};
    private static final int MODE_NUM = 3;
    private static final int IMPUT_NUM = 5;

    public InputForm() {
        setTitle("Время диска");
        setBackground(Color.WHITE);
        setSize(205, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textFields0 = new JTextField[IMPUT_NUM];
        textFields1 = new JTextField[IMPUT_NUM];
        labels = new JLabel[IMPUT_NUM];
        colorPanels = new JPanel[IMPUT_NUM];
        modeLabels = new JLabel[MODE_NUM];

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel label00 = new JLabel("Индекс");
        JLabel label01 = new JLabel("Кол-во");

        label00.setBounds(78, 2, 50, 20);
        label01.setBounds(135, 2, 50, 20);

        mainPanel.add(label00);
        mainPanel.add(label01);

        for (int i = 0; i < MODE_NUM; i++){
            modeLabels[i].setText(modeLabelsStr[i]);
        }

        for (int i = 0; i < IMPUT_NUM; i++){
            textFields0[i] = new JTextField(15);
            textFields1[i] = new JTextField(15);
            labels[i] = new JLabel(String.format("Метка %d:", i + 1));
            colorPanels[i] = FrameUtils.createColorRectangle(rectangleColors[i]);
        }

        timeModeCombo = new JComboBox<>(TimeSets.values());

        int currentInputY = 20;

        for (int i = 0; i < IMPUT_NUM; i++){
            textFields0[i].setBounds(75, currentInputY, 50, 20);
            textFields1[i].setBounds(130, currentInputY, 50, 20);
            labels[i].setBounds(10, currentInputY, 50, 20);
            colorPanels[i].setBounds(62, currentInputY + 1, 10, 18);
            currentInputY += 20;
        }

        timeModeCombo.setBounds(55,125,125,25);
        mainPanel.add(timeModeCombo);

        for (int i = 0; i < IMPUT_NUM; i++){
            mainPanel.add(textFields0[i]);
            mainPanel.add(textFields1[i]);
            mainPanel.add(labels[i]);
            mainPanel.add(colorPanels[i]);
        }

        JButton submitButton = new JButton("счёт");
        submitButton.setBounds(55, 155, 80, 25);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int [] numberValues = FrameUtils.getIntArrFromFields(textFields1);
                    float [] indexValues = FrameUtils.getFloatArrFromFields(textFields0);
                    String result = String.format("Итог: %.6f", CalcUtils.getOperatingTime(numberValues, indexValues));
                    JOptionPane.showMessageDialog(InputForm.this, result);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(InputForm.this, "Поля заполнены некорректно");
                }
                /*TimeSets ts = (TimeSets) timeModeCombo.getSelectedItem();
                System.out.println(ts.name());*/
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