#include "Shape.h"

Shape::Shape() {
    height = 0;
    width = 0;
    length = 0;
}
Shape::Shape(double length) {
    height = 0;
    width = 0;
    length = length;
}
Shape::Shape(double length, double width){
    length = length;
    width = width;
    height = 0;
}
Shape::Shape(double length, double width, double height){
    length = length;
    width = width;
    height = height;
}
Shape::~Shape()
{

}
double Shape::getArea(double length, double width)
{
    return area;
}
double Shape::getPerimiter(double length, double width, double height)
{
    return perimiter;
}