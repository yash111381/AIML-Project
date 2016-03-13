/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Yash
 */
public class queen {

    int[] x;
    int no=0;

    public queen(int N) {
        x = new int[N];
    }

    public boolean canPlaceQueen(int r, int c) {
        /**
         * Returns TRUE if a queen can be placed in row r and column c.
         * Otherwise it returns FALSE. x[] is a global array whose first (r-1)
         * values have been set.
         */
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }

    public void printQueens(int[] x) {
        int N = x.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int placeNqueens(int r, int n) {
        /**
         * 
         * Using backtracking this method prints all possible placements of n
         * queens on an n x n chessboard so that they are non-attacking.
         */
        for (int c = 0; c < n; c++) {
            if (canPlaceQueen(r, c)) {
                x[r] = c;
                if (r == n - 1) {
                    printQueens(x);
                    no++;
                } else {
                    placeNqueens(r + 1, n);
                }
            }
        }
        return no;
    }

    public int callplaceNqueens() {
        int i=placeNqueens(0, x.length);
        return i;
    }

    public static void main(String args[]) {
        queen Q = new queen(10);
        int i=Q.callplaceNqueens();
     System.out.println(i);
    }
}
