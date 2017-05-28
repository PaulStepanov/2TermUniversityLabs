import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class MyForm extends JFrame {
    public MyForm() {
        super("Первое Swing-приложение");
        setBounds(100, 50, 380, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel firstOperandLabel = new JLabel("Первый операнд:");
        firstOperandLabel.setBounds(10, 10, 350, 30);
        add(firstOperandLabel);

        JTextField firstOperandTextField = new JTextField();
        firstOperandTextField.setBounds(10, 50, 350, 30);
        add(firstOperandTextField);

        JLabel secondOperandLabel = new JLabel("Второй операнд:");
        secondOperandLabel.setBounds(10, 90, 350, 30);
        add(secondOperandLabel);

        JTextField secondOperandTextField = new JTextField();
        secondOperandTextField.setBounds(10, 130, 350, 30);
        add(secondOperandTextField);

        JButton calculateButton = new JButton("Вычислить сумму");
        calculateButton.setBounds(60, 170, 250, 30);
        calculateButton.addActionListener(
                new CalculateButtonHandler(
                        firstOperandTextField,
                        secondOperandTextField
                )
        );
        add(calculateButton);
        validate();
        setVisible(true);
    }
}

class CalculateButtonHandler implements ActionListener {
    private JTextField f1, f2;
    public CalculateButtonHandler(JTextField f1,
                                  JTextField f2) {
        this.f1 = f1;
        this.f2 = f2;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Double a = Double.parseDouble(f1.getText());
            Double b = Double.parseDouble(f2.getText());
            Double c = a + b;
            String result = "Сумма чисел равна " + c;
            JOptionPane.showMessageDialog(null, result);
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
}
