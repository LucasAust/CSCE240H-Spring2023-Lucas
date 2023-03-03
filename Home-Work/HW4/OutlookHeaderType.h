#ifndef OUTLOOKHEADERTYPE_H_
#define OUTLOOKHEADERTYPE_H_
#include "BaseEmailHeaderType.h"
#include <string>
using namespace std;

class OutlookHeaderType : public BaseEmailHeaderType
{
    string* header;
    public:
    OutlookHeaderType();
    OutlookHeaderType(string*);
    string getLine(string*);
    string* getHeader(OutlookHeaderType);
    virtual ~OutlookHeaderType();

};
#endif;