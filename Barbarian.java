package adventureGame;

public class Barbarian extends Player {
    public Barbarian() {
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
