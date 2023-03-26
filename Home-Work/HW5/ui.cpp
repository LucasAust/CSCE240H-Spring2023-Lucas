#include <iostream>
#include <fstream>
#include <stdio.h>
#include <vector>
using namespace std;
void demoVector() {
cout << "\n*** DEMO of vector ***\n\n";
	// Credit: Adapted from https://www.geeksforgeeks.org/vector-in-cpp-stl/

    vector<int> g1;
    
    for (int i = 0; i < 6; i++) {
        g1.push_back(i+1);
    	g1.at(i) = i* 10;
    }
  
    cout << "Size : " << g1.size();
    cout << "\nCapacity : " << g1.capacity();
    cout << "\nMax_Size : " << g1.max_size();
  
    // resizes the vector size to 4
    g1.resize(4);
  
    // prints the vector size after resize()
    cout << "\nSize : " << g1.size();
    
    // print the value of vector elements
    cout << "\nVector contents:" << endl;
    for (int i = 0; i < 4; i++) {
    	cout << "\t" << i << " - " << g1[i] << endl;
    }
    
    // Try accessing outside -- print the value of vector elements
    cout << "\nVector out-of-range access:" << endl;
    cout << "\t" << 4 << " - " << g1[4] << endl;
    cout << "\t" << 5 << " - " << g1[5] << endl;    
    
    // Shrinks the vector
	cout << "\n*** Shrinking the value ***\n\n";

    g1.shrink_to_fit();
    
    cout << "Size : " << g1.size();
    cout << "\nCapacity : " << g1.capacity();
    cout << "\nMax_Size : " << g1.max_size();
    
    cout << "\nVector elements are: ";
    for (auto it = g1.begin(); it != g1.end(); it++)
        cout << *it << " ";
    cout<<g1.at(4);
    cout<<g1.at(5);

    }
