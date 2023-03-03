#include "BaseEmailHeaderType.h"
#include <string>

BaseEmailHeaderType::BaseEmailHeaderType() {
    header = new string[0];
}
BaseEmailHeaderType::BaseEmailHeaderType(string* h)
{
    header = h;
}
string BaseEmailHeaderType::getLine(string* h,string value) {
    return "hello";
}
string* BaseEmailHeaderType::getHeader(BaseEmailHeaderType type)
{
    return type.header;
}
BaseEmailHeaderType::~BaseEmailHeaderType()
{
    
}


