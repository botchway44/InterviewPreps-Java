import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.PriorityQueue;
//TargetSum
public class ClimbingStairs {


    public static int targetSum(int target) {

    	return targetSumHelper(0, target);
    }



    private static int targetSumHelper(int sum, int target) {
    	

		if(sum == target) return 1;
		else if(sum > target) return 0;
    		
    	return targetSumHelper(sum+1, target) + targetSumHelper(sum+2, target);
    }















    // tests

    @Test
    public void TestTwo() {
        final int target = 2;
        final int answer = 2;
        final int actual = targetSum(target);
        assertSame(answer, actual);
    }
    
    @Test
    public void TestThree() {
        final int target =3 ;
        final int answer = 3;
        final int actual = targetSum(target);
        assertSame(answer, actual);
    }

    @Test
    public void TestFive() {
        final int target = 5;
        final int answer = 8;
        final int actual = targetSum(target);
        assertSame(answer, actual);
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