package com.chong.mcspcgoodsservice;

public class TestByteSheeft {
    public static void main(String[] args){
        Long a = -1L;
        int bytes = 5;

        //负数二进制为绝对值取反+1  比如-5的二进制为：1）绝对值+5 0000 0101 =>2）取反 1111 1010 =>加1后 1111 1011
        System.out.println("String:-1L");
        System.out.println(-1L);
        System.out.println(Long.toBinaryString(-1L));

        System.out.println("String:-1L<<5");
        System.out.println(-1L<<5);
        System.out.println(Long.toBinaryString(-1L<<5));

        System.out.println("String:-1L^(-1L<<5)");
        System.out.println(-1L^(-1L<<5));
        System.out.println(Long.toBinaryString(-1L^(-1L<<5)));

        System.out.println("String:-2L");
        System.out.println(-2L);
        System.out.println(Long.toBinaryString(-2L));

        System.out.println("String:-3L");
        System.out.println(-3L);
        System.out.println(Long.toBinaryString(-3L));

        System.out.println("String:-4L");
        System.out.println(-4L);
        System.out.println(Long.toBinaryString(-4L));

        System.out.println("String:-5L");
        System.out.println(-5L);
        System.out.println(Long.toBinaryString(-5L));


    }
}
