package org.kimp;

import java.io.PrintStream;
import java.util.LinkedList;

public class QueueDisplay {
    private LinkedList<ServiceWindow> windows = new LinkedList<>();
    private static PrintStream out = new PrintStream(System.out);

    public void connectServiceWindow(ServiceWindow window) {
        if (windows.contains(window) == false) windows.add(window);
    }

    public void disconnectServiceWindow(ServiceWindow window) {
        windows.remove(window);
    }

    public void printQueue() {
        out.println(" Window | Ticket ");
        for(var w : windows) {
            if (w.getCurrentTicket() != null)
                out.printf("   %2d   |   %2d   %n", w.getNumber(), w.getCurrentTicket().getNumber());
        }
        out.print(" Other tickets: ");
        for (var t: TicketQueue.getInstance().getTickets()){
            out.print(t.getNumber() + " ");
        } out.println();
    }
}
