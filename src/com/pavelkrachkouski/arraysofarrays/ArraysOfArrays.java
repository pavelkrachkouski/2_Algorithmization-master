package com.pavelkrachkouski.arraysofarrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysOfArrays {



    //Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
    public static void task1() {
        int[][] array = createRandomMatrix();
        //Выводим нечётные столбцы матрицы у которых первый элемент больше последнего
        for (int j = 0; j < array.length; j += 2) {
            if (array[0][j] > array[array.length-1][j]) {
                System.out.print("Столбец " + (j + 1) + ": ");
                for (int[] ints : array) {
                    System.out.print(ints[j] + "   ");
                }
                System.out.println(" ");
            }
        }
    }



    //Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
    public static void task2() {
        int[][] array = createRandomMatrix();
        //Выводим элементы стоящие на диагонали
        System.out.print("Элементы стоящие на диагонали: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i][i] + "  ");
        }

    }



    //Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
    public static void task3() {
        int[][] array = createRandomMatrix();
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку (k): ");
        int k = scan.nextInt();
        System.out.print("Введите столбец (p): ");
        int p = scan.nextInt();
        System.out.print("k-я строка: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[k-1][i] + "  ");
        }
        System.out.println(" ");
        System.out.print("p-й столбец: ");
        for (int[] ints : array) {
            System.out.print(ints[p - 1] + "  ");
        }
    }



    //Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    public static void task4() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите порядок матрицы (четный): ");
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    array[i][j] = j+1;
                }
                else {
                    array[i][j] = n-j;
                }
            }
        }
        //Выводим матрицу на экран
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }



    //Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    public static void task5() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите порядок матрицы (четный): ");
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                array[i][j] = i+1;
            }
        }
        //Выводим матрицу на экран
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }



    //Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    public static void task6() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите порядок матрицы (четный): ");
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i < n/2) {
                for (int j = i; j < n - i; j++) {
                    array[i][j] = 1;
                }
            }
            else {
                for (int j = (n-i-1); j < n - (n-i-1); j++) {
                    array[i][j] = 1;
                }
            }
        }
        //Выводим матрицу на экран
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }



    //Сформировать квадратную матрицу порядка N по правилу и подсчитать количество положительных элементов в ней.
    public static void task7() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите порядок матрицы: ");
        int n = scan.nextInt();
        double[][] array = new double[n][n];
        int count = 0; //количество положительных элементов
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Math.sin((Math.pow(i,2)-Math.pow(j,2)) / n);
                if (array[i][j] > 0) {
                    count++;
                }
            }
        }
        //Выводим матрицу на экран
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.print("Количество положительных элементов: " + count);
    }



    //В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
    //на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
    //пользователь с клавиатуры.
    public static void task8() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите № столбца: ");
        int a = scan.nextInt();
        System.out.print("Введите № столбца: ");
        int b = scan.nextInt();
        int[][] array = createRandomMatrix();
        for (int j = 0; j < array.length; j++) {
            int aa = array[j][a-1];
            array[j][a-1] = array[j][b-1];
            array[j][b-1] = aa;
        }
        System.out.println("\n");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }



    //Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
    //столбец содержит максимальную сумму.
    public static void task9() {
        int[][] array = createRandomMatrixABS();
        int max_sum = Integer.MIN_VALUE;
        int column_number = 0;

        for (int j = 0; j < array.length; j++) {
            int sum = 0;
            for (int[] ints : array) {
                sum += ints[j];
            }
            if (sum > max_sum) {
                max_sum = sum;
                column_number = j+1;
            }
            System.out.println("Сумма элементов в столбце " + (j+1) + " равна: " + sum);
        }
        System.out.println("\nСтолбец " + column_number + " содержит максимальную сумму равную: " + max_sum);
    }



    //Найти положительные элементы главной диагонали квадратной матрицы.
    public static void task10() {
        int[][] array = createRandomMatrix();
        System.out.print("Положительные элементы главной диагонали квадратной матрицы: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i][i] > 0) {
                System.out.print(array[i][i] + " ");
            }
        }
    }



    //Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
    //которых число 5 встречается три и более раз.
    public static void task11() {
        int[][] array = createRandomMatrixTenTwenty();
        System.out.print("\nЧисло 5 встречается 3 и более раз в строках: ");
        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 0; j < 20; j++) {
                if (array[i][j] == 5) {
                    count++;
                }
                if (count == 3) {
                    System.out.print(i+1 + " ");
                    break;
                }
            }
        }
    }



    //Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
    public static void task12() {
        int[][] array = createRandomMatrixTenTwenty();
        System.out.print("\n");
        for (int[] ints : array) {
            bubbleSort(ints);
        }
        //Выводим отсортированную по возрастанию матрицу на экран
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.print("\n");
        for (int[] ints : array) {
            bubbleSortReverse(ints);
        }
        //Выводим отсортированную по убыванию матрицу на экран
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }



    //Отсотрировать столбцы матрицы по возрастанию и убыванию значений эементов.
    public static void task13() {
        int[][] array = createRandomMatrixTenTwenty();
        System.out.print("\n");
        for (int j = 0; j < array[0].length; j++) {
            boolean sort = true;
            while (sort) {
                sort = false;
                for (int i = 0; i < array.length-1; i++) {
                   if (array[i][j] > array[i+1][j]) {
                       int swap = array[i][j];
                       array[i][j] = array[i+1][j];
                       array[i+1][j] = swap;
                       sort = true;
                   }
                }
            }
        }
        //Выводим матрицу с отссортированными по возрастанию столбцами
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.print("\n");
        for (int j = 0; j < array[0].length; j++) {
            boolean sort = true;
            while (sort) {
                sort = false;
                for (int i = 0; i < array.length-1; i++) {
                    if (array[i][j] < array[i+1][j]) {
                        int swap = array[i][j];
                        array[i][j] = array[i+1][j];
                        array[i+1][j] = swap;
                        sort = true;
                    }
                }
            }
        }
        //Выводим матрицу с отссортированными по убыванию столбцами
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }



    //Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
    //единиц равно номеру столбца.
    public static void task14() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк матрицы: ");
        int m = scanner.nextInt();
        //количество столбцов должно быть меньше либо равно количеству строк иначе условие не выполнимо
        System.out.print("Введите количество столбцов матрицы: ");
        int n = scanner.nextInt();
        int[][] array = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                array[i][j] = 1;
            }
        }
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }



    //Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
    public static void task15() {
        int[][] array = createRandomMatrix();
        System.out.print("\n");
        //Находим наибольший элемент
        int max = Integer.MIN_VALUE;
        for (int[] value : array) {
            for (int j = 0; j < array.length; j++) {
                if (value[j] > max) {
                    max = value[j];
                }
            }
        }
        System.out.print("Максимальный элемент матрицы: " + max);
        //Замняем все нечетные элементы на значение max
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] % 2 != 0) {
                    array[i][j] = max;
                }
            }
        }
        System.out.print("\n\n");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }



    //Магическим квадратом порядка n называется квадратная матрица размера n x n, составленная из чисел 1, 2, 3,
    //..., n 2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
    //собой. Построить такой квадрат.
    public static void task16() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        //Используем сиамский метод (применим для матриц нечетного порядка)
        int count = 1;
        int y = 0;
        int x = array.length/2;
        while (true) {
            array[y][x] = count;
            count++;

            if (((y == 0) && (x >= n-1)) && (array[n-1][0] != 0)){
                y++;
            }
            else {
                y--;
                if (y < 0) {
                    y = n - 1;
                }
                x++;
                if (x == n) {
                    x = 0;
                }
                if(array[y][x]!=0) {
                    y+=2;
                    x--;
                }
            }

            if (count == n*n+1) {
                break;
            }
        }
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }


    //Метод генерации матрицы случайных чисел размерностью n*n
    private static int[][] createRandomMatrix() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        //Генерируем матрицу случайных чисел n*n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int)(Math.random()*(200+1)-100);
            }
        }
        //Выводим матрицу на экран
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        return array;
    }



    //Метод генерации матрицы случайных ABS чисел размерностью n*n
    private static int[][] createRandomMatrixABS() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        //Генерируем матрицу случайных чисел n*n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Math.abs((int)(Math.random()*(200+1)-100));
            }
        }
        //Выводим матрицу на экран
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        return array;
    }



    //Метод генерации матрицы случайных чисел от 0 д о 15 размерностью 10*20
    private static int[][] createRandomMatrixTenTwenty() {
        int[][] array = new int[10][20];
        //Генерируем матрицу случайных чисел n*n
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                //Math.random()*(b-a))+a ------ нижняя граница а | верхняя b
                array[i][j] = (int)(Math.random()*(15)+1);
            }
        }
        //Выводим матрицу на экран
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        return array;
    }



    //Сортировка пузырьком по возрастанию
    private static void bubbleSort(int[] array) {
        boolean if_sorted = true;
        while (if_sorted) {
            if_sorted = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    int swap = array[i];
                    array[i] = array[i+1];
                    array[i+1] = swap;
                    if_sorted = true;
                }
            }
        }
    }



    //Сортировка пузырьком по убыванию
    private static void bubbleSortReverse(int[] array) {
        boolean if_sorted = true;
        while (if_sorted) {
            if_sorted = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] < array[i+1]) {
                    int swap = array[i];
                    array[i] = array[i+1];
                    array[i+1] = swap;
                    if_sorted = true;
                }
            }
        }
    }



}
