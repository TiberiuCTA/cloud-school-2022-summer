import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() throws Exception{
        calculator=new Calculator();

    }

    @Test
    @DisplayName("test the addition")
    public void testAdd(){
        assertEquals(20, calculator.add(10, 10));

    }

    @Test
    @DisplayName("test the addition")
    public void testSubstract(){
        assertEquals(5, calculator.substract(15, 10));

    }

    @Test
    @DisplayName("test the addition")
    public void testDivision(){
        assertThrows(ArithmeticException.class, () -> {calculator.divide(20, 0);});
    }

}
