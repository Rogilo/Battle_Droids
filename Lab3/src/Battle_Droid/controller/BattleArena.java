package Battle_Droid.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BattleArena {
    int myDroidTurn;
    int enemyDroidTurn;
    int myDroidIndex = 0;
    int turnNumber = 1;
    int enemyDroidIndex = 0;
    static BufferedReader reader;

    public void slash() {
        System.out.println("/////////////////////////////");
    }

    public void line() {
        System.out.println("..............................");
    }

    public void startFight(DroidFactory myTeam, DroidFactory enemyTeam) {
        while(true) {
            if (!myTeam.getDroidList().isEmpty() && !enemyTeam.getDroidList().isEmpty()) {
                this.turnInfo(myTeam);
                this.myTurn(myTeam, enemyTeam);
                if (!enemyTeam.getDroidList().isEmpty()) {
                    this.enemyTurn(myTeam, enemyTeam);
                    continue;
                }
            }

            if (enemyTeam.getDroidList().isEmpty()) {
                System.out.println("Congratulations, you won!");
            } else if (myTeam.getDroidList().isEmpty()) {
                System.out.println("The enemy team won, better luck next time.");
            }
            return;
        }
    }

    private void turnInfo(DroidFactory myTeam) {
        this.line();
        System.out.println("Turn number " + this.turnNumber++);
        System.out.println("Team info:");
        this.slash();
        myTeam.showInfo();
        this.slash();
        System.out.println();
    }

    private void enemyTurn(DroidFactory myTeam, DroidFactory enemyTeam) {
        this.enemyTeamTurn(this.enemyDroidTurn, enemyTeam);
        Random random = new Random();
        int value = myTeam.getDroidList().size();
        if (value == 0) {
            this.myDroidIndex = 0;
        } else {
            this.myDroidIndex = random.nextInt(value);
        }
        System.out.println("Enemy droid attack " + myTeam.getDroidList().get(this.myDroidIndex).getName());
        shootEnemyDroid(enemyTeam, myTeam, this.enemyDroidTurn, this.myDroidIndex);
    }

    private void myTurn(DroidFactory myTeam, DroidFactory enemyTeam) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.myTeamTurn(this.myDroidTurn, myTeam);
        System.out.print("Enemies that can be attacked:\n");
        enemyTeam.showInfo();
        System.out.println(myTeam.getDroidList().get(this.myDroidTurn).getName() + " turn");
        System.out.print("Choose your enemy!\n");

        try {
            String enemyIndex = reader.readLine();
            this.enemyDroidIndex = Integer.parseInt(enemyIndex) - 1;
            this.slash();
            System.out.println("Your droid attack " + enemyTeam.getDroidList().get(this.enemyDroidIndex).getName());
            shootEnemyDroid(myTeam, enemyTeam, this.myDroidTurn, this.enemyDroidIndex);
        } catch (IndexOutOfBoundsException var5) {
            System.out.println("Please, choose existing enemy: 1-" + enemyTeam.getDroidList().size());
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    private void enemyTeamTurn(int turn, DroidFactory Team) {
        if (turn < Team.getDroidList().size() - 1) {
            ++this.enemyDroidTurn;
        } else if (turn >= Team.getDroidList().size() - 1) {
            this.enemyDroidTurn = 0;
        }
    }

    private void myTeamTurn(int turn, DroidFactory Team) {
        if (turn < Team.getDroidList().size() - 1) {
            ++this.myDroidTurn;
        } else if (turn >= Team.getDroidList().size() - 1) {
            this.myDroidTurn = 0;
        }

    }

    private void shootEnemyDroid(DroidFactory attacer, DroidFactory target, int droidAttacerIndex, int droidTargetIndex) {
        attacer.getDroidList().get(droidAttacerIndex).attack(target.getDroidList().get(droidTargetIndex));
        if (target.getDroidList().get(droidTargetIndex).isDead()) {
            target.getDroidList().remove(droidTargetIndex);
        }

    }
}