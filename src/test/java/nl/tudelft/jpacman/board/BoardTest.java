package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    void TestValid(){
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        new Board(grid);
    }

    @Test
    void TestInvalid(){
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;
        Assertions.assertThrows(AssertionError.class, ()-> {new Board(grid);});
//        Board board = new Board(grid);
//        Assertions.assertThrows(AssertionError.class, ()->{board.squareAt(0,0);});
    }
}
