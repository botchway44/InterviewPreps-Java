/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		int[] head = {1,2,3,3,4};
//		int[] head = {1,1,2};

		ListNode ls = createList(head);
		
		

		System.out.println("-----------------------------------------");
		ListNode node = removeDuplicates(ls);

		while(node!= null) {
			System.out.println("Duplicates >> "+ node.val );
			node = node.next;
		}
		
	}

	public static ListNode createList(int[] head){
		ListNode headNode = null;
		for(int i=head.length-1; i>=0; i--) {
			//create a new node 
			ListNode node = new ListNode(head[i]);
			if(headNode == null) {
				headNode = node;
			}else {
				node.next = headNode;
				headNode = node;
			}
			
		}
		return headNode;
	}

	//Optimize this by removing just the pointers and not creating new space
	public static ListNode removeDuplicates(ListNode head) {
		ListNode pointer = head;
		ListNode newHead = null;
		
		while(pointer!= null) {
			
			if(newHead == null) {
				newHead = new ListNode(pointer.val);
			}else {
				ListNode temp = newHead;
				
				while(temp.next != null) {
					temp = temp.next;
				}
				
				temp.next = new ListNode(pointer.val);
			}
			
			if(pointer.next != null && pointer.next.val == pointer.val) {
				if(pointer.next.next != null) pointer = pointer.next.next;
				else pointer = null;
			}else {
				pointer = pointer.next;
			}
			
			
		}
		
		return newHead;
	}
}

 class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }