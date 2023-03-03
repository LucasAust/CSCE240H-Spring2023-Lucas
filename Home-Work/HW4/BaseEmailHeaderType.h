#ifndef BASEEMAILHEADERTYPE_H_
#define BASEEMAILHEADERTYPE_H_
#include <string>

using namespace std;

class BaseEmailHeaderType{
    string* header;
    public:
    BaseEmailHeaderType();
    BaseEmailHeaderType(string*);
    string getLine(string*,string);
    string* getHeader(BaseEmailHeaderType);
    virtual ~BaseEmailHeaderType();
};
#endif