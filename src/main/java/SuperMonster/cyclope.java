package SuperMonster;

import javax.swing.*;

public class cyclope extends SuperMonster {
    public cyclope() {
        //monsterPicture = new ImageIcon( "Pictures/Cyclope .jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Cyclope .jpg"));
        name = "Cyclope";
        hp = 2000;
        damage = 50;
        weapon = "Polearm";
    }

}
