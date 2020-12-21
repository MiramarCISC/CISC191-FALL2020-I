package Game;
/**
 * @author  Damien Bissell
 * @description randomizer for main hallway
 */
import SuperMonster.SuperMonster;

import javax.swing.*;

public class mainCoridor {
    Game game;
    Interfacce ui;
    Visibility vm;
    ImageIcon doorPicture;
    public SuperMonster monster;
    public mainCoridor(Game g, Interfacce u, Visibility v) {
        game = g;
        ui = u;
        vm = v;
    }
    // randomized coridor to make game a little more fun
    public void incrossRoad() {
        vm.gameScreen();
        int randomroom = new java.util.Random().nextInt(8); //0,1,2
        switch (randomroom) {
            case 0:
                //all possible ways
                //doorPicture = new ImageIcon("Pictures/Alldoors_.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Alldoors_.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Open left Door");
                ui.choice2.setText("Open right door");
                ui.choice3.setText("Move forward");
                ui.choice4.setText("Save and Exit to menu");

                game.nextPosition1 = "left";
                game.nextPosition2 = "right";
                game.nextPosition3 = "forward";
                game.nextPosition4 = "save";
                break;
            case 1:
                //only left door
                //doorPicture = new ImageIcon("Pictures/Onlyleft_.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Onlyleft_.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Open left Door");
                ui.choice2.setText("Save and Exit to menu");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "left";
                game.nextPosition2 = "save";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
                break;
            case 2:
                //only right door
                //doorPicture = new ImageIcon("Pictures/Onlyright_ 1.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Onlyright_ 1.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Open right door");
                ui.choice2.setText("Save and Exit to menu");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "right";
                game.nextPosition2 = "save";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
                break;

            case 3:
                //only forward
                //doorPicture = new ImageIcon("Pictures/OnlyForward.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/OnlyForward.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Move forward");
                ui.choice2.setText("Save and Exit to menu");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "forward";
                game.nextPosition2 = "save";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
                break;
            case 4:
                //left and right doors
                //doorPicture = new ImageIcon("Pictures/leftandright.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/leftandright.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Open left Door");
                ui.choice2.setText("Open right door");
                ui.choice3.setText("Save and Exit to menu");
                ui.choice4.setText("");

                game.nextPosition1 = "left";
                game.nextPosition2 = "right";
                game.nextPosition3 = "save";
                game.nextPosition4 = "";
                break;
            case 5:
                //forward and left
                //doorPicture = new ImageIcon("Pictures/Forward_and_left.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Forward_and_left.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Open left Door");
                ui.choice2.setText("Move forward");
                ui.choice3.setText("Save and Exit to menu");
                ui.choice4.setText("");

                game.nextPosition1 = "left";
                game.nextPosition2 = "forward";
                game.nextPosition3 = "save";
                game.nextPosition4 = "";
                break;
            case 6:
                //right or forward
                //doorPicture = new ImageIcon("Pictures/Forward_and_right.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Forward_and_right.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Open right Door");
                ui.choice2.setText("Move forward");
                ui.choice3.setText("Save and Exit to menu");
                ui.choice4.setText("");

                game.nextPosition1 = "right";
                game.nextPosition2 = "forward";
                game.nextPosition3 = "save";
                game.nextPosition4 = "";
                break;
            case 7:
                //only forward
                //doorPicture = new ImageIcon("Pictures/Forwarddoor.jpg");
                doorPicture = new ImageIcon(getClass().getClassLoader().getResource("Pictures/Forwarddoor.jpg"));
                ui.positionPictureLabel.setIcon(doorPicture);
                ui.choice1.setText("Open Door");
                ui.choice2.setText("Save and Exit to menu");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "left";
                game.nextPosition2 = "save";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
                break;
        }
    }

    public void crossRoad() {
        ui.storyArea.setText("You are in corridor. \n\nWhich door do you choose?");
        incrossRoad();
    }
}
