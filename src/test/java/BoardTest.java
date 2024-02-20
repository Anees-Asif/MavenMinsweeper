import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
public class BoardTest {
private Board board;
    @Before
    public void setUp() {
        board = new Board(4,4,3);
    }

    @Test
    public void boardCreated(){
        Assertions.assertEquals(4,board.getHeight());
        Assertions.assertEquals(4,board.getWidth());
    }

}
