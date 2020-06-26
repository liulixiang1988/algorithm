#include <studio.h>

#define MAX_LEN 1000

void build_tree(int arr[], int tree[], int node, int start, int end) {
    if (start == end) {
        tree[node] = arr[start];
        return;
    }
    int mid = (start + end) / 2;
    int left_node = node * 2 + 1;
    int right_node = node * 2 + 2;
    build_tree(arr, tree, left_node, start, mid);
    build_tree(arr, tree, right_node, mid+1, end);
    tree[node]=tree[left_node] + tree[right_node];
}

void update_tree(int arr[], int tree[], int node, int start, int end, int idx, int val) {
    if (start == end) {
        arr[idx] = val;
        tree[node] = val;
        return;
    }
    int mid = (start + end) / 2;
    int left_node = node * 2 + 1;
    int right_node = node * 2 + 2;
    if (idx >= start && idx <= mid) {
        update_tree(arr, tree, left_node, start, mid, idx, val);
    } else {
        update_tree(arr, tree, right_node, mid + 1, end, idx, val);
    }
    tree[node] = tree[left_node] + tree[right_node];
}

int query_tree(int arr[], int tree[], int node, int start, int end, int L, int R) {
    if (R < start || L > end) {
        return 0;
    }
    if (start == end) {
        return tree[node];
    }
    if (start >= L && end <= R) {
        return tree[node];
    }
    int mid = (start + end) / 2;
    int left_node = node * 2 + 1;
    int right_node = node * 2 + 2;
    int sum_left = query_tree(arr, tree, left_node, start, mid, L, R);
    int sum_right = query_tree(arr, tree, node, right_node, mid+1, end, L, R);
    return sum_left + sum_right;
}
int main() {
    int arr[] = {1, 3, 5, 7, 9, 11};
    int size = 6;
    int tree[MAX_LEN] = {0};
    build_tree(arr, tree, 0, size-1);
    for (int i = 0;  i < 15; i++) {
        printf("tree[%d]=%d\n", i, tree[i]);
    }

    printf("\n");
    update_tree(arr, tree, 0, 0, size-1, 4, 6);
    for (int i = 0;  i < 15; i++) {
        printf("tree[%d]=%d\n", i, tree[i]);
    }
    int sum = query_tree(arr, tree, 0, 0, size-1, 4, 6);
    printf("sum=%d", sum);
    return 0;
}