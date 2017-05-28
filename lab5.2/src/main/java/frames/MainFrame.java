package frames;


import handlers.CalculateHandler;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * hack into the mainframe
 * */
public class MainFrame extends JFrame{

    private NumberFormat amountFormat;


    public MainFrame() throws HeadlessException {

        JFrame frame = new JFrame("FormattedTextFieldDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new MyJPanel());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
