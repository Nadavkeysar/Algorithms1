package lecture6;
/**
 * Even Odd Algorithm is not optimal almost:
 * compare between sum of elements at even index 
 * and elements at odd index - once
 * assumption - size is even
 * Complexity: O(n)
 * Calculate the sum of all numbers that are odd-numbered.
 * Calculate the sum of all numbers that are even-numbered.
 * The first player can choose the number standing on an even or odd place (where sum is bigger).
 * If the first player chooses the number standing on an even place,
 * the second player can choose the number standing on an odd place and vice versa.
 *
 */
public class OddEvenAlgorithm {
	static public int AliceResult;
	static public int BobResult ;
	static public int array[]; // number's array
	static public int begin; // array's first index
	static public int end; // array's last index
	static public int oddSum; // sum of odd-numbered elements
	static public int evenSum; // sum of even-numbered elements
	//**************************************************************************
	public OddEvenAlgorithm(){
		AliceResult = 0;
		BobResult = 0;
		array = buildArray();
		begin = 0;
		end = array.length - 1;
		oddSum = 0;
		evenSum = 0;
	}
	//**************************************************************************
	static public void gameOddEven() {
		boolean even = true;
		if (evenSum < oddSum)
			even = false;
		int step = 1;
		System.out.println("********** THIS IS A GAME **********");
		printArray();
		System.out.println("************************************");
		while (end > begin) {
			System.out.println("********************************");
			System.out.println("****** step # " + step + " *****");
			System.out.println("********************************");
			//***** First player ( Alice ) choice *****
			printArray();
			if ((even && begin%2 == 0) || (!even && begin %2 != 0)) {
				System.out.println("ALICE: I take the first: "+array[begin]);
				AliceResult = AliceResult + array[begin++];
			}
			else {
				System.out.println("ALICE: I take the last: "+array[end]);
				AliceResult = AliceResult + array[end--];
			}
			//***** Second player ( Bob ) choice *****
			printArray();
			if (array[begin] > array[end]) {
				System.out.println("BOB: I take the first: "+array[begin]);
				BobResult = BobResult + array[begin++];
			}
			else {
				System.out.println("BOB: I take the last: "+array[end]);
				BobResult = BobResult + array[end--];
			}
			step++;
			System.out.println(" -------------------------");
			System.out.println(" Sum - ALICE: " + AliceResult +
					", BOB: " + BobResult);
			System.out.println(" -------------------------");
			System.out.println();
		}
		System.out.println("Congratulations! ALICE = " + AliceResult + ", BOB = " + BobResult);
	}
	//**************************************************************************
	static public void oddEvenAlgorithm() {
		boolean even = true;
		if (evenSum < oddSum)
			even = false;
		while (end > begin) {
			//***** First player ( Alice ) choice *****
			if ((even && begin%2 == 0) || (!even && begin %2 != 0))
				AliceResult = AliceResult + array[begin++];
			else
				AliceResult = AliceResult + array[end--];
			//***** Second player ( Bob ) choice *****
			if (array[begin] > array[end])
				BobResult = BobResult + array[begin++];
			else
				BobResult = BobResult + array[end--];
		}
	}
	//**************************************************************************
	public static void calculateOddEvenSum() {
		for(int i = 0; i < array.length; i = i+2) {
			evenSum = evenSum + array[i];
			oddSum = oddSum + array[i + 1];
		}
	}
	//**************************************************************************
	public static int[] buildArray(){
		int arr[] ={1,3,6,1,3,6};//{5, 20, 10, 1};
		return arr;
	}
	//**************************************************************************
	public static void printArray(){
		System.out.print(" Array : ");
		for(int i = begin; i <= end; i++)
			System.out.print(array[i]+", ");
		System.out.println();
	}
	//**************************************************************************
	public static void main(String[] args) {		
		new OddEvenAlgorithm();
		calculateOddEvenSum();
		gameOddEven();		
		System.out.println("\n\n*****************************************");
		//new OddEvenAlgorithm();		
		//printArray();
		//calculateOddEvenSum();
		//oddEvenAlgorithm();
		//System.out.println("Alice : " + AliceResult + " Bob : " + BobResult);
	}
}

