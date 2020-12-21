package Game;
/**
 * @author  Oliver Ortiz, Damien Bissell, Valentyn Protsyuk
 * @description basically Main() part 2. it is used to call all other classes and construct the game.
 */

import SuperMonster.*;
import game2.Weapon_Knife;
import game2.Weapon_TestersSword;
import game2.none;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//import SoundEffects.java
import java.util.Random;

public class Lore {
    Game game;
    Interfacce ui;
    Visibility vm;
    Rooms rooms;
    mainCoridor mc;
    Player player = new Player(100, 0, 10, 2);
    ImageIcon GM;
    public SuperMonster monster;
    public int forwardCounter=0;
    public int roomCounter =0;
    public int floorCounter=1;
    public int familiarCounter;
    Random rand = new Random(); // random number gen for crit rolls.
    SoundEffects music = new SoundEffects("SoundEffects/ThemeMusic.mp3",true);
    SoundEffects door = new SoundEffects("SoundEffects/doorOpen.mp3",false);
    SoundEffects attack = new SoundEffects("SoundEffects/hit.mp3",false);
    SoundEffects critical = new SoundEffects("SoundEffects/critHit.mp3",false);
    SoundEffects money = new SoundEffects("SoundEffects/money.mp3",false);
    SoundEffects footsteps = new SoundEffects("SoundEffects/footsteps.mp3",false);
    public Lore(Game g, Interfacce u, Visibility v, Rooms r, mainCoridor m) {
        game = g;
        ui = u;
        vm = v;
        rooms = r;
        mc= m;
    }

