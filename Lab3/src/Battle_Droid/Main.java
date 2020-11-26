package Battle_Droid;

import Battle_Droid.controller.BattleArena;
import Battle_Droid.model.DroidFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("Choose your droids!\n");
        DroidFactory team1 = new DroidFactory(3);
        System.out.println("Nice job! Here is your team list:");
        team1.showInfo();
        System.out.println("\nChoose enemy droids!\n");
        DroidFactory team2 = new DroidFactory(3);
        BattleArena battle = new BattleArena();
        battle.startFight(team1, team2);
    }
}
