package com.pavelkrachkouski.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class OneDimensionalArrays {



    //В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
    public static void task1() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        System.out.print("Введите число K: ");
        int k = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*(100-1)+1);
        }
        System.out.println(Arrays.toString(array));

        int sum = 0;
        for (int a: array) {
            if (a % k == 0) {
                System.out.println(a);
                sum += a;
            }
        }
        System.out.print("Сумма элементов кратных K(" + k + "): " + sum);
    }



    //Дана последовательность действительных чисел а 1 ,а 2 ,..., а п . Заменить все ее члены, большие данного Z, этим
    //числом. Подсчитать количество замен.
    public static void task2() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        System.out.print("Введите число Z: ");
        double z = scan.nextDouble();
        //Генерируем массив случайных чисел длиной n
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = Math.random()*(200+1)-100;
        }
        System.out.println(Arrays.toString(array));
        int count_changes = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] > z) {
                array[i] = z;
                count_changes++;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Количество замен: " + count_changes);
    }



    //Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
    //положительных и нулевых элементов.
    public static void task3() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = Math.random()*(200+1)-100;
        }
        System.out.println(Arrays.toString(array));
        int count_plus = 0;
        int count_minus = 0;
        int count_null = 0;
        for (double a: array) {
            if (a > 0) {
                count_plus++;
            }
            else if (a < 0) {
                count_minus++;
            }
            else {
                count_null++;
            }
        }
        System.out.println("Количество отрицательных элементов: " + count_minus + "\nКоличество положительных элементов: " + count_plus + "\nКоличество нулевых элементов: " + count_null);
    }



    //Даны действительные числа а 1 ,а 2 ,..., а n . Поменять местами наибольший и наименьший элементы.
    public static void task4() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = Math.random()*(200+1)-100;
        }
        System.out.println(Arrays.toString(array));
        double min = array[0];
        int min_pos = 0;
        double max = array[0];
        int max_pos = 0;
        //найдем наибольший элемен и наименьший элемент и их позиции
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
                max_pos = i;
            }
            if (array[i] < min) {
                min = array[i];
                min_pos = i;
            }
        }
        System.out.println("Min: "+min+" "+min_pos);
        System.out.println("Max: "+max+" "+max_pos);
        //поменяем местами наибольший и наименьший элемент
        array[min_pos] = max;
        array[max_pos] = min;
        System.out.println(Arrays.toString(array));
    }



    //Даны целые числа а 1 ,а 2 ,..., а n . Вывести на печать только те числа, для которых а i > i.
    public static void task5() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*(200+1)-100);
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < n; i++) {
            if (array[i] > i) {
                System.out.print(array[i] + " ");
            }
        }
    }



    //Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
    //являются простыми числами.
    public static void task6() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = (Math.random()*(200+1)-100);
        }
        System.out.println(Arrays.toString(array));
        double sum = 0;
        for (int i = 1; i < n; i++) {
            if (ifSimple(i+1)) {
                sum += array[i];
            }
        }
        System.out.println("Sum: " + sum);
    }



    //Даны действительные числа a 1 , a 2 ,  , a n . Найти
    //max( a 1 + a 2 n , a 2 + a 2 n − 1 ,  , a n + a n + 1 ) . (длина последовательности должна быть четной иначе остается 1 лишний элемент)
    public static void task7() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = (Math.random()*(200+1)-100);
        }
        System.out.println(Arrays.toString(array));
        double max = array[1] + array[n-1];
        for (int i = 0; i < n/2; i++) {
            double sum = array[i] + array[n-1-i];
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println("Max: " + max);
    }



    //Дана последовательность целых чисел a 1 , a 2 , ... , a n . Образовать новую последовательность, выбросив из
    //исходной те члены, которые равны min( a 1 , a 2 , ... , a n ) .
    public static void task8() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*(200+1)-100);
        }
        System.out.println(Arrays.toString(array));
        int min = array[0];
        int count = 0;
        //находим минимальный элемент
        for (int i = 1; i < n; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        //находим количество элементов равных минимальному
        for (int a: array) {
            if (a == min) {
                count++;
            }
        }
        int[] new_array = new int[n-count];
        int new_index = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] != min) {
                new_array[new_index] = array[i];
                new_index++;
            }
        }
        System.out.print("Новая последовательность: " + Arrays.toString(new_array));
    }



    //В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
    //чисел несколько, то определить наименьшее из них.
    public static void task9() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*(200+1)-100);
        }
        System.out.println(Arrays.toString(array));

        int biggest_count = 0;
        int smaller_number = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int current_number = array[i];
            int current_count = 0;
            for (int j = 0; j < n; j++) {
                if (array[i] == array[j]) {
                    current_count++;
                }
            }
            if (current_count >= biggest_count && current_number < smaller_number) {
                biggest_count = current_count;
                smaller_number = current_number;
            }
            //System.out.println("Число " + array[i] + " встречается " + current_count + " раз(а).");
        }
        System.out.println("Число '" + smaller_number + "' наименьшее из самых частовстречающихся чисел.");
    }



    //Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
    //элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
    public static void task10() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan.nextInt();
        //Генерируем массив случайных чисел длиной n
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*(200+1)-100);
        }
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < n; i += 2) {
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }



    //Вспомгательная функция проверки на простоту к заданию 6
    private static boolean ifSimple(int n) {
        boolean if_simple = true;

        for (int i =2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                if_simple = false;
                break;
            }
        }
        return if_simple;
    }




}