    int healthLimit = 100;
    public void defaultSetup() {
        //ImageIcon picture = new ImageIcon("Pictures/Player.jpg");
        //music.play(); // start music MUSIC MESSES UP TITLE SCREEN
        ImageIcon picture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Player.jpg"));
        ui.playerPictureLabel.setIcon(picture);
        ui.pplayer.setVisible(false);
        //default for player
        player.setHp(100);
        player.setHealnum(0);
        player.setWeapon(new none());

        ui.hpnuml.setText("" + player.getHp());
        ui.weapontypel.setText(player.getWeaponName());
        ui.attacknuml.setText(""+player.getWeaponDamage());
        ui.healnuml.setText(""+player.getHealnum());
        ui.goldnuml.setText(""+player.getGold());
    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "awakening": awakening();break;
            case "crossRoad": mc.crossRoad();break;
            case "left": left();break;
            case "attack": playerAttack();break;
            case "fight": fight();break;
            case "monsterAttack": monsterAttack();break;
            case "win": win();break;
            case "loss": loss();break;
            case "tomenu": tomenu();break;
            case "forward": forward();break;
            case "heal": heal();break;
            case "GM1": GM1();break;//here
            case "drop1": drop1();break;
            case "right": right();break;
            case "boss1rep": boss1rep();break;
            case "boss2rep": rooms.gameMasterRoom();break;
            case "boss3rep":  rooms.finalBossRoom();break;
            case "boss1fight": boss1fight();break;
            case "buff": buff();break;
            case "fairyheal": fairyheal();break;
            case "medusal": medusal();break;
            case "evilMickey": evilMickey();break;
            case "buyAll": buyAll();break;
            case "buyOne": buyOne();break;
            case "sellerFight": sellerFight();break;
            case "run": run();break;
            case "mimicRandom": mimicRandom();break;
            case "ripFamiliar": ripFamiliar();break;
            case "riddle": riddle();break;
            case "noDealGM": noDealGM();break;
            case "dealGM": dealGM();break;
            case "dealGM2": rooms.welcomeThirdFloor();break;
            case "seller": rooms.seller();break;
            case "ending2": rooms.ending2();break;
            case "ending3": rooms.ending3();break;
            case "finalFight": finalFight();break;
            case "ripHl": ripHl();break;
            case "theEnd": rooms.theEnd();break;
            case"save": safe();break;
        }
    }
    public void safe(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
            bw.write(""+ player.getHp());
            bw.newLine();
            bw.write(player.getWeaponName());
            bw.newLine();
            bw.write(""+player.getWeaponDamage());
            bw.newLine();
            bw.write(""+ player.getGold());
            bw.newLine();
            bw.write(""+player.getHealnum());
            bw.newLine();
            bw.write(""+ roomCounter);
            bw.newLine();
            bw.write(""+floorCounter);
            bw.newLine();
            bw.write(""+forwardCounter);

            bw.close();
        }
        catch (Exception e){

        }
        GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));
        ui.positionPictureLabel.setIcon(GM);
        ui.storyArea.setText("< You saved your progress >");

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "tomenu";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    // main menu continue (load safe)
    public void load(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            player.setHp(Integer.parseInt(br.readLine()));
            player.editWeaponName(br.readLine());
            player.editWeaponDamage(Integer.parseInt(br.readLine()));
            player.addGold(Integer.parseInt(br.readLine()));
            money.play();
            player.setHealnum(Integer.parseInt(br.readLine()));

            roomCounter = Integer.parseInt(br.readLine());
            floorCounter = Integer.parseInt(br.readLine());
            forwardCounter = Integer.parseInt(br.readLine());

                    br.close();
        }
        catch (Exception e){

        }
        GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));
        ui.positionPictureLabel.setIcon(GM);
        ui.storyArea.setText("< You loaded saved progress >");

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        ui.hpnuml.setText("" + player.getHp());
        ui.weapontypel.setText(player.getWeaponName());
        ui.attacknuml.setText(""+player.getWeaponDamage());
        ui.healnuml.setText(""+player.getHealnum());
        ui.goldnuml.setText(""+player.getGold());

    }
    //main menu info
    public void info(){
        ui.storyArea.setText("< TOP SECRET >\n" +
                "- If you move three rooms forward you will find treasure room\n" +
                "- Ignore mimics it's not worth it\n" +
                "- Answer to Sphinx's riddle is HUMAN\n" +
                "- If you see cute little creature take it with you\n" +
                "- Altar takes two types of sacrifice one is familiar and second is Health limit\n" +
                "- Don't attack Elixir trader he is under GM's protection\n" +
                "- You have to kill monsters in order to move to the other floor\n" +
                "- If you walk into dark room don't light the torch!");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "tomenu";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //first floor room effects

    //First floor awakening effect
    public void awakening() {
        ui.storyArea.setText("< You woke up >\n" +
                "You - Ugh...My head hurts…\n" +
                "You - What happened? Where am I?\n" +
                "< you look around >\n" +
                "You - Looks like an old mansion of a rich family\n" +
                "< You hear strange voice, but you don’t see anyone >");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        //ui.window.setVisible(true);
        //ui.choiceP.setVisible(true);
        game.nextPosition1 = "GM1";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void GM1() {
        //GM = new ImageIcon("Pictures/Microphone.jpg");
        GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Microphone.jpg"));

                ui.positionPictureLabel.setIcon(GM);
        ui.storyArea.setText("GM- Hahahaha! You finally woke up!" +
                "\nGM- Welcome to the mansion of my lord." +
                "\nGM- I’m your game master and you were taken from your world in order to entertain me and my lord." +
                "\nGM- In order to beat the game and return to your world you have to reach third floor of this mansion and defeat my lord. " +
                "\nGM- Some of the rooms are very dangerous so choose your class it will increase your chances to survive.");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "drop1";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //first floor start items
    public void drop1() {
        ui.storyArea.setText("< You received knife >" +
                "\n< You received 5 healing potions >" +
                "\n< you received 100 gold >");
        player.addGold(100);
        //money.play();
        player.setHealnum(5);
        player.setWeapon(new Weapon_Knife());
        updatePlayerStatus();
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //first floor evill Mickey effect (takes you to the boss)
    public void evilMickey(){
        roomCounter=4;
        ui.storyArea.setText("EM - Good choice");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "boss1rep";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //first floor Sphinx's riddle effect
    public void riddle(){
        ui.storyArea.setText("< Sphinx is surprised you knew the answer >\n" +
                "< HP cap increased by 50 points >\n" +
                "< Your Attack increased by 10 points >");
        healthLimit += 50;
        player.setHp(healthLimit);
        player.editWeaponDamage(player.getWeaponDamage()+10);
        updatePlayerStatus();
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //first floor boss
    public void boss1rep(){
        //GM = new ImageIcon("Pictures/Bigogre_.jpg");
        GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Bigogre_.jpg"));

                ui.positionPictureLabel.setIcon(GM);
        monster = new Ogre_Boss();
        updateMonsterStatus();
        ui.storyArea.setText("< You entered the territory of floor boss > \n" +
                "< you see abnormally huge Ogre sitting on his throne >\n" +
                "O- You filthy human, how many of my man you killed to get here?\n" +
                "O- Now is time to pay.\n" +
                "< Ogre stands up and fight begins >");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "boss1fight";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void boss1fight(){
        monster = new Ogre_Boss();
        ui.storyArea.setText("You encountered\n" + monster.name.toUpperCase());
        fight();
    }

    //second floor room effects

    //second floor fairy effect
    public void fairyheal(){
        ui.storyArea.setText("< You were healed in exchange for 1 elixir >");
        player.setHealnum(player.getHealnum()-1);
        player.heal(300);
        updatePlayerStatus();
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    //second floor altar room effect
    //sacrifice health
    public void ripHl(){
        roomCounter++;
        player.takeDamage(30);
        healthLimit = healthLimit-30;
        updatePlayerStatus();
        ui.storyArea.setText("< You sacrificed 30 health limit points to the altar >");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "run";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    //sacrifice familiar
    public void ripFamiliar(){
        roomCounter++;
        if(familiarCounter <= 0){
            ui.storyArea.setText("< You don't have any familiars to sacrifice >\n" +
                    "< Altar took your life instead >");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "loss";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else{
            ui.storyArea.setText("< You lost one of your familiars >\n" +
                    "< Your attack decreased >");
            familiarCounter--;
            player.editWeaponDamage(player.getWeaponDamage()/2);
            updatePlayerStatus();
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

    }

    //second floor familiar buff effect
    public void buff(){
        roomCounter++;
        familiarCounter++;
        ui.storyArea.setText("< Your attack increased >");
        player.editWeaponDamage(player.getWeaponDamage()* 2);
        updatePlayerStatus();
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //second floor succubus debuff effect
    public void debuff(){
        ui.storyArea.setText("< Your attack decreased >");
        int debuff = player.getWeaponDamage()/ 4;
        player.editWeaponDamage(player.getWeaponDamage() - debuff);
        updatePlayerStatus();

    }
    // second floor boss room effects
    public void dealGM(){
        //GM = new ImageIcon("Pictures/As real.jpg");
        GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/As real.jpg"));

                ui.positionPictureLabel.setIcon(GM);
        ui.storyArea.setText("GM - HAhahaha interesting, and what makes you think you have enough authority\n" +
                " to put conditions in my deal? I don’t understand if you are just greedy or smart.\n" +
                "\n" +
                "< You feel pressure and stand into battle stance >\n" +
                "\n" +
                "You - …\n" +
                "\n" +
                "GM- Hmm... Fine, you don’t have to answer my question. I will grant you this wish.\n" +
                "\n" +
                "< You obtained legendary weapon Samael's Pride>\n" +
                "< You obtained 500 gold >\n" +
                "< HP limit increased by 100 points >");
       // player.currentWeapon.name = "Samael's Pride";
        //player.currentWeapon.damage+=500;
        player.setWeapon("Samael's Pride", 500);
        player.addGold(500);
        money.play();
        healthLimit += 100;
        player.setHp(healthLimit);
        updatePlayerStatus();
        roomCounter=4;
        ui.choice1.setText("Go to the final floor.");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "win";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void noDealGM(){
        //GM = new ImageIcon("Pictures/Microphone.jpg");
        GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Microphone.jpg"));

                ui.positionPictureLabel.setIcon(GM);
        ui.storyArea.setText("GM - Fool, I really didn’t want to waste my time on someone like you when the result of this battle is obvious.\n" +
                "\n" +
                "GM - But now that you made me mad there is no mercy for you. DIE!\n" +
                "\n" +
                "< GM casted huge fireball >\n");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "loss";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


    //third floor room effects

    //third floor medusa
    public void medusal(){
        ui.storyArea.setText("< You encountered Medusa with torch and turned into rock. >");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "loss";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void finalFight(){
        monster = new Minotaur_Boss();
        updateMonsterStatus();
        fight();
    }

    //universal room effects

    //Universal Mimic effect
    public void mimicRandom() {
        roomCounter++;
        int randomMimic = new java.util.Random().nextInt(2);
        if (randomMimic == 0) {
            ui.storyArea.setText("< This was a treasure chest >\n" +
                    "< You received a better Legendary Sword >\n" +
                    "< You recieved 200 gold >");
            //player.currentWeapon.name = ("Legendary Sword");
            //player.currentWeapon.damage += 200;
            player.setWeapon("Legendary Sword", 200);
            player.addGold(200);
            money.play();
            updatePlayerStatus();
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            ui.storyArea.setText("< You met Mimic >");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "loss";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    //Universal run effect
    public void run(){
        footsteps.play();
        mc.crossRoad();
    }

    // Universal seller effect
    public void buyAll()
    {
        if (player.getGold() > 99)
        {
            int all = player.getGold() / 100;
            int totalGold = all * 100;
            player.removeGold(totalGold);
            money.play();
            player.setHealnum(player.getHealnum()+all);
            updatePlayerStatus();
        }
    }
    public void buyOne(){
        if(player.getGold() > 99)
        {
            player.removeGold(100);
            money.play();
            player.setHealnum(player.getHealnum()+1);
            updatePlayerStatus();
        }
    }

    public void sellerFight(){
        ui.storyArea.setText("< Seller was under GM's protection >");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "loss";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // Universal move forward effect and hidden room
    public void forward() {
        forwardCounter++;
        footsteps.play();
        GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));
        ui.positionPictureLabel.setIcon(GM);
        ui.storyArea.setText("You moved forward");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        if (forwardCounter == 3) {
           // GM = new ImageIcon("Pictures/TesterRoom.jpg");
            GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/TesterRoom.jpg"));
            ui.positionPictureLabel.setIcon(GM);
            ui.storyArea.setText("< You found hidden room with treasures > \n" +
                    "< You received Tester's sword >\n" +
                    "< you received 1000 gold. >\n" +
                    "\n" +
                    "GM - you cheater I will teleport you back to the corridor");
            player.addGold(1000);
            money.play();
            player.setWeapon(new Weapon_TestersSword());
            //ui.weapontypel.setText(player.currentWeapon.name);
            updatePlayerStatus();
            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
            updatePlayerStatus();
        } else {
            game.nextPosition1 = "run";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    //other movement options
    public void left() {
        door.play();
        if(floorCounter == 1) {
            firstFloor();
        }
        else if (floorCounter == 2){
            secondFloor();
        }
        else if(floorCounter ==3){
            thirdFloor();
        }
    }

    public void right() {
        door.play();
        if(floorCounter == 1) {
            firstFloor();
        }
        else if (floorCounter == 2){
            secondFloor();
        }
        else if(floorCounter ==3){
            thirdFloor();
        }
    }

    //Universal fight effect (begins fight)
    public void fight() {
        vm.battleScreen();
        ui.storyArea.setText("You encountered "+monster.name);
        updateMonsterStatus();
        ui.choice1.setText("Attack");
        ui.choice2.setText("Add HP");
        ui.choice3.setText("Run");
        ui.choice4.setText("");

        game.nextPosition1 = "attack";
        game.nextPosition2 = "heal";
        game.nextPosition3 = "run";
        game.nextPosition4 = "";
    }

    //Universal update status effect (updates player's current items and health)
    public void updatePlayerStatus(){
        if(player.getHp() > healthLimit){
            player.setHp(healthLimit);
        }
        else if(player.getHp() < 0){
            player.setHp(0);
        }
        ui.hpnuml.setText("" + player.getHp());
        ui.weapontypel.setText(player.getWeaponName());
        ui.attacknuml.setText(""+player.getWeaponDamage());
        ui.healnuml.setText(""+player.getHealnum());
        ui.goldnuml.setText(""+player.getGold());

    }
    ////update monster status
    public void updateMonsterStatus(){
        ui.monsterPictureLabel.setIcon(monster.monsterPicture);
        ui.hpmnuml.setText(""+monster.hp);
        ui.attackmnuml.setText(""+monster.damage);
        ui.monsterNamel.setText(""+monster.name);
        ui.weaponmtypel.setText(""+monster.weapon);
    }

    //Universal heal option
    public void heal(){
        if(player.getHealnum() > 0){
            player.heal(50) ;
            player.setHealnum(player.getHealnum()-1);
            ui.hpnuml.setText("" + player.getHp());
            updatePlayerStatus();
        }
    }
    //Universal to menu option (sends player to menu)
    public void tomenu(){
        defaultSetup();
        vm.showTitleScreen();
    }

    //randomizer for the first floor (need to win 4 random battles in order to meet boss)
    public void firstFloor() {
        int randomMob = new java.util.Random().nextInt(7); //0,1,2
        switch (randomMob) {

            case 0:
                monster = new goblin_knife();
                updateMonsterStatus();
                fight();
                break;
            case 1:
                monster = new goblin_archer("Goblin Archer",60, 15, 18, 1.3, "Bow");
                updateMonsterStatus();
                fight();
                break;
            case 2:
                monster = new goblin_mage();
                updateMonsterStatus();
                fight();
                break;
            case 3:
                monster = new evilMickey();
                rooms.evilMickeyRoom();
                updateMonsterStatus();
                break;
            case 4:
                rooms.seller();
                break;
            case 5:
                rooms.mimic();
                break;
            case 6:
                rooms.sphinx();
                break;
        }
        if (roomCounter == 4) {
            //GM = new ImageIcon("Pictures/Alldoors_.jpg");
            vm.gameScreen();
            GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Alldoors_.jpg"));

            ui.positionPictureLabel.setIcon(GM);
            ui.storyArea.setText("You are in corridor. \n\nWhich room do you choose?");
            ui.choice1.setText("Open left Door");
            ui.choice2.setText("Open right door");
            ui.choice3.setText("Move forward");
            ui.choice4.setText("");

            game.nextPosition1 = "boss1rep";
            game.nextPosition2 = "boss1rep";
            game.nextPosition3 = "boss1rep";
            game.nextPosition4 = "";
        }
    }
    //randomizer for second floor
        public void secondFloor() {
            int randomMob = new java.util.Random().nextInt(10);
            switch (randomMob) {
                case 0:
                    monster = new familiar("Familiar", 25, 15, 18, 1.3, "Claws");
                    rooms.familiarRoom();
                    updateMonsterStatus();
                    break;
                case 1:
                    debuff();
                    monster = new Succubus();
                    rooms.succubusRoom();
                    updateMonsterStatus();
                    break;
                case 2:
                    rooms.fairyRoom();
                    break;
                case 3:
                    monster = new elementalSpirit();
                    updateMonsterStatus();
                    fight();
                    break;
                case 4:
                    monster = new waterSpirit();
                    updateMonsterStatus();
                    fight();
                    break;
                case 5:
                    monster = new fireSpirit();
                    updateMonsterStatus();
                    fight();
                    break;
                case 6:
                    monster = new windSpirit();
                    updateMonsterStatus();
                    fight();
                    break;
                case 7:
                    rooms.seller();
                    break;
                case 8:
                    rooms.mimic();
                    break;
                case 9:
                    rooms.altar();
                    break;
            }
            if (roomCounter == 4) {
                //GM = new ImageIcon("Pictures/Alldoors_.jpg");
                vm.gameScreen();
                GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Alldoors_.jpg"));
                ui.positionPictureLabel.setIcon(GM);
                ui.storyArea.setText("You are in corridor. \n\nWhich room do you choose?");
                ui.choice1.setText("Open left Door");
                ui.choice2.setText("Open right door");
                ui.choice3.setText("Move forward");
                ui.choice4.setText("");

                game.nextPosition1 = "boss2rep";
                game.nextPosition2 = "boss2rep";
                game.nextPosition3 = "boss2rep";
                game.nextPosition4 = "";
            }
        }
        //randomizer for third floor
            public void thirdFloor() {
                int randomMob = new java.util.Random().nextInt(6);
                switch (randomMob) {
                    case 0:
                        monster = new Medusa();
                        rooms.medusaRoom();
                        updateMonsterStatus();
                        break;
                    case 1:
                        monster = new chimera();
                        updateMonsterStatus();
                        fight();
                        break;
                    case 2:
                        monster = new cyclope();
                        updateMonsterStatus();
                        fight();
                        break;
                    case 3:
                        monster = new small_minotaur();
                        updateMonsterStatus();
                        fight();
                        break;
                    case 4:
                        rooms.seller();
                        break;
                    case 5:
                        rooms.mimic();
                        break;
                }
                if (roomCounter == 4) {
                    //GM = new ImageIcon("Pictures/Alldoors_.jpg");
                    vm.gameScreen();
                    GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Alldoors_.jpg"));
                    ui.positionPictureLabel.setIcon(GM);
                    ui.storyArea.setText("You are in corridor. \n\nWhich room do you choose?");
                    ui.choice1.setText("Open left Door");
                    ui.choice2.setText("Open right door");
                    ui.choice3.setText("Move forward");
                    ui.choice4.setText("");

                    game.nextPosition1 = "boss3rep";
                    game.nextPosition2 = "boss3rep";
                    game.nextPosition3 = "boss3rep";
                    game.nextPosition4 = "";
                }
    }

    //Battle system
    public void playerAttack(){
        // add or subtract to make crit chance lower or higher
        int critDifficulty = 20;
        int playerDamage = player.attack(rand.nextInt(critDifficulty));//feeds random number between 0-19 to player attack function
        if(playerDamage > player.attack(1))//checks for crit hit
        {
            ui.battleArea.setText("Crit! You attacked "+ monster.name+" and damaged for "+playerDamage+" hp");
            critical.play();
        }
        else
        {
            ui.battleArea.setText("You attacked " + monster.name + " and damaged for " + playerDamage + " hp");
            attack.play();
        }
        monster.hp -=playerDamage;
        updateMonsterStatus();
        updatePlayerStatus();
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");


        if (monster.hp > 0){
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(monster.hp <= 0){
            monster.hp = 0;
            updateMonsterStatus();
            ui.battleArea.setText("You attacked"+monster.name+" and damaged for " +playerDamage+"\n" +"\n" +
                    "<"+monster.name+" died >");

            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
        public void monsterAttack(){
            int monsterDamage = monster.damage;
            ui.battleArea.setText("Monster damaged you for "+monsterDamage+" hp");
            player.takeDamage(monsterDamage);
            updatePlayerStatus();
            updateMonsterStatus();
            ui.choice1.setText("Attack");
            ui.choice2.setText("Add HP");
            ui.choice3.setText("Run");
            ui.choice4.setText("");

            if (player.getHp() > 0){
                game.nextPosition1 = "attack";
                game.nextPosition2 = "heal";
                game.nextPosition3 = "run";
                game.nextPosition4 = "";
            }
            else if(player.getHp() < 1){
                ui.choice1.setText(">");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "loss";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }
        //win algorithm
        public void win(){
        roomCounter++;
            ui.battleArea.setText("");
            vm.gameScreen();
            if(roomCounter==5 && floorCounter == 1){
                //GM = new ImageIcon("Pictures/Microphone.jpg");
                GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Microphone.jpg"));
                ui.positionPictureLabel.setIcon(GM);
                ui.storyArea.setText("< You have defeated "+ monster.name+" you received a reward 500 gold. >\n" +
                        "< Your HP limit is increased by 100 points >\n" +
                        "GM - Woohooo! crazy! you adapt so quick !\n" +
                "Which room do you choose?\n" +
                        "GM - You actually defeated Ogre!\n" +
                        "GM - Now use the stairs behind his chair to get to my floor\n" +
                        "GM - Oh  before you go, buy some elixirs.");
                roomCounter = 0;
                floorCounter++;
                player.addGold(500);
                money.play();
                healthLimit+=100;
                player.setHp(healthLimit);
                updatePlayerStatus();
                ui.choice1.setText(">");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "seller";//next floor position
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else if(roomCounter == 5 && floorCounter ==2){
                rooms.welcomeThirdFloor();
                roomCounter = 0;
                floorCounter++;

            }
            else if (roomCounter == 5 && floorCounter == 3){
                rooms.ending1();
            }
            else if(floorCounter==1){
                ui.storyArea.setText("You have defeated "+ monster.name+ " you received a reward 100 gold.\n" +
                    "You are at crossroad. \n\nWhich room do you choose?");
                ui.battleArea.setText("");
            player.addGold(100);
            money.play();
            updatePlayerStatus();
            mc.incrossRoad();
            }
            else if(floorCounter==2){
                ui.storyArea.setText("You have defeated "+ monster.name+ " you received a reward 300 gold.\n" +
                        "You are at crossroad. \n\nWhich room do you choose?");
                ui.battleArea.setText("");
                player.addGold(300);
                money.play();
                updatePlayerStatus();
                mc.incrossRoad();
            }
            else if (floorCounter==3){
                ui.storyArea.setText("You have defeated "+ monster.name+ " you received a reward 500 gold.\n" +
                        "You are at crossroad. \n\nWhich room do you choose?");
                ui.battleArea.setText("");
                player.addGold(500);
                money.play();
                updatePlayerStatus();
                mc.incrossRoad();
            }
        }
        //loss
        public void loss(){
        roomCounter = 0;
        floorCounter =1;
        forwardCounter = 0;
        healthLimit =100;
            player.setWeapon(new Weapon_Knife());
            player.setHp(healthLimit);
            player.setGold(100);
            money.play();
            player.setHealnum(5);
            updatePlayerStatus();
            safe();
            //GM = new ImageIcon("Pictures/Black.jpg");
            GM = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));

            ui.positionPictureLabel.setIcon(GM);
            ui.storyArea.setText("YOU DIED");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "tomenu";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

