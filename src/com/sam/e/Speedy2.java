package com.sam.e;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static com.sam.e.Print.*;

public class Speedy2 implements Runnable {
    private static int ID = 0; // Unique ID
    String name = ""; // Name of the horse + ID
    private static int pos = 1; // Positions of horse at the finish line
    public int finalPos; // Finish Position per Horse
    public static ArrayList<Speedy2> positions = new ArrayList<>();
    public String strPos; // Position in cool format ex: 1st,2nd,3rd...etc



    public Speedy2() {
        this.name = "Horse#" + ID;
        ID++;
    }

    public void setName(String name) {
        this.name = (name + " #" + ID);
    }

    public static ArrayList<Speedy2> getPositions() {
        return positions;
    }


    @Override
    public void run() {
        Random random = new Random();
        // Total Amount of Runs of the for-loop
        final int distanceInMeters = 100; // Must be bigger than 1
        // Sleep Timer - Recommended < 100
        final int sensitivity = 101; // Must be bigger than 0
        for (int i = 1; i <= distanceInMeters; i++) {
            println(this.name + ": " + (((float)i/(float)distanceInMeters)*100) + "%");
            // Setting Random Priority to the current Thread for more randomization
            Thread.currentThread().setPriority(((int)(Math.random()*10))+1);
            try {
                int sleepTime = random.nextInt(sensitivity); // Random sleep
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        positions.add(this);
        strPos = locator(pos);
        println(this.name + "\tFinished in " + strPos + " place!\t" + LocalTime.now());
        this.finalPos = pos;
        pos++;
    }

    // Quick function that takes an int returns it as a String position
    public String locator(int p){
        if (p % 10 == 1 && p % 100 != 11) {
            return + p + "st";
        } else if (pos % 10 == 2 && pos % 100 != 12) {
            return + p + "nd";
        } else if (pos % 10 == 3 && pos % 100 != 13) {
            return + p + "rd";
        }else {
            return + p + "th";
        }
    }

    public static int returnPosInt(String s){
        int i = 1;
        try {
            i = Math.abs(Integer.parseInt(s));
            return i;
        }
        catch( Exception e ) {
             print("Please Enter a valid Integer: ");
             Scanner scanner = new Scanner(System.in);
             s = scanner.nextLine();
             i = returnPosInt(s);
            scanner.close();
            return i;
        }
    }

    // Horse Race!!
    public static void HorseRace(){
        // Lists of horses and threads
        ArrayList<Speedy2> horses = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        print("Enter total amount of horses to race: ");
        String numberOfHorses = scanner.nextLine();
        int totalHorses = returnPosInt(numberOfHorses);

        print("Enter Total Top Positions to show: ");
        String numberOfWinners = scanner.nextLine();
        int winners = returnPosInt(numberOfWinners);

        while(winners>totalHorses){
            print("\nRe-Enter the Top positions to show(Has to be less or equal to the amount of horses): ");
            numberOfWinners = scanner.nextLine();
            winners = returnPosInt(numberOfWinners);
        }

        final int posToShow = winners; // Show only top 3 winners

        for (int i = 0 ; i < totalHorses; i++){
            horses.add(new Speedy2());
            threads.add(new Thread(horses.get(i)));
            threads.get(i).start();
        }

        // Wait for all threads to finish
        try {
            for (int i = 0 ; i < totalHorses; i++){
                threads.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Speedy2> finalPositions = getPositions();
        println("\nFinal Positions: ");
        for (int i = 0 ; i < posToShow; i++){
            println(finalPositions.get(i).strPos + ": " + finalPositions.get(i).name);
        }
    }

    public static void main(String[] args) {
        print("Start Horse Race?(y/n) ");
        Scanner s = new Scanner(System.in);
        String start = s.nextLine();
        start = start.toLowerCase();
        while(start.equals("yes") || start.equals("y") || start.equals("1")){
            HorseRace();
            print("\nRun Horse Race Again?(y/n) ");
            start = s.nextLine();
            start = start.toLowerCase();
        }
        println("Goodbye!");
        // close scanner
        s.close();
    }
}
