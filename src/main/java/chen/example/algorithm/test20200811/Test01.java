package chen.example.algorithm.test20200811;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: chendaren
 * @CreateDate: 2020/8/11 13:59
 */
public class Test01 {

    public static void main(String[] args) {
        Test01 test01 = new Test01();

        char[][] board = new char[4][5];
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        board[0][3] = 'X';
        board[0][4] = 'X';
        //
        board[1][0] = 'X';
        board[1][1] = 'O';
        board[1][2] = 'O';
        board[1][3] = 'O';
        board[1][4] = 'X';
        //
        board[2][0] = 'X';
        board[2][1] = 'O';
        board[2][2] = 'O';
        board[2][3] = 'X';
        board[2][4] = 'X';
        //
        board[3][0] = 'X';
        board[3][1] = 'O';
        board[3][2] = 'X';
        board[3][3] = 'X';
        board[3][4] = 'X';

        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + "\t");
            }
            System.out.println();
        }
        System.out.println("............................................");

        test01.solve3(board);

        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + "\t");
            }
            System.out.println();
        }
    }

    // public void solve(char[][] board) {
    //
    // }

    private void test01(char[][] board) {

    }

    int n = 0;
    int m = 0;

    private void solve2(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        n = board.length;
        m = board[0].length;
        // 竖着两条
        for (int i = 0; i < n; i++) {
            parse(board, i, 0);
            parse(board, i, m - 1);
        }
        // 横着两条
        for (int i = 0; i < m; i++) {
            parse(board, 0, i);
            parse(board, n - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if (board[i][i1] == 'A') {
                    board[i][i1] = 'O';
                } else if (board[i][i1] == 'O') {
                    board[i][i1] = 'X';
                }
            }
        }

    }

    private void parse(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        parse(board, x, y - 1);// 左
        parse(board, x, y + 1);// 右
        parse(board, x - 1, y);// 下
        parse(board, x + 1, y);// 上
    }

    // 上下左右坐标偏差
    int[] a1 = {0, 0, -1, 1};
    int[] a2 = {1, -1, 0, 0};

    private void solve3(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        Queue<int[]> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                list.offer(new int[] {i, 0});
            }
            if (board[i][m - 1] == 'O') {
                list.offer(new int[] {i, m - 1});
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                list.offer(new int[] {0, i});
            }
            if (board[n - 1][i] == 'O') {
                list.offer(new int[] {n - 1, i});
            }
        }

        while (!list.isEmpty()) {
            int[] poll = list.poll();
            int x = poll[0], y = poll[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int nx = x + a1[i], my = y + a2[i];
                if (nx < 0 || nx >= n || my < 0 || my >= m || board[nx][my] != 'O') {
                    continue;
                }
                list.offer(new int[] {nx, my});
            }

        }
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if (board[i][i1] == 'A') {
                    board[i][i1] = 'O';
                } else if (board[i][i1] == 'O') {
                    board[i][i1] = 'X';
                }
            }
        }
    }

}
