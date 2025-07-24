import java.util.concurrent.Callable;// Importierung der Klasse Callable
import java.util.concurrent.ExecutorService;// Importierung der Klasse ExecutorService
import java.util.concurrent.Executors;// Importierung der Klasse Executors
import java.util.concurrent.Future;// Importierung der Klasse Future

public class Callable_Beispiel {// Klasse zur Demonstration der Verwendung von Callable
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();//Erstellung eines ThreadPool, 
        //der nur einen Thread verwaltet

    
        Callable<Integer> aufgabe = () -> {// Definition der Aufgabe, 
            //die auf dem Thread ausgeführt wird
            int zahl = 21;// Zahl, mit der durch den Thread 
            //gearbeitet wird
            Thread.sleep(500); // Simulation einer Rechenzeit von 500 
            //Millisekunden durch den Thread
            return zahl * 2;   // Durchführung der Aufgabe(verdoppeln der Zahl)
            //und Rückgabe des Ergebnisses
        };

        try {
            // Weitergabe der Aufgabe an den Executor der diese an den Thread weitergibt
            Future<Integer> ergebnis = executor.submit(aufgabe);//Der Executor führt 
            //die Aufgabe asynchron aus und gibt ein Future-Objekt zurück

            System.out.println("Ergebnis: " + ergebnis.get());//Abruf des Ergebnisses der Aufgabe, 
            //erst möglich, wenn Berechnung abgeschlossen ist
        } catch (Exception e) {
            
            System.err.println("Fehler bei der Ausführung der Aufgabe: " + e.getCause());// Ausgabe einer Fehlermeldung, 
            //falls bei der Ausführung des Threads eine Exception auftritt
        } finally {
        
            executor.shutdown();// Beenden des Executors und Freigabe der Ressourcen auch wenn 
            //eine Exception aufgetreten ist
        }
    }
}
