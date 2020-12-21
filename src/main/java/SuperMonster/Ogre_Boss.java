package SuperMonster;

import javax.swing.*;

public class Ogre_Boss extends SuperMonster{
    public Ogre_Boss(){
        //monsterPicture = new ImageIcon( "Pictures/Ogre.jpg");
        monsterPicture = new ImageIcon( getClass().getClassLoader().getResource("Pictures/Ogre.jpg"));

                name = "Entient Ogre Leader";
        hp = 500;
        damage = 35;
        weapon = "Huge Club";
    }
}
