package org.kimp;

import java.util.HashMap;
import java.util.LinkedList;

public class TicketQueue {
    private HashMap<Integer, Ticket> tickets = new HashMap<>();
    private static TicketQueue instance;

    static {
        instance = new TicketQueue();
    }

    public static TicketQueue getInstance() {
        return instance;
    }

    public static class Ticket {
        private int number;
        private TicketType type;

        private Ticket(int number, TicketType type) {
            this.number = number; this.type = type;
        }

        public TicketType getType() {
            return type;
        }

        public int getNumber() {
            return number;
        }
    }

    public void addTicket(TicketType type) {
        int n = tickets.keySet().size();
        if (n != 0) n = (int)tickets.keySet().toArray()[n - 1];
        do {
            n = n + 1;
        } while (tickets.containsKey(n) == true);
        tickets.put(n, new Ticket(n, type));
    }

    public Ticket popTicket() {
        if (tickets.keySet().size() == 0) return null;
        Ticket res = null;
        try {
            res = tickets.get(tickets.keySet().toArray()[0]);
            return res;
        } finally {
            tickets.remove(res.getNumber());
        }
    }
}
