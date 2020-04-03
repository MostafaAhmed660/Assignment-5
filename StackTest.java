package eg.edu.alexu.csd.datastructure.stack.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void test1() {
        Stack s = new Stack();
        for (int i = 0 ; i <= 5 ; i++)
            s.push(i);
        //stack will be : 0 1 2 3 4 5

        assertFalse(s.isEmpty());
        assertEquals(5,s.pop());
        //stack will be : 0 1 2 3 4

        assertEquals(4,s.pop());
        //stack will be : 0 1 2 3

        assertEquals(3,s.peek());
        assertEquals(4,s.size());
    }

    @Test
    void test2() {
        Stack s = new Stack();

        assertTrue(s.isEmpty());
        assertEquals(0,s.size());

        try{
            s.pop();
        }
        catch (Exception e){
            //will catch exception because stack is empty
            assertTrue(true);
        }

        try{
            s.peek();
        }
        catch (Exception e){
            //will catch exception because stack is empty
            assertTrue(true);
        }

        s.push(5);
        s.push(10);
        assertEquals(10,s.peek());
        assertEquals(2,s.size());
        //cuz peek don't remove the top element in stack so size won't be changed

        assertFalse(s.isEmpty());
        assertEquals(10,s.pop());
        assertEquals(1,s.size());
        //cuz pop remove the top element in stack so size will increase
    }

}