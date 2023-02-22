#ifndef CIRCLE_H_
#define CIRCLE_H_
#include "Shape.h"
using namespace std;

class Circle : public Shape
{
    double length;
    double area;
    double perimiter;
    public:
    Circle();
    Circle(double);
    double getArea(Circle circle);
    double getPerimiter(Circle circle);

    virtual ~Circle();
};
#endif