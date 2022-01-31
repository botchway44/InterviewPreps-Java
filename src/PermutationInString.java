

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
//TargetSum
public class PermutationInString {

	/**
	 *  s1 = ab
	 *  s2 = eidbaooo
	 *  
	 * @param one
	 * @param two
	 * @return
	 */

    public static boolean solution(String one, String two) {

    	//get the length of string one
    	
    	int len = one.length();
    	int position = 0;
    	
    	while(true) {
    		if((position + len) <= two.length()) {
    			
    			String substring = two.substring(position, position+len);
    			System.out.println("Substring "+ substring);
    			if(stringEqual(one,substring)) return true;
    			
    			position+=1;
    		}else {
    			return false;
    		}
    		
    	}
    	    	
    }




    private static boolean stringEqual(String one, String two) {

    	HashMap<Character, Integer> chars = new HashMap<>();
    	
    	int len = one.length();
    	
    	//put all of string one into the hash map and count
    	for(int i=0; i<len; i++) {
    		if(chars.containsKey(one.charAt(i))) {
    			chars.put(one.charAt(i), chars.get(one.charAt(i))+1);
    		}
    		else chars.put(one.charAt(i), 1);

    	}
    	
    	//check if the second string contains all the string in one
    	for(int i=0; i< len; i++) {
    		if(chars.containsKey(two.charAt(i))) {
    			chars.put(two.charAt(i), chars.get(two.charAt(i))-1);
    		}
    		else return false;
    	}
    	
    	//if there are any characters left in string one with a value > 0 || < 0
    	//return false
      	for(Character ch : chars.keySet()) {
      		System.out.println(ch + " == " + chars.get(ch));
    		if(chars.get(ch) >0 || chars.get(ch) <0) {
    			return false;
    		}
    	}
    	return true;
    }





    // tests

    @Test
    public void test1() {
        
        final String one = "ab";
        final String two = "eidbaooo";
        
        final boolean actual = solution(one, two);
        assertSame(true, actual);
    }
    
    @Test
    public void test2() {
        
        final String one = "ab";
        final String two = "eidboaoo";
        
        final boolean actual = solution(one, two);
        assertSame(false, actual);
    }

    @Test
    public void test3() {
        
        final String one = "hello";
        final String two = "ooolleoooleh";
        
        final boolean actual = solution(one, two);
        assertSame(false, actual);
    }
    

//    @Test
//    public void test4() {
//        
//        final String one = "ab";
//        final String two = "ab";
//        
//        final boolean actual = solution(one, two);
//        assertSame(true, actual);
//    }
    
//
//    @Test
//    public void secondArrayIsEmptyTest() {
//        final int[] myArray = {5, 6, 7};
//        final int[] alicesArray = {};
//        final int[] expected = {5, 6, 7};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void bothArraysHaveSomeNumbersTest() {
//        final int[] myArray = {2, 4, 6};
//        final int[] alicesArray = {1, 3, 7};
//        final int[] expected = {1, 2, 3, 4, 6, 7};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void arraysAreDifferentLengthsTest() {
//        final int[] myArray = {2, 4, 6, 8};
//        final int[] alicesArray = {1, 7};
//        final int[] expected = {1, 2, 4, 6, 7, 8};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}