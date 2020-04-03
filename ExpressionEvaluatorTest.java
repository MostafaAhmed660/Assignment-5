package eg.edu.alexu.csd.datastructure.stack.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    @Test
    void test1() {
        ExpressionEvaluator s = new ExpressionEvaluator();

        //if we want to infixToPostfix expression : "5----------------5"
        //function be default will make any form as simple form as can
        // so "5----------------5" will be  "5 + 5"
        //so out put will be "5 5 + "
        assertEquals("5 5 + ",s.infixToPostfix("5----------------5"));

        //"13*-15" in this case we will use duumy zero to avoid errors from -ve integers
        //by dummy zero it should be "13 0 15 - * "
        assertEquals("13 0 15 - * ",s.infixToPostfix("13*-15"));
        assertEquals("13 0 15 - / ",s.infixToPostfix("13/-15"));


        assertEquals("2 3 4 * + ",s.infixToPostfix("2 + 3 * 4"));

        assertEquals("a b * 5 + ",s.infixToPostfix("a * b + 5 "));

        assertEquals("1 2 + 7 * ",s.infixToPostfix("(1 + 2) * 7"));

        assertEquals("a b * c / ",s.infixToPostfix("a * b / c"));

        assertEquals("a b c - d + / e a - * c * ",s.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));

        assertEquals("a b / c - d e * + a c * - ",s.infixToPostfix("a / b - c + d * e - a * c "));

        assertEquals("a b c + * d * ",s.infixToPostfix("a * (b + c) * d"));
    }

    @Test
    void test2() {
        ExpressionEvaluator s = new ExpressionEvaluator();

        assertEquals("invalid expression",s.infixToPostfix("55 66 5"));
        // if number of "operations + 1" don't equal "number of operators" will return "invalid expession"

        assertEquals("invalid expression",s.infixToPostfix("55"));
        //one operator without operation

        assertEquals("invalid expression",s.infixToPostfix("15*/6"));
        assertEquals("invalid expression",s.infixToPostfix("15//6"));
        assertEquals("invalid expression",s.infixToPostfix("1 + ( 5 + 3"));


        assertEquals("Invalid expression having speacial characters",s.infixToPostfix("15 * 5 / #"));
        assertEquals("Invalid expression having speacial characters",s.infixToPostfix("$$ * 5 / 6"));

        try {
            s.evaluate("15 0 /");
        }catch (Exception e){
            assertTrue(true);
            //will catch exception because divide on zero
        }

        try {
            s.evaluate("15 1 5 +");
        }catch (Exception e){
            assertTrue(true);
            //will catch exception because number of operators != number of operations + 1
        }

        try {
            s.evaluate("15 $ 5 +");
        }catch (Exception e){
            assertTrue(true);
            //will catch exception because have special characters
        }

        assertEquals(0,s.evaluate("0 15 - 0 *"));
        assertEquals(90,s.evaluate("0 15 - 0 6 - *"));
        assertEquals(8,s.evaluate("6 2 / 3 - 4 2 * +"));

    }

    @Test
    void test3() {
        ExpressionEvaluator s = new ExpressionEvaluator();
        String str = new String("");

        str = s.infixToPostfix("-15 * 3 / 3");
        assertEquals(-15,s.evaluate(str));

        str = s.infixToPostfix("3 * 7 / 21");
        assertEquals(1,s.evaluate(str));

        str = s.infixToPostfix("8 * 6 / 4");
        assertEquals(12,s.evaluate(str));

        str = s.infixToPostfix("(-12 * 2 / 6) * 2");
        assertEquals(-8,s.evaluate(str));

        str = s.infixToPostfix("( 100 - 1 ) / 9 ");
        assertEquals(11,s.evaluate(str));

        str = s.infixToPostfix("( ( 9 + 1 ) * 2 ) / 4");
        assertEquals(5,s.evaluate(str));
    }
}