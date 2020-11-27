package project.jenkins.maven;

public class MathUtils {
	public static void main(String args[])
	{
		System.out.println("Hello World!");
	}
	public int add(int a,int b)
	{
		return a+b;
	}
	
	public int substract(int a,int b) {
		return a-b;
	}
	
	public int divide(int a,int b)
	{
		return a/b;
	}
	
	public int multiply(int a,int b) {
		return a*b;
	}
	
	public double computeCircleArea(double radius)
	{
		return Math.PI*radius*radius;
	}
	
	public double computeSquareArea(double side) {
		return side*side;
	}
}
