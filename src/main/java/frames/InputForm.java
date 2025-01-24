package frames;

import Utils.CalcUtils;
import Utils.FrameUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputForm extends JFrame {

    private JTextField [] textFields0;
    private JTextField [] textFields1;
    private JLabel [] labels;

    private JPanel [] colorPanels;

    private final String [] rectangleColors = {"LIGHT_GRAY", "GRAY", "DARK_GRAY", "GREEN", "ORANGE"};

    public InputForm() {
        setTitle("Время диска");
        setBackground(Color.WHITE);
        setSize(205, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textFields0 = new JTextField[5];
        textFields1 = new JTextField[5];
        labels = new JLabel[5];
        colorPanels = new JPanel[5];

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel label00 = new JLabel("Индекс");
        JLabel label01 = new JLabel("Кол-во");

        label00.setBounds(78, 2, 50, 20);
        label01.setBounds(135, 2, 50, 20);

        mainPanel.add(label00);
        mainPanel.add(label01);

        for (int i = 0; i < 5; i++){
            textFields0[i] = new JTextField(15);
            textFields1[i] = new JTextField(15);
            labels[i] = new JLabel(String.format("Метка %d:", i + 1));
            colorPanels[i] = FrameUtils.createColorRectangle(rectangleColors[i]);
        }

        int currentInputY = 20;

        for (int i = 0; i < 5; i++){
            textFields0[i].setBounds(75, currentInputY, 50, 20);
            textFields1[i].setBounds(130, currentInputY, 50, 20);
            labels[i].setBounds(10, currentInputY, 50, 20);
            colorPanels[i].setBounds(62, currentInputY + 1, 10, 18);
            currentInputY += 20;
        }

        for (int i = 0; i < 5; i++){
            mainPanel.add(textFields0[i]);
            mainPanel.add(textFields1[i]);
            mainPanel.add(labels[i]);
            mainPanel.add(colorPanels[i]);
        }

        // Создаем и добавляем кнопку
        JButton submitButton = new JButton("счёт");
        submitButton.setBounds(55, 125, 80, 25);
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