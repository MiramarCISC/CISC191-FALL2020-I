package Game;
/**
 * @author  Valentyn Protsyuk
 * @description code for what happens in each room
 */
import javax.swing.*;
// Class for all possible rooms
public class Rooms {
    Game game;
    Interfacce ui;
    Visibility vm;
    ImageIcon positionPicture;
    public Rooms(Game g, Interfacce u, Visibility v) {
        game = g;
        ui = u;
        vm = v;
    }

    //first floor rooms
//first floor evil mickey room (you can get to boss faster)
    public void evilMickeyRoom(){
        //positionPicture = new ImageIcon("Pictures/BigEm.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/BigEm.jpg"));
                ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("EM - Hello there, you got yourself into quite a story! \n " +
                "EM - Do you need help?\n" +
                "EM - I can show you the way directly to the Boss of the first floor.\n" +
                "\n" +
                "Are you going to follow strange mouse?");
        ui.choice1.setText("yes");
        ui.choice2.setText("No");
        ui.choice3.setText("Run");
        ui.choice4.setText("");

        game.nextPosition1 = "evilMickey";
        game.nextPosition2 = "fight";
        game.nextPosition3 = "run";
        game.nextPosition4 = "";
    }

    //first floor sphinx
    public void sphinx(){
        //positionPicture = new ImageIcon("Pictures/Sphinx.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Sphinx.jpg"));

                ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You entered most dangerous area on this floor be careful >\n" +
                "< Sphinx appeared >\n" +
                "S - If you answer my question correctly I will spare your life and \n" +
                "increase your chances to survive here.\n" +
                "S - So answer me what goes on four feet in the morning, two feet at noon, \n" +
                "and three feet in the evening?");
        ui.choice1.setText("Human");
        ui.choice2.setText("Dog");
        ui.choice3.setText("Bird");
        ui.choice4.setText("Whale");

        game.nextPosition1 = "riddle";
        game.nextPosition2 = "loss";
        game.nextPosition3 = "loss";
        game.nextPosition4 = "loss";
    }

    //second floor rooms

    //room for succubus monster
    public void succubusRoom(){
        //positionPicture = new ImageIcon("Pictures/Bigsuccub.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Bigsuccub.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You encountered Succubus >\n" +
                "< you were seduced >\n" +
                "< your attack was lowered >");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //second floor room for familiar
    public void familiarRoom(){
        //positionPicture = new ImageIcon("Pictures/Familiar.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Familiar.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You found cute little creature >\n" +
                "\n" +
                "Do you want to take it with you on adventure?");
        ui.choice1.setText("I take it !!!");
        ui.choice2.setText("Fight it");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "buff"; //attack x2
        game.nextPosition2 = "fight";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    //second floor room for fairy
    public void fairyRoom(){
        //positionPicture = new ImageIcon("Pictures/Fairy.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Fairy.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("Hey traveler, I'm fairy I can restore your full HP in exchange for one elixir \n" +
                "Do we have a deal?");
        ui.choice1.setText("Sure");
        ui.choice2.setText("No");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fairyheal"; //heals until limit
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    //second floor altar room
    public void altar (){
        //positionPicture = new ImageIcon("Pictures/Altar.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Altar.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You entered altar room >\n" +
                "< Door closed you cannot run >\n" +
                "Would you sacrifice your familiar?");
        ui.choice1.setText("Never!");
        ui.choice2.setText("I have no choice...");
        ui.choice3.setText("Sacrifice 30 health limit");
        ui.choice4.setText("");

        game.nextPosition1 = "loss";
        game.nextPosition2 = "ripFamiliar";
        game.nextPosition3 = "ripHl";
        game.nextPosition4 = "";
    }

//second floor boss
    public void gameMasterRoom(){
        //positionPicture = new ImageIcon("Pictures/As real.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/As real.jpg"));
        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You entered GM’s room >\n" +
                "< You see GM proudly sitting on his throne >\n" +
                "GM - Wow you actually did it!\n" +
                "GM - You are something!\n" +
                "GM - Clearing two floors you are the first one who made it this far.\n" +
                "GM - Interesting…\n" +
                "GM - What should I do, hmmm....\n" +
                "GM - I have a deal, if you don’t waste my time I will let you go to \n" +
                "the next floor peacefully.\n" +
                "What is your choice?");
        ui.choice1.setText("*SHOUT* Never, you brought me to this mansion! And now, when I slew your friends you\n" +
                " are just afraid of me! I’m not going to accept this deal!!!");
        ui.choice2.setText("Fine, I just want to get back to my family. However, I have one condition \n" +
                "you have to give me a reward that I am supposed to get for defeating you.");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "noDealGM";
        game.nextPosition2 = "dealGM";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //third floor rooms


    public void welcomeThirdFloor(){
        //positionPicture = new ImageIcon("Pictures/Microphone.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Microphone.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("GM - Welcome to the last floor of our mansion my friend.\n" +
                "GM - After you clear 6 rooms on this floor you will be honored by the chance to fight with my lord.\n" +
                "GM - SH*T the microphone isn’t working properly! Ah whatever I said everything I wanted.\n" +
                "GM - Good luck traveler.\n" +
                "\n" +
                "P - Wait this it? Aren’t you going to tell me who is your lord and why he choose me for the game?\n" +
                "\n" +
                "GM - *PsHHhhsh* Why don’t you ask my *PshSh* lord instead?!? Don’t you hear I have*SHHH* micro*Psh*one issues*HPHhhph*\n" +
                "\n" +
                "P - Right, I should ask the ruler himself once I defeat him.\n" +
                "GM - Also *PsphShh* there is a *SHshH* seller I recommend to *Pshh* buy elixirs.");
        ui.choice1.setText("Explore new floor");
        ui.choice2.setText("go to seller");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "seller";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    //third floor room for Medusa
    public void medusaRoom(){
        //positionPicture = new ImageIcon("Pictures/Black.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("You entered very dark room \n" +
                "Do you want to light a torch?");
        ui.choice1.setText("yes");
        ui.choice2.setText("No");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "medusal";
        game.nextPosition2 = "fight";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

