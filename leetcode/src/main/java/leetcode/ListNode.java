package leetcode;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public String toString(){
		return val+(next==null?"":"->"+next);
	}
	
	public static ListNode build(int[] array){
		ListNode head = null;
		ListNode pre = null;
		for(int i=0;i<array.length;i++){
			if(i==0){
				pre = new ListNode(array[i]);
				head=pre;
			}else{
				pre.next=new ListNode(array[i]);
				pre=pre.next;
			}
		}
		return head;
	}
	
}
