package lab11;

public class Cp2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[]{4,6,1,4,7,3,6,9};
		System.out.println(findMax(a));
	}

	public static int findMax(int[] ints){
		return helper(ints, 0, ints.length - 1);
	}
	
	private static int helper(int[] ints, int start, int end){
		if(start == end){
			return ints[start];
		} else{
			int mid = (start + end) / 2;
			int leftMax = helper(ints, start, mid);
			int rightMax = helper(ints, mid + 1, end);
			return Math.max(leftMax, rightMax);
		}
	}
}
