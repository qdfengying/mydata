import java.util.*;
public class GridSearch {
  public static void main (String [] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String [][] grid = new String[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = in.next();
      }
    }
    int w = in.nextInt();
    String [] wordList = new String[w];
    for (int i = 0; i < w; i++) {
      wordList[i] = in.next();
    }

    for (String word : wordList) {
      System.out.println(countWord(grid, word) + " " + word);
    }

  }


  public static int countWord(String[][] grid, String word) {
    int gridSize = grid.length;
    int wordLength = word.length();
    int counter = 0;

    for (int i = 0; i < gridSize; i++) {
      for (int j = 0; j < gridSize; j++) {
        if (grid[i][j].equals(Character.toString(word.charAt(0)))) {
          for (int r = -1; r <= 1; r++) {
            if (r == -1 && i < wordLength - 1 || r == 1 && i + wordLength > gridSize) {
              continue;
            }
            for (int c = -1; c <= 1; c++) {
              if (c == -1 && j < wordLength - 1 || c == 1 && j + wordLength > gridSize) {
                continue;
              }
              if (r != 0 || c != 0) { 
                boolean match = true;
                int index = 1;
                while (match && index < wordLength) {
                  if (grid[i + index * r][j + index * c].equals(Character.toString(word.charAt(index)))) {
                    index++;
                  } else {
                    match = false;
                  }
                }
                if (match) {
                  counter += 1;
                }
              }
            }
          }
        }
      }
    }
    return counter;
  }
}