package net.codejava.springmvc;

public class Rectangle extends Shape {

	private double width;
	
	private double height;
	
	public Rectangle()
		{
			
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
			return width * height;
		}

	@Override
	public double perimeter() 
		{
			return width + height;
		}
	
}
