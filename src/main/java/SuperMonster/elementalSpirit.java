package SuperMonster;

import javax.swing.*;

public class elementalSpirit extends SuperMonster{
public elementalSpirit(){
    //monsterPicture = new ImageIcon( "Pictures/Spirit.jpg");
    monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Spirit.jpg"));

            name = "Spirit leader";
    hp = 500;
    damage = 15;
    weapon = "Elemental Magic";
}
}
