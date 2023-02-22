#include <iostream>
#include <sstream>
#include <fstream>
#include <cctype>
#include <string.h>
#include <algorithm>
#include "Shape.cpp"
#include "Rectangle.cpp"
#include "Circle.cpp"
#include "Triangle.cpp"

//TO RUN THE PROGRAM
//Press the play button in the top right 
//Keep your data in the data folder 
//output will appear in output.txt in the output folder

using namespace std;

int main()
{
    int readFile(string fileName);
    cout<<"Welcome to the Geometric Property Calculator!"<<endl;
    cout<<"Enter the file you would like to read from"<<endl;
    string fileName;
    cin>>fileName;
    readFile(fileName);
}
int readFile(string fileName)
{
    int calculate(string value);
    int shape(string value);
    ifstream myfile(fileName);
    if(myfile.is_open())
    {
        int i = 0;
        string line;
        string values[10];
        while(getline(myfile,line))
        {
            values[i]=line;
            i++;
        }
        if (i ==0)
        {
            cout <<"This file has no lines in it. Exiting the program"<<endl;
            exit(0);
        }
        for(int j =0;j<i;j++)
        {
        calculate(values[j]);
        }
       
    }
    else
    {
        cout<<"File not found. exiting the program";
        exit(0);
    }
    return 0;
}
int calculate(string value)
{
    string print = "";
        int writeFile(string print);
        string shapeLine = value;
        string delim = " ";
        string shape = shapeLine.substr(0,shapeLine.find(delim));//Splits string into 1 part for the shape and 1 for the values
        string values = shapeLine.substr(shapeLine.find(delim)+1);//String that holds the values
        for (char c: values)
        {
            if(isalpha(c))//This function checks to see if any alphabetic characters are in the string, if there are then the format would be bad
            {
                cout<<"Invalid format detected. Exiting program.";
                exit(0);
            }
        }
        transform(shape.begin(), shape.end(), shape.begin(), ::tolower);//This makes the string lowercase to avoid capitilization errors
        if(shape.compare("triangle")==0)//compare returns 0 if the two strings are the same
        {
            if (values.length()==5)
            {  
                double length = stod(values.substr(0,values.find(delim)));
                values = values.substr(values.find(delim)+1);
                double width = stod(values.substr(0,values.find(delim)));
                double height = stod(values.substr(values.find(delim)+1));
                Triangle test(length,width,height);
                cout<<"Enter 1 to calculate the area, or 2 to calculate the perimiter of the "+shape<<endl;
                int val1=0;
                cin>>val1;
                if(val1 ==1)
                {
                     print = test.getArea();
                }
                else if(val1==2)
                {
                     print = to_string(test.getPerimiter(test));
                }
                else
                {
                    cout<<"Invalid response, exiting the program."<<endl;
                    exit(0);
                }
                
                
            }
            else
            {
                print = "Invalid format for the "+shape;
            }
        }
        else if(shape.compare("rectangle")==0)
        {
            if(values.length()==3)
            {
                
                double length = stod(values.substr(0,values.find(delim)));
                values = values.substr(values.find(delim)+1);
                double width = stod(values.substr(values.find(delim)+1));
                Rectangle test(length,width);
                cout<<endl;
                cout<<"Enter 1 to calculate the area, or 2 to calculate the perimiter of the "+shape<<endl;
                int val2 = 0;
                cin>>val2;
                if(val2 ==1)
                {
                    double area = test.getArea(test);
                    print = "The area of the rectangle is "+to_string(area);
                     
                }
                else if(val2==2)
                {
                    print = to_string(test.getPerimiter(test));
                }
                else
                {
                    cout<<"Invalid response. Exiting the program."<<endl;
                    exit(0);
                }
            }
            else
            {
                print = "Invalid format for the "+shape;
            }
            
        }
        else if(shape.compare("circle")==0)
        {
            if(values.length() ==1)
            {
                double length = stod(values);
                Circle circle(length);
                cout<<endl;
                cout<<"Enter 1 to calculate the area, or 2 to calculate the perimiter of the "+shape<<endl;
                int val=0;
                cin>>val;
                if(val ==1)
                {
                    print = to_string(circle.getArea(circle));
                }
                else if(val==2)
                {
                    print = to_string(circle.getPerimiter(circle));
                }
                else
                {
                    cout<<"Invalid Response. Exiting the program."<<endl;
                    exit(0);
                }
            }
            else
            {
                print = "Invalid format for the "+shape;
            }
            
        }
        else
        {
            cout<<"Make sure you have entered a valid shape, and your file is formatted correctly. Exiting the program"<<endl;
            exit(0);
        }
        writeFile(print);
}
int writeFile(string print)
{
    string out_file_name = "output.txt";
    string line;
    ofstream out_myfile(out_file_name,ios::app);
    if (out_myfile.is_open())
    {
        out_myfile << print<<endl;
    }
    out_myfile.close();
    return 0;
}
