package lecture6;
/**
 * Game of numbers
 * There are 2*n numbers in a line:
 * a0, a1, a2, a3, ... , a2n-4, a2n-3, a2n-2, a2n-1
 * Two players take the number one by one
 * from one of the ends of the line until there are no more numbers left.
 * The player with the larger sum of numbers wins.
 */

/**
 * Greedy algorithm:
 * A greedy algorithm is an algorithmic paradigm that follows 
 * the problem solving of making the locally optimal choice 
 * at each stage with the hope of finding a global optimum.
 */
public class GreedyAlgorithm {
	static public int AliceResult;
	static public int BobResult ;
	static public int array[]; // number's array
	static public int begin; // array's first index
	static public int end; // array's last index
	//**************************************************************************
	public GreedyAlgorithm(){
		AliceResult = 0;
		BobResult = 0;
		array = buildArray();
		begin = 0;
		end = array.length - 1;
	}
	//**************************************************************************
	static public void gameGreedy() {
		int step = 1;
		System.out.println("*********** THIS IS A GAME **********");
		printArray();
		System.out.println("*************************************");
		while (end > begin) {
			System.out.println("********************************");
			System.out.println("******* step # " + step + " *******");
			System.out.println("********************************");
			//***** First player ( Alice ) choice *****
			printArray();
			if (array[begin] > array[end]) {
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
	static public void greedyAlgorithm() {
		while (end > begin) {
			//***** First player ( Alice ) choice *****
			if (array[begin] > array[end])
				AliceResult = AliceResult + array[begin++];
			else
				AliceResult = AliceResult + array[end--];
			//***** Second player ( Bob ) choice *****
			if (array[begin] > array[end])
				BobResult = BobResult + array[begin++];
			else
				BobResult = BobResult + array[end--];
			System.out.println(" Sum - ALICE: " + AliceResult +
					", BOB: " + BobResult);
		}
	}
	//**************************************************************************
	public static int[] buildArray(){
		int arr[] = {5, 20, 10, 1};//{ 6, 9, 1, 2, 16, 12};
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
		
		new GreedyAlgorithm();
		//greedyAlgorithm();
		gameGreedy();
		System.out.println("\n\n*******************************************");
	}


}
