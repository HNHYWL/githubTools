package com.githubtools.githubtools.beantest;

public class Fu {
    static {
        System.out.println("fu static");
    }

    public Fu(int i) {

        System.out.println("fu "+i);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("aa");
        Fu fu = Fu.class.newInstance();
    }
}

class Zi extends Fu {
    static {
        System.out.println("zi static");
    }

    Zi() {
        super(1);
        System.out.println("zi");

    }

    public static void main(String[] args) {
        new Zi();
    }
}


class T{
    public static void main(String[] args) {
        new Zi();
        K[] values = K.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            System.out.println(values[i].ordinal());
            System.out.println(values[i].i);
        }

    }
}

enum K {
    A(1), B(2), C(3), D(4);

    int i;

      K(int i) {
        this.i = i;
    }
}


