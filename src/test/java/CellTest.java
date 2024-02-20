import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {

    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void testIsMineInitiallyFalse() {
        assertFalse(cell.isMine());
    }

    @Test
    public void testSetMine() {
        cell.setMine(true);
        assertTrue(cell.isMine());
    }

    @Test
    public void testIsRevealedInitiallyFalse() {
        assertFalse(cell.isRevealed());
    }

    @Test
    public void testReveal() {
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    public void testIsFlaggedInitiallyFalse() {
        assertFalse(cell.isFlagged());
    }

    @Test
    public void testToggleFlag() {
        cell.toggleFlag();
        assertTrue(cell.isFlagged());
        cell.toggleFlag();
        assertFalse(cell.isFlagged());
    }

    @Test
    public void testSetNeighboringMines() {
        int mines = 3;
        cell.setNeighboringMines(mines);
        assertEquals(mines, cell.getNeighboringMines());
    }
}
