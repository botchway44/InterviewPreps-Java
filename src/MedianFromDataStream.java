

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

	For example, for arr = [2,3,4], the median is 3.
	For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
	Implement the MedianFinder class:
	
	MedianFinder() initializes the MedianFinder object.
	void addNum(int num) adds the integer num from the data stream to the data structure.
	double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
public class MedianFromDataStream {

	PriorityQueue<Integer> leftHeap;
	PriorityQueue<Integer> rightHeap;
	
	public MedianFromDataStream(){
		//Synonymous to right heap
		rightHeap = new PriorityQueue<Integer>();
		
		//Synonymous to left heap
		leftHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
	}
	

    public void addNum(int num) {
    	//always add to minheap
        leftHeap.offer(num);
        
        //Balance the tree if the value just inserted is greater than the value on the right
        if(leftHeap.size() > 0 && rightHeap.size() > 0 && leftHeap.peek() > rightHeap.peek()) {
        	
        	int left = leftHeap.poll();
        	int right = rightHeap.poll();
        	
        	rightHeap.add(left);
        	leftHeap.add(right);
        }
        
        //resize heaps
        int difference =  leftHeap.size() - rightHeap.size();
        if(difference >= 2) {
        	//get the topmost of the min heap and push to the max heap
        	//swap values
        	rightHeap.add(leftHeap.poll());
        }

     
    }
    
    public double findMedian() {
    	int difference = leftHeap.size() - rightHeap.size();
        if(difference >= 1) {
        	//get the topmost of the min heap and push to the max heap
        	return (double) leftHeap.peek()/1.0;
        }
        
		return (leftHeap.peek() + rightHeap.peek())/2.0;
        
    }

    

    @Test
    public void test1() {
        final MedianFromDataStream test = new MedianFromDataStream();

        test.addNum(-1);    // arr = [1]
        test.addNum(-2);    // arr = [1, 2]
        test.addNum(-3);    // arr[1, 2, 3]
        test.addNum(-4);    // arr = [1, 2]
        test.addNum(-5);
        double results = (1+2.0)/2.0;
        
        System.out.println(test.findMedian());
        
        assertSame(2.0, test.findMedian());
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