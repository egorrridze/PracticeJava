package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите последовательность скобок:");
        Scanner in = new Scanner(System.in);
        String brackets = in.next();
        Stack stack = new Stack();
        boolean isOk = true;
        for (int i = 0; i < brackets.length(); i++) {  // начинаем последовательно считывать
            char ch = brackets.charAt(i);              // считывание символа
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if (!stack.empty()){
                    if (!(stack.pop().toString().charAt(0) == '{')) {
                        isOk = false;
                    }} else isOk = false;
                    break;
                case ']':
                    if (!stack.empty()){
                    if (!(stack.pop().toString().charAt(0) == '[')) {
                        isOk = false;
                    }} else isOk = false;
                    break;
                case ')':
                    if (!stack.empty()){
                    if (!(stack.pop().toString().charAt(0) == '(')) {
                        isOk = false;
                    }} else isOk = false;
                    break;
                default: isOk = false;
            }
        }
        if (isOk && stack.empty()) System.out.println("Все верно!");
        else System.out.println("Ошибка :(");
    }
}