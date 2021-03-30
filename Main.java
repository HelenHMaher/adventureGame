package adventureGame;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        boolean running = true;

        Player character;

        System.out.println("Welcome to the Dungeon!");
        System.out.println("\n\tWhat character would you like to play?");
        System.out.println("\t1. Barbarian");
        System.out.println("\t2. Gymnast");

        String charCreateInput = in.nextLine();
        while (!charCreateInput.equals("1") && !charCreateInput.equals("2")) {
            System.out.println("Invalid command!");
            charCreateInput = in.nextLine();
        }

        if (charCreateInput.equals("1")) {
            character = new Barbarian();
        } else {
            character = new Gymnast();
        }

        System.out.println("Enter a name for your " + character.type + "!");
        String nameInput = in.nextLine();
        character.setName(nameInput);

        System.out.println(character.name + ", the " + character.type + ", fearlessly enters the deadly dungeon.");

        GAME: while (running) {
            System.out.println("----------------------------------------");

            Enemy enemy = new Enemy();
            System.out.println("\t# A " + enemy.enemyType + " has appeared! #\n");
            // # Skeletron has appeared! #

            while (enemy.health > 0) {
                System.out.println("\tYour HP: " + character.health);
                System.out.println("\tYour MP: " + character.magic);
                System.out.println("\t" + enemy.enemyType + "'s HP: " + enemy.health);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
                System.out.println("\t4. Use magic for a special attack!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    String enemyAttack = enemy.getAttack();
                    String playerAttack = character.getMainAttack();
                    int damageDealt = character.getAttackDamage();
                    int damageTaken = enemy.getAttackDamage();

                    enemy.takeDamage(damageDealt);
                    character.takeDamage(damageTaken);

                    System.out.println(
                            "\t> You " + playerAttack + " the " + enemy.enemyType + " for " + damageDealt + " damage.");
                    System.out.println("\t> The " + enemy.enemyType + " " + enemyAttack + " in retaliation!  You take "
                            + damageTaken + " in damage.");

                    if (character.health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on.");
                        break;
                    }

                } else if (input.equals("2")) {
                    if (character.numHealthPotions > 0) {
                        character.health += character.healthPotionHealAmount;
                        character.numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for "
                                + character.healthPotionHealAmount + ".  " + "\n\t> You now have " + character.health
                                + " HP." + "\n\t> You have " + character.numHealthPotions + " health potions left.\n");
                    } else {
                        System.out.println(
                                "\t> You have no health potions left!  Defeat enemies for a chance to get one!");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + enemy.enemyType + "!");
                    // we want to go to the top of the GAME loop
                    continue GAME;
                } else if (input.equals("4")) {
                    if (character.magic < 10) {
                        System.out.println(
                                "\tYou have exhausted all your magic!  Drink a grog to revive yourself or use a physical attack.");
                    } else {
                        String enemyAttack = enemy.getAttack();
                        String playerAttack = character.getSpecialAttack();
                        int damageDealt = character.getAttackDamage();
                        int damageTaken = enemy.getAttackDamage();

                        enemy.takeDamage(damageDealt);
                        character.takeDamage(damageTaken);

                        System.out.println("\t> You " + playerAttack + " the " + enemy.enemyType + " for " + damageDealt
                                + " damage.");
                        System.out.println("\t> The " + enemy.enemyType + " " + enemyAttack
                                + " in retaliation!  You take " + damageTaken + " in damage.");

                        if (character.health < 1) {
                            System.out.println("\t> You have taken too much damage, you are too weak to go on.");
                            break;
                        }
                    }
                } else {
                    System.out.println("\tInvalid command!");
                }
            }
            // you have died
            if (character.health < 1) {
                System.out.println("The " + enemy.enemyType + " lets out a shrill cry, \"" + enemy.victoryCry
                        + ",\" as you retreat.  Defeated, you limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("----------------------------------------");
            System.out.println(" # The " + enemy.enemyType + " lets out a sad final death rattle, \"" + enemy.deathCry
                    + "\" before falling still.  You were victorious! #");
            System.out.println(" # You have " + character.health + " HP left #");
            System.out.println(" # You have " + character.magic + " MP left #");
            if (rand.nextInt(100) < enemy.healthPotionDropChance) {
                character.numHealthPotions++;
                System.out.println(" # The " + enemy.enemyType + " dropped a health potion! #");
                System.out.println(" # You now have " + character.numHealthPotions + " health potion(s). #");
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
