package com.netcracker.edu.miloserdov.quadratic;

/**
 * Represents the quadratic equation.
 * Contains the method to solve it with returning x1 and x2 by entering a, b, and c in ax^2+bx+c=0.
 */

public class Quadratic {

    private final double a;
    private final double b;
    private final double c;

    /**
     * Constructor with 3 parameters.
     * @param a a in ax^2+bx+c=0.
     * @param b b in ax^2+bx+c=0.
     * @param c c in ax^2+bx+c=0.
     */

    Quadratic(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Getter of quadratic equation returns string of the following form: (a)x^2 + (b)x + (c) = 0.
     */

    public String getQuadratic(){
        return "(" + a + ")x^2" + " + (" + b + ")x + (" + c + ") = 0";
    }

    /**
     * Nested static class to find discriminant of equation.
     */

    public class Discriminant {

        private final double value; // Value of discriminant

        /**
         * Constructor evaluates discriminant and changes the field value by entering 3 params a, b, c in ax^2+bx+c=0.
         */

        Discriminant(){
            value = (b*b -4*a*c);
        }

        /**
         * Getter returns double value of discriminant
         */

        public double getDiscriminant(){
            return value;
        }

    }

    /**
     * Solving equation, returns the string with information about the roots.
     */

    public String solve(){

        double x1;
        double x2;
        double D = new Discriminant().getDiscriminant();

        System.out.println("Your equation is " + this.getQuadratic()); // information about equation

        if (D < 0){
            return "Discriminant is negative. There are no roots.";
        }else if (D == 0){
            x1 = (-b)/(2*a);
            return "Discriminant equals to zero. There is one root: " + String.format("%.3f", x1);
        }

        x1 = (-b + Math.sqrt(D))/(2*a);
        x2 = (-b - Math.sqrt(D))/(2*a);

        return "Discriminant is positive. There are two roots: " + String.format("%.3f", x1) + " and " + String.format("%.3f", x2);
    }

}

/*
Структура файлов .class:
После компиляции появляются два файла Quadratic.class и Quadratic$Discriminant.class
Один из которых относится к основному классу, а другой к вложенному. Компилятор javac создает
по одному .class файлу для каждого класса, интерфейса и модуля, определенных в исходном коде,
поэтому создается не один а два файла Quadratic.class и Quadratic$Discriminant.class.
Один из которых относится к основному классу Quadratic, а другой к вложенному Discriminant.
 */

/*
Анализ использования вложенного класса:

Создание объекта класса:
Quadratic equation =  new Quadratic(double a, double b, double c);
Quadratic.Discriminant D = equation. new Discriminant();

Обращение к методам класса выглядит следующим образом :
<Quadratic>.Discriminant.<method>().

Таким образом класс можно использовать только вместе с объявленным объектом класса Quadratic.
 */