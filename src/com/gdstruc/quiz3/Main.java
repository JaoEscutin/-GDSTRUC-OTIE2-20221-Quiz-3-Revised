package com.gdstruc.quiz3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        ArrayQueue arrayQueue = new ArrayQueue(11);
        Player [] players = {new Player(10,"Jayce",30),
                new Player(9,"Jinx",28),
                new Player(8,"Lux",25),
                new Player(7,"Teemo",23),
                new Player(6,"Vi",21),
                new Player(5,"Ez",20),
                new Player(4,"Jax",18),
                new Player(3,"Vanz",16),
                new Player(2,"Udyr",10),
                new Player(1,"Caitlyn",5)};

        System.out.println("List of Players: ");
        for (int i =0; i < players.length; i++){
            System.out.println(players[i]);
        }

        System.out.println("==========================");
        System.out.println("=== GAME START ===");

        int games = 0;
        int counter = 1;
        while (games != 10){
            System.out.println ("TURN " + counter);
            System.out.println("==========================");
            int x = r.nextInt(7) + 1;
            for (int i = 0; i < x; i++){
                arrayQueue.enqueue(players[i]);
            }

            System.out.println("Number of players queued: " + x);
            System.out.println("Players queued: ");
            arrayQueue.printQueue();

            if (arrayQueue.size() >= 5){
                System.out.println("Game has started.");
                games++;
                for (int i = 0; i < 5; i++){
                    arrayQueue.dequeue();
                }
                System.out.println("Players have been dequeued. Queue size: " + arrayQueue.size());
                System.out.println("Game has ended.");
                System.out.println("Hit enter to start again");
                String input = scanner.nextLine();
                if (input != null){
                    counter = 1;
                }
            }
            else {
                System.out.println("Hit enter to move to next turn");
                String input = scanner.nextLine();
                if (input != null){
                    counter++;
                }
            }
            System.out.println("==========================");
            System.out.println("Total games started: " + games);
        }
        if (games == 10){
            System.out.println("All 10 games have been completed");
        }

    }
}