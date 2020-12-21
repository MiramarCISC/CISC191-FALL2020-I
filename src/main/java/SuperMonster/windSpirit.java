package SuperMonster;

import javax.swing.*;

public class windSpirit extends SuperMonster{
    public windSpirit(){
        //monsterPicture = new ImageIcon( "Pictures/Windelemental.jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Windelemental.jpg"));

        name = "Wind elemental";
        hp = 300;
        damage = 10;
        weapon = "Wind Magic";
    }
}
