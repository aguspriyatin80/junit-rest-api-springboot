import com.rest.app.Calculator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;
    @Test
    public void testMultiply(){
        calculator = new Calculator();
        assertEquals(20, calculator.multiply(4,5));
        assertEquals(25, calculator.multiply(5,5));
    }
//    @Test
//    public void testMultiply_DiffParameters(){
//        calculator = new Calculator();
//        assertEquals(25, calculator.multiply(5,5));
//    }
    @Test
    public void testDivide(){
        calculator = new Calculator();
        assertEquals(4, calculator.divide(20,5));
        assertEquals(4, calculator.divide(20,0));
    }
}
