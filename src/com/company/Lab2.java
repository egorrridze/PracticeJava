package com.company;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        int out[] = new int[4], in[] = new int[4];
        System.out.println("Введите количество купюр следующих номиналов: 1000 500 100 30");
        Scanner scan = new Scanner(System.in);
        in[3] = scan.nextInt();
        in[2] = scan.nextInt();
        in[1] = scan.nextInt();
        in[0] = scan.nextInt();
       // int in1000 = in.nextInt(), in500 = in.nextInt(), in100 = in.nextInt(), in30 = in.nextInt();
        int sum = in[3] * 1000 + in[2] * 500 + in[1] * 100 + in[0] * 30;
        System.out.println("Введите сумму, которую желаете получить");
        int a = scan.nextInt();

        if (a > sum || a % 10 != 0) {
            System.out.println("Данную сумму получить невозможно");
        }
        else{
            while (a % 100 != 0 && a >= 30 && in[0] > 0){
                a -= 30;
                in[0]--;
                out[0]++;
            }
            while (a >= 1000 && in[3] > 0){
                a -= 1000;
                in[3]--;
                out[3]++;
            }
            while (a >= 500 && in[2] > 0){
                a -= 500;
                in[2]--;
                out[2]++;
            }
            while (a >= 100 && in[1] > 0){
                a -= 100;
                in[1]--;
                out[1]++;
            }
            if (a == 0) {
                System.out.println((out[3] != 0 ? out[3] + " купюр(ы) по 1000 руб, " : "") + (out[2] != 0 ? out[2] + " купюр(ы) по 500 руб," : ""));
                System.out.println((out[1] != 0 ? out[1] + " купюр(ы) по 100 руб, " : "") + (out[0] != 0 ? out[0] + " купюр(ы) по 30 руб," : ""));
            } else {
                System.out.println("Данную сумму получить невозможно");
            }
        }
    }
}