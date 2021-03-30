package adventureGame;

import java.util.Random;

public class Player {
    int health;
    int magic;
    int attackDamage;
    String playerType;
    String specialAttack;
    String mainAttack;

    Random rand = new Random();

    int[] maxHealthOptions = {};
    int[] maxMagicOptions = {};
    int[] playerAttackDamageOptions = {};
    String[] playerTypeOptions = {};
    String[] mainAttackOptions = {};
    String[] specialAttackOptions = {};

    public Player(int type) {
        health = rand.nextInt(maxHealthOptions[type]);
        magic = rand.nextInt(maxMagicOptions[type]);
    }
}
