package sample;

public class SingleLinkedList {
	
	private static class SingleList{
		private int data;
		private SingleList value;
		
	
		private SingleList(int data){
			this.data=data;
		}
		
	}
	
	
	
	private  static void display(SingleList display){
		SingleList node =display;
		while(node!=null){
			//System.out.print(node.value);
				System.out.print(node.data +"-->");
			node= node.value;
		}
		
	}
	
	
	private  static SingleList delete(SingleList node,int pos){
		SingleList head =node;
		SingleList previous = null;
		SingleList next = null;
		int count =1;
		while(count <pos){
			count ++;
			previous= head;
			next= head.value;
		}
		System.out.println("SingleLinkedList.delete()"+next.data);

		//display(next.value);
		//display(head.value);

		SingleList afterDelete= previous;//from previous current node
		previous.value = next.value;
		//current.value = null;
		
		return afterDelete;
	}
	
	
	SingleLinkedList(){
	
	}
	
	public static void main(String args[]){
	    SingleList list1  = new SingleList(1);
	    SingleList list2  = new SingleList(2);
	    SingleList list3  = new SingleList(3);
	    SingleList list4  = new SingleList(4);
	    SingleList list5  = new SingleList(5);

	    list1.value = list2;
	    list2.value = list3;
	    list3.value = list4;
	    list4.value = list5;
	    list5.value = null;
	    
	    //System.out.println("SingleLinkedList.main()"+list3.value);
	   //display(list1);
	   list1 = delete(list1,2); 
	   System.out.println();
	   display(list1); 
	    
	}

}
