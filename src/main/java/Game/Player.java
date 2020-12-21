package Game;
/**
 * @author  Oliver Ortiz
 * @description This is the code behind the payer class
 */
import game2.SuperWeapon;

public class Player {
    private int hp;
    private SuperWeapon currentWeapon;
    private int gold;
    private int healnum;
    private int critRange;
    private int critDamage;

    public Player(int health, int money, int _critRange, int _critDamage)
    {
        hp = health;
        gold = money;
        critRange=_critRange;
        critDamage = _critDamage;
    }

    public int getHp()
    {
        return hp;
    }
    public void setHp(int health)
    {
        hp = health;
    }
    public void heal(int health)
    {
        hp += health;
    }
    public void takeDamage(int damage)
    {
        hp -= damage;
    }
    public int getGold()
    {
        return gold;
    }
    public void addGold(int amount)
    {
        gold+= amount;
    }
    public void removeGold(int amount)
    {
        gold-= amount;
    }
    public void setGold(int amount)
    {
        gold = amount;
    }
    public int attack(int roll)
    {
        if(roll > critRange)
        {
            return (currentWeapon.getDamage() * critDamage);
        }
        else
        {
            return currentWeapon.getDamage();
        }
    }
     public String getWeaponName()
     {
         return currentWeapon.getName();
     }
     public int getWeaponDamage()
     {
         return currentWeapon.getDamage();
     }
     public void setWeapon(SuperWeapon currWeapon)
     {
         currentWeapon = currWeapon;
     }
    public void setWeapon(String _name, int _damage)
    {
        currentWeapon = new SuperWeapon(_name, _damage);
    }
    public void editWeaponDamage(int _damage)
    {
        currentWeapon.setDamage(_damage);
    }

    public void editWeaponName(String _name)
    {
        currentWeapon.setName(_name);
    }

    public void setCritDamage(int critDamage) {
        this.critDamage = critDamage;
    }

    public void setCritRange(int critRange) {
        this.critRange = critRange;
    }

    public int getHealnum() {
        return healnum;
    }

    public void setHealnum(int healnum) {
        this.healnum = healnum;
    }
}
