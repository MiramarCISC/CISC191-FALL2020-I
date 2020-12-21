package Game;
/**
        * @author : Valentyn Protsyuk
        sets what is visible for each part of the game
**/
public class Visibility {
    Interfacce ui;
    public Visibility(Interfacce usI){
ui = usI;

    }
    public void showTitleScreen(){
        //setting visible parts
ui.Title.setVisible(true);
ui.startButton.setVisible(true);
// invisible parts
        ui.pStory.setVisible(false);
        ui.choiceP.setVisible(false);
        ui.pplayer.setVisible(false);
        ui.pBattle.setVisible(false);
        ui.playerPic.setVisible(false);
        ui.plmonster.setVisible(false);
        ui.positionPic.setVisible(false);
        ui.monsterPic.setVisible(false);
        ui.pmonster.setVisible(false);
        ui.plstory.setVisible(false);
        ui.plbattle.setVisible(false);
    }
    public void gameScreen(){
        //setting invisible parts
        ui.Title.setVisible(false);
        ui.startButton.setVisible(false);

        ui.pBattle.setVisible(false);
        ui.plmonster.setVisible(false);
        ui.monsterPic.setVisible(false);
        ui.pmonster.setVisible(false);
        ui.plstory.setVisible(false);
        ui.plbattle.setVisible(false);
// visible parts
        ui.pStory.setVisible(true);
        ui.choiceP.setVisible(true);
        ui.pplayer.setVisible(true);
        ui.playerPic.setVisible(true);
        ui.positionPic.setVisible(true);

       // ui.window.setVisible(true);
    }
    //screen for info button
    public void infoScreen(){
        ui.Title.setVisible(false);
        ui.startButton.setVisible(false);

        ui.pBattle.setVisible(false);
        ui.plmonster.setVisible(false);
        ui.monsterPic.setVisible(false);
        ui.pmonster.setVisible(false);
        ui.plstory.setVisible(false);
        ui.plbattle.setVisible(false);
// visible parts
        ui.pStory.setVisible(true);
        ui.choiceP.setVisible(true);
        ui.pplayer.setVisible(false);
        ui.playerPic.setVisible(false);
        ui.positionPic.setVisible(false);
    }

    public void battleScreen(){

        ui.Title.setVisible(false);
        ui.startButton.setVisible(false);
        ui.positionPic.setVisible(false);
        //visible parts
        ui.pBattle.setVisible(true);
        ui.plmonster.setVisible(true);
        ui.monsterPic.setVisible(true);
        ui.pmonster.setVisible(true);
        ui.plstory.setVisible(true);
        ui.plbattle.setVisible(true);
        ui.pStory.setVisible(true);
        ui.choiceP.setVisible(true);
        ui.pplayer.setVisible(true);
        ui.playerPic.setVisible(true);

       // ui.window.setVisible(true);
    }
    //ui.window.setVisible(true);
}
