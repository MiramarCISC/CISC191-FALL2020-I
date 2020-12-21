package Game;
/**
 * @author  Valentyn Protsyuk
 * @description basically Main(). it is used to call all other classes and construct the game.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game {
    Interfacce ui = new Interfacce();
    choices pchoice = new choices();
    Visibility vm = new Visibility(ui);
    mainCoridor mc = new mainCoridor(this,ui,vm);
    Rooms rooms = new Rooms(this,ui,vm);
    Lore lore = new Lore(this,ui,vm,rooms,mc);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        ui.createInterface(pchoice);
        lore.defaultSetup();
        vm.showTitleScreen();
    }

    public class choices implements ActionListener {

        public void actionPerformed(ActionEvent event) {
           String yourChoice = event.getActionCommand();
           switch(yourChoice){
               case"start": vm.gameScreen();lore.awakening();break;
               case"continue":vm.gameScreen();lore.load();break;
               case"info":vm.infoScreen();lore.info();break;
               case"exit":System.exit(0);
               case"c1":lore.selectPosition(nextPosition1); break;
               case"c2":lore.selectPosition(nextPosition2);break;
               case"c3":lore.selectPosition(nextPosition3); break;
               case"c4":lore.selectPosition(nextPosition4); break;
           }
        }
    }
}
