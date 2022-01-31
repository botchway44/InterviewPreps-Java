import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        // combine the sorted arrays into one large sorted array
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int newItemsPos = 0;
        int[] items = new int[myArray.length + alicesArray.length];
        int len = myArray.length > alicesArray.length ? myArray.length : alicesArray.length;
        
        int array1Pos = 0;
        int array2Pos = 0;
        
        for(int i=0; i<len; i++) {
        	//if array 1 position is lessthan array, remove and add to pq
        	if(array1Pos < myArray.length) {
        		pq.add(myArray[array1Pos]);
        		array1Pos++;
        	}
        	
        	//do same for pos 2
        	if(array2Pos < alicesArray.length) {
        		pq.add(alicesArray[array2Pos]);
        		array2Pos++;
        	}
        	
        	//remove from the pq and add to the new array
        	if(!pq.isEmpty()) {
        		items[newItemsPos++] = pq.poll();
        	}
        	else break;
        }
        
        //Make sure nothing is in the pq
        while(!pq.isEmpty()) {
        	items[newItemsPos++] = pq.poll();
        	
        }

        
        return items;
    }


















    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

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