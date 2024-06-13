package org.anderson.curso_ada.queue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        var rand = new Random();
        int client = rand.nextInt(101);
        Queue myQueue = new Queue(client);
        System.out.println("the customer arrived: " + client);
        for (int i = 1; i < n; i++) {
            client = rand.nextInt(101);
            System.out.println("the customer arrived: " + client);
            myQueue.enqueue(client);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("customer " + myQueue.dequeue().getValue() + " was served ");
        }

    }
}
