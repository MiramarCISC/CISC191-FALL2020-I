package SuperMonster;

import javax.swing.*;

public class Minotaur_Boss extends SuperMonster {
    public Minotaur_Boss() {
        //monsterPicture = new ImageIcon( "Pictures/Bossmino.jpg");
        monsterPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Bossmino.jpg"));

                name = "Old Minotaur";
        hp = 10000;
        damage = 50;
        weapon = "Giant Rusty Axe";
    }

}
