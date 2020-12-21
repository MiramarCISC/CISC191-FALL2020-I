package SuperMonster;

import javax.swing.*;

public class goblin_knife extends SuperMonster{
    public goblin_knife(){
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Goblin knife.jpg"));

        name = "Goblin with a knife";
        hp = 50;
        damage = 10;
        weapon = "Knife";
    }
}
