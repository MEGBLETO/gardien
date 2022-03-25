package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame implements ActionListener {


    ImageIcon menuIcon;
    ImageIcon menuOverlay;
    JLabel myLabel;
    JButton parametre ;
    JButton commencer;



    public GameMenu(){

        commencer = new JButton("Start");
        commencer.addActionListener(this);
        commencer.setFocusable(false);
        commencer.setBounds(350, 300, 100, 40);


        parametre = new JButton("Settings");
        parametre.setBounds(350, 350, 100, 40);
        parametre.setFocusable(false);
        parametre.addActionListener(this);




        java.net.URL imageURL = GameMenu.class.getResource("bg.jpg");
        menuIcon = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT));
        myLabel=new JLabel("hello");
        myLabel.setIcon(menuIcon);
        myLabel.setSize(800, 800);
        myLabel.add(commencer);
        myLabel.add(parametre);
        setResizable(false);


//       java.net.URL overlayUrl = GameMenu.class.getResource("/menuoverlay.png");
//       menuOverlay = new ImageIcon(new ImageIcon(overlayUrl).getImage().getScaledInstance(30,10,Image.SCALE_DEFAULT));
//       myLabel.setIcon(menuOverlay);
//

        setTitle("Gardien");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        add(myLabel);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == commencer){
            dispose();
            MainGUI gameMainGUI = new MainGUI("guardian","");

            Thread gameThread = new Thread(gameMainGUI);
            gameThread.start();

        }
        if(e.getSource() == parametre){
            dispose();
            GameSettings gameSettings = new GameSettings();


        }
    }
}