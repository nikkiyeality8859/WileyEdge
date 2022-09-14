package Day6Assignment;
//5. Write a program to test if the first and last element of the array are same. The length of the 
//array must be greater than 5.
public class CheckElements {
public static boolean checkArray(int[]a) {
	return (a[0]==a[a.length-1]);
}
	public static void main(String[] args) {
		int []array=new int[]{1,3,2,6,5,7,9,4,6,8,9};
		System.out.println(checkArray(array));

	}

}
