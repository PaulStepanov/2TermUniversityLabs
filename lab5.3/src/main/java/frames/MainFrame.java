package frames;

import handlers.MyHandler;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        super("Родительская форма");
        setBounds(100, 50, 380, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel sizeLabel = new JLabel("Размер дочерней формы:");
        sizeLabel.setBounds(10, 10, 350, 30);
        add(sizeLabel);

        JLabel sWidthLabel = new JLabel("Ширина:");
        sWidthLabel.setBounds(10, 50, 350, 30);
        add(sWidthLabel);
        JTextField sWidthTextField = new JTextField();
        sWidthTextField.setBounds(65, 50, 50, 30);
        add(sWidthTextField);

        JLabel sHeightLabel = new JLabel("Высота:");
        sHeightLabel.setBounds(135, 50, 350, 30);
        add(sHeightLabel);
        JTextField sHeightTextField = new JTextField();
        sHeightTextField.setBounds(190, 50, 50, 30);
        add(sHeightTextField);

        JLabel firstOperandLabel = new JLabel("Положение дочерней формы:");
        firstOperandLabel.setBounds(10, 90, 350, 30);
        add(firstOperandLabel);

        JLabel xLabel = new JLabel("x:");
        xLabel.setBounds(10, 130, 350, 30);
        add(xLabel);
        JTextField xTextField = new JTextField();
        xTextField.setBounds(65, 130, 50, 30);
        add(xTextField);

        JLabel yLabel = new JLabel("y:");
        yLabel.setBounds(135, 130, 350, 30);
        add(yLabel);
        JTextField yTextField = new JTextField();
        yTextField.setBounds(190, 130, 50, 30);
        add(yTextField);

        JLabel comMan = new JLabel("Менеджер размещения компонент:");
        comMan.setBounds(10, 250, 350, 30);
        add(comMan);
        String[] arr = {"FlowLayout", "GridLayout"};
        JComboBox comboBox = new JComboBox(arr);
        comboBox.setBounds(10, 290, 210, 30);
        add(comboBox);


        JLabel colLablel = new JLabel("Столбцов");
        colLablel.setBounds(10, 330, 150, 30);
        add(colLablel);
        JTextField columnAmountField = new JFormattedTextField();
        columnAmountField.setBounds(150, 330, 50, 30);
        columnAmountField.setText("2");
        columnAmountField.setEnabled(false);
        //Если выбран GridLayout включаем поле
        comboBox.addItemListener(evt -> {
            if (evt.getItem().equals("GridLayout")) {
                columnAmountField.setEnabled(true);
            } else {
                columnAmountField.setEnabled(false);
            }
        });
        add(columnAmountField);


        JLabel elAm = new JLabel("Колличество создаваемых элементов:");
        elAm.setBounds(10, 170, 230, 30);
        add(elAm);

        JLabel fieldsAmountLabel = new JLabel("Полей:");
        fieldsAmountLabel.setBounds(10, 210, 350, 30);
        add(fieldsAmountLabel);

        JTextField fieldsAmountTextField = new JTextField();
        fieldsAmountTextField.setBounds(65, 210, 50, 30);
        add(fieldsAmountTextField);

        JLabel flagsAmountLabel = new JLabel("Меток:");
        flagsAmountLabel.setBounds(135, 210, 350, 30);
        add(flagsAmountLabel);

        JTextField flagsAmountTextField = new JTextField();
        flagsAmountTextField.setBounds(190, 210, 50, 30);
        add(flagsAmountTextField);

        JButton calculateButton = new JButton("Создать");
        calculateButton.setBounds(60, 380, 250, 30);
        calculateButton.addActionListener(
                new MyHandler(
                        sWidthTextField,
                        sHeightTextField,
                        xTextField,
                        yTextField,
                        comboBox,
                        fieldsAmountTextField,
                        flagsAmountTextField,
                        columnAmountField
                )
        );
        add(calculateButton);

        validate();
        setVisible(true);
    }
}
