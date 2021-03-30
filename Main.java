package adventureGame;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Player variables
        int health = 100;
        int attackDamage = 30;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 20; // Percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME: while (running) {
            System.out.println("----------------------------------------");

            Enemy enemy = new Enemy();
            System.out.println("\t# A " + enemy.enemyType + " has appeared! #\n");
            // # Skeletron has appeared! #

            while (enemy.health > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy.enemyType + "'s HP: " + enemy.health);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemy.attackDamage);

                    enemy.takeDamage(attackDamage);
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy.enemyType + " for " + damageDealt + " damage.");
                    System.out.println("\t> The " + enemy.enemyType + " " + enemy.mainAttack
                            + " in retaliation!  You take " + enemy.attackDamage + " in damage.");

                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on.");
                        break;
                    }

                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for "
                                + healthPotionHealAmount + ".  " + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    } else {
                        System.out.println(
                                "\t> You have no health potions left!  Defeat enemies for a chance to get one!");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + enemy.enemyType + "!");
                    // we want to go to the top of the GAME loop
                    continue GAME;
                } else {
                    System.out.println("\tInvalid command!");
                }
            }
            // you have died
            if (health < 1) {
                System.out.println("The " + enemy.enemyType + " lets out a shrill cry, \"" + enemy.victoryCry
                        + ",\" as you retreat.  Defeated, you limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("----------------------------------------");
            System.out.println(" # The " + enemy.enemyType + " lets out a sad final death rattle, \"" + enemy.deathCry
                    + "\" before falling still.  You were victorious! #");
            System.out.println(" # You have " + health + " HP left #");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy.enemyType + " dropped a health potion! #");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
            }
            System.out.println("----------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue on your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventures!");
                break;
            }
        }
        // game over
        in.close();
        System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");
    }

}
