#include "Circle.h"

Circle::Circle()
{
    length = 0;
}
Circle::Circle(double l)
{
    length = l;
}
Circle::~Circle()
{

}
double Circle::getArea(Circle circle)
{
    try{
         area = (3.1415)*(circle.length)*(circle.length);
    }
    catch(int test)
    {
        area = -1;
    }
    return area;

}
double Circle::getPerimiter(Circle circle)
{
    try{
        perimiter = (2)*(3.1415)*(circle.length);
    }
    catch(int test)
    {
        area = -1;
    }
    return perimiter;
}