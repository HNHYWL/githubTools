package com.githubtools.githubtools.http;

public interface Myi {
    default void show() {
        System.out.println("hah");
    }

    public static void main(String[] args) {
        new Myi(){

        }.show();
    }
}
