package Codility;

/**
 * Created by GregHuang on 10/4/16.
 */
/*
 */
public class MatrixSearch {
    public static void main(String[] args) {
        int[] m = new int[]{
                1,5,10,20,30,
                4,8,11,21,32,
                5,21,37,42,72};
        System.out.println(search(m, 3, 5, 37));
        System.out.println(search(m, 3, 5, 38));
        System.out.println(search(m, 3, 5, 20));
        System.out.println(search(m, 3, 5, 8));
        System.out.println(search(m, 3, 5, 25));
    }

    public static boolean search(int[] matrix, int row, int col, int target) {
        int k = row -1;
        int j = col -1;

        int cur_value = matrix[k*col + j];

        while(cur_value > target) {
            int left_value = matrix[k*col + j-1];
            int up_value = matrix[(k-1)*col + j];
            if( left_value > up_value )
                k--;
            else
                j--;

            // need to check the minimum of k and j
            cur_value = matrix[k*col + j];
        }


        if (cur_value == target) return true;

        int nrow = Math.min(k+1, row -1);
        int ncol = Math.min(j+1, col -1);
        int search_max = nrow * col + ncol;

        for (int n = 0; n < ncol; n++) {
            int search_index = nrow*col + n;
            if (search_index < search_max && matrix[search_index] == target) return true;
        }

        for (int n = 0; n < nrow; n++) {
            int search_index = n*col + ncol;
            if (search_index < search_max && matrix[search_index] == target) return true;
        }

        return false;
    }
}
