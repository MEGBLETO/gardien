package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettings extends JFrame  {


    JRadioButton b1;
    JRadioButton b2;
    JPanel panel;



    public GameSettings(){




        b1 = new JRadioButton("Directional");

        b2 = new JRadioButton("Aplphabetical");



        //Box box1 = Box.createHorizontalBox();
        panel = new JPanel(new GridLayout(1,2));
        panel.add(b1);
        panel.add(b2);
        panel.setBackground(Color.blue);



        b1.setHorizontalAlignment(SwingConstants.CENTER);


        setTitle("Gardien");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
        setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == b1){
                    dispose();
                    MainGUI gameMainGUI = new MainGUI("guardian", "alpha");
                    Thread gameThread = new Thread(gameMainGUI);
                    gameThread.start();
                }
            }
        });


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == b2){
                    dispose();
                    MainGUI gameMainGUI = new MainGUI("guardian", "direction");
                    Thread gameThread = new Thread(gameMainGUI);
                    gameThread.start();
                }
            }
        });


    }


}
