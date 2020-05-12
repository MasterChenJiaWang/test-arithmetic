package chen.example.algorithm.test20200508;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/8 20:32
 */
public class Test01 {

//    在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
//    示例:
//
//    输入:
//
//            1,0,1,0,0,1
//            1,0,1,1,1,1
//            1,1,1,1,1,1
//            1,0,1,1,1,0
//
//    输出: 4


    public static void main(String[] args) {
        Test01 test01 = new Test01();
//        char[][] matrix = new char[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','0','1','1','1'}, {'1','0','0','1','0'}};
//        int i = test01.maximalSquare(matrix);
        int i = 10;

        Test01 test011 = new Test01();
        int i1 = test01.maximalSquare(matrix);

        System.out.println(i1);
    }


    /**
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        return test03(matrix);
    }



    private int test01(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print((int) aChar + "  ");
            }
            System.out.println(" ");
        }

        for (int i = 0; i < matrix.length; i++) {
            char[] matrix1 = matrix[i];
            boolean isTrue = true;
            int count = 0;

            for (int i1 = 0; i1 < matrix1.length; i1++) {
                int c = matrix1[i1];
                if (c != 1) {
                    continue;
                }
                int y = i;
                int under = matrix[i1][++y];
                if (under != 1) {
                    continue;
                }
                count++;
                int x = i1;

                int right = right(count, ++x, matrix1);

                if (right > count) {
                }
                while (right > count) {
                    count = right;
//                    int under = matrix[i1][++y];
                    right = right(count, ++x, matrix1);
                }

                if (count >= 2) {
//                    under()
                }
            }

            while (isTrue) {

            }

            for (int i1 = 0; i1 < matrix1.length; i1++) {

            }
        }

        return 0;
    }

    private int test02(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 遇到一个 1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1);
                    // 计算可能的最大正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }


    //[["1","0","1","0","0"],
// ["1","0","1","1","1"],
// ["1","1","1","1","1"],
// ["1","0","0","1","0"]]
    private int test03(char[][] matrix) {
        int maxArea = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxArea;
        }

        int rows = matrix.length, column = matrix[0].length;
        int[][] dp = new int[rows][column];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < column; y++) {
                if (matrix[x][y] != '1') {
                    continue;
                }
                if (x == 0 || y == 0) {
                    dp[x][y] = 1;
                } else {
                    dp[x][y] = Math.min(Math.min(dp[x][y - 1], dp[x - 1][y - 1]), dp[x - 1][y]) + 1;
                }
                maxArea = Math.max(maxArea, dp[x][y]);
            }
        }
        return maxArea * maxArea;
    }



    private int right(int count, int x, char[] matrix) {
        int matrix1 = matrix[x];
        if (matrix1 == 1) {
            count++;
        }
        return count;
    }

    private int under(int count, int y, char[] matrix) {
        int matrix1 = matrix[y];
        if (matrix1 == 1) {
            count++;
        }
        return count;
    }
}
