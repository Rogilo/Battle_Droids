package Battle_Droid.model;

public class B1_Droid extends BattleDroid
{
    public B1_Droid() {
        this.setHealth(150);
        this.setDamage(25);
        this.setCritChance(5);
        this.setEvasion(10);
    }

    public String toString()
    {
        String var10000 = this.getName();
        return "Name:" + var10000 + " (Type: B1 HP: " + this.getHealth() + " Dmg: " + this.getDamage() + " Crt " +
                this.getCritChance() + "% Evs " + this.getEvasion() + "% )";
    }
}
