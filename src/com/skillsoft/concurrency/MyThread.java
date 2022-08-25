package com.skillsoft.concurrency;

public class MyThread implements Runnable{

    @Override
    public void run(){
        System.out.println("This has been executed by a thead.");
        System.out.println("Current thread name: "
                + Thread.currentThread().getName());
    }

    public static void main(String[] args){
        Thread myThread = new Thread(new MyThread());
        System.out.println("Current thread name: "
                + Thread.currentThread().getName());

        myThread.start();

        System.out.println("Is myThread a Runnable? "
                + (myThread instanceof Runnable));

        System.out.println("Is myThread a Thread? "
                + (myThread instanceof Thread));

        System.out.println("Is myThread a Object? "
                + (myThread instanceof Object));
    }
}
