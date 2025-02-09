package com.sam.e;

import java.util.Random;

import static com.sam.e.Print.println;
public class Speedy implements Runnable {
    private boolean flag = false;
    private Speedy competitor;
    int num = 0;
    private static int ID = 0;
    String name = "";

    public void setCompetitor(Speedy competitor) {
        ID++;
        this.competitor = competitor;
    }

    public Speedy(Speedy competitor) {
        this.competitor = competitor;
        this.name = "Speedy" + ID;
        ID++;
    }



    public void stop() {
        this.flag = true;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            this.num++;
            if (flag) {
                break;
            }
            println(this.name + ": " + i);
            try {
                int sleepTime = random.nextInt(101); // Random sleep between 0 and 1000 ms
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (competitor != null) {
            competitor.stop(); // Notify the competitor to stop
        }
    }
    public static void main(String[] args) {
        // Create two Speedy instances
        Speedy speedy1 = new Speedy(null); // Initially, speedy1 has no competitor
        Speedy speedy2 = new Speedy(speedy1); // speedy2's competitor is speedy1

        // Set speedy1's competitor to speedy2
        speedy1.setCompetitor(speedy2);

        // Create Thread objects and pass the Speedy instances
        Thread thread1 = new Thread(speedy1);
        Thread thread2 = new Thread(speedy2);

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish (optional)
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (speedy1.num > speedy2.num){
            println(speedy1.name + " Won!");
        }else if(speedy1.num < speedy2.num){
            println(speedy2.name + " Won!");
        }else{
            println("It's a Draw!!!!");
        }


    }
}
