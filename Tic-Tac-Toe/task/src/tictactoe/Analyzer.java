package tictactoe;

public class Analyzer {
    public static String analyzeTheGameState(Field f) {
        char[][] field = f.getField();
        int xs = 0;
        int os = 0;
        boolean xWins;
        boolean oWins;
        String notFinished = "";
        String impossible = "";
        String draw = "";
        String winnerIsX = "";
        String winnerIsO = "";
        for (char[] line: field) {
            for (char ch: line) {
                if (ch == 'X') {
                    xs++;
                } else if (ch == 'O') {
                    os++;
                }
            }
        }
        xWins = markWins(field, 'X');
        oWins = markWins(field, 'O');
        impossible = (Math.abs(xs - os ) > 1 || (xWins && oWins)) ? "Impossible" : "";
        int fields = field.length * field.length;
        notFinished = (!xWins && !oWins && (fields - xs - os > 0)) ? "Game not finished" : "";
        draw = (!xWins && !oWins && (xs + os == fields)) ? "Draw" : "";
        winnerIsX = (xWins && !oWins) ? "X wins" : "";
        winnerIsO = (!xWins && oWins) ? "O wins" : "";
        String[] states = new String[] {impossible, notFinished, draw, winnerIsO, winnerIsX};
        for (String s: states) {
            if (!"".equals(s)) {
                return s;
            }
        }
        return "";
    }

    private static boolean markWins(char[][] field, char mark) {
        return threeInDiagonal(field,mark) || threeInColumn(field, mark) || threeInRow(field, mark);
    }

    private static boolean threeInDiagonal(char[][] field, char x) {
        if (field[0][0] == x && field[1][1] == x && field [2][2] == x) {
            return true;
        } else if (field[0][2] == x && field[1][1] == x && field [2][0] == x) {
            return true;
        }
        return false;
    }

    private static boolean threeInColumn(char[][] field, char x) {
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == x && field[1][i] == x && field [2][i] == x) {
                return true;
            }
        }
        return false;
    }

    private static boolean threeInRow(char[][] field, char x) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == x && field[i][1] == x && field [i][2] == x) {
                return true;
            }
        }
        return false;
    }
}
