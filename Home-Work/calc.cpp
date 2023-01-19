//To run program, press run in the top left corner, and click run without debugging. 
//Enter data/input.txt when asked for the file name.


#include <iostream>
#include <fstream>
#include <sstream>
#include <string>


using namespace std;

int main()
{
    int count=0;
    int i1;
    int i2;
    int ans;
    string op;
    string line;
    string s[3] = {"","",""};
    string d[2] = {"",""};
    string file_name;
    cout << "Enter the name of your file, the default will be data/input.txt"<<endl;
    cin>>file_name;
    if(file_name.empty())
    {
        file_name = "data/input.txt";
    }
    ifstream myfile(file_name);
    if(myfile.is_open())
    {
        int i = 0;
        while(getline(myfile,line)){
            s[i]=line;
            i++;
        }
        for (int h=0;h<(sizeof(s)/sizeof(s[0]));h++)
        {
            
            if ((s[h]=="+")||(s[h]=="-")||s[h]=="*"||s[h]=="/")
            {
                op = s[h];
            }
            else
            {
                d[count]=s[h];
                count++;
            }
                
        }
        myfile.close();
        i1 =stoi(d[0]);
        i2 = stoi(d[1]);
        string opString;
        if (op =="+")
        {
            ans = i1+i2;
            opString = "addition";
        }
        else if (op =="-")
        {
            ans = i1-i2;
            opString = "subtraction";
        }
        else if (op =="/")
        {
            ans = i1/i2;
            opString = "division";
        }
        else if (op=="*")
        {
            ans = i1*i2;
            opString = "multiplication";
        }
        else 
        {
            cout <<"Invalid operator"<<endl;
        }

        string out_file_name = "data/output.txt";
        string line;
        ofstream out_myfile(out_file_name);
        if (out_myfile.is_open())
        {
            int out_line2 = ans;
            out_myfile << "The result of "<<opString<<" on "<<i1<<" and "<<i2<<" is below"<<endl;
            out_myfile <<out_line2;
        }
        out_myfile.close();
    }
    else
    {
        cout<<"File not found, please try again."<<endl;
        main();
    }
}