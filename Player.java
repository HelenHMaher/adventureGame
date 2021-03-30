package adventureGame;

import java.lang.Math;

public class Player {
    int health;
    int magic;
    int numHealthPotions;
    int healthPotionHealAmount = 30;
    int grog;
    int attackDamage;
    int currentAttackDamage;
    String name;
    String type;
    String specialAttack;
    String mainAttack;

    public void takeDamage(int damageDealt) {
        health -= damageDealt;
    }

    public String getSpecialAttack() {
        double diceRoll = Math.random();
        if (magic >= 10) {
            magic -= 10;
            currentAttackDamage = (int) Math.floor(diceRoll * attackDamage) * 2;
            return specialAttack;
        }
        return "You have exhausted all your magic!  Grog would help, if you can find any.";
    }

    public String getMainAttack() {
        double diceRoll = Math.random();
        currentAttackDamage = (int) Math.floor(diceRoll * attackDamage);
        return mainAttack;
    }

    public int getAttackDamage() {
        return currentAttackDamage;
    }

    public void setName(String nameInput) {
        name = nameInput;
    }

    public Player() {
    }
}
