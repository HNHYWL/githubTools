package com.githubtools.githubtools.beantest;

public class AbstractFu {
    private int a = 90;

    public int getA() {
        return a;
    }
}


class Z extends AbstractFu{

    int b;

    @Override
    public int getA() {
        return super.getA();
    }

    public static void main(String[] args) {
        int a = new Z().getA();
        System.out.println(a);

        AbstractFu fu = new Z();
        System.out.println(fu.getA());

    }
}
