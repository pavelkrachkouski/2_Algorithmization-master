package com.pavelkrachkouski.decomposition;

import java.util.ArrayList;
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






    //Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
    //Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
    //массива с номерами от k до m._____________________________________________________________________________________
    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите длину массива D, кратную 3: ");
        int d = scanner.nextInt();
        int[] array = new int[d];
        for (int i = 0; i < d; i++) {
            array[i] = randomWithRange(-20, 20);
        }
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < d-2; i++) {
            System.out.println(sumThreeItems(array, i));
        }
    }



    private static int sumThreeItems(int[] array, int position) {
        System.out.print("Сумма трех последовательных элементов (" + array[position] + ", " + array[position+1] + ", " + array[position+2] +") равна: ");
        return array[position] + array[position+1] + array[position+2];
    }
    //__________________________________________________________________________________________________________________






    //Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
    //если угол между сторонами длиной X и Y— прямой.___________________________________________________________________
    public static void task9() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Длина стороны X: ");
        int x = scanner.nextInt();
        System.out.print("Длина стороны Y: ");
        int y = scanner.nextInt();
        System.out.print("Длина стороны Z: ");
        int z = scanner.nextInt();
        System.out.print("Длина стороны T: ");
        int t = scanner.nextInt();

        //Проверим существует ли прямоугольник
        if (checkTriangle(x, y, z, t)) {
            //Так как нам дан только один угол, найдем площадь четырехугольника как сумму площадей двух треугольников
            //Для начала найдем гипотенузу треугольника со сторонами X и Y
            double hypotenuse = searchHypotenuse(x, y);
            //Площадь прямоугольного треугольника с катетами X, Y  и гипотенузой hypotenuse
            double s1 = 0.5 * x * y;
            //Площадь второго треугольника найдем по формуле Герона
            double p = halfMeter(z, t, hypotenuse);
            double s2 = Math.sqrt(p * (p - z) * (p - t) * (p - hypotenuse));
            //Площадь четырехугольника равна сумме площадей двух треугольников
            double s = s1 + s2;
            System.out.println("Площадь четырехугольника равна: " + s);
        }
        else {
            System.out.println("Четырехугольника с такими сторонами не существует!");
        }

    }



    private static double searchHypotenuse(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }



    private static double halfMeter(int z, int t, double h) {
        return (z + t + h) / 2;
    }



    //Проверка существования треугольников
    public static boolean checkTriangle(int x, int y, int z, int t) {
        double h = searchHypotenuse(x, y); //недостающая сторона треугольников
        if (x > 0 && y > 0 && z > 0 && t > 0 && h > 0) {
            return z + t > h && z + h > t && t + h > z && x + y > h && x + h > y && y + h > x;
        } else {
            return false;
        }
    }
    //__________________________________________________________________________________________________________________






    //Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
    //являются цифры числа N____________________________________________________________________________________________
    public static void task10() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число N: ");
        int n = scanner.nextInt();
        String number = String.valueOf(n);
        char[] array = new char[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = number.charAt(i);
        }
        System.out.println(Arrays.toString(array));
    }
    //__________________________________________________________________________________________________________________






    //Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр____________________________________
    public static void task11() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        if (String.valueOf(a).length() > String.valueOf(b).length()) {
            System.out.println("В первом числе цифр больше");
        }
        else if (String.valueOf(a).length() < String.valueOf(b).length()) {
            System.out.println("Во втором числе цифр больше");
        }
        else {
            System.out.println("Количество цифр в обоих числах одинаково");
        }
    }
    //__________________________________________________________________________________________________________________






    //Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
    //являются числа, сумма цифр которых равна К и которые не большее N.________________________________________________
    public static void task12() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число K: ");
        int k = scanner.nextInt();
        System.out.print("Введите второе число N: ");
        int n = scanner.nextInt();

        ArrayList<Integer> arrayA = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if (sumDigits(i) == k && i <= n) {
                arrayA.add(i);
            }
        }
        for (Integer a : arrayA) {
            System.out.println(a + " ");
        }

    }



    //Считаем сумму цифр числа
    private static int sumDigits(int number) {
        int sum = 0;
        String num = String.valueOf(number);
        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }
        return sum;
    }
    //__________________________________________________________________________________________________________________






    //Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
    //Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
    //решения задачи использовать декомпозицию._________________________________________________________________________
    public static void task13() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число больше 2: ");
        int n = scanner.nextInt();
        for (int i = n; i < 2*n; i++) {
            if (isSimple(i)) {
                if (isSimple(i+2)) {
                    System.out.println("Пара близнецов: " + i + " и " + (i+2));
                    i += 2;
                }
            }
        }
    }



    private static boolean isSimple(int n) {
        boolean isSimple = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isSimple = false;
                break;
            }
        }
        return isSimple;
    }
    //__________________________________________________________________________________________________________________






    //Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
    //возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
    //использовать декомпозицию.________________________________________________________________________________________
    public static void task14() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число k: ");
        int k = scanner.nextInt();

        System.out.print("Числа Армстронга: ");
        for (int i = 1; i <= k; i++) {
            if (checkArmstrong(i)) {
                System.out.print(i + ", ");
            }
        }
    }



    private static boolean checkArmstrong(int n) {
        return n == sumDigitsPowN(n);
    }



    //Считаем сумму цифр числа и возводим в степень равную количеству цифр числа
    private static double sumDigitsPowN(int number) {
        int sum = 0;
        String num = String.valueOf(number);
        for (int i = 0; i < num.length(); i++) {
            sum += Math.pow(num.charAt(i) - '0', num.length());
            //sum += num.charAt(i) - '0';???
        }
        //return Math.pow(sum, num.length());???
        return sum;
    }
    //__________________________________________________________________________________________________________________






    //Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
    //последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.__________________________
    public static void task15() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        System.out.print(n + "-значные числа, образующие возрастающую последовательность: ");
        ArrayList<Integer> numbers = createNumber(n);
        for (Integer num: numbers) {
            System.out.print(num + " ");
        }
    }



    private static ArrayList<Integer> createNumber(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        //Получаем минимальное значение n-значного числа
        int min = (int) Math.pow(10, n-1);
        //Получаем максимальное значение n-значного числа
        int max = (int) Math.pow(10, n) - 1;
        for (int i = min; i <= max; i++) {
            if (checkNumber(i)) {
                numbers.add(i);
            }
        }
        return numbers;
    }



    private static boolean checkNumber(int n) {
        boolean isIncreasing = true;
        String num = String.valueOf(n);
        for (int i = 0; i < num.length()-1; i++) {
            if (num.charAt(i) >= num.charAt(i + 1)) {
                isIncreasing = false;
                break;
            }
        }
        return isIncreasing;
    }
    //__________________________________________________________________________________________________________________






    //Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
    //Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.____________
    public static void task16() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        int sum = 0;
        ArrayList<Integer> numbers = createOddArray(n);
        for (Integer num: numbers) {
            System.out.print(num + " ");
            sum += num;
        }
        System.out.println("\nСумма всех " + n + "-значных чисел, содержащих только нечетные числа: " + sum);
        System.out.println("В найденной сумме количество четных цифр равно: " + countEven(sum));
    }



    //Создадим массив всех n-значных чисел, содержащих только нечетные цифры
    public static ArrayList<Integer> createOddArray(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        //Получаем минимальное значение n-значного числа
        int min = (int) Math.pow(10, n-1);
        //Получаем максимальное значение n-значного числа
        int max = (int) Math.pow(10, n) - 1;
        for (int i = min; i <= max; i++) {
            if (checkOdd(i)) {
                numbers.add(i);
            }
        }
        return numbers;
    }



    //Проверка цифр числа на нечетность
    private static boolean checkOdd(int n) {
        boolean isOdd = true;
        String num = String.valueOf(n);
        for (int i = 0; i < num.length(); i++) {
            if ((num.charAt(i)-'0')%2 == 0 ) {
                isOdd = false;
                break;
            }
        }
        return isOdd;
    }



    //Проверка цифр числа на нечетность
    private static int countEven(int n) {
        int count = 0;
        String num = String.valueOf(n);
        for (int i = 0; i < num.length(); i++) {
            if ((num.charAt(i)-'0')%2 == 0 ) {
                count++;
            }
        }
        return count;
    }
    //__________________________________________________________________________________________________________________






    //Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
    //действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию._____________________
    public static void task17() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            n = n -sumDigits(n);
            count++;
        }
        System.out.println("Заданное число стало равно 0 за: " + count + " итераций");
    }
    //__________________________________________________________________________________________________________________



}
