import java.util.Arrays;

public class Sample {

	private static int[] insertionsort(int arr[],int k) {
		int size = arr.length-1;
		
		int result[] = new int[size+1];
		
		int j=size;
		for (int i = size; i>=0 ; i--) {
			int diff= i-k;
			j= diff<0 ?(-1)*diff+k:diff; 
			//System.out.println("Sample.insertionsort()"+diff +" i:"+i  +"j"+j);

			/*4-2 2
			3-2 1
			2-2 0
			1-2 3
			0-2 5*/
			
			result[i]=  arr[j];
			
		}

		return result;
	}


	private static void printArr(int arr[]) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			System.out.println("index:"+i +" value:"+arr[i]);
		}

	}

	public static void main(String args[]) {
		Sample sample = new Sample();
		int a[] = new int[5];
		a[4] = 5;
		a[3] = 4;
		a[2] = 3;
		a[1] = 2;
		a[0] = 1;
		Arrays.sort(a);
		printArr(a);
		int result[] = insertionsort(a,2);
		System.out.println("After Sorted");
		System.out.println();
		printArr(result);
	}

}
