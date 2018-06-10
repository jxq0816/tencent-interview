package com.week.riddle;

/**
 * 思路：遇到这类逻辑判断问题，应当将每个人说的话，每个人自身的条件充分考虑，还要考虑是否有其他的影藏条件
 *
 * 本题三个人来自三个族，所以输出的结果是对应谁是哪个族，两面族是一个特殊情况，必须将两面和诚实分开考虑
 *
 * 分析：a,b,c表示3个人取值为0（说谎）  到   1（诚实）, aa, bb,  cc为代表两面，取值为0（说谎）到1（诚实）
 *
 * 穷举从0到1
 *
 * 当a为诚实时的情况 ， 当b为诚实情况  ，当c为诚实情况
 *
 * 当a为两面时的情况 ， 当b为两面情况  ，当c为两面情况
 *
 * 当a为说谎时的情况 ， 当b为说谎情况  ，当c为说谎情况
 *
 * a+b+c值只能为，只有1个是诚实的，aa+bb+cc值只能为1，只有一个是两面的
 *
 * a和aa，b和bb，c和cc不能同时为1，也就是不能同时为诚实或两面
 */
public class Racial {
    public static void main(String[] args) {
        int a, b, c, aa, bb, cc;
        for (a = 0; a < 2; a++)
            for (b = 0; b < 2; b++)
                for (c = 0; c < 2; c++)
                    for (aa = 0; aa < 2; aa++)
                        for (bb = 0; bb < 2; bb++)
                            for (cc = 0; cc < 2; cc++) {
                                if ((a == 1 && aa != 1 && b == 1 || b == 1 && bb != 1 || c == 1 && cc != 1 && b == 0 && bb == 0) &&//a,b,c均为诚实，
                                        (a + aa <= 1 && b + bb <= 1 && c + cc <= 1) && (a + b + c == 1 && aa + bb + cc == 1) &&  //3个人来自3个不同的族
                                        (aa == 1 && a != 1 || bb == 1 && b != 1 || cc == 1 && c != 1) &&//a，b,c为两面
                                        (a == 0 && aa != 0 && b != 1 && bb < 2 || b == 0 && bb != 1 || c == 0 && cc != 1 && b != 0 && bb != 0)//a，b,为说谎
                                        ) {
                                    String left = (aa == 1) ? "两面" : (a == 1 ? "诚实" : "说谎");
                                    System.out.println("左边的为" + left); //条件嵌套，输出汉字为字符串s

                                    String mid = (bb == 1) ? "两面" : (b == 1 ? "诚实" : "说谎");
                                    System.out.println("中间的为" + left); //条件嵌套，输出汉字为字符串s

                                    String right = (cc == 1) ? "两面" : (c == 1 ? "诚实" : "说谎");
                                    System.out.println("中间的为" + right); //条件嵌套，输出汉字为字符串s
                                }
                            }
    }
}
