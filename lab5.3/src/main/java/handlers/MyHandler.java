package handlers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

public class MyHandler implements ActionListener {
    private JTextField width, height, x, y,
            fieldsAmount, flagsAmount, gridColAmount;
    private JComboBox comboBox;

    public MyHandler(JTextField width, JTextField height, JTextField x, JTextField y, JComboBox comboBox, JTextField fieldsAmount, JTextField flagsAmount, JTextField gridAmount) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.comboBox = comboBox;
        this.fieldsAmount = fieldsAmount;
        this.flagsAmount = flagsAmount;
        this.gridColAmount = gridAmount;
    }

    public void actionPerformed(ActionEvent event) {
        JFrame jFrame = new JFrame("Дочернее окно");
        jFrame.setBounds(Integer.parseInt(x.getText()),
                Integer.parseInt(y.getText()),
                Integer.parseInt(width.getText()),
                Integer.parseInt(height.getText()));
        switch (comboBox.getSelectedItem().toString()) {
            case "FlowLayout": {
                jFrame.setLayout(new FlowLayout());
                break;
            }
            case "GridLayout": {
                int colAmount = Integer.valueOf(gridColAmount.getText());
                Double test = (Double.parseDouble(fieldsAmount.getText()) +
                        Double.parseDouble(flagsAmount.getText())) / colAmount;
                int rowAmount = (int) Math.ceil(test);

                jFrame.setLayout(new GridLayout(rowAmount, colAmount));
                break;
            }
            default: {
                jFrame.setLayout(new FlowLayout());
            }
        }
        IntStream.range(0, Integer.parseInt(fieldsAmount.getText())).forEach(i -> {
            JTextField jTextField = new JTextField("Undefined");
            jTextField.setEditable(false);
            jFrame.add(jTextField);
        });

        IntStream.range(0, Integer.parseInt(flagsAmount.getText())).forEach(i -> {
            JLabel jLabel = new JLabel("Undefined");
            jFrame.add(jLabel);
        });

        jFrame.setVisible(true);

    }
}
