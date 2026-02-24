package oop.labor02;

public class Rectangle
{
    private double length = 10;
    private double width = 6;
    public Rectangle(double l, double w)
    {
        if (l > 0) length = l;
        if (w > 0) width = w;
    }
    public double getLength()
    {
        return length;
    }
    public double getWidth()
    {
        return width;
    }
    public double area()
    {
        return (length * width);
    }
    public double perimeter()
    {
        return (2 * length) + (2 * width);
    }

}
