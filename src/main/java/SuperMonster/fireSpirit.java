package SuperMonster;

import javax.swing.*;

public class fireSpirit extends SuperMonster{
    public fireSpirit(){
        //monsterPicture = new ImageIcon( "Pictures/Fireelemental.jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Fireelemental.jpg"));

                name = "Fire elemental";
        hp = 350;
        damage = 12;
        weapon = "Fire Magic";
    }
}
