package SuperMonster;

import javax.swing.*;

public class familiar extends SuperMonster {
    public familiar(String _name, int health, int dmg, int _critRange, double _critDamage, String _weapon) {
        super(_name, health, dmg, _critRange, _critDamage, _weapon);
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/FamiliarFight_.jpg"));
    }

}
