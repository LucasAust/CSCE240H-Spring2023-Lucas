#ifndef GMAILHEADERTYPE_H_
#define GMAILHEADERTYPE_H_
#include "BaseEmailHeaderType.h"
#include <string>
using namespace std;

class GmailHeaderType : public BaseEmailHeaderType
{
    string* header;
    public:
    GmailHeaderType();
    GmailHeaderType(string*);
    string getLine(string*);
    string* getHeader(GmailHeaderType);
    virtual ~GmailHeaderType();
};
#endif