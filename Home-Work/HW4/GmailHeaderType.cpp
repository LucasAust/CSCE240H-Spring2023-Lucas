#include "GmailHeaderType.h"
#include <iostream>
#include <string>
#include <algorithm>

GmailHeaderType::GmailHeaderType()
{
    header = new string[0];
}
GmailHeaderType::GmailHeaderType(string* h)
{
    header = h;
}
string GmailHeaderType::getLine(string* h)
{
    string resp = "";
    string line = "";
    bool quit = false;
    cout<<"The commands this program runs on are \"received from\", \"from\", \"content type\", \"date\", \"reply to\", \"to\", \"from\", \"message ID\","<<endl <<"\"subject\", \"mime version\", \"content type\", \"content transfer encoding\", \"delivered to\", \"received by\", and \"x-google-smtp-source\"."<<endl;
    while (!quit)
    {
    cout<<"Enter what you want to know about your email header. Or enter quit to exit"<<endl;    
    getline(cin,resp);
    transform(resp.begin(), resp.end(), resp.begin(), ::tolower);
    
    if(resp.find("delivered to") != string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            line = h[i];
            if(line.find("Delivered-To") != string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("received by")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Received: by")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("x-google-smtp-source")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("X-Google-Smtp-Source")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("received from")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Received: from")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("received by")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Received: by")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("from")!= string::npos)
    {
        for(int i = 0;i<1000;i++)
        {
            string line = h[i];
            if(line.find("From:")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("content type")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Content-Type")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("date")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Date: ")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("reply to")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Reply-To:")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("to")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("To: ")!= string::npos && line.find("-")==string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("from")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.compare("From:\*"))
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("message id")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Message-ID:")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("subject")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Subject: ")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("mime version")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Mime-Version")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("content type")!= string::npos)
    {
        for(int i = 0;i<200;i++)
        {
            string line = h[i];
            if(line.find("Content-Type: ")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if(resp.find("content transfer encoding")!= string::npos)
    {
        for(int i = 0;i<1000;i++)
        {
            string line = h[i];
            if(line.find("Content-Transfer-Encoding: ")!= string::npos)
            {
                cout<<line;
                cout<<endl;
                break;
            }
        }
    }
    else if (resp.find("quit")!= string::npos)
    {
        quit = true;
        cout<<"Thank you for using our system";
        exit(0);
    }
    else
    {
        cout<<"Sorry, I dont know that.";
        cout<<endl;
    }
    }

}
string* GmailHeaderType::getHeader(GmailHeaderType type)
{
    return type.header;
}
GmailHeaderType::~GmailHeaderType()
{

}
