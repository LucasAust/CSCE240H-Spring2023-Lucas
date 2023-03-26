#include <iostream>
#include <string>
using namespace std;
int main() {
    float (*fI)(bool operation,float length,float width);
    float fIC(bool operation, float length, float width);
    float fIS(bool operation, float length, float width);
    cout << "What shape would you like to calculate";
    string resp;
    cin>>resp;
    if (resp == "Circle")
    {
        fI = &fIC;
        fI(1,2,2);
    }
    else if( resp == "Square")
    {
        fI = &fIS;
        fI(0,12,12);
    }


}
float fIC(bool op, float length, float width)
{
    cout<<"hello";
}
float fIS(bool op,float length,float width)
{
    cout<<"hi";
}