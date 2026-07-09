package games;

import java.util.Scanner;
import java.util.Random;

public class DiceRoller {
    public static void main(String[] args){

        //declare variables
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        displayDice(rollDice(random));


    }

    static int rollDice(Random random){
        return random.nextInt(1,7);
    }

    static void displayDice(int dice){
        String dice1 = """
                 -------
                |       |
                |   *   |
                |       |
                 -------

                """;

        String dice2 = """
                 -------
                | *     |
                |       |
                |     * |
                 -------

                """;

        String dice3 = """
                 -------
                | *     |
                |   *   |
                |     * |
                 -------

                """;

        String dice4 = """
                 -------
                | *   * |
                |       |
                | *   * |
                 -------

                """;

        String dice5 = """
                 -------
                | *   * |
                |   *   |
                | *   * |
                 -------

                """;

        String dice6 = """
                 -------
                | *   * |
                | *   * |
                | *   * |
                 -------

                """;

        switch(dice){
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
        }


    }
}
