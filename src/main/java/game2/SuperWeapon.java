package game2;
/**
 * @author  Oliver Ortiz, Damien Bissell
 * code behind the weapons
 */
public class SuperWeapon {
    private String name;
    private int damage;

    public SuperWeapon()
    {

    }
    public SuperWeapon(String _name, int _damage)
    {
        damage = _damage;
        name = _name;
    }
    public String getName()
    {
        return name;
    }
    public int getDamage()
    {
        return damage;
    }
    public void setName(String _Name)
    {
        name = _Name;
    }
    public void setDamage(int _Damage)
    {
        damage = _Damage;
    }
}
