import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
public class BoardTest {
private Board board;
    @Before
    public void setUp() {
        board = new Board(10,10,10);
    }

    @Test
    public void boardCreated(){
        Assertions.assertEquals(10,board.getHeight(), "incorrect board height");
        Assertions.assertEquals(10,board.getWidth(), "incorrect board width");
    }
    @Test
    public void minesAreCorrectlyPlaced() {
        int mineCount = 0;
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                if (board.getCell(y, x).isMine()) {
                    mineCount++;
                }
            }
        }
        Assertions.assertEquals(10, mineCount, "There should be 10 mines on the board");
    }
    @Test
    public void minesAreCorrectlyPlaced2() {

        Assertions.assertEquals(10, board.placeMines(), "There should be 10 mines on the board");
    }

    @Test
    public void neighboringMinesCalculatedCorrectly() {
        board = new Board(3, 3, 0);
        board.getCell(1, 1).setMine(true);
        board.calculateNeighboringMines();

        // Assert neighboring mines count
        Assertions.assertEquals(1, board.getCell(0, 0).getNeighboringMines(), "Cell (0,0) should have 1 neighboring mine");
        Assertions.assertEquals(1, board.getCell(0, 1).getNeighboringMines(), "Cell (0,1) should have 1 neighboring mine");


        // Assert that the cell with the mine itself doesn't count its own mine
        Assertions.assertEquals(0, board.getCell(1, 1).getNeighboringMines(), "Cell with mine should not count itself");
    }
    @Test
   public void revealCellRevealsCorrectly() {
        board = new Board(3, 3, 0); // Create a small board with no mines
        board.revealCell(1, 1);

        Assertions.assertTrue(board.getCell(1, 1).isRevealed(), "Cell should be revealed after revealCell call");
    }

}