//third floor boss
    public void   finalBossRoom(){
        //positionPicture = new ImageIcon("Pictures/-big_mini.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/-big_mini.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You entered territory of the final boss >\n" +
                "< You see an old Minotaur who is three times bigger than the Ogre >\n" +
                "M - You finally came. Did you like our service?\n" +
                "\n" +
                "P - I see you like to joke... do you know how many times I almost died here?\n" +
                "\n" +
                "M - That’s the point, we wanted to make you stronger! I needed a worthy opponent!\n" +
                "          Without our support you wouldn’t survive even an hour in my Mansion.\n" +
                "P - *Sarcastic* Haha funny “OuR sUpOrT”. Without you guys, I wouldn’t even need to survive!\n" +
                "< You charged at minotaur because of emotions, last fight begins >\n");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "finalFight";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void ending1(){
        //positionPicture = new ImageIcon("Pictures/Black.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));
        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText(" You almost killed him, but you stopped yourself >\n" +
                "< You started crying >\n" +
                "\n" +
                "You - Why?!?\n" +
                "You - Why me?!?!\n" +
                "You - What is even the point of this stupid game?\n" +
                "You - You just teleport me here to watch me suffering? \n" +
                "      And you give me enough resources to kill you.\n" +
                "      What is the reasoning here?");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "ending2";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void ending2(){
        //positionPicture = new ImageIcon("Pictures/Black.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));
        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("M - I have been leaving in this mansion since I remember myself. \n" +
                "M - Now I’m old and leaving in this mansion is boring so I came up with a plan…\n" +
                "M - I decided to host this game where I summon humans and they either die while \n" +
                "entertaining me or they become worthy warriors and let me die in the epic battle!\n" +
                "M - For defeating me you get to keep all the skills weapons and items you obtained here as  well as this mansion is now yours too \n" +
                "\n" +
                "< Minotaur collapses because of the blood loss and dies >\n" +
                "\n" +
                "You - ...\n");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "ending3";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void ending3(){
        //positionPicture = new ImageIcon("Pictures/Black.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Black.jpg"));
        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("                          < ENDING >                       \n" +
                "\n"+
                "       < You returned to your world became super rich and successful > \n" +
                "\n"+
                "         < You saved many people by using potions from the mansion > \n" +
                "\n"+
                "< With your experience and gear from the MANSION you cleared hundreds of other dungeons >\n" +
                "\n"+
                "                     < You became a very known hero. >");
        ui.choice1.setText("GG");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "theEnd";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void theEnd(){
        ui.storyArea.setText("                            < THE END >\n" +
                "\n"+
                "Interface, Pictures and Sounds done by Valentyn Protsyuk\n" +
                "\n"+
                "Rooms and story done by Oliver Ortiz\n" +
                "\n"+
                "Battle system, weapons and monsters done by Damien");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "tomenu";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    //Universal rooms (can be on any floor)

    //mimic room (die or treasure)
    public void mimic(){
        //positionPicture = new ImageIcon("Pictures/Mimic.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Mimic.jpg"));

        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You found a chest, or is it a Mimic? > \n" +
                "< You have a 50 % chance to die or find good drop >" +
                "Do you want to loot this chest?");
        ui.choice1.setText("Loot it!");
        ui.choice2.setText("Ignore");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "mimicRandom";
        game.nextPosition2 = "run";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //buy elixirs on any floor
    public void seller(){
        //positionPicture = new ImageIcon("Pictures/Seller.jpg");
        positionPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Seller.jpg"));
        ui.positionPictureLabel.setIcon(positionPicture);
        ui.storyArea.setText("< You met elixir trader >\n" +
                "< Each elixir costs 100 gold and restores 50 hp >\n" +
                "Do you want to buy any?");
        ui.choice1.setText("Buy All");
        ui.choice2.setText("Buy x1");
        ui.choice3.setText("Attack");
        ui.choice4.setText("Next Room");

        game.nextPosition1 = "buyAll";
        game.nextPosition2 = "buyOne";
        game.nextPosition3 = "sellerFight";
        game.nextPosition4 = "run";
    }
}
