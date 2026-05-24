import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DemoTest {

    @Test
    public void testValidTriangle() {
        assertTrue(Demo.isTriangle(3, 4, 5));
    }

    @Test
    public void testEquilateralTriangle() {
        assertTrue(Demo.isTriangle(5, 5, 5));
    }

    @Test
    public void testInvalidTriangleEqualBoundary() {
        assertFalse(Demo.isTriangle(1, 2, 3));
    }

    @Test
    public void testInvalidTriangleTooSmall() {
        assertFalse(Demo.isTriangle(1, 1, 5));
    }

    @Test
    public void testZeroSide() {
        assertFalse(Demo.isTriangle(0, 4, 5));
    }

    @Test
    public void testNegativeSide() {
        assertFalse(Demo.isTriangle(-1, 4, 5));
    }

    @Test
    public void testMainTriangle() {
        String input = "3\n4\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Demo.main(new String[]{});

        assertTrue(output.toString().contains("This is a triangle."));
    }

    @Test
    public void testMainNotTriangle() {
        String input = "1\n2\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Demo.main(new String[]{});

        assertTrue(output.toString().contains("This is not a triangle."));
    }
}


