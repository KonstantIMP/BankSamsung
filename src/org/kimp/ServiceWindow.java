package org.kimp;

public class ServiceWindow {
    private TicketQueue.Ticket currentTicket = null;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TicketQueue.Ticket getCurrentTicket() {
        return currentTicket;
    }

    public ServiceWindow(int number) {
        this.number = number;
    }

    public void requestNextTicket() {
        finishCurrentTicket();
        currentTicket = TicketQueue.getInstance().popTicket();
    }

    public void requestNextTicketWithType(TicketType type) {
        finishCurrentTicket();
        for(TicketQueue.Ticket t : TicketQueue.getInstance().getTickets()) {
            if (t.getType() == type) {
                currentTicket = TicketQueue.getInstance().popTicket(t.getNumber());
            }
        }
    }

    public void finishCurrentTicket() {
        currentTicket = null;
    }
}
