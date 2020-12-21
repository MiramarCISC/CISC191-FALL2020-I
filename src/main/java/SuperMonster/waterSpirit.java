package SuperMonster;

import javax.swing.*;

public class waterSpirit extends SuperMonster{
    public waterSpirit(){
        //monsterPicture = new ImageIcon( "Pictures/Waterelemental.jpg");
        monsterPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Waterelemental.jpg"));

        name = "Water elemental";
        hp = 200;
        damage = 5;
        weapon = "Water Magic";
    }
}
