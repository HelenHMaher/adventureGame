package adventureGame;

import java.util.Random;
import java.lang.Math;

public class Enemy {
        int type;
        int health;
        int magic;
        int attackDamage;
        int currentAttackDamage;
        String enemyType;
        String specialAttack;
        String mainAttack;
        String deathCry;
        String victoryCry;

        Random rand = new Random();

        int[] maxHealthOptions = { 100, 100, 100, 70, 100, 500, 80, 80, 80, 90 };

        int[] maxMagicOptions = { 70, 20, 20, 20, 80, 600, 20, 100, 100, 50 };

        int[] enemyAttackDamageOptions = { 20, 20, 20, 30, 30, 40, 40, 20, 50, 10 };

        String[] enemyTypeOptions = { "fire-spitting lizard", "giant slug", "rodent of unusual size",
                        "swarm of high-pitched screeming spiders", "golumn", "lost porkupine", "poisonus moth",
                        "half-eaten zombie", "zombie eating another zombie", "sickly-looking man in a lab coat" };

        String[] mainAttackOptions = { "spits fire at you", "covers you with toxic slime",
                        "bites you through a kink in your armor",
                        "swarm you, biting you until you're itching everywhere", "stops on your foot",
                        "looks at you with big, sad eyes", "poisons you with the dust from its wings",
                        "kicks you in the shins", "throws a piece of zombie at you",
                        "coughs in your general direction" };

        String[] specialAttackOptions = { "jumps on your face and cries naipalm into your ears",
                        "launches itself at your chest, hitting you right in the solar-plexis", "bites at your ankles",
                        "screem so laud you are deafened", "kicks you in the face", "cries at you",
                        "flies around your head until you are too dizy to keep your balance and you fall over",
                        "rushes you dramatically", "spits stomach acid at you", "spits in your general direction" };

        String[] deathCryOptions = { "eeeeeeeeeeeeeee...", "ffffffffffff...", "wwwweeeeeeeeiiiiiii....",
                        "EEiiiieeeEEEIIieee...", "uuuuugh...", "golump...", "whoopwhoopwhoop...",
                        "ggrrroooooooorrrr...", "aaarrrrbbbraraaaiinnnnsss...", "the... experiment..." };

        String[] victoryCryOptions = { "EEEEEEEEE!!!!!", "FFFFFFFFF!!!", "WWWWWEEEEEEEIIiiiiiiii!!!",
                        "EEiiiieeeEEEIIieee!!!", "UUUuugh!!!", "GOLUMP!!", "WhoopWhoopWhoop!!!", "GGrrroooooooorrrr!!",
                        "AAaRrrrBbbRAraaaIINnnnSSss!!!", "THE EXPERIMENT!!!!" };

        public Enemy() {
                type = rand.nextInt(enemyTypeOptions.length);

                health = rand.nextInt(maxHealthOptions[type]);
                magic = rand.nextInt(maxMagicOptions[type]);
                attackDamage = rand.nextInt(enemyAttackDamageOptions[type]);
                enemyType = enemyTypeOptions[type];
                specialAttack = specialAttackOptions[type];
                mainAttack = mainAttackOptions[type];
                deathCry = deathCryOptions[type];
                victoryCry = victoryCryOptions[type];
        }

        public void takeDamage(int damageDealt) {
                health -= damageDealt;
        }

        public String getAttack() {
                double diceRoll = Math.random();
                if (magic > 10) {
                        double healthMultiplier = (maxHealthOptions[type] - health) / health;
                        double usesMagicChance = healthMultiplier * diceRoll;
                        if (usesMagicChance > .2) {
                                currentAttackDamage = (int) Math.floor(diceRoll * attackDamage) * 2;
                                return specialAttack;
                        }
                }
                currentAttackDamage = (int) Math.floor(diceRoll * attackDamage);
                return mainAttack;
        }

        public int getAttackDamage() {
                return currentAttackDamage;
        }
}
