package frames;

import handlers.CalculateHandler;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


public class MyJPanel extends JPanel {
    public static String DATE_FORMAT = "dd.MM.yyyy";

    public MyJPanel() {
        super(new BorderLayout());
        JButton calculateButton = new JButton("Вычислить");
        calculateButton.setEnabled(false);

        JLabel dateOperandLabel = new JLabel("Дата:");
        JLabel amountOperandLabel = new JLabel("Колличество месяцев:");
        JLabel resultOperandLabel = new JLabel("Результат");

        JFormattedTextField dateTestField = new JFormattedTextField(new SimpleDateFormat(DATE_FORMAT));
        addNotNullListener(dateTestField, calculateButton);

        JFormattedTextField monthAmountTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        addNotNullListener(monthAmountTextField, calculateButton);

        JTextField resultField = new JTextField();
        resultField.setColumns(15);
        resultField.setEnabled(false);

        calculateButton.addActionListener(
                new CalculateHandler(dateTestField, monthAmountTextField, resultField)
        );

        JPanel labelPane = new JPanel(new GridLayout(0, 1));

        labelPane.add(dateOperandLabel);
        labelPane.add(amountOperandLabel);
        labelPane.add(resultOperandLabel);

        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(dateTestField);
        fieldPane.add(monthAmountTextField);
        fieldPane.add(resultField);

        JPanel buttonPane = new JPanel(new GridLayout(0, 1));
        buttonPane.add(calculateButton);

        //Put the panels in this panel, labels on left,
        //text fields on right.
        setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
        add(buttonPane, BorderLayout.AFTER_LAST_LINE);
    }

    private void addNotNullListener(final JTextField jTextField, final JButton button) {
        jTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (jTextField.getText().equals("")) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }

            }
        });
    }
}
