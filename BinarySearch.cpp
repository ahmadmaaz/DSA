#include <iostream>
#include <vector>

using namespace std;

int BinarySearch(vector<int> &nums1, int numberToBeFound) {
    int low = 0;
    int high = nums1.size() -1;
    int mid = (low + high) / 2;
    while (nums1[mid] != numberToBeFound) {
        if (nums1[mid] > numberToBeFound) {
            high = mid - 1;
        } else if (nums1[mid] < numberToBeFound) {
            low = mid + 1;
        }
        if (mid == high) {
            return -1;
        }
        mid = (low + high) / 2;
    }
    return mid;
}


int main() {
    vector<int> numsArr1 = {-1, 0, 1, 2, 3, 4};
    cout << BinarySearch(numsArr1, 9);

    return 0;
}