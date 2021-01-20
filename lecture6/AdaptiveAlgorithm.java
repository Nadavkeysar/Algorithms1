package lecture6;
/**
 * Even Odd Adaptive Algorithm:
 * compare between sum of elements at even index 
 * and elements at odd index - each step
 * Complexity: O(n)
 * Adaptive strategy is a strategy that is determined in the process of solving the problem,
 * based on the accumulation of new information on the possible results of a solution.
 * The first player strategy: 
 * 	Every step in loop he checks the sums of numbers with even and odd indexes 
 * 	and choose new strategy.
 * 	Strategy:
 * 		if sumEven > sumOdd ->
 * 			take number with even index
 * 		if sumEven < sumOdd ->
 * 			take number with odd index
 */
public class AdaptiveAlgorithm {
	static public int AliceResult;
	static public int BobResult ;
	static public int array[]; // number's array
	static public int begin; // array's first index
	static public int end; // array's last index
	static public int oddSum; // sum of odd-numbered elements
	static public int evenSum; // sum of even-numbered elements
	//**************************************************************************
	public AdaptiveAlgorithm(){
		AliceResult = 0;
		BobResult = 0;
		array = buildArray();
		begin = 0;
		end = array.length - 1;
		oddSum = 0;
		evenSum = 0;
	}
	//**************************************************************************
	static public void gameAdaptive() {
		boolean even = true;
		int step = 1;
		System.out.println("********** THIS IS A GAME **********");
		printArray();
		System.out.println("************************************");
		while (end > begin) {
			even = true;
			if (evenSum < oddSum)
				even = false;
			else if (oddSum == evenSum) {
				if(array[begin] > array[end]) {
					if (begin%2 == 0) even=true;
					else even = false;
				}
				else {//array[begin] <= array[end]
					if (end%2 == 0) even=true;
					else even = false;
				}
			}
			System.out.println("********************************");
			System.out.println("****** step # " + step + " *****");
			System.out.println("********************************");
			System.out.println("****** even # " + even + ", begin # " + begin + ", end # " + end + " *****");
			//***** First player ( Alice ) choice *****
			printArray();
			if ((even && begin%2 == 0) || (!even && begin%2 != 0)) {		
				if (even) evenSum = evenSum - array[begin];			
				else oddSum = oddSum - array[begin];			
				System.out.println("ALICE: I take the first: "+array[begin]);
				AliceResult = AliceResult + array[begin++];
			}
			else {
				if (even) evenSum = evenSum - array[end];			
				else oddSum = oddSum - array[end];			
				System.out.println("ALICE: I take the last: "+array[end]);
				AliceResult = AliceResult + array[end--];
			}
			//***** Second player ( Bob ) choice *****
			printArray();
			if (array[begin] > array[end]) {
				System.out.println("BOB: I take the first: "+array[begin]);
				if (begin%2 == 0)
					evenSum = evenSum -  array[begin];
				else
					oddSum = oddSum -  array[begin];
				BobResult = BobResult + array[begin++];
			}
			else {
				System.out.println("BOB: I take the last: "+array[end]);
				if (end%2 == 0)
					evenSum = evenSum -  array[end];
				else
					oddSum = oddSum -  array[end];
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
	static public void oddEvenAdaptiveAlgorithm() {
		boolean even = true;		
		while (end > begin) {
			even = true;
			if (evenSum < oddSum)
				even = false;
			else if (oddSum == evenSum) {
				if(array[begin] > array[end]) {
					if (begin%2 == 0) even=true;
					else even = false;
				}
				else {//array[begin] <= array[end]
					if (end%2 == 0) even=true;
					else even = false;
				}
			}			
			//***** First player ( Alice ) choice *****			
			if ((even && begin%2 == 0) || (!even && begin%2 != 0)) {		
				if (even) evenSum = evenSum - array[begin];			
				else oddSum = oddSum - array[begin];			
				AliceResult = AliceResult + array[begin++];
			}
			else {
				if (even) evenSum = evenSum - array[end];			
				else oddSum = oddSum - array[end];			
				AliceResult = AliceResult + array[end--];
			}
			//***** Second player ( Bob ) choice *****
			if (array[begin] > array[end]) {
				if (begin%2 == 0)
					evenSum = evenSum -  array[begin];
				else
					oddSum = oddSum -  array[begin];
				BobResult = BobResult + array[begin++];
			}
			else {
				if (end%2 == 0)
					evenSum = evenSum -  array[end];
				else
					oddSum = oddSum -  array[end];
				BobResult = BobResult + array[end--];
			}
		}
	}	
	//**************************************************************************
	public static void calculateOddEvenSum() {
		for(int i = begin; i < end; i = i+2) {
			evenSum = evenSum + array[i];
			oddSum = oddSum + array[i + 1];
		}
	}
	//**************************************************************************
	public static int[] buildArray(){
		//int arr[] = { 6, 9, 1, 2, 16, 12};//ALICE = 23, BOB = 23
		//int []arr = {7, 1, 3, 9, 6, 0, 3, 2, 2, 7};//ALICE = 21, BOB = 19
		int []arr = {1,3,6,1,3,6};//ALICE = 13, BOB = 7
		//int []arr = {6, 0, 2, 7, 4, 4, 1, 3};//ALICE = 14, BOB = 13
		//int arr[] = {5,4,1,5,6,4};//ALICE = 13, BOB = 12
		//int arr[] ={5, 20, 10, 1};//ALICE = 21, BOB = 15
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
		System.out.println("\n\n");
		new AdaptiveAlgorithm();
		calculateOddEvenSum();
		gameAdaptive();
		System.out.println("\n\n*********************************************************************");
		//new AdaptiveAlgorithm();		
		//printArray();
		//calculateOddEvenSum();		
		//oddEvenAdaptiveAlgorithm();
		//System.out.println("Alice: " + AliceResult + " Bob: " + BobResult);
	}

}
