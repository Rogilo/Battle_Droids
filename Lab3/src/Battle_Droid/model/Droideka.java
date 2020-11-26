package Battle_Droid.model;

public class Droideka extends BattleDroid {
    private int armor;

    public Droideka() {
        this.setHealth(100);
        this.setDamage(30);
        this.setArmor(15);
        this.setCritChance(5);
        this.setEvasion(10);
    }

    public String toString() {
        String var10000 = this.getName();
        return "Name:" + var10000 + " (Type: Droideka HP: " + this.getHealth() + " Dmg: " + this.getDamage() + " AR: "
                + this.getArmor() + " Crt " + this.getCritChance() + "% Evs " + this.getEvasion() + "% )";
    }

    public boolean blocByArmor(int damage) {
        if (damage - this.getArmor() <= 0) {
            --this.armor;
            return true;
        } else {
            return false;
        }
    }

    public int getHit(int damage) {
        if (!this.toBlock() && !this.blocByArmor(damage)) {
            this.health -= damage;
            return damage;
        } else {
            System.out.println("Attack blocked");
            return 0;
        }
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}