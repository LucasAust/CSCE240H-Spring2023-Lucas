#include "Rectangle.h"

Rectangle::Rectangle()
{
    length = 0;
    width = 0;
}
Rectangle::Rectangle(double l,double w)
{
    length = l;
    width = w;
}
 Rectangle::~Rectangle()
{

}
double Rectangle::getArea(Rectangle rectangle)
{
    try{
         area = rectangle.length*rectangle.width;
    }
    catch(int test)
    {
        area = -1;
    }
    return area;
}
double Rectangle::getPerimiter(Rectangle rectangle)
{
    try{
        perimiter = (rectangle.length*2)+(rectangle.width*2);
    }
    catch(double perimiter)
    {
        perimiter = -1;
    }
    return perimiter;
}