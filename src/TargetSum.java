

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
//TargetSum
public class TargetSum {


    public static int targetSum(int[] myArray, int target) {

    	HashMap<HashSet<Integer>,Integer> cache =new  HashMap<>();
    	
    	return targetSumHelper(myArray, 0, 0, target,cache);
    }



    private static int targetSumHelper(int[] array, int currentPosition, int sum, int target,HashMap<HashSet<Integer>,Integer> cache) {
    	

    	if(currentPosition > array.length-1) {
    		//check if target is equal to sum
    		if(sum == target) return 1;
    		else return 0;
    	}
    	
    	 HashSet<Integer> temp = new HashSet<Integer>();
    	 temp.add(array[currentPosition] );
    	 temp.add(sum);
    	 
    	 //implement cache
//    	if(cache.containsKey(temp)) {
//    		
//    	}
    	
    	int pos = targetSumHelper(array,currentPosition+1, sum+array[currentPosition], target, cache);
    	int neg = targetSumHelper(array,currentPosition+1, sum-array[currentPosition], target, cache);
    	
    	return pos+neg;
    }















    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {1,1,1,1,1};
        final int target = 3;
        final int answer = 5;
        final int actual = targetSum(myArray, target);
        assertSame(answer, actual);
    }
//
//    @Test
//    public void firstArrayIsEmptyTest() {
//        final int[] myArray = {};
//        final int[] alicesArray = {1, 2, 3};
//        final int[] expected = {1, 2, 3};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
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