//
//1. Create a class Circle with following details: 
//Attributes: radius, area
//Methods  : calculateArea
//Create object of circle with given radius and calculate the area. 
//(Use the concept of parameterized constructor, code recommendation and
//this keyword)


public class Circle {
	public double radius;
	public double area;
	public Circle() {
		
	}
	public Circle(double radius) {
		this.radius=radius;
	}
	public double calculateArea() {
		this.area= (Math.PI*radius*radius);
		return area;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Circle circle1=new Circle(12.1);

double area=circle1.calculateArea();
System.out.println("area of the circle :"+ area);
//System.out.println(circle1.radius+" "+circle1.area);
	}

}
