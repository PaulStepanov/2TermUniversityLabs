import javax.swing.*;

class MainFrame extends JFrame {
    public MainFrame() {
        super("function");
        setBounds(100, 50, 380, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel aLabel = new JLabel("a:");
        aLabel.setBounds(10, 10, 350, 30);
        add(aLabel);
        JTextField aTextFiled = new JTextField();
        aTextFiled.setBounds(10, 50, 350, 30);
        add(aTextFiled);

        JLabel bLabel = new JLabel("b:");
        bLabel.setBounds(10, 90, 350, 30);
        add(bLabel);
        JTextField bTextField = new JTextField();
        bTextField.setBounds(10, 130, 350, 30);
        add(bTextField);

        JLabel cLabel = new JLabel("c:");
        cLabel.setBounds(10, 170, 350, 30);
        add(cLabel);
        JTextField cTextField = new JTextField();
        cTextField.setBounds(10, 210, 350, 30);
        add(cTextField);


        JLabel dLabel = new JLabel("d:");
        dLabel.setBounds(10, 250, 350, 30);
        add(dLabel);
        JTextField dTextField = new JTextField();
        dTextField.setBounds(10, 290, 350, 30);
        add(dTextField);

        JLabel x1Label = new JLabel("x1:");
        x1Label.setBounds(10, 330, 350, 30);
        add(x1Label);
        JTextField x1TextField = new JTextField();
        x1TextField.setBounds(10, 370, 350, 30);
        add(x1TextField);

        JLabel x2Label = new JLabel("x2:");
        x2Label.setBounds(10, 410, 350, 30);
        add(x2Label);
        JTextField x2TextField = new JTextField();
        x2TextField.setBounds(10, 440, 350, 30);
        add(x2TextField);

        JButton calculateBtn = new JButton("calculate");
        calculateBtn.setBounds(10, 480, 350, 30);
        calculateBtn.addActionListener(e -> {
            int defaultScalation = 20;
            Graph graph = new Graph(aTextFiled, bTextField, cTextField, dTextField, x1TextField, x2TextField, defaultScalation);

            JFrame form = new JFrame();
            graph.repaint();
            form.setSize(500, 500);
            form.add(graph);
            graph.addMouseWheelListener(e1 -> {
                if (e1.getWheelRotation() == -1) { //scroll up
                    graph.setScalation(graph.scalation - 3);
                } else {
                    graph.setScalation(graph.scalation + 3);
                }
                graph.repaint();
            });
            form.setVisible(true);
        });
        add(calculateBtn);
        validate();
        setVisible(true);
    }
}
