package SuperMonster;

import javax.swing.*;

public class Succubus extends SuperMonster {
    public Succubus() {
        //monsterPicture = new ImageIcon( "Pictures/Succubus.jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Succubus.jpg"));

                name = "Succubus";
        hp = 50;
        damage = 5;
        weapon = "Seduction";
    }

}
