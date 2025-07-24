package com.multithreading.examples;

public class Runable {//Klasse zur Demonstration von Runable in Java

    public static void main(String[] args) {

        Runnable aufgabe1 = () -> {//Erstellung eines ersten Runnable-Objektes
            for (int i = 1; i <= 5; i++) {//Runnabele führt eine Schleife von 1 bis 5 aus
                System.out.println(" Thread 1 Schritt " + i);// Rückgabe des aktuellen Schrittes von Thread 1
               
            }
        };

        
        Runnable aufgabe2 = () -> {//Erstellung eines zweiten Runnable-Objektes
            for (char c = 'A'; c <= 'E'; c++) {//Runnable führt eine Schleife von A bis E aus
                System.out.println("Thread 2 Buchstabe " + c);// Rückgabe des aktuellen Buchstabens von Thread 2
            }
        };

        Thread thread1 = new Thread(aufgabe1);// Erzeugung eines Threads mit der Aufgabe 1
        Thread thread2 = new Thread(aufgabe2);// Erzeugung eines Threads mit der Aufgabe 2

        thread1.start();// Start des ersten Threads
        thread2.start();// Start des zweiten Threads

        System.out.println(" Beide Threads wurden gestartet!");// Ausgabe an den Nutzer, sobald beide Threads gestartet wurden
    }
}
