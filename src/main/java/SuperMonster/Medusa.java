package SuperMonster;

import javax.swing.*;

public class Medusa extends SuperMonster {
    public Medusa() {
        //monsterPicture = new ImageIcon( "Pictures/Medusa.jpg");
        monsterPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Medusa.jpg"));

                name = "Medusa";
        hp = 1000;
        damage = 10;
        weapon = "Tail";
    }

}
