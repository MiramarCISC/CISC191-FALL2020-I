package Game;
/**
 * @author : Valentyn Protsyuk
 * @description interface for the game
 **/
import Game.Game.choices;

import javax.swing.*;
import java.awt.*;

public class Interfacce {
    JFrame window;
    JPanel Title, startButton, pStory, choiceP,pplayer, pBattle;
    JPanel pmonster, plmonster, plstory, playerPic, monsterPic, plbattle, positionPic;
    JLabel lTitle, hpl, hpnuml, weaponl, weapontypel, goldl, goldnuml;
    JLabel attackl, attacknuml, heall, healnuml, psl, psl2, lorel, battlel;
    JLabel playerPictureLabel, monsterPictureLabel, positionPictureLabel;
    JLabel hpml, hpmnuml, attackml, attackmnuml, weaponml, weaponmtypel, monsterNamel;
    JButton startBut, exitBut, continueBut, infoBut, choice1, choice2, choice3, choice4;
    JTextArea storyArea, battleArea;
    Font fTitle = new Font("Times New Roman", Font.PLAIN, 100 );
    Font butFont = new Font("Times New Roman", Font.BOLD, 20 );

    public void createInterface(choices pchoice){
        //Window
        window = new JFrame("MANSION");
        window.setSize(1920,1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        //Title screen
        Title = new JPanel();
        Title.setBounds(600, 300, 600, 150);
        Title.setBackground(Color.black);

        lTitle = new JLabel("MANSION");
        lTitle.setForeground(Color.white);
        lTitle.setFont(fTitle);
        Title.add(lTitle);
        //Title menu buttons
        startButton = new JPanel();
        startButton.setBounds(790, 450, 200, 100);
        startButton.setBackground(Color.black);
        startButton.setLayout(new GridLayout(4,1));

        startBut = new JButton("NEW GAME");
        startBut.setBackground(Color.black);
        startBut.setForeground(Color.white);
        startBut.setFont(butFont);
        startBut.setFocusPainted(false);
        startBut.addActionListener(pchoice);
        startBut.setActionCommand("start");
        startButton.add(startBut);

        //continue Button
        continueBut = new JButton("CONTINUE");
        continueBut.setBackground(Color.black);
        continueBut.setForeground(Color.white);
        continueBut.setFont(butFont);
        continueBut.setFocusPainted(false);
        continueBut.addActionListener(pchoice);
        continueBut.setActionCommand("continue");
        startButton.add(continueBut);

        //Info button
        infoBut = new JButton("INFO");
        infoBut.setBackground(Color.black);
        infoBut.setForeground(Color.white);
        infoBut.setFont(butFont);
        infoBut.setFocusPainted(false);
        infoBut.addActionListener(pchoice);
        infoBut.setActionCommand("info");
        startButton.add(infoBut);

        //exit button
        exitBut = new JButton("EXIT");
        exitBut.setBackground(Color.black);
        exitBut.setForeground(Color.white);
        exitBut.setFont(butFont);
        exitBut.setFocusPainted(false);
        exitBut.addActionListener(pchoice);
        exitBut.setActionCommand("exit");
        startButton.add(exitBut);

        window.add(Title);
        window.add(startButton);


        //pics
        playerPic = new JPanel();
        playerPic.setBounds(100,15,345,345);
        playerPic.setBackground(Color.black);
        window.add(playerPic);

        playerPictureLabel = new JLabel();
        playerPic.add(playerPictureLabel);

        monsterPic = new JPanel();
        monsterPic.setBounds(1000,15,345,345);
        monsterPic.setBackground(Color.black);
        window.add(monsterPic);

        monsterPictureLabel = new JLabel();
        monsterPic.add(monsterPictureLabel);

        positionPic = new JPanel();
        positionPic.setBounds(800,15,1000,970);
        positionPic.setBackground(Color.black);
        window.add(positionPic);

        positionPictureLabel = new JLabel();
        positionPic.add(positionPictureLabel);
        //monster status
        pmonster = new JPanel();
        pmonster.setBounds(1365, 55,300,190);
        pmonster.setBackground(Color.black);
        pmonster.setLayout(new GridLayout(0,2));
        window.add(pmonster);
        //monster status label
        plmonster = new JPanel();
        plmonster.setBounds(1365, 15,300,30);
        plmonster.setBackground(Color.black);
        window.add(plmonster);

        monsterNamel = new JLabel("oop");
        monsterNamel.setFont(butFont);
        monsterNamel.setForeground(Color.green);
        plmonster.add(monsterNamel);

        //monster hp
        hpml = new JLabel("HP: ");
        hpml.setFont(butFont);
        hpml.setForeground(Color.white);
        pmonster.add(hpml);

        hpmnuml = new JLabel();
        hpmnuml.setFont(butFont);
        hpmnuml.setForeground(Color.white);
        pmonster.add(hpmnuml);
        //monster weapon
        weaponml = new JLabel("Weapon:");
        weaponml.setFont(butFont);
        weaponml.setForeground(Color.white);
        pmonster.add(weaponml);

        weaponmtypel = new JLabel();
        weaponmtypel.setFont(butFont);
        weaponmtypel.setForeground(Color.white);
        pmonster.add(weaponmtypel);
        //monster attack
        attackml = new JLabel("Attack:");
        attackml.setFont(butFont);
        attackml.setForeground(Color.white);
        pmonster.add(attackml);

        attackmnuml = new JLabel();
        attackmnuml.setFont(butFont);
        attackmnuml.setForeground(Color.white);
        pmonster.add(attackmnuml);
//
        //player status
        pplayer = new JPanel();
        pplayer.setBounds(460, 15,300,345);
        pplayer.setBackground(Color.black);
        pplayer.setLayout(new GridLayout(0,2));
        window.add(pplayer);
        //player status label
        psl = new JLabel("                YOUR");
        psl.setFont(butFont);
        psl.setForeground(Color.green);
        pplayer.add(psl);

        psl2 = new JLabel("STATUS");
        psl2.setFont(butFont);
        psl2.setForeground(Color.green);
        pplayer.add(psl2);

        //player hp
        hpl = new JLabel("HP: ");
        hpl.setFont(butFont);
        hpl.setForeground(Color.white);
        pplayer.add(hpl);

        hpnuml = new JLabel();
        hpnuml.setFont(butFont);
        hpnuml.setForeground(Color.white);
        pplayer.add(hpnuml);
        //player weapon
        weaponl = new JLabel("Weapon:");
        weaponl.setFont(butFont);
        weaponl.setForeground(Color.white);
        pplayer.add(weaponl);

        weapontypel = new JLabel();
        weapontypel.setFont(butFont);
        weapontypel.setForeground(Color.white);
        pplayer.add(weapontypel);
        //player attack
        attackl = new JLabel("Attack:");
        attackl.setFont(butFont);
        attackl.setForeground(Color.white);
        pplayer.add(attackl);

        attacknuml = new JLabel();
        attacknuml.setFont(butFont);
        attacknuml.setForeground(Color.white);
        pplayer.add(attacknuml);
        //player's gold
        goldl = new JLabel("Gold:");
        goldl.setFont(butFont);
        goldl.setForeground(Color.white);
        pplayer.add(goldl);

        goldnuml = new JLabel();
        goldnuml.setFont(butFont);
        goldnuml.setForeground(Color.white);
        pplayer.add(goldnuml);
        //player's healing potions
        heall = new JLabel("Heal:");
        heall.setFont(butFont);
        heall.setForeground(Color.white);
        pplayer.add(heall);

        healnuml = new JLabel();
        healnuml.setFont(butFont);
        healnuml.setForeground(Color.white);
        pplayer.add(healnuml);

        //lore label
        plstory = new JPanel();
        plstory.setBounds(100, 370,660,30);
        plstory.setBackground(Color.black);
        window.add(plstory);

        lorel = new JLabel("Story & Dialogs");
        lorel.setFont(butFont);
        lorel.setForeground(Color.green);
        plstory.add(lorel);
        // Story display
        pStory = new JPanel();
        pStory.setBounds(100,400,660,430);
        pStory.setBackground(Color.black);
        window.add(pStory);
        storyArea = new JTextArea("");
        storyArea.setBounds(100,400,660,430);
        storyArea.setBackground(Color.black);
        storyArea.setForeground(Color.white);
        storyArea.setFont(butFont);
        storyArea.setLineWrap(true);
        pStory.add(storyArea);

        //battle label
        plbattle= new JPanel();
        plbattle.setBounds(1000, 370,800,30);
        plbattle.setBackground(Color.black);
        window.add(plbattle);

        battlel = new JLabel("Battle");
        battlel.setFont(butFont);
        battlel.setForeground(Color.green);
        plbattle.add(battlel);
        //battle display
        pBattle = new JPanel();
        pBattle.setBounds(1000,400,800,585);
        pBattle.setBackground(Color.black);
        window.add(pBattle);
        battleArea = new JTextArea("");
        battleArea.setBounds(100,400,800,590);
        battleArea.setBackground(Color.black);
        battleArea.setForeground(Color.white);
        battleArea.setFont(butFont);
        battleArea.setLineWrap(true);
        pBattle.add(battleArea);


        //choices
        choiceP = new JPanel();
        choiceP.setBounds(100, 830,660, 150);
        choiceP.setBackground(Color.black);
        choiceP.setLayout(new GridLayout(4,1));
        window.add(choiceP);
        //window.setVisible(true);
        //choice1 button
        choice1 = new JButton("1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(butFont);
        choice1.addActionListener(pchoice);
        choice1.setActionCommand("c1");
        choice1.setFocusPainted(false) ;
        choiceP.add(choice1);
        //choice2 button
        choice2 = new JButton("2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(butFont);
        choice2.addActionListener(pchoice);
        choice2.setActionCommand("c2");
        choice2.setFocusPainted(false) ;
        choiceP.add(choice2);
        //choice3 button
        choice3 = new JButton("3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(butFont);
        choice3.addActionListener(pchoice);
        choice3.setActionCommand("c3");
        choice3.setFocusPainted(false) ;
        choiceP.add(choice3);
        //choice4 button
        choice4 = new JButton("4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(butFont);
        choice4.addActionListener(pchoice);
        choice4.setActionCommand("c4");
        choice4.setFocusPainted(false) ;
        choiceP.add(choice4);


        window.setVisible(true);
    }

}
