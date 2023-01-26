//TO RUN PROGRAM
//Press the play button in the top right corner
//If the terminal switches to the debug console tab, just click back
//Delete the output folder after each test



#include <iostream>
#include <string.h>
#include <sstream>
#include <fstream>
#include <algorithm>

int j =0;
using namespace std;
//Main method
int main(){
    int readFile (string fileName);
    cout << "Welcome to the geometric calculator"<<endl;
    cout << "Enter the name of the file you would like to read. The default file will be data/input.txt"<<endl;
    string fileName;
    cin >>  fileName;
    if (fileName.empty())
    {
        fileName = "data/input.txt";
    }
    readFile(fileName);
    cout<<"Thank you for using the calculator.";
}

//Method to read the file into an array
int readFile(string fileName)
{
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
            cout <<"This file has no lines in it. Restarting the program."<<endl;
            main();
        }
        for(int j =0;j<i;j++)
        {
        shape(values[j]);
        }
    }
    else
    {
        cout<<"File Not found. Restarting the program."<<endl;
        main();
    }
    myfile.close();
    return 0;
}

//Method to figure out what shape is being calculated
int shape(string value)
{
    int triangleCalc(string line);
    int rectCalc(string line);
    int circCalc(string line);
    string line = value;
    string delim = " ";
    string shape = line.substr(0,line.find(delim));
    string vals = line.substr(line.find(delim)+1);
    transform(shape.begin(), shape.end(), shape.begin(), ::tolower);
    if (shape.compare("triangle")==0)
    {
        triangleCalc(vals);
    }
    else if (shape.compare("rectangle")==0)
    {
        rectCalc(vals);
    }
    else if (shape.compare("circle")==0)
    {
        circCalc(vals);
    }
    else
    {
        cout<<"Shape not recognized.";
        return 0;
    }
    return 0;
}

//Method to check area and rectangle of a triangle
int triangleCalc(string line)
{
    cout<<"Triangle:"<<endl;
    if(line.length()<5)
    {
        cout<<"Not enough information to calculate."<<endl;
        return 0;
    }
    int writeFile(string print);
    int val1=-1;
    int val2=-1;
    int val3=-1;
    string delim = " ";
    val1 = stoi(line.substr(0,line.find(delim)));
    line = line.substr(line.find(delim)+1);
    val2 = stoi(line.substr(0,line.find(delim)));
    val3 = stoi(line.substr(line.find(delim)+1,line.find(delim)+2));
    if((val1<=0)||(val2<=0)||(val3<=0))
    {
        cout<<"Please enter valid numbers for the triangle.";
        return 0;
    }
    bool check = true;
    while(check==true)
    {
        cout<<"Enter 1 for area or 2 for perimiter"<<endl;
        int resp;
        cin>>resp;
        if(resp ==1)
        {
            check =false;
            cout<<"Sorry, I cannot check the area of a triangle.";
            return 0;
        }
        else if(resp ==2)
        {
            int per = val1+val2+val3;
            string per1 = to_string(per);
            string  perim = "Triangle perimiter: "+per1;
            writeFile(perim);
            check = false;
        }       
        else
        {
            cout<<"Invalid response try again"<<endl;
            check = true;
        }
    }
    return 0;
}

//Method to calculate area and perimiter of a rectangle
int rectCalc(string line)
{
    cout<<"Rectangle: "<<endl;
    if(line.length()<3)
    {
        cout<<"Not enough information to calculate."<<endl;
        return 0;
    }
    int writeFile(string print);  
    int val1=-1;
    int val2=-1;
    string delim = " ";
    val1 = stoi(line.substr(0,line.find(delim)));
    line = line.substr(line.find(delim)+1);
    val2 = stoi(line.substr(line.find(delim)+1,line.find(delim)+2));
    if((val1<=0)||(val2<=0))
    {
        cout<<"Please enter valid numbers for the rectangle.";
        return 0;
    }
    bool check = true;
    while(check==true)
    {
        cout<<"Enter 1 for area or 2 for perimiter"<<endl;
        int resp;
        cin>>resp;
        if(resp ==1)
        {
            check =false;
            int ar = (val1*val2);
            string ar1 = to_string(ar);
            string area = "Rectangle area: "+ar;
            writeFile(area);
        }
        else if(resp ==2)
        {
            check = false;
            int per = val1+val2+val1+val2;
            string per1 = to_string(per);
            string  perim = "Square perimiter: "+per;
            writeFile(perim);
        }
        else
        {
            cout<<"Invalid response try again";
            check == true;
        }
    }
    return 0;
}

//Method to calculate area and perimiter of a circle
int circCalc(string line)
{
    cout<<"Circle: "<<endl;
    if(line.length()<1)
    {
        cout<<"Not enough information to calculate"<<endl;
        return 0;
    }
    int writeFile(string print);
    int val1;
    val1 = stoi(line.substr(0,1));
    if((val1<=0))
    {
        cout<<"Not enough valid information for the circle.";
        return 0;
    }
    double pi = 3.14;
    bool check = true;
    while(check==true)
    {
        cout<<"Enter 1 for area or 2 for perimiter"<<endl;
        int resp;
        cin>>resp;
        if(resp ==1)
        {
            check =false;
            double ar = val1*val1*pi;
            string ar1 = to_string(ar);
            string area = "Circle area: "+(ar1);
            writeFile(area);
        }
        else if(resp ==2)
        {
            check = false;
            double per = val1*2*pi;
            string per1 = to_string(per);
            string  perim = "Circle perimiter: "+per1;
            writeFile(perim);
        }
        else
        {
            cout<<"Invalid response try again";
            check == true;
        }
    }
    return 0;
}
//Method to append each line to the file
int writeFile(string print)
{
    string out_file_name = "data/output.txt";
    string line;
    ofstream out_myfile(out_file_name,ios::app);
    if (out_myfile.is_open())
    {
        out_myfile << print<<endl;
    }
    out_myfile.close();
    return 0;
}