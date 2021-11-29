package com.mithrill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgentGUI extends JFrame {

    private Main myAgent;
    private JTextField Textx1;

    AgentGUI(Main a) {
        super(a.getLocalName());

        myAgent = a;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(10, 1));
        p.add(new JLabel("LR Multiple"));
        Textx1 = new JTextField(5);
        p.add(new JLabel("X1"));
        p.add(Textx1);
        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("LR Multiple");
        addButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String data;
                    data = Textx1.getText();
                    myAgent.getMultiple(data);

                    Textx1.setText("");
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(AgentGUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );
        JButton addButton2 = new JButton("LR Simple");
        addButton2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String data;
                    data = Textx1.getText();

                    myAgent.getSimple(data);
                    Textx1.setText("");

                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(AgentGUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );

        p = new JPanel();
        p.add(addButton);
        p.add(addButton2);
        getContentPane().add(p, BorderLayout.SOUTH);


        addWindowListener(new    WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myAgent.doDelete();
            }
        } );

    }

    public void showGui() {
        pack();
        this.setSize(new Dimension(390,315));
        setLocationRelativeTo(null);

        super.setVisible(true);
    }


}
