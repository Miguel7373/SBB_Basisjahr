package myStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    MyStack<String> stack;
    MyStack<String> emptystack ;

    @BeforeEach
    void Setup(){
        emptystack = new MyStack<>();
        stack = new MyStack<>();
        stack.push("blue");
        stack.push("yellow");
        stack.push("green");
        stack.push("orange");
    }

    @Test
    void testPush() {
        assertEquals("orange", stack.peek());
//        assertEquals(4, stack.size());
//        assertFalse(stack.empty());
    }


    @Test
    void testPop() {
        assertThrows(EmptyStackException.class,()-> emptystack.pop());
        assertEquals("orange", stack.pop());
//        assertEquals("green", stack.peek());
//        assertEquals(3, stack.size());
//        assertFalse(stack.empty());
    }

    @Test
    void testPeek() {
        assertEquals("orange", stack.peek());
        assertThrows(EmptyStackException.class,()-> emptystack.peek());
//        assertEquals(4, stack.size());
//        assertFalse(stack.empty());
    }

    @Test
    void testSize() {
        assertEquals(4, stack.size());
//        assertFalse(stack.empty());
    }

    @Test
    void testEmpty() {
        assertTrue(emptystack.empty());
//        emptystack.push("apple");
//        assertFalse(emptystack.empty());
    }

    @Test
    void testToString() {
        assertEquals("[orange, green, yellow, blue]", stack.toString());
    }
    @Test
    void search(){
        assertEquals(1, stack.search("orange"));
    }
}