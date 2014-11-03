package org.nuxeo.test;

import org.junit.Assert;
import org.junit.Test;
import org.nuxeo.ThisIsWhereYouCode;

/**
 * Here are the unit tests that must be verified by the implementation
 * 
 * @author tiry
 *
 */
public class Tester {

    ThisIsWhereYouCode impl = new ThisIsWhereYouCode();
           
    @Test
    public void testExtensions() {
        
        String[] inputs = {"somefile.dat", "movie.torrent", "noextension", ".htaccess", "noext.", null};
        String[] expected = {"dat", "torrent", null , "htaccess", "", null};
        
        for (int i = 0; i < inputs.length; i++) {
            Assert.assertEquals(expected[i], impl.getFileNameExtension(inputs[i]));            
        }       
    }
    
    @Test
    public void testLongestString() {
        
        Object[][] inputs = { new Object[]{"a","ab","abc"} ,
                new Object[]{"abc","ab","a"},
                new Object[]{"big",new Object[]{"ab","a",},"tiny"},
                new Object[]{"big",new Object[]{"ab","a",new Object[]{"superbig","a"}},"tiny"},
                new Object[]{123,23123123,"a"},
                new Object[]{null ,new Object[]{},"a"}
                };
        String[] expected = {"abc", "abc","tiny","superbig", "a", "a"};
                for (int i = 0; i < inputs.length; i++) {
            Assert.assertEquals(expected[i], impl.getLongestString(inputs[i]));            
        }
        
    }
    
    @Test
    public void testArrayEquals() {
        
        Assert.assertTrue(impl.areArraysEquals(new String[]{}, new String[]{}));
        Assert.assertTrue(impl.areArraysEquals(new String[]{"a","b","c"}, new String[]{"a","b","c"}));
        Assert.assertFalse(impl.areArraysEquals(new String[]{"a","b","c"}, new String[]{"ab","", "c"}));
        Assert.assertFalse(impl.areArraysEquals(null, new String[]{}));
        Assert.assertFalse(impl.areArraysEquals(new String[]{"a",null,"b"}, new String[]{"a", "b"}));
        Assert.assertFalse(impl.areArraysEquals(null, new String[]{}));
        Assert.assertTrue(impl.areArraysEquals(null, null));
        
    }
    
    @Test
    public void testCompressor() {
                
        String[] inputs = {"abc", "aaabbc", null, "abccc", "aaaaaaaaaaaaaaabb"};
        String[] expected = {"abc", "3a2bc", null, "ab3c", "15a2b"};
        
        for (int i = 0; i < inputs.length; i++) {
            Assert.assertEquals(expected[i], impl.getCompressedString(inputs[i]));            
        }
        
    }
        
    void dump(String[] array) {
        System.out.print("[");
        for (String d : array) {
            System.out.print(d + ",");
        }
        System.out.println("]");
    }

    @Test
    public void testSorter() {

        String[][] inputs = { new String[]{"a","ab","abc"} ,
                new String[]{"abc","ab","a"},
                new String[]{"abc","aab","abbb"},
                new String[]{"abc","acc","ab"},
                new String[]{"aaaa","aaab","ab"}
        };

        String[][] expected = { new String[]{"a","ab","abc"} ,
                new String[]{"a","ab","abc"},
                new String[]{"aab","abbb","abc"},
                new String[]{"acc","ab","abc"},
                new String[]{"aaab","aaaa","ab"}
        };
              
        for (int i = 0; i < inputs.length; i++) {
            Assert.assertTrue( impl.areArraysEquals(expected[i], impl.getSortedArray(inputs[i])));
        }
        
    }

    
}
