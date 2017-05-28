package handlers;

import frames.MainFrame;
import frames.MyJPanel;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class CalculateHandler implements ActionListener {
    private JTextField dateField;
    private JTextField dayAmountField;
    private JTextField resultField;

    public CalculateHandler(JTextField dateField, JTextField dayAmountField, JTextField resultField) {
        this.dateField = dateField;
        this.dayAmountField = dayAmountField;
        this.resultField = resultField;
    }

    public void actionPerformed(ActionEvent e) {
        LocalDate inputedDate = LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern(MyJPanel.DATE_FORMAT));

        LocalDate newDate = inputedDate.minus(Integer.valueOf(dayAmountField.getText()), ChronoUnit.MONTHS);

        if (newDate.isBefore(LocalDate.now())) {
            resultField.setText("Полученая дата до текуще   ");
        }
        if (newDate.isEqual(LocalDate.now())) {
            resultField.setText("Полученая дата равна текущей ");
        }
        if (newDate.isAfter(LocalDate.now())) {
            resultField.setText("Полученая дата после текущей ");
        }

    }
}
