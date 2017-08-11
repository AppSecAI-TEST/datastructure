
public class RotateArrays {

	public int arr[] = { 1, 2, 3, 4, 5, 6 };
	
	//612345
	//561234
	//so index increase by 3 positon i.e 1 moved from 0 to 3
	//Also since rotate by 2 last array elments decrease by 2 i.e 5 to 1 and 6 to 0
	//so last 2or 3  i.e 2 or 3  based on rotate by time. since rotate 2or 3 it decrease by 2 or 3 based on rotate time.
	int order = 3;
	int length = arr.length-1;
	RotateArrays() {
		
		int limit = length - order;
		
		
		reverse(arr,0,limit);
		reverse(arr,limit+1,length);
		reverse(arr,0,length);
		
		for (int i = 0; i <=length; i++) {
			System.out.print( arr[i]  + " " );
		}
	}
	
	private void reverse(int arr[],int left,int right){
	 
		while(left<right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
	}

	public static void main(String args[]) {
		new RotateArrays();
	}

}
