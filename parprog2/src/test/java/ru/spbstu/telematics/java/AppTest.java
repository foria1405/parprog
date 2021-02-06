package ru.spbstu.telematics.java;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest 
    extends TestSuite
{
    private MyQueue<Integer> myQueue;
    private Integer first, second;

    @Before
    public void init(){
        myQueue = new MyQueue <Integer>();
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);
    }

    @Test
    public void testElement()
    {
        first = myQueue.element();
        second = myQueue.element();
        Assert.assertTrue("method .element() test failed", first==second);

    }


    @Test
    public void testRemove()
    {
        first = myQueue.remove();
        second = myQueue.remove();
        Assert.assertNotEquals("method .remove() test failed", first, second);

    }

    @Test
    public void testPeek()
    {
        first = myQueue.peek();
        second = myQueue.peek();
        Assert.assertEquals("method .peek() test failed", first, second);

    }

    @Test
    public void testPoll()
    {
        first = myQueue.poll();
        second = myQueue.poll();
        Assert.assertNotEquals("method .poll() test failed", first, second);

    }

}
