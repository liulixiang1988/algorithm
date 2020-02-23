#include <iostream>

using namespace std;

/*
1. 指定一个中轴
2. 从右往左找，右边赋值给左边
3. 从左往右找，左边赋值给右边
*/
int getIndex(int *arr, int left, int right) {
    int pivot = arr[left];
    while (left < right) {
        while (arr[right] >= pivot && left < right) {
            right--;
        }
        arr[left] = arr[right];
        while (arr[left] <= pivot && left < right) {
            left++;
        }
        arr[right] = arr[left];
    }
    arr[left] = pivot;
    return left;
}

/*
所有判断都要加上left < right
1. 找中轴
2. 左边快排
3. 右边快排
*/
void quickSort(int *arr, int left, int right) {
    if (left < right){
        int index = getIndex(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }
}

int main() {
    int arr[] = {1, -1, 9, 0, -7, 2, -4, 13, 5, 1};
    int len = sizeof(arr)/sizeof(*arr);
    quickSort(arr, 0, len - 1);
    cout << "len: "<< len << endl;
    for (int i = 0; i < len; i++) {
        cout << arr[i]<< " ";
    }
    cout << endl;
    return 0;
}