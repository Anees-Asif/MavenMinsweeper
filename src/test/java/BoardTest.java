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
   public void revealCellRevealsCorrectly() {
        board = new Board(3, 3, 0); // Create a small board with no mines
        board.revealCell(1, 1);

        Assertions.assertTrue(board.getCell(1, 1).isRevealed(), "Cell should be revealed after revealCell call");
    }

}
