#ifndef TRIANGLE_H_
#define TRIANGLE_H_
#include "Shape.h"
#include <string>
using namespace std;

class Triangle : public Shape {
double length;
double width;
double height;
double area;
double perimiter;

public:
Triangle();
Triangle(double,double,double);
string getArea();
double getPerimiter(Triangle triangle);

virtual ~Triangle();
};

#endif