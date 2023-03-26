#include <iostream>
#include <chrono>
//TO RUN THE PROGRAM
//Click the play button on the top right corner
//I did not try to do the string numbers
using namespace std;
int main(){
    float factorial();
    float combination();
    cout<<"Welcome to the factorial fun program."<<endl;
    cout<<"Enter \"1\" to calculate a factorial or \"2\" to calculate a combination."<<endl;
    int resp;
    cin>>resp;
    if(resp ==1)//Calls method based on user response
    {
        cout<<factorial()<<endl;
    }
    else if(resp ==2)
    {
        cout<<combination()<<endl;
    }
    else
    {
        cout<< "Invalid input Exiting the program";
        exit(0);
    }
}
float factorial()//Method to calculate the factorial
{
    cout<<"Enter the integer you would like to calculate the factorial for. If you enter more than one integer it will only calculate the first one."<<endl;
    bool fac = false;
    int fact=-1;
    int ret;
    cin.exceptions(istream::failbit);
    do{
    try{
        cin >>fact;
        cout<< "FactorialFun "<<fact<<endl;
        if(fact==0||fact==1)
        {
            return 1;
        }
        fac = true;
        if(fact<0)
        {
            cout<<"Please enter a valid number. Exiting the program.";
            exit(0);
        }
    }
    catch(ios_base::failure &fail)//This catches if the user inputs anything other than a string
    {
        fac =false;
        cout<<"please enter an integer."<<endl;
        cin.clear();
        string tmp;
        getline(cin, tmp);
    }
    }while(fac==false);
    int i = fact;
    int resp = fact;
    auto start = chrono::steady_clock::now();//Starts count
    while(i>1)
    {
        resp = resp *(i-1);
        i--;
    }
    auto end = chrono::steady_clock::now();//Ends count
    chrono::duration<double> diff_in_seconds = end - start;//Calculates the difference between start and stop
    cout<<"Time for processing: "<< diff_in_seconds.count() << " seconds"<<endl;
    return resp;
}
float combination()//Method to calculate combination
{
cout<<"Enter the integers that you would like to calculate the combination of. Enter the larger number first. If you try to enter more than 2 numbers, it will only calculate the first two."<<endl<<"The program will not continue until you enter 2 integers."<<endl;
bool fac = false;
int n=-1;
int r=-1;
cin.exceptions(istream::failbit);
do{
    try{
        cin >>n;
        cin >>r;
        fac=true;
        cout<< "FactorialFun "<<n<<" "<<r<<endl;
    }
    catch(ios_base::failure &fail)//This catches if the user inputs anything other than a string
    {
        fac =false;
        cout<<"please enter an integer."<<endl;
        cin.clear();
        string tmp;
        getline(cin, tmp);
    }
    }while(fac==false);
    if(r>n)
    {
        cout<<"The first number must be larger than the second. Exiting the program.";
        exit(0);
    }
    if(r<0||n<0)
    {
        cout<<"Please enter valid integers. Exiting the program.";
        exit(0);
    }
    int i = n;
    int num = n;
    auto start = chrono::steady_clock::now();
    while(i>1)//Calculates numerator
    {
        num = num *(i-1);
        i--;
    }
    int j = r;
    int den1 = r;
    while(j>1)//Calculates first half of denominator
    {
        den1 = den1 *(j-1);
        j--;
    }
    int k = n-r;
    int den2 = n-r;
    while(k>1)//Calculates second half of denominator
    {
        den2 = den2 *(k-1);
        k--;
    }
    float den = den1*den2;//Combines denominator
    float resp = num/den;//Divides to find the response
    auto end = chrono::steady_clock::now();
    chrono::duration<double> diff_in_seconds = end - start;
    cout<<"Time for processing: "<< diff_in_seconds.count() << " seconds"<<endl;
    return resp;
}