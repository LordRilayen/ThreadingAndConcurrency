package com.skillsoft.concurrency;

public class ThreadLifeCycle {

    public static class Walk implements Runnable {

        @Override
        public void run() {
            for(int i = 1; i < 5; i++){
                try{
                    Thread.sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("I'm walking...My isAlive state is " + Thread.currentThread().isAlive());
            }
        }
    }
//
//    public static class ChewGum implements Runnable {
//
//        @Override
//        public void run() {
//            for(int i = 1; i < 5; i++){
//                try{
//                    Thread.sleep(3000);
//                }
//                catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//
//                System.out.println("I'm chewing gum...");
//            }
//        }
//    }

//    public static void main(String[] args){
//        Thread walkThread = new Thread(new Walk());
//        Thread gumThread = new Thread(new ChewGum());
//
//        try{
//            walkThread.start();
//            walkThread.join(5000);
//            gumThread.start();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//    }

//    public static void main(String[] args){
//        Thread walkThread = new Thread(new Walk());
//
//        System.out.println("State of WalkThread after init: " + walkThread.getState());
//        System.out.println("State of main thread after walkthread init: " + Thread.currentThread().getState());
//
//        try {
//            walkThread.start();
//            System.out.println("State of WalkThread after start: " + walkThread.getState());
//            System.out.println("State of main thread after walkthread stat: " + Thread.currentThread().getState());
//
//            Thread.sleep(1000);
//            walkThread.join(5000);
//
//
//            walkThread.join();
//            System.out.println("State of WalkThread after join: " + walkThread.getState());
//            System.out.println("State of main thread after walkthread join: " + Thread.currentThread().getState());
//
//            System.out.println("Main thread will sleep for 20s...:");
//            Thread.sleep(20000);
//
//            System.out.println("State of WalkThread at the end: " + walkThread.getState());
//            System.out.println("State of main thread at the end: " + Thread.currentThread().getState());
//
//
//        }
//        catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//    }

    public static void main(String[] args){
        Thread walkThread = new Thread(new Walk());
        System.out.println("IsAlive state of walkThread after init: " + walkThread.isAlive());

        try{
            walkThread.start();
            System.out.println("isAlive state of walkThread after start: " + walkThread.isAlive());

            walkThread.join(5000);
            System.out.println("isAlive state of walkThread after join: " + walkThread.isAlive());

            Thread.sleep(10000);
            System.out.println("isAlive state of walkThread at the end: " + walkThread.isAlive());
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
