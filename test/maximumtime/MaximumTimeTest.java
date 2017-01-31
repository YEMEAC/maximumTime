package maximumtime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yeison Melo <melo.yeison@gmail.com>
 */
public class MaximumTimeTest {
    
    public MaximumTimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class MaximumTime.
     */
    @Test
    public void test1() {
        System.out.println("main");
        String r=MaximumTime.solution(1,2,3,4);
        assertEquals("23:41",r);

    }
    
    @Test
    public void test2() {
        System.out.println("test2");
        String r=MaximumTime.solution(1,8,3,2);
        assertEquals("23:18",r);
    }
    
     @Test
    public void test3() {
        System.out.println("test3");
        String r=MaximumTime.solution(2,4,0,0);
        assertEquals("20:40",r);
    }
    
     @Test
    public void test4() {
        System.out.println("test4");
        String r=MaximumTime.solution(3,0,7,0);
        assertEquals("07:30",r);
    }
    
     @Test
    public void test5() {
        System.out.println("test5");
        String r=MaximumTime.solution(9,1,9,7);
        assertEquals("NOT POSSIBLE",r);
    }
    
}
