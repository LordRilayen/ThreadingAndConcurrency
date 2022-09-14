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

                System.out.println("I'm walking...");
            }
        }
    }

    public static class ChewGum implements Runnable {

        @Override
        public void run() {
            for(int i = 1; i < 5; i++){
                try{
                    Thread.sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("I'm chewing gum...");
            }
        }
    }

    public static void main(String[] args){
        Thread walkThread = new Thread(new Walk());
        Thread gumThread = new Thread(new ChewGum());

        try{
            walkThread.start();
            walkThread.join(5000);
            gumThread.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
