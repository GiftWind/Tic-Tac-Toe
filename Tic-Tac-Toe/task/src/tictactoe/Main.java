package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        Coordinates currentMove;
        char currentMark;
        String result = "";

        while (true) {
            field.printTheField();
            currentMove = askForTheMove(field.getField(), scanner);
            currentMark = counter % 2 == 0 ? 'X' : 'O';
            field.setTheMark(currentMove, currentMark);
            counter++;
            if (counter > 3) {
                result = Analyzer.analyzeTheGameState(field);
            }
            if (!"".equals(result) && !"Game not finished".equals(result)) {
                field.printTheField();
                System.out.println(result);
                break;
            }
        }
    }

    private static Coordinates askForTheMove(char[][] field, Scanner scanner) {
        while (true) {
            int x = 0;
            int y = 0;
            System.out.print("Enter the coordinates: ");
            String[] userInput = scanner.nextLine().split(" ");
            try {
                x = Integer.parseInt(userInput[0]);
                y = Integer.parseInt(userInput[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (field[3 - y][x - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            return new Coordinates(x, y);
        }
    }



}
