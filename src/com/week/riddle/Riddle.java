package com.week.riddle;

/**
 * 迷语博士的难题(2)
 * 两面族是荒岛上的一个新民族，他们的特点是说话真一句假一句且真假交替。如果第一句为真，则第二句是假的；如果第一句为假的，则第二句就是真的，但是第一句是真是假没有规律。
 迷语博士遇到三个人，知道他们分别来自三个不同的民族：诚实族、说谎族和两面族。三人并肩站在博士前面。
 博士问左边的人：“中间的人是什么族的？”，左边的人回答：“诚实族的”。
 博士问中间的人：“你是什么族的？”，中间的人回答：“两面族的”。
 博士问右边的人：“中间的人究竟是什么族的？”，右边的人回答：“说谎族的”。
 请问：这三个人都是哪个民族的？
 */
public class Riddle {
    public static void main(String[] args) {
        int a, b, c;

        for (a = 2; a >= 0; --a)
            for (b = 2; b >= 0; --b)
                for (c = 2; c >= 0; --c)
                    if ((((a == 1 || a == 2) && b == 1) || ((a == 0 || a == 2) && b != 1)) &&//左边说真话||左边说假话
                            ((b == 2 && a == 0 && b == 0) || (b == 0 && ((a == 1 && c == 2) || (a == 2 && c == 1)))) &&//中间说真话||中间说假话
                            (((c == 1 || c == 2) && b == 0) || ((c == 0 || c == 2) && b != 0)) &&//右边说真话||右边说假话
                            a + b + c == 3//每个族的都有一个人
                            ) {
                        if (a == 2)
                            System.out.println("左边的人是两面人");
                        else if (a == 1)
                            System.out.println("左边的人是诚实族");
                        else
                            System.out.println("左边的人是说谎族");

                        if (b == 2)
                            System.out.println("中间的人是两面人");
                        else if (b == 1)
                            System.out.println("中间的人是诚实族");
                        else
                            System.out.println("中间的人是说谎族");

                        if (c == 2)
                            System.out.println("右边的人是两面人");
                        else if (c == 1)
                            System.out.println("右边的人是诚实族");
                        else
                            System.out.println("右边的人是说谎族");
                    }

    }
}
