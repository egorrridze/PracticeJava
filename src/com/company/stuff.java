package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

import java.math.RoundingMode;
import java.util.*;
import java.math.BigDecimal;
 /*Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String expression = in.nextLine();

        if(expression.charAt(0) == '-')
            expression = "0" + expression;

        if(expression.charAt(expression.length() - 1) == '=')
            expression = expression.substring(0, expression.length() - 1);

        String[] arr = expression.split(" ");

        ArrayList<String> arrayList = getPolishNotation(arr);
        BigDecimal result = new BigDecimal(getResult(arrayList));
        System.out.println(result.setScale(3, RoundingMode.CEILING).stripTrailingZeros());
    }

            private static double getResult(ArrayList<String> arr){
                ArrayList<Double> doubles = new ArrayList<>();

                for (int i = 0; i < arr.size(); i++){
                    if(isDouble(arr.get(i))){
                        doubles.add(Double.parseDouble(arr.get(i)));
                    }else if(arr.get(i).equals("+")){
                        double tmp = doubles.get(doubles.size() - 2) + doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else if(arr.get(i).equals("-")){
                        double tmp = doubles.get(doubles.size() - 2) - doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else if(arr.get(i).equals("*")) {
                        double tmp = doubles.get(doubles.size() - 2) * doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else if(arr.get(i).equals("^")){
                        double tmp = Math.pow(doubles.get(doubles.size() - 2), doubles.get(doubles.size() - 1));

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else {
                        double tmp = doubles.get(doubles.size() - 2) / doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }
                }

                return doubles.get(0);
            }

            private static ArrayList<String> getPolishNotation(String[] arr){
                ArrayList<String> newArr = new ArrayList<>();
                Stack<String> stack = new Stack<>();

                for(int i = 0; i < arr.length; i++){
                    if(isDouble(arr[i])){
                        newArr.add(arr[i]);
                    }else if(arr[i].equals(")")){

                        while (!stack.peek().equals("(")){
                            newArr.add(stack.pop());
                        }

                        stack.pop();

                    }else if(arr[i].equals("+") || arr[i].equals("-")) {
                        while (!stack.empty() && (stack.peek().equals("+") || stack.peek().equals("-") ||
                                stack.peek().equals("*") || stack.peek().equals("/"))){
                            newArr.add(stack.pop());
                        }

                        stack.push(arr[i]);
                    }else if(arr[i].equals("*") || arr[i].equals("/")) {
                        while (!stack.empty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                            newArr.add(stack.pop());
                        }

                        stack.push(arr[i]);

                    }else if (arr[i].equals("^")){
                        if (!stack.empty() && stack.peek().equals("^")){
                            newArr.add(stack.pop());
                        }

                        stack.push(arr[i]);
                    }else{
                        stack.push(arr[i]);
                    }
                }

                while (!stack.empty()){
                    newArr.add(stack.pop());
                }

                return newArr;
            }

            private static boolean isDouble(String s) throws NumberFormatException {
                try {
                    Double.parseDouble(s);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }

*/

public class stuff {
    public static void main(String[] args) {
       /* try {
            String html = "https://rating.chgk.info/tournaments";
            Document table = Jsoup.connect(html).get();
            Elements rows = table.select("tr");
            boolean head_of_table = false;
            for (int i = 0; i < rows.size(); i++) {
                Element row = rows.get((i)); //по номеру индекса получает строку
                Elements cols = row.select("td");// разбиваем полученную строку по тегу  на столбцы
                //System.out.println(cols);
                //System.out.println(2019/2020);
                //System.out.println();
                //String l = cols.get(7).select("a[href]").attr("href"); парсинг ссылки на страницу
                if (cols.size() == 1)
                {
                    System.out.print("    " + cols.select("td[class]").text());
                }
                else if (cols.size() == 8)
                {
                    if (head_of_table) {
                        System.out.print(cols.get(1).text() + " ");// первый столбец
                        System.out.print(cols.get(2).text() + " ");// первый столбец
                        System.out.print(cols.get(3).text() + " ");// первый столбец
                    }
                    head_of_table = true;
                }
                //System.out.println(l.attr("href"));
                //System.out.print(cols.size());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String expression = in.nextLine();

        if(expression.charAt(0) == '-')
            expression = "0" + expression;

        if(expression.charAt(expression.length() - 1) == '=')
            expression = expression.substring(0, expression.length() - 1);

        String[] arr = expression.split(" ");

        ArrayList<String> arrayList = getPolishNotation(arr);
        BigDecimal result = new BigDecimal(getResult(arrayList));
        System.out.println(result.setScale(3, RoundingMode.CEILING).stripTrailingZeros());
    }

            private static double getResult(ArrayList<String> arr){
                ArrayList<Double> doubles = new ArrayList<>();

                for (int i = 0; i < arr.size(); i++){
                    if(isDouble(arr.get(i))){
                        doubles.add(Double.parseDouble(arr.get(i)));
                    }else if(arr.get(i).equals("+")){
                        double tmp = doubles.get(doubles.size() - 2) + doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else if(arr.get(i).equals("-")){
                        double tmp = doubles.get(doubles.size() - 2) - doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else if(arr.get(i).equals("*")) {
                        double tmp = doubles.get(doubles.size() - 2) * doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else if(arr.get(i).equals("^")){
                        double tmp = Math.pow(doubles.get(doubles.size() - 2), doubles.get(doubles.size() - 1));

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }else {
                        double tmp = doubles.get(doubles.size() - 2) / doubles.get(doubles.size() - 1);

                        doubles.remove(doubles.size() - 1);
                        doubles.remove(doubles.size() - 1);

                        doubles.add(tmp);
                    }
                }

                return doubles.get(0);
            }

            private static ArrayList<String> getPolishNotation(String[] arr){
                ArrayList<String> newArr = new ArrayList<>();
                Stack<String> stack = new Stack<>();

                for(int i = 0; i < arr.length; i++){
                    if(isDouble(arr[i])){
                        newArr.add(arr[i]);
                    }else if(arr[i].equals(")")){

                        while (!stack.peek().equals("(")){
                            newArr.add(stack.pop());
                        }

                        stack.pop();

                    }else if(arr[i].equals("+") || arr[i].equals("-")) {
                        while (!stack.empty() && (stack.peek().equals("+") || stack.peek().equals("-") ||
                                stack.peek().equals("*") || stack.peek().equals("/"))){
                            newArr.add(stack.pop());
                        }

                        stack.push(arr[i]);
                    }else if(arr[i].equals("*") || arr[i].equals("/")) {
                        while (!stack.empty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                            newArr.add(stack.pop());
                        }

                        stack.push(arr[i]);

                    }else if (arr[i].equals("^")){
                        if (!stack.empty() && stack.peek().equals("^")){
                            newArr.add(stack.pop());
                        }

                        stack.push(arr[i]);
                    }else{
                        stack.push(arr[i]);
                    }
                }

                while (!stack.empty()){
                    newArr.add(stack.pop());
                }

                return newArr;
            }

            private static boolean isDouble(String s) throws NumberFormatException {
                try {
                    Double.parseDouble(s);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }