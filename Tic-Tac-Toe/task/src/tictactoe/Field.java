package tictactoe;

public class Field {
    private char[][] field = new char[3][3];

    public Field() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';
            }
        }
    }

    public char[][] getField() {
        return field;
    }

    public void setTheMark(Coordinates coordinates, char mark) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        field[(3 - y)][(x - 1)] = mark;
    }

    public void printTheField() {
        String horizontalBorder = "---------";
        System.out.println(horizontalBorder);
        for (char[] line: field) {
            printTheLine(line);
        }
        System.out.println(horizontalBorder);
    }

    private void printTheLine(char[] line) {
        System.out.print("| ");
        for (char ch: line) {
            System.out.print(ch + " ");
        }
        System.out.print("|");
        System.out.print("\n");
    }
}
