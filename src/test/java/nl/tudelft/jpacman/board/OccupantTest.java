package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isEqualTo(false);
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {

        //Occupying Null square
        Assertions.assertThrows(AssertionError.class, ()->{
            unit.occupy(null);
        });

        //Occupying Normal square
        Square square = new BasicSquare();
        unit.occupy(square);
        assertThat(unit.hasSquare()).isEqualTo(true);
        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square square1 = new BasicSquare();
        Square square2 = new BasicSquare();
        //Reoccupy with same block
        unit.occupy(square1);
        unit.occupy(square1);
        assertThat(unit.hasSquare()).isEqualTo(true);
        assertThat(unit.getSquare()).isEqualTo(square1);
        assertThat(square1.getOccupants()).contains(unit);
        assertThat(square2.getOccupants()).isEmpty();

        //Reoccupy with different block
        unit.occupy(square1);
        unit.occupy(square2);
        assertThat(unit.hasSquare()).isEqualTo(true);
        assertThat(unit.getSquare()).isEqualTo(square2);
        assertThat(square1.getOccupants()).isEmpty();
        assertThat(square2.getOccupants()).contains(unit);
    }
}
