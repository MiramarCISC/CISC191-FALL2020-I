package SuperMonster;

import javax.swing.*;

public class chimera extends SuperMonster {
    public chimera() {
        //monsterPicture = new ImageIcon( "Pictures/Chimera.jpg");
        monsterPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Chimera.jpg"));
        name = "Chimera";
        hp = 5000;
        damage = 30;
        weapon = "Claws and Fangs";
    }

}
