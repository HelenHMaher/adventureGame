package adventureGame;

import java.util.Random;

public class Enemy {

    int health;
    int attackDamage;
    String enemyType;
    String specialAttack;
    String mainAttack;
    String deathCry;
    String victoryCry;

    int[] maxHealthOptions = { 50, 40, 40, 70, 20, 500, 40, 80, 60, 20 };

    int[] enemyAttackDamageOptions = { 20, 20, 20, 30, 30, 40, 40, 20, 50, 10 };

    String[] enemyTypeOptions = { "fire-spitting lizard", "giant slug", "rodent of unusual size",
            "swarm of high-pitched screeming spiders", "golumn", "lost porkupine", "poisonus moth", "half-eaten zombie",
            "zombie eating another zombie", "sickly-looking man in a lab coat" };

    String[] mainAttackOptions = { "spits fire at you", "covers you with toxic slime",
            "bites you through a kink in your armor", "swarm you, biting you until you're itching everywhere",
            "stops on your foot", "looks at you with big, sad eyes", "poisons you with the dust from its wings",
            "kicks you in the shins", "throws a piece of zombie at you", "coughs in your general direction" };

    String[] specialAttackOptions = { "jumps on your face and cries naipalm into your ears",
            "launches itself at your chest, hitting you right in the solar-plexis", "bites at your ankles",
            "screem so laud you are deafened", "kicks you in the face", "cries at you",
            "flies around your head until you are too dizy to keep your balance and you fall over",
            "rushes you dramatically", "spits stomach acid at you", "spits in your general direction" };

    String[] deathCryOptions = { "eeeeeeeeeeeeeee...", "ffffffffffff...", "uuuuugh...", "EEiiiieeeEEEIIieee...",
            "golump...", "whoopwhoopwhoop...", "ggrrroooooooorrrr...", "aaarrrrbbbraraaaiinnnnsss...",
            "the... experiment..." };

    String[] victoryCryOptions = { "EEEEEEEEE!!!!!", "FFFFFFFFF!!!", "UUUuugh!!!", "EEiiiieeeEEEIIieee!!!", "GOLUMP!!",
            "WhoopWhoopWhoop!!!", "GGrrroooooooorrrr!!", "AAaRrrrBbbRAraaaIINnnnSSss!!!", "THE EXPERIMENT!!!!" };

    public Enemy(int type) {
        health = rand.nextInt(maxHealthOptions[type]);
        attackDamage = rand.nextInt(enemyAttackDamageOptions[type]);
        enemyType = enemyTypeOptions[type];
        specialAttack = specialAttackOptions[type];
        deathCry = deathCryOptions[type];
        victoryCry = victoryCryOptions[type];
    }

    public void takeDamage(int damageDealt) {
        health -= damageDealt;
    }

    public static void main(String[] args) {

    }
}
