import java.util.Comparator;
import java.util.PriorityQueue;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1};
		System.out.println(houseRobber(nums));
	}
	
	
	public static int houseRobber(int[] houses) {
		PriorityQueue<Integer> monies = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		
		
		if(houses.length ==1) {
			return houses[0];
		}else {
			houseRobberHelper(houses,0,0,monies);
			houseRobberHelper(houses,1,0,monies);

		}
		
		return monies.peek();
	}
	
	public static void houseRobberHelper(int[] houses,int position,int amount,PriorityQueue<Integer> monies) {
		System.out.println("Position >> "+position);

		if(position >= houses.length) {
			monies.add(amount);
			
			System.out.println("Accumulated >> "+amount);
		}else {
		
			int currentValue  = houses[position];
			//total amount
			amount = amount + currentValue;
			position +=2;
			houseRobberHelper(houses,position, amount, monies);
		}
	}

	

}
