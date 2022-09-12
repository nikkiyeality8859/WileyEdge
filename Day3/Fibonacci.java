//Create a program to print Fibonacci series in the given range using the 
//object oriented programming concept.

public class Fibonacci {
	int start;
	int end;
	
	public Fibonacci() {}
	
	public Fibonacci(int start,int end) {
		this.start=start;
		this.end=end;
		
	}
	
	public void printFibonacci() {
		if(this.start<this.end) {
		int a=this.start;
		int b=this.start;
		System.out.print(a+",");
		System.out.print(b+",");
		for(int i=0;i<end-2;i++) {
			int c=a+b;
			System.out.print(c+",");
			a=b;
			b=c;
		}
		}else {
			System.out.println("invalid input");
		}
		
		
	}

	public static void main(String[] args) {
		Fibonacci f1=new Fibonacci(2,5);
		f1.printFibonacci();
		

	}

}
