#include <iostream>
#include <algorithm>
using namespace  std;

void selectionSort(int arr[],int n){
    for (int i=0; i<n-1;i++){
        int minIndex=i;
        for (int j=i+1; j<n;j++){
            if (arr[minIndex]>arr[j]){
                minIndex=j;
            }
        }
        if (minIndex!=i){
            swap(arr[i],arr[minIndex]);
        }
    }
}
int main(){
    int  numbers[]={7,23,5,3,2};
    selectionSort(numbers,5);
    for ( int i :numbers){
        cout << i << " ";
    }
    return 0;
}



