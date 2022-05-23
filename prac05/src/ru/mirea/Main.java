package ru.mirea;

public class Main {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton1Copy = Singleton1.getInstance();

        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton2Copy = Singleton2.getInstance();

        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton3Copy = Singleton3.getInstance();
        Singleton3 singleton3AnotherCopy = Singleton3.INSTANCE;

        MyClass object = new MyClass();
        MyClass objectCopy = new MyClass();

        System.out.print("\nSingleton1 hashCodes: ");
        System.out.print(singleton1.hashCode() + " ");
        System.out.println(singleton1Copy.hashCode());

        System.out.print("\nSingleton2 hashCodes: ");
        System.out.print(singleton2.hashCode() + " ");
        System.out.println(singleton2Copy.hashCode());

        System.out.print("\nSingleton3 hashCodes: ");
        System.out.print(singleton3.hashCode() + " ");
        System.out.print(singleton3Copy.hashCode() + " ");
        System.out.println(singleton3AnotherCopy.hashCode());

        System.out.print("\nMyClass hashCodes: ");
        System.out.print(object.hashCode() + " ");
        System.out.println(objectCopy.hashCode());
    }
}

