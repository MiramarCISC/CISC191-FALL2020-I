package SuperMonster;
/**
 * @author  Oliver Ortiz, Damien Bissell
 * @description parent class for all monsters in the game.
 */
import Game.*;

import javax.swing.*;

public class SuperMonster {
    public static ImageIcon monsterPicture;
    public String name;
    public int hp;
    public int damage;
    int critRange;
    double critDamage;
    public String weapon;

    public SuperMonster()
    {

    }
    public SuperMonster(String _name, int health, int dmg, int _critRange, double _critDamage, String _weapon)
    {
        name = _name;
        hp= health;
        damage = dmg;
        critRange = _critRange;
        critDamage = _critDamage;
        weapon = _weapon;
    }
    public void takeDamage(int dmg)
    {
        hp -= dmg;
    }
    public int getHealth()
    {
        return hp;
    }
    public int attack(int roll)
    {
        if(roll > critRange)
        {
            return (int) (damage * critDamage);
        }
        else
        {
            return damage;
        }
    }

}
