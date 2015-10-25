package net.codejava.springmvc;

public class Circle extends Shape {

	private double width;
	
	private double height;
	
	public Circle(double radius)
		{
			this.width = radius;
			this.height = radius;
		}

	public double getWidth() 
		{
			return width;
		}

	public void setWidth(double width) 
		{
			this.width = width;
		}

	public double getHeight() 
		{
			return height;
		}

	public void setHeight(double height) 
		{
			this.height = height;
		}
	
	public double square()
		{
			return width + height;
		}

	@Override
	public double perimeter() 
		{
			return width + height - 10;
		}
	
}
