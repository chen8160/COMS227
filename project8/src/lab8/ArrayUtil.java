package lab8;

/**
 * Class containing some utilities for manipulating arrays.
 */
public class ArrayUtil {
	public static void main(String[] args) {
		// try it out
		int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(toString(test));
		reverse(test);
		System.out.println(toString(test));
	}

	/**
	 * Reverses the contents of the given array.
	 * 
	 * @param arr
	 */
	public static void reverse(int[] arr) {
		// exchange arr[0] with arr[length - 1], arr[1]
		// with arr[length - 2], and so on, until we get
		// to the middle of the array
		int front = 0;
		int rear = arr.length - 1;
		while (front < rear) {
			// exchange arr[front] with arr[rear] using a temporary variable
			int temp = arr[front];
			arr[front] = arr[rear];
			arr[rear] = temp;

			// move indices towards the center
			front += 1;
			rear -= 1;
		}
	}

	/**
	 * Returns a string representation of the given array.
	 * 
	 * @param arr
	 * @return
	 */
	public static String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; ++i) {
			if (i > 0) {
				// every element after first one has comma before it
				sb.append(", ");
			}
			sb.append(arr[i]);
		}
		sb.append("]");
		return sb.toString();
	}
}