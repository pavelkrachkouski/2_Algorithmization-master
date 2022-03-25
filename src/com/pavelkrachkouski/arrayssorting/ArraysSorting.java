package com.pavelkrachkouski.arrayssorting;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSorting {



    //Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
    //один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
    //дополнительный массив
    public static void task1() {
        int[] array1 = new int[]{1,2,3,4,5,6,7};
        int[] array2 = new int[]{8,9,10,11};
        int[] array3 = new int[array1.length+array2.length];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число k: ");
        int k = scanner.nextInt();

        int count = 0;
        for (int i = k; i < k+ array2.length; i++) {
            array3[i] = array2[count];
            count++;
        }
        count = 0;
        for (int i = 0; i < k; i++) {
            array3[i] = array1[count];
            count++;
        }
        for (int i = k + array2.length; i < array3.length; i++) {
            array3[i] = array1[count];
            count++;
        }
        System.out.print(Arrays.toString(array3));
    }



    //Даны две неубывающие последовательности. Образовать из них новую последовательность
    //чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
    public static void task2() {
        int[] array1 = new int[]{1,2,3,4,5,6,7};
        int[] array2 = new int[]{2,3,14,17};
        int[] array3 = new int[array1.length+array2.length];
        //объеденим две последовательности в 1
        System.arraycopy(array1, 0, array3, 0, array1.length);
        int count = 0;
        for (int i = array1.length; i < array3.length; i++) {
            array3[i] = array2[count];
            count++;
        }
        //затем отсортируем последовательность по возрастанию
        boolean iftrue = true;
        while (iftrue)
        {
            iftrue = false;
            for (int i = 0; i < array3.length-1; i++) {
                if (array3[i] > array3[i+1]) {
                    iftrue = true;
                    int swap = array3[i];
                    array3[i] = array3[i+1];
                    array3[i+1] = swap;
                }
            }
        }
        System.out.print(Arrays.toString(array3));
    }



    //Сортировка выбором
    public static void task3() {
        //дана последовательность
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = i+1;
        }
        System.out.print(Arrays.toString(array));
        //расположить числа по убыванию
        for (int i = 0; i < array.length; i++) {
            int max = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    array[j] = array[i];
                    array[i] = max;
                }
            }
        }
        System.out.print("\n" + Arrays.toString(array));
    }



    //Сортировка обменами
    public static void task4() {
        //дана последовательность
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = (int)(Math.random()*(200+1)-100);
        }
        System.out.print(Arrays.toString(array));
        boolean a = true;
        int count = 0;
        while (a) {
            a = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    int swap = array[i];
                    array[i] = array[i+1];
                    array[i+1] = swap;
                    a = true;
                    count++;
                }
            }
        }
        System.out.print("\n" + Arrays.toString(array));
        System.out.print("\nКоличество перестановок: " + count);
    }



    //Сортировка вставками______________________________________________________________________________________________
    public static void task5() {
        //дана последовательность
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = (int)(Math.random()*(200+1)-100);
        }
        System.out.print(Arrays.toString(array) + "\n");

        //Создаем новый массив
        int[] sortedArray = new int[30];
        Arrays.fill(sortedArray, Integer.MAX_VALUE);
        sortedArray[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            //Бинарным поиском получаем позицию вставки нового элемента
            int n = binarySearch(sortedArray, 0, i, array[i]);

            //Раздвигаем массив для вставки нового элемента с позиции n
            if (i - n >= 0) System.arraycopy(sortedArray, n, sortedArray, n + 1, i - n);

            sortedArray[n] = array[i];
        }

        System.out.print("\n" + Arrays.toString(sortedArray));
    }



    //метод бинарного поиска
    //sortedArray масив в котором осуществляется поиск места для вставки нового элемента
    //startPosition && finishPosition нужны для того чтобы брать определенный префикс массива sortedArray
    private static int binarySearch(int[] sortedArray, int startPosition, int finishPosition, int searchElement) {
        int middlePosition;
        while (startPosition <= finishPosition) {
            middlePosition = (startPosition + finishPosition) / 2;

            if (searchElement < sortedArray[middlePosition]) {
                finishPosition = middlePosition - 1;
            }
            else if (searchElement > sortedArray[middlePosition]) {
                startPosition = middlePosition + 1;
            }
            else {
                return middlePosition;
            }
        }
        return startPosition;
    }
    //__________________________________________________________________________________________________________________



    //Сортировка Шелла__________________________________________________________________________________________________
    public static void task6() {
        //дана последовательность
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = (int)(Math.random()*(200+1)-100);
        }
        System.out.print(Arrays.toString(array) + "\n");
        for (int i = 0; i < array.length-1; ) {
            if (array[i] > array[i+1]) {
                int swap = array[i];
                array[i] = array[i+1];
                array[i+1] = swap;
                if (i != 0) i--;
            }
            else {
                i++;
            }
        }
        System.out.print(Arrays.toString(array) + "\n");
    }
    //__________________________________________________________________________________________________________________



    //Требуется указать те места, на которые нужно вставлять элементы последовательности в первую
    //последовательность так, чтобы новая последовательность оставалась возрастающей.___________________________________
    public static void task7() {
        int m = 0;
        int k = 1;
        //дана последовательность 1
        int[] arrayOne = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayOne[i] = m;
            m += 2;
        }
        System.out.print("Первая неубывающая последовательность a: " + Arrays.toString(arrayOne) + "\n");
        //дана последовательность 2
        int[] arrayTwo = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayTwo[i] = k;
            k += 2;
        }
        System.out.print("Вторая неубывающая последовательность b: " + Arrays.toString(arrayTwo) + "\n\n");

        int[] arrayNew = new int[arrayOne.length + arrayTwo.length]; //Новая неубывающая последовательность
        Arrays.fill(arrayNew, Integer.MAX_VALUE);
        //Заполняем значениями из первой последовательности a
        System.arraycopy(arrayOne, 0, arrayNew, 0, arrayOne.length);
        //Далее принцип как в задании №5. Бинарным поиском ищем место для вставки элемента из последовательности b в
        //новую последовательность. Раздвигаем массив от места вставки. Вставляем эллемент
        for (int i = 0; i < arrayTwo.length; i++) {
            //Бинарным поиском получаем позицию вставки нового элемента
            int n = binarySearch(arrayNew, 0, arrayOne.length + i, arrayTwo[i]);
            //Раздвигаем массив для вставки нового элемента с позиции n
            if (arrayOne.length + i - n >= 0) System.arraycopy(arrayNew, n, arrayNew, n + 1, arrayOne.length + i - n);
            arrayNew[n] = arrayTwo[i];
        }

        System.out.print("Новая последовательность: " + Arrays.toString(arrayNew) + "\n\n");
    }
    //__________________________________________________________________________________________________________________



    //Даны дроби. Привести их к общему знаменателю. Упорядочить в порядке возрастания___________________________________
    public static void task8() {
        //p-числитель и q-знаменатель (натуральные числа)
        int[] arrayP = new int[5];
        int[] arrayQ = new int[5];
        for (int i = 0; i < arrayP.length; i++) {
            arrayP[i] = (int)(Math.random()*(10-1+1)+1);
            arrayQ[i] = (int)(Math.random()*(10-1+1)+1);
        }
        System.out.print("Массив числителей " + Arrays.toString(arrayP) + "\n");
        System.out.print("Массив знаменателей " + Arrays.toString(arrayQ) + "\n\n");

        int z = 1; //общий знаменатель
        for (int j : arrayQ) {
            z *= j;
        }

        System.out.print("Общий знаменатель: " + z + "\n\n");

        for (int i = 0; i < arrayQ.length; i++) {
            System.out.print(z + "/" + arrayQ[i] + " = " + z/arrayQ[i] + "\n");
            arrayP[i] = arrayP[i] * (z/arrayQ[i]);
            arrayQ[i] = z;
        }

        System.out.print("\nМассив числителей " + Arrays.toString(arrayP) + "\n");
        System.out.print("Массив знаменателей " + Arrays.toString(arrayQ) + "\n\n");

        for (int i = 0; i < arrayP.length-1; ) {
            if (arrayP[i] > arrayP[i+1]) {
                int swap = arrayP[i];
                int swapQ = arrayQ[i];

                arrayP[i] = arrayP[i+1];
                arrayP[i+1] = swap;

                arrayQ[i] = arrayQ[i+1];
                arrayQ[i+1] = swapQ;
                if (i != 0) i--;
            }
            else {
                i++;
            }
        }

        System.out.print("Дроби в порядке возрастания:\n");
        System.out.print("Массив числителей " + Arrays.toString(arrayP) + "\n");
        System.out.print("Массив знаменателей " + Arrays.toString(arrayQ) + "\n");
    }



}
