#include "Triangle.h"

Triangle::Triangle() {
    height =0;
    width = 0;
    length = 0;
}
Triangle::Triangle(double l, double w, double h)
{
    length = l;
    width = w;
    height = h;
}
Triangle::~Triangle()
{

}
string Triangle::getArea()
{
    return "Sorry Cannot calculate the area of the triangle";
}
double Triangle::getPerimiter(Triangle triangle)
{
    try{
        perimiter = triangle.height+triangle.width+triangle.length;
    }
    catch(int test)
    {
        perimiter = -1;
    }
    return perimiter;
}