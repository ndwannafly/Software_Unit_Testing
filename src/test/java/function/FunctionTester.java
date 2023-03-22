package function;

import org.junit.jupiter.api.*;
import function.Taylor;
public class FunctionTester {
    private Taylor taylor;
    private double accuracy;
    private double x;
    private double expected;
    private double actual;

    @BeforeEach
    public void setUp(){
        taylor=new Taylor();
        accuracy = 10e-6;
    }

    @Test
    @DisplayName("acos(-1)")
    public void testMethod1() {
        x = -1;
        expected = Math.acos(x);
        actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(0)")
    public void testMethod2() {
        x = 0;
        expected = Math.acos(x);
        actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(1)")
    public void testMethod3() {
        x = 1;
        expected = Math.acos(x);
        actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(-0.5)")
    public void testMethod4() {
        x = -0.5;
        expected = Math.acos(x);
        actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(0.75)")
    public void testMethod5() {
        x = 0.75;
        expected = Math.acos(x);
        actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }

    @Test
    @DisplayName("acos(-5)")
    public void testMethod6() {
        x = -5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> taylor.getAcos(x, accuracy));
    }

    @Test
    @DisplayName("acos(10)")
    public void testMethod7() {
        x = 10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> taylor.getAcos(x, accuracy));
    }

    @Test
    @DisplayName("acos(0.96)")
    public void testMethod8() {
        x = 0.96;
        expected = Math.acos(x);
        actual = taylor.getAcos(x, accuracy);
        Assertions.assertTrue(Math.abs(actual - expected) < accuracy);
    }
}
