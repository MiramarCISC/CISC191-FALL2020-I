package SuperMonster;

import javax.swing.*;

public class evilMickey extends SuperMonster{
    public evilMickey(){
        //monsterPicture = new ImageIcon( "Pictures/Evilmickey.jpg");
        monsterPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Evilmickey.jpg"));
        name = "Evil Mickey";
        hp = 300;
        damage = 2;
        weapon = "Unknown";
    }
}