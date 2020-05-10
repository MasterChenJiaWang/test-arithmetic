package chen.example.algorithm.test20200509;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/9 19:48
 */
public class Test01 {

//    实现 int sqrt(int x) 函数。
//
//    计算并返回 x 的平方根，其中 x 是非负整数。
//
//    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
//    示例 1:
//
//    输入: 4
//    输出: 2
//    示例 2:
//
//    输入: 8
//    输出: 2
//    说明: 8 的平方根是 2.82842...,
//                 由于返回类型是整数，小数部分将被舍去。


    public static void main(String[] args) {
//        System.out.println(46341*46341);
        Test01 test01 = new Test01();
        int x=2147395600;
        int i = test01.mySqrt(x);
        System.out.println(i);
        System.out.println((int)Math.sqrt(x)==i);
    }

    public int mySqrt(int x) {
        return test04(x);
    }


    private int test01(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int i = 1+(x-1) / 2;
        int key = 1;
        int n = 0;
        // 1 - i
        for (int i1 = 1; i1 <= i; i1++) {
            if (n > 0) {
                return key;
            }
            if ( (long)i1 * i1<= x) {
                key=i1;
                continue;
            }
            n++;
        }
        return key;
    }

    private int test02(int x){
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
    private int test03(int x){
        if(x==0){
            return 0;
        }
        System.out.println(x);
        int n=0,m=x,result=-1;
        while(n<=m){
            System.out.print(String.format(" m = %d  n = %d     result = % d  ",m,n,result));
            int i = n + (m - n) / 2;
            System.out.println("  i =" + i);
            if((long)i*i<=x){
                result=i;
                n=i+1;
            }else{
                m=i-1;
            }
        }
        return result;
    }

    private int test04(int x){
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }

}
