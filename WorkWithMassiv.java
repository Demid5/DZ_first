import java.util.Arrays;


import static java.lang.System.out;

public class WorkWithMassiv {

    // реверс массива
    public static int[] revers(int [] mass) {
        int temp = 0;
        for (int i = 0; i < (mass.length) / 2; ++i) {
            temp = mass[i];
            mass[i] = mass[mass.length - i - 1];
            mass[mass.length - i - 1] = temp;
        }
        return mass;
    }

    // поиск максимального элемента в массиве
    public static int max(int [] mass) {
        int maxElem = Integer.MIN_VALUE;
        for (int elem: mass)
            maxElem = Math.max(maxElem, elem);
        return maxElem;
    }

    // поиск минимального элемента в массиве
    public static int min(int [] mass) {
        int minElem = Integer.MAX_VALUE;
        for (int elem: mass)
            minElem = Math.min(minElem, elem);
        return minElem;
    }


    // среднее значение в массиве
    public static double middle(int [] mass) {
        double mid = 0;
        for (int elem: mass) {
            mid += elem;
        }
        return (mid / mass.length);
    }


    // сортировка методом пузырька
    public static int[] sort(int [] mass) {
        int temp;
        for (int i = 0; i < mass.length; ++i)
            for (int j = 0; j < mass.length - 1; ++j)
                if (mass[j] > mass[j + 1]) {
                    temp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = temp;
                }
        return mass;
    }



    //наибольшая непрерывно возрастающая подпоследователььность
    public static int[] LIP(int [] mass) {
        int left = 0;
        int Left = 0, Right = 0;
        int distance = -1;

        for (int right = 1; right < mass.length; ++right) {
            if (mass[right - 1] <= mass[right]) {
                distance = right - left;
                Right = right;
                Left = left;
            }
            else {
                left = right;
            }
        }
        int []resultMass = new int[Right - Left + 1];
        for (int i = Left; i <= Right; ++i)
            resultMass[i - Left] = mass[i];
        return resultMass;
    }

    public static int mediana(int [] mass) {
        mass = sort(mass);
        return mass[mass.length / 2];
    }

}
