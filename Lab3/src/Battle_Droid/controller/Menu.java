package Battle_Droid.controller;


import java.util.Scanner;

public class Menu {

    public void typeOfFight() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose type of fight!\n1. One on one fight\n2. Team fight");
        int num = in.nextInt();
        switch (num) {
            case 1 -> creatTeams(1);
            case 2 -> {
                System.out.println("Choose the size of the battle!\n");
                int count = in.nextInt();
                creatTeams(count);
            }
            default -> {
                System.out.println("Invalid request");
                System.exit(0);
            }
        }
    }

    public void creatTeams(int countOfDroid) {
        System.out.println("Choose your droids!\n");
        DroidFactory team1 = new DroidFactory( countOfDroid);
        System.out.println("Nice job! Here is your team list:");
        team1.showInfo();
        System.out.println("\nChoose enemy droids!\n");
        DroidFactory team2 = new DroidFactory( countOfDroid);
        BattleArena battle = new BattleArena();
        battle.startFight(team1, team2);
    }

    public void startFight() {
        typeOfFight();
    }
}
