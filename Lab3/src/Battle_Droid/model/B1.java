package Battle_Droid.model;

public class B1 extends BattleDroid
{
    public B1() {
        this.setHealth(150);
        this.setDamage(25);
        this.setCritChance(5);
        this.setEvasion(10);
    }

    public String toString() {
        return "Name:" + this.getName() + " (Type: B1 HP: " + this.getHealth() + " Dmg: " + this.getDamage()
                + " Crt " + this.getCritChance() + "% Evs " + this.getEvasion() + "% )";
    }

}
