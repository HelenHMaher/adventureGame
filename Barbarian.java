package adventureGame;

import java.lang.Math;
import java.util.Random;

public class Barbarian extends Player {
    public Barbarian() {
        Random rand = new Random();
        type = "barbarian";
        health = 120;
        magic = 120;
        numHealthPotions = 0;
        grog = 0;
        attackDamage = 40;
        specialAttack = "suplex";
        mainAttack = "brutaly clobber";
    }
}
