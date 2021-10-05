import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);

        Integer[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        String [] str = {"яблоки", "помидоры", "огурцы", "кабачки", "апельсины"};

        //1. вызов метода для замены местами членов массива с указанием номеров изменяющих своё место членов массива
        System.out.println("Задание 1. Изменение мест членов массива");
        System.out.println(Arrays.toString(arr));
        System.out.println("Введите номера членов массива цифр для замены, нажмите Enter!");
        int num1 = in.nextInt()-1;
        int num2 = in.nextInt()-1;
        System.out.println(Arrays.toString(swap(arr, num1, num2)));//меняем местами цифры

        System.out.println();
        System.out.println("Изменение мест членов массива слов");
        System.out.println(Arrays.toString(str));
        System.out.println("Введите номера членов массива слов для замены, нажмите Enter!");
        int str1 = in.nextInt()-1;
        int str2 = in.nextInt()-1;
        System.out.println(Arrays.toString(swap(str, str1, str2)));//меняем местами строки
        System.out.println();


        //2. вызов метода для преобразования массива в АррайЛист
        arrayToList(arr);
        arrayToList(str);


        //3. Классы коробки и фруктов

        ArrayList <Apple> appleList = new ArrayList<>(); //лист яблок
        ArrayList <Orange> orangeList = new ArrayList<>(); //лист апельсинов
        ArrayList <Apple> appleList2 = new ArrayList<>(); //лист яблок 2

        BoxWithFruit <Apple> appleBox1 = new BoxWithFruit<>(appleList); //объект коробки с яблоками
        BoxWithFruit <Apple> appleBox2 = new BoxWithFruit<>(appleList2); //объект коробки с яблоками

        BoxWithFruit <Orange> orangeBox1 = new BoxWithFruit<>(orangeList); //объект коробки с апельсинами
       // BoxWithFruit <Orange> orangeBox2 = new BoxWithFruit<>(orangeList); //объект коробки с апельсинами

        Apple apple = new Apple();
        Orange orange = new Orange();

        // добавляем фрукты в коробки из консоли
        System.out.println();
       // Scanner in = new Scanner (System.in);
        System.out.println("Введите количество яблок для добавления в коробку 1:");
        int appleAmount = in.nextInt();
        System.out.println("Введите количество апельсин для добавления в коробку 2:");
        int orangeAmount = in.nextInt();

        for (int i=0; i<appleAmount; i++) {
            appleBox1.addFruit(apple);
        }
        for (int i=0; i<orangeAmount; i++) {
            orangeBox1.addFruit(orange);
        }


        //вызываем метод подсчёта веса коробки
        System.out.println();
        System.out.println("Взвешиваем коробки с фруктами!");
        float appleBox1Weight = appleBox1.getWeight();
        System.out.println("Вес коробки с яблоками 1: "+ appleBox1Weight);

        float orangeBox1Weight = orangeBox1.getWeight();
        System.out.println("Вес коробки с апельсинами 1: " + orangeBox1Weight);

        //вызываем метод сравнения коробок

        System.out.println();
        System.out.println("Сравниваем вес коробок с яблоками и апельсинами!");
        if (appleBox1.compare(orangeBox1)) {
            System.out.println("Вес коробок одинаковый и равен: "+ appleBox1.getWeight());
        } else {
            System.out.println("Вес коробок разный." );
            System.out.println("Коробка с яблоками 1 весит: "+appleBox1.getWeight());
            System.out.println("Коробка с апельсинами 1 весит: "+orangeBox1.getWeight());
        }

        //вызов метода пересыпания фруктов из коробки в коробку

        System.out.println();
        System.out.println("Пересыпаем яблоки из одной коробки в другую");
        appleBox1.pourFruits(appleBox2);

        System.out.println("Вес коробки с яблоками 2: "+ appleBox2.getWeight());

        System.out.println("Вес коробки с яблоками 1: "+ appleBox1.getWeight());
    }

    //метод для изменения мест указанных элементов в массиве обобщённого типа
    public static <T> T[] swap (T [] arr, int i, int j) {
        try {
            T ii = arr[i];
            T jj = arr[j];
            arr[i] = jj;
            arr[j] = ii;

        } catch  (ArrayIndexOutOfBoundsException e) {
        System.out.println("Введены некорректные номера членов массива!");

        }
        return arr;

    }

    //метод для преобразования массива в Лист
    public static <T> ArrayList<T> arrayToList (T [] arr) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }
}


