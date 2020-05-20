package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Lab1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String brackets = in.next();
        Stack stack = new Stack();
        boolean isOk = true;
        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);
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