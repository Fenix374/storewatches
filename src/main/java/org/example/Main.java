package org.example; // Объявление пакета

import java.util.ArrayList; // Импорт класса ArrayList из пакета java.util
import java.util.Scanner; // Импорт класса Scanner из пакета java.util

class Customer { // Объявление класса Customer
    String name; // Объявление строки name
    String mail; // Объявление строки mail
    String phone; // Объявление строки phone
    String[] productPosition; // Объявление массива строк productPosition
    int quantity; // Объявление целочисленной переменной quantity

    public Customer(String name, String mail, String phone, String[] productPosition, int quantity) { // Объявление конструктора класса Customer с параметрами
        this.name = name; // Присвоение значения параметра name полю класса
        this.mail = mail; // Присвоение значения параметра mail полю класса
        this.phone = phone; // Присвоение значения параметра phone полю класса
        this.productPosition = productPosition; // Присвоение значения параметра productPosition полю класса
        this.quantity = quantity; // Присвоение значения параметра quantity полю класса
    }

    public String toString() { // Переопределение метода toString для класса Customer
        return "Покупатель: " + name + "\nПочта: " + mail + "\nНомер телефона: " + phone +
                "\nПродукт: " + productPosition[0] + " бренда " + productPosition[1] + "\nКоличество: " + quantity; // Возврат строки с данными о покупателе
    }
}

public class Main { // Объявление класса Main
    public static void main(String[] args) { // Объявление метода main
        String[] brands = {"Tissot", "Rolex", "Маяк"}; // Объявление массива строк brands
        String[][] models = { // Объявление двумерного массива строк models
                {"Кварцевые", "Tissot"}, // Элемент массива
                {"Золотые", "Rolex"}, // Элемент массива
                {"Скелетон", "Маяк"} // Элемент массива
        };

        ArrayList<Customer> customers = new ArrayList<>(); // Создание списка покупателей
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для ввода данных с клавиатуры

        for (int i = 0; i < 3; i++) { // Цикл для ввода данных о покупателях
            System.out.println("Введите данные покупателя для заказа " + (i + 1) + ":"); // Вывод приглашения к вводу данных
            System.out.print("ФИО: "); // Вывод приглашения к вводу ФИО
            String name = scanner.nextLine(); // Считывание ФИО с клавиатуры
            System.out.print("Почта: "); // Вывод приглашения к вводу почты
            String mail = scanner.nextLine(); // Считывание почты с клавиатуры
            System.out.print("Номер телефона: "); // Вывод приглашения к вводу номера телефона
            String phone = scanner.nextLine(); // Считывание номера телефона с клавиатуры

            System.out.println("Доступные позиции товаров:"); // Вывод списка доступных товаров
            for (int j = 0; j < models.length; j++) { // Цикл для вывода доступных позиций товаров
                System.out.println((j + 1) + ". " + models[j][0] + " бренда " + models[j][1]); // Вывод информации о доступной позиции товара
            }
            System.out.print("Введите номер позиции товара: "); // Вывод приглашения к вводу номера позиции товара
            int positionNumber = Integer.parseInt(scanner.nextLine()) - 1; // Считывание номера позиции товара с клавиатуры
            String[] selected = models[positionNumber]; // Выбор позиции товара

            System.out.print("Введите количество: "); // Вывод приглашения к вводу количества товара
            int quantity = Integer.parseInt(scanner.nextLine()); // Считывание количества товара с клавиатуры

            customers.add(new Customer(name, mail, phone, selected, quantity)); // Добавление покупателя в список
        }

        System.out.println("\nЗаказы:"); // Вывод заголовка списка заказов
        for (Customer customer : customers) { // Цикл для вывода списка заказов
            System.out.println(customer + "\n"); // Вывод информации о заказе
        }
    }
}
