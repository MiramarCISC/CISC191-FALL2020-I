package SuperMonster;

import javax.swing.*;

public class goblin_archer extends SuperMonster{
    public goblin_archer(String _name, int health, int dmg, int _critRange, double _critDamage, String _weapon){
        super(_name, health, dmg, _critRange, _critDamage, _weapon);
        //monsterPicture = new ImageIcon( "Pictures/GoblinArcher.jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/GoblinArcher.jpg"));
    }
}
