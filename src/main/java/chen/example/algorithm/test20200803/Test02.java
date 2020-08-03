package chen.example.algorithm.test20200803;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 二位数组 转换成 稀疏数组
 *
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/8/3 15:08
 */
public class Test02 {

    public static void main(String[] args) {

        int[][] ints = new int[10][12];
        ints[0][4] = 1;
        ints[1][1] = 2;
        ints[3][9] = 1;
        ints[9][1] = 4;
        ints[4][11] = 8;

        for (int i = 0; i < ints.length; i++) {
            int[] anInt = ints[i];
            for (int i1 = 0; i1 < anInt.length; i1++) {
                System.out.print(anInt[i1]);
                System.out.print(" ");
            }
            System.out.println();
        }

        // 转换成稀疏数组
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            int[] anInt = ints[i];
            for (int i1 = 0; i1 < anInt.length; i1++) {
                if (anInt[i1] != 0) {
                    sum++;
                }
            }
        }
        //
        int[][] sparseInt = new int[sum + 1][3];
        sparseInt[0][0] = ints.length;
        sparseInt[0][1] = ints[0].length;
        sparseInt[0][2] = sum;
        int n = 1;
        for (int i = 0; i < ints.length; i++) {
            int[] anInt = ints[i];
            for (int i1 = 0; i1 < anInt.length; i1++) {
                if (anInt[i1] != 0) {
                    sparseInt[n][0] = i;
                    sparseInt[n][1] = i1;
                    sparseInt[n][2] = anInt[i1];
                    n++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        //
        for (int i = 0; i < sparseInt.length; i++) {
            int[] anInt = sparseInt[i];
            for (int i1 = 0; i1 < anInt.length; i1++) {
                System.out.print(anInt[i1]);
                stringBuilder.append(anInt[i1]);
                stringBuilder.append("\t");
            }
            stringBuilder.append("\n");
        }
        try {
            Files.write(Paths.get("C:\\Users\\曾帅\\Desktop\\22.txt"), stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
