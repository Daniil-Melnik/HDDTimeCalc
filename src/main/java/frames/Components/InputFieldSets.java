package frames.Components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class InputFieldSets extends JPanel {

    private JTextField[] textFields0;
    private JTextField [] textFields1;
    private JLabel label01, label00;
    private TimeSets timeType;
    private static final int INPUT_NUM = 5;

    public InputFieldSets(){

        super(null);
        timeType = null;
        setSize(105, 120);
        //setLayout(null);

        label00 = new JLabel("Индекс");
        label01 = new JLabel("Кол-во");

        label00.setBounds(0, 0, 50, 20);
        label01.setBounds(60, 0, 50, 20);

        add(label00);
        add(label01);

        textFields0 = new JTextField[INPUT_NUM];
        textFields1 = new JTextField[INPUT_NUM];

        for (int i = 0; i < INPUT_NUM; i++){
            textFields0[i] = new JTextField(15);
            textFields1[i] = new JTextField(15);
        }
        int currentInputY = 20;
        for (int i = 0; i < INPUT_NUM; i++){
            textFields0[i].setBounds(0, currentInputY, 50, 20);
            textFields1[i].setBounds(55, currentInputY, 50, 20);
            currentInputY += 20;
        }

        for (int i = 0; i < INPUT_NUM; i++) {
            add(textFields0[i]);
            add(textFields1[i]);
        }
    }

    public JTextField [][] getTextFields(){
        return new JTextField[][]{textFields0, textFields1};
    }
    public void setTimeType(TimeSets newTimeType){ timeType = newTimeType;}
}
