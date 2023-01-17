#include <iostream>
using namespace std;

#define MAX 100


int main()
{
    int arr[MAX];
    int n,i,j;
    int temp;

    cout<<"Enter total number of numbers: ";
    cin>>n;
if(n<= 0)
{
    cout<<"Invalid range"<<endl;
    main();
}
    for(i=0;i<n;i++)
    {
        cout<<"Enter element ["<<i+1<<"] ";
        cin>>arr[i];
    }
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    cout<<"Sorted array elements: "<<endl;
    for(i=0;i<n;i++)
    cout<<arr[i]<<" ";




}