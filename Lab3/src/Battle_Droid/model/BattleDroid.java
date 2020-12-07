package Battle_Droid.model;

import java.util.Random;

public class BattleDroid implements Attack {
    protected String name;
    protected int health;
    protected int damage;
    protected int evasion;
    protected int criticalAttackChance;

    public int criticalStrike(int value) {
        if (this.probability() <= this.getCritChance()) {
            System.out.println("Critical strike!");
            value *= 2;
        }

        return value;
    }

    public void attack(BattleDroid droid) {
        int damage = this.prepareAttack();
        System.out.println("Damage done: " + droid.getHit(damage));
    }

    public int prepareAttack() {
        int attack = this.getDamage();
        attack = this.criticalStrike(attack);
        return attack;
    }

    public boolean toBlock() {
        return this.probability() <= this.getEvasion();
    }

    public boolean isDead() {
        return this.getHealth() <= 0;
    }

    public int getHit(int damage) {
        if (this.toBlock()) {
            System.out.println("Attack blocked");
            return 0;
        } else {
            this.health -= damage;
            return damage;
        }
    }

    public int probability() {
        return (new Random()).nextInt(100);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getEvasion() {
        return this.evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getCritChance() {
        return this.criticalAttackChance;
    }

    public void setCritChance(int critChance) {
        this.criticalAttackChance = critChance;
    }
}
