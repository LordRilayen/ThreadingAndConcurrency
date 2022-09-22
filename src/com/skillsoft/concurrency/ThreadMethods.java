package com.skillsoft.concurrency;

public class ThreadMethods {

    public static class Walk implements Runnable{

        @Override
        public void run(){
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

        public static class ChewGum implements Runnable {

            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("I'm chewing gum...");
                }
            }
        }

        public static void main(String[] args){
            Thread walkThread = new Thread(new Walk());
            Thread chewThread = new Thread(new ChewGum());

//            walkThread.start();
//            chewThread.start();
//
//            System.out.println("\nwalkThread's ID: " + walkThread.getId());
//            System.out.println("\nchewThread's ID: " + chewThread.getId());
//            System.out.println("\nmain thread's ID: " + Thread.currentThread().getId());
//
//            System.out.println("\nwalkThread's name: " + walkThread.getName());
//            System.out.println("\nchewThread's name: " + chewThread.getName());
//            System.out.println("\nmain thread's name: " + Thread.currentThread().getName());
//
//            System.out.println("\nwalkThread's thread group: " + walkThread.getThreadGroup());
//            System.out.println("\nchewThread's thread group: " + chewThread.getThreadGroup());
//            System.out.println("\nmain thread's thread group: " + Thread.currentThread().getThreadGroup());
//
//            System.out.println("\nwalkThread's priority: " + walkThread.getPriority());
//            System.out.println("\nchewThread's priority: " + chewThread.getPriority());
//            System.out.println("\nmain thread's priority: " + Thread.currentThread().getPriority());
//
//            System.out.println("#Active threads: " + Thread.activeCount());
//

//            walkThread.setPriority(9);
//            chewThread.setPriority(2);
//
//            System.out.println("\nwalkThread's priority: " + walkThread.getPriority());
//            System.out.println("\nchewThread's priority: " + chewThread.getPriority());
//            System.out.println("\nmain thread's priority: " + Thread.currentThread().getPriority());
//
//            walkThread.start();
//            chewThread.start();

            chewThread.setDaemon(true);

            System.out.println("\nwalkThread's daemon status: " + walkThread.isDaemon());
            System.out.println("\nchewThread's daemon status: " + chewThread.isDaemon());
            System.out.println("\nmain thread's daemon status: " + Thread.currentThread().isDaemon());

            try {
                walkThread.start();
                walkThread.join(5000);
                chewThread.start();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("\n\n");
        }
    }
}
