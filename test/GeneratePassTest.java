/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zabuz
 */
public class GeneratePassTest {
    
    public GeneratePassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of GenPass method, of class GeneratePass.
     */
   
    @Test
    public void testGenSpecial() {
        System.out.println("GenSpecial");
        int q = 0;
        GeneratePass instance = new GeneratePass();
        String expResult = "";
        String result = instance.GenSpecial(q);
        assertEquals(expResult, result);
        System.out.println(result);
    }

    
}
