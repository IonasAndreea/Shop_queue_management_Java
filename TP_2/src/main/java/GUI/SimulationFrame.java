package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {
    private JFrame frame;
    private JPanel panelMain;
    private JPanel panel;
    private JPanel panelout;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel labelTitle;
    private JLabel labelNoOfClients;
    private JLabel labelNoOfQueues;
    private JLabel simulationInterval;
    private JLabel labelMinArrivalTime;
    private JLabel labelMaxArrivalTime;
    private JLabel labelMinServiceTime;
    private JLabel labelMaxServiceTime;
    private JButton startB;
    private JTextField textNoOfQueues;
    private JTextField textNoOfClients;
    private JTextField textSimulationInterval;
    private JTextField textMinArrivalTime;
    private JTextField textMaxArrivalTime;
    private JTextField textMinServiceTime;
    private JTextField textMaxServiceTime;
    private JTextArea out;

    public SimulationFrame() {
        this.frame = new JFrame();
        this.panelMain = new JPanel();
        this.panel = new JPanel();
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.panelout = new JPanel();
        this.labelTitle = new JLabel();
        this.labelMaxArrivalTime = new JLabel();
        this.labelMaxServiceTime = new JLabel();
        this.labelMinArrivalTime = new JLabel();
        this.labelMinServiceTime = new JLabel();
        this.labelNoOfQueues = new JLabel();
        this.labelNoOfClients = new JLabel();
        this.simulationInterval = new JLabel();
        this.startB = new JButton("START");
        this.textMaxArrivalTime = new JTextField();
        this.textMaxServiceTime = new JTextField();
        this.textSimulationInterval = new JTextField();
        this.textNoOfClients = new JTextField();
        this.textNoOfQueues = new JTextField();
        this.textMinArrivalTime = new JTextField();
        this.textMinServiceTime = new JTextField();
        this.out = new JTextArea();

        labelTitle.setText("Queues Management");
        labelTitle.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 20));

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 2));
        panel.setBackground(Color.orange);
        panel.add(labelTitle);

        labelNoOfClients.setText("Number of clients = ");
        labelNoOfClients.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        labelNoOfClients.setForeground(Color.black);

        textNoOfClients.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textNoOfClients.setPreferredSize(new Dimension(220, 20));

        labelNoOfQueues.setText("Number of queues = ");
        labelNoOfQueues.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        labelNoOfQueues.setForeground(Color.black);

        textNoOfQueues.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textNoOfQueues.setPreferredSize(new Dimension(220, 20));

        simulationInterval.setText("Simulation Interval = ");
        simulationInterval.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        simulationInterval.setForeground(Color.black);

        textSimulationInterval.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textSimulationInterval.setPreferredSize(new Dimension(220, 20));

        labelMinServiceTime.setText("Minim service time = ");
        labelMinServiceTime.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        labelMinServiceTime.setForeground(Color.black);

        textMinServiceTime.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textMinServiceTime.setPreferredSize(new Dimension(220, 20));

        labelMaxServiceTime.setText("Maxim service time = ");
        labelMaxServiceTime.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        labelMaxServiceTime.setForeground(Color.black);

        textMaxServiceTime.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textMaxServiceTime.setPreferredSize(new Dimension(220, 20));

        labelMinArrivalTime.setText("Minim arrival time = ");
        labelMinArrivalTime.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        labelMinArrivalTime.setForeground(Color.black);

        textMinArrivalTime.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textMinArrivalTime.setPreferredSize(new Dimension(220, 20));

        labelMaxArrivalTime.setText("Maxim arrival time = ");
        labelMaxArrivalTime.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        labelMaxArrivalTime.setForeground(Color.black);

        textMaxArrivalTime.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textMaxArrivalTime.setPreferredSize(new Dimension(220, 20));

        out.setFont(new Font("Tahome", Font.ITALIC, 10));

        panel1.setLayout(new GridLayout(10,2));
        panel1.setBackground(Color.orange);
        panel1.add(labelNoOfClients);
        panel1.add(textNoOfClients);
        panel1.add(simulationInterval);
        panel1.add(textSimulationInterval);
        panel1.add(labelNoOfQueues);
        panel1.add(textNoOfQueues);
        panel1.add(labelMinServiceTime);
        panel1.add(textMinServiceTime);
        panel1.add(labelMaxServiceTime);
        panel1.add(textMaxServiceTime);
        panel1.add(labelMinArrivalTime);
        panel1.add(textMinArrivalTime);
        panel1.add(labelMaxArrivalTime);
        panel1.add(textMaxArrivalTime);
        panel1.add(out);

        panel2.setLayout(new GridLayout(1, 3, 2, 2));
        panel2.setBackground(Color.orange);
        panel2.add(startB);

        panelout.setBackground(Color.orange);
        panelout.setBounds(20,10,70,70);
        panelout.add(out);

        frame.setTitle("Queues Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBackground(Color.orange);
        frame.setResizable(false);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        panelMain.add(panel);
        panelMain.add(panel1);
        panelMain.add(panel2);
        panelMain.add(panelout);

        frame.add(panelMain);
    }

    public void startListener(ActionListener actionL) {
        this.startB.addActionListener(actionL);
    }
    public String getMaxArrivalTime() {
        return this.textMaxArrivalTime.getText();
    }

    public String getMaxServiceTime()
    {
        return this.textMaxServiceTime.getText();
    }

    public String getMinServiceTime()
    {
        return this.textMinServiceTime.getText();
    }

    public String getMinArrivalTime()
    {
        return this.textMinArrivalTime.getText();
    }

    public String getNoOfClients()
    {
        return this.textNoOfClients.getText();
    }

    public String getNoOfQueues()
    {
        return this.textNoOfQueues.getText();
    }

    public String getSimulationInterval()
    {
        return this.textSimulationInterval.getText();
    }

    public void showNumberError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);

    }

    public void setTextOut(String s)
    {
        out.setText(s);
    }

}
