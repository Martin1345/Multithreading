public class Wait {
    private static final Object sperre = new Object();

    public static void main(String[] args) {
        Thread wartender_Thread = new Thread(() -> {
            synchronized (sperre) {// Snchroninsation mit sperre 
                System.out.println(" Thread 1 wartet...");// Ausgabe, dass der wartende Thread 
                //ausführbar wäre
                try {
                    sperre.wait(); // Der Thread wartet, bis er durch den notify() 
                    //Aufruf eines anderen Threads benachrichtigt wird
                } catch (InterruptedException e) {
                    System.out.println(" Thread wurde unterbrochen!");// Sollte der Thread unterbochen werden,
                    //so wird eine Fehlermeldung ausgegeben
                }
                System.out.println(" Thread 1 wurde benachrichtigt und macht weiter!");// Ausgabe 
                //an den Nutzer, dass Notify aufgerufen wurde und der wartende Thread weieterarbeiten kann
                
            }
        });

        Thread benachrichtigerThread = new Thread(() -> {
            try {
                Thread.sleep(2000); //Thread 2 pausiert für 2 Sekunden, um eine verzögerung zu simmulieren,
                //erst danach wird der wartende Thread benachrichtigt
            } catch (InterruptedException e) {
                e.printStackTrace();// Falls der Thread unterbrochen wird, 
                //wird eine Fehlermeldung ausgegeben
            }

            synchronized (sperre) {
                System.out.println(" Thread 2 benachrichtigt...");// Ausgabe an den Nutzer, 
                //dass der benachrichtigende 
                //Thread nun Notify aufruft
                sperre.notify(); // Aufruf von notify() auf dem sperre Objekt, 
                //um den wartenden Thread zu benachrichtigen
            }
        });

        wartender_Thread.start();// Start des wartenden Threads
        benachrichtigerThread.start();// Start des benachrichtigenden Threads
    }
}
