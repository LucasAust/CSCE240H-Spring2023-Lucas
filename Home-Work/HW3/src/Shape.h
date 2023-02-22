#ifndef SHAPE_H_
#define SHAPE_H_

using namespace std;

class Shape {
    double length;
    double width;
    double height;
    double area;
    double perimiter;
    public:
    Shape();
    Shape(double);
    Shape(double,double);
    Shape(double,double,double);
    double getArea(double, double);
    double getPerimiter(double,double,double);

    virtual ~Shape();
     

};




#endif