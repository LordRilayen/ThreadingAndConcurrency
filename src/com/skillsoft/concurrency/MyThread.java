package com.skillsoft.concurrency;

public class MyThread implements Runnable{

    @Override
    public void run(){
        for(int i = 1; i < 5; i++){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " says: " + i);
        }
    }

    public static void main(String[] args){
        Thread firstThread = new Thread(new MyThread(), "1st Thread");
        Thread secondThread = new Thread(new MyThread());
        secondThread.setName("2nd Thread");

        firstThread.start();
        secondThread.start();

        //This will throw an IllegalThreadStateException, because it isn't legal to start the same thread more than once
        //firstThread.start();

        //This will NOT throw an IllegalThreadStateException, because calling the run() method directly causes it to be
        //called in the CURRENT thread, rather than first starting up a NEW thread
        //firstThread.run();
    }
}
