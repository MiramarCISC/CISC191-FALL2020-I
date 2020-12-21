package SuperMonster;

import javax.swing.*;

public class goblin_mage extends SuperMonster{
    public goblin_mage(){
        //monsterPicture = new ImageIcon( "Pictures/Goblinmage.jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Goblinmage.jpg"));

        name = "Goblin mage";
        hp = 35;
        damage = 20;
        weapon = "Catalyst";
    }
}
