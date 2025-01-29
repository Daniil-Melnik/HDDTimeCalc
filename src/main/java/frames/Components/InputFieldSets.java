package frames.Components;

import javax.swing.*;

public class InputFieldSets extends JPanel {

    private JTextField[] textFields0;
    private JTextField [] textFields1;
    private JLabel label01, label00;
    private static final int IMPUT_NUM = 5;

    public InputFieldSets(){
        label00 = new JLabel("Индекс");
        label01 = new JLabel("Кол-во");

        label00.setBounds(78, 2, 50, 20);
        label01.setBounds(135, 2, 50, 20);


    }
}
