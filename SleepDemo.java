public class SleepDemo {//Klasse zur Demonstration von Thread.sleep()
    public static void main(String[] args) {
        System.out.println(" Starte Countdown...");//Ausgabe, dass der Countdown gestartet wurde

        for (int i = 5; i >= 1; i--) {//Schleife, die die Sekunden bis zum Aufwachen des Threads zählt
            System.out.println(+ i + " Sekunden verbleiben...");// Jede Sekunde wird die Anzahl verbleibender Sekunden bis zum Aufwachen des 
            //Threads ausgegeben

            try {
                Thread.sleep(1000); // Thread schläft für 1000 Millisekunden (1 Sekunde)
            } catch (InterruptedException e) {
                System.out.println(" Der Schlaf wurde unterbrochen.");// Falls der Thread während des Schlafens unterbrochen wird, 
                //wird eine Fehlermeldung ausgegeben
            }
        }

        System.out.println(" Start erfolgt!");// Rückmeldung, dass der Countdown beendet ist und der Start erfolgt ist
    }}
