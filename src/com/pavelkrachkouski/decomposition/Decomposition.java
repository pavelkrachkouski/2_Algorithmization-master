package com.pavelkrachkouski.decomposition;

import java.util.Arrays;
import java.util.Scanner;

public class Decomposition {



    //Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
    //натуральных чисел_________________________________________________________________________________________________
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число A: ");
        int a = scanner.nextInt();
        System.out.print("Введите число B: ");
        int b = scanner.nextInt();

        System.out.println("Наибольший общий делитель чисел " + a + " и " + b + " = " + searchNOD(a, b));
        System.out.print("Наименьшее общее кратное чисел " + a + " и " + b + " = " + (a * b) / searchNOD(a, b));
    }



    //НОД алгоритм Евклида
    private static int searchNOD(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }
    //__________________________________________________________________________________________________________________






    //Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.______________________
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число A: ");
        int a = scanner.nextInt();
        System.out.print("Введите число B: ");
        int b = scanner.nextInt();
        System.out.print("Введите число C: ");
        int c = scanner.nextInt();
        System.out.print("Введите число D: ");
        int d = scanner.nextInt();

        int d2 = searchNOD(a, b);
        int d3 = searchNOD(d2, c);
        int d4 = searchNOD(d3, d);

        System.out.println("Наибольший общий делитель чисел " + a + ", " + b + ", " + c + ", " + d + " = " + d4);
    }
    //__________________________________________________________________________________________________________________






    //Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
    //треугольника._____________________________________________________________________________________________________
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сторону шестиугольника a: ");
        double a = scanner.nextDouble();
        //Правильный шестиугольник состоит из 6 равносторонних треугольников
        double hexagonSquare = hexagonSquare(a);
        System.out.print("\nПлощадь правильного шестиугольника равна: " + hexagonSquare);
    }



    private static double hexagonSquare(double a) {
        return (3 * Math.sqrt(3) * Math.pow(a, 2)) / 2;
    }
    //__________________________________________________________________________________________________________________






    //На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
    //из пар точек самое большое расстояние. Указание. Координаты точек занести в массив._______________________________
    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите количество точек n: ");
        int n = scanner.nextInt();
        int[][] arrayPoints = pointsGenerator(n);

        double maxDistance = 0;
        String betweenPoints = "";

        for (int i = 0; i < n; i++) {
            double distance;
            for (int j = 0; j < n; j++) {
                distance = distanceBetweenTwoPoints(arrayPoints[i][0], arrayPoints[i][1], arrayPoints[j][0], arrayPoints[j][1]);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    betweenPoints = "точкой " + i + " и точкой " + j;
                }
            }
        }
        System.out.println("Максимальная дистанция между " + betweenPoints + " = " + maxDistance);
    }



    //Генерируем n случайных точек и выводим их на экран
    private static int[][] pointsGenerator(int n) {
        int[][] arrayPoints = new int[n][2];
        //Заполняем массив случайными числами
        Scanner scanner = new Scanner(System.in);
        System.out.print("Минимальное значение диапазона случайных чисел: ");
        int min = scanner.nextInt();
        System.out.print("Максимальное значение диапазона случайных чисел: ");
        int max = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j ++) {
                arrayPoints[i][j] = randomWithRange(min, max);
            }
        }
        //Выводим сформированный массив на экран
        for (int i = 0; i < n; i++) {
            System.out.println("Точка " + (i+1) + ": " + Arrays.toString(arrayPoints[i]));
        }
        return  arrayPoints;
    }



    //Диапазон значений случайных чисел
    private static int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }



    //Расстояние между двумя точками
    private static double distanceBetweenTwoPoints(int x1, int y1, int x2, int y2) {
        int x = x2 - x1;
        int y = y2 - y1;
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    //__________________________________________________________________________________________________________________






    //Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
    //которое меньше максимального элемента массива, но больше всех других элементов)___________________________________
    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите количество элементов массива N: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomWithRange(-100, 100);
        }
        System.out.println(Arrays.toString(array));
        int max = Integer.MIN_VALUE;
        for (int k : array) {
            if (k > max) {
                max = k;
            }
        }
        int secondMax = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > secondMax && j < max) {
                secondMax = j;
            }
        }
        System.out.println("Второе по величине число: " + secondMax);
    }
    //__________________________________________________________________________________________________________________






    //Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми._______________________________
    public static void task6() {
        Scanner scanner = new Scanner(System.in);
        int[] arrayThree = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите число " + (i+1) + ": ");
            arrayThree[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arrayThree));

        //Если НОД этих трех чисел больше 1, значит они не взаимнопростые
        int d2 = searchNOD(arrayThree[0], arrayThree[1]);
        int d3 = searchNOD(d2, arrayThree[2]);

        if (d3 == 1) {
            System.out.print("Числа являются взаимно простыми!");
        }
        else {
            System.out.print("Числа НЕ являются взаимно простыми!");
        }
    }
    //__________________________________________________________________________________________________________________






    //Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9_____________________________
    public static void task7() {
        int sum = 0;
        for (int i = 1; i <= 9; i+=2) {
            sum += factorial(i);
        }
        System.out.print("Сумма факториалов нечётных чисел от 1 до 9: " + sum);

    }



    //Вычисление факториала
    private static int factorial(int f) {
        if (f <= 1) {
            return 1;
        }
        return f * factorial(f - 1);
    }
    //__________________________________________________________________________________________________________________



}
