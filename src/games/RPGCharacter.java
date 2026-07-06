package games;

import java.util.Scanner;

public class RPGCharacter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //basic attributes
        String name;
        int characterType;
        String character;
        int level;
        int hp;
        int maxHp;
        int mp;
        int maxMp;
        int attack;
        int defense;
        int gold = 10;
        boolean alive = true;

        System.out.println("Choose your character type: ");
        System.out.println("1. Knight ");
        System.out.println("2. Mage ");
        System.out.println("3. Archer ");

        characterType = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter your character name: ");
        name = scanner.nextLine();


        if (characterType == 1) {
            character = "Knight";
            level = 1;
            hp = 100;
            maxHp = 100;
            mp = 0;
            maxMp = 0;
            attack = 25;
            defense = 20;
        } else if (characterType == 2) {
            character = "Mage";
            level = 1;
            hp = 50;
            maxHp = 50;
            mp = 40;
            maxMp = 40;
            attack = 10;
            defense = 10;
        } else {
            character = "Archer";
            level = 1;
            hp = 80;
            maxHp = 80;
            mp = 0;
            maxMp = 0;
            attack = 30;
            defense = 15;
        }


        System.out.println("========= Your Character =========");
        System.out.printf("%-10s : %s\n", "name", name);
        System.out.printf("%-10s : %s\n", "class", character);
        System.out.printf("%-10s : %d\n", "level", level);
        System.out.printf("%-10s : %3d/%-3d\n", "HP", hp, maxHp);
        System.out.printf("%-10s : %3d/%-3d\n", "MP", mp, maxMp);
        System.out.printf("%-10s : %d\n", "Attack", attack);
        System.out.printf("%-10s : %d\n", "Defense", defense);
        System.out.printf("%-10s : %d G\n", "Gold", gold);
        System.out.printf("%-10s : %s\n", "Status", alive ? "Alive" : "Dead");

        scanner.close();
    }
}
