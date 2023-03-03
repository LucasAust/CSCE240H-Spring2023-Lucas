#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <algorithm>
#include "BaseEmailHeaderType.cpp"
#include "GmailHeaderType.cpp"
#include "OutlookHeaderType.cpp"
using namespace std;
//TO RUN
//This program reads the email header from a text file
//Copy and paste your header into the text file
//Keep your text file in the data folder
//Then, click the play button in the upper right hand corner
//I'm not sure why, but the first time you try to find out information about the header, the while loop runs automatically. Ignore the first 4 lines that get printed out
int main()
{
    string* readFile(string fileName);
    int fileLength(string fileName);
    cout<<"Welcome to the Email Information Extractor!"<<endl;
    cout<<"I will read a message header from your file, and then you can ask me questions about it."<<endl;
    cout<<"Enter the name of the file you would like to read from. The form should be data/filename.txt"<<endl;
    string fileName;
    cin>>fileName;
    cout<<"What type of email header is this? \"outlook\" or \"gmail\"? (The test file is an outlook header.)"<<endl;
    string fileType;
    cin>>fileType;
    transform(fileType.begin(), fileType.end(), fileType.begin(), ::tolower);//switches response to lowercase to avoid capitilization errors
    int length = fileLength(fileName);//calculates fileLength to initialize array
    string* header = new string[length];
    header = readFile(fileName);//initializes the array with all the values
    if(fileType.compare("gmail")==0)
    {
    GmailHeaderType email(header);
    email.getLine(header);
    }
    else if(fileType.compare("outlook")==0)
    {
        OutlookHeaderType email(header);
        email.getLine(header);
    }
    else
    {
        cout<<"Cannot identify header type, exiting program"<<endl;
        exit(0);
    }



}
//Reads the file and returns it in the form of an array
string* readFile(string fileName)
{
    int fileLength(string fileName);
    ifstream myfile(fileName);
    int j = 0;
    int i = 0;
    i = fileLength(fileName);
    if(myfile.is_open())
    {
        string* values = new string[i];
        string line;
        while(getline(myfile,line))
        {
            values[j] = line;
            j++;
        }
        return values;
    }
    else
    {
        cout<<"File not found. exiting the program";
        exit(0);
    }
    return 0;
}
//Reads a file and returns its size
int fileLength(string fileName)
{
    ifstream myfile(fileName);
    if(myfile.is_open())
    {
        int i = 0;
        string line;
        while(getline(myfile, line))//checks if program reached the end of the file
        {
            i++;
        }
        if(i ==0)
        {
            cout<<"THis file has no lines in it. Exiting the file";
            exit(0);
        }
        return i;
    }
    else
    {
        cout<<"File not found. Exiting the program";
        exit(0);
    }
    return 0;
}