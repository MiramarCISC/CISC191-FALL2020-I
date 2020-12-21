package SuperMonster;

import javax.swing.*;

public class small_minotaur extends SuperMonster {
    public small_minotaur() {
        //monsterPicture = new ImageIcon( "Pictures/Smallmino.jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Smallmino.jpg"));

        name = "Small Minotaur";
        hp = 3000;
        damage = 10;
        weapon = "Morgenshtern";
    }

}
