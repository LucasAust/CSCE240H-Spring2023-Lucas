#ifndef RECTANGLE_H_
#define RECTANGLE_H_
#include "Shape.h"
#include <string>
using namespace std;

class Rectangle : public Shape
{
    double length;
    double width;
    double area;
    double perimiter;
    public:
    Rectangle();
    Rectangle(double,double);
    double getArea(Rectangle rectangle);
    double getPerimiter(Rectangle rectangle);

    virtual ~Rectangle();
};

#endif