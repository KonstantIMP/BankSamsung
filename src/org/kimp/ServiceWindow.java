package org.kimp;

/**
 * Describes the service window for tickets process
 */
public class ServiceWindow {
    private TicketQueue.Ticket currentTicket = null;
    private int number;

    /**
     * @return Number of the window
     */
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return Ticket which are being processed by the window
     */
    public TicketQueue.Ticket getCurrentTicket() {
        return currentTicket;
    }

    /**
     * Creates new window
     * @param number Number for the window
     */
    public ServiceWindow(int number) {
        this.number = number;
    }

    /**
     * Get new ticket for processing from the queue
     */
    public void requestNextTicket() {
        finishCurrentTicket();
        currentTicket = TicketQueue.getInstance().popTicket();
    }

    /**
     * Get new ticket with the specified type for processing
     * @param type Available service type
     */
    public void requestNextTicketWithType(TicketType type) {
        finishCurrentTicket();
        for(TicketQueue.Ticket t : TicketQueue.getInstance().getTickets()) {
            if (t.getType() == type) {
                currentTicket = TicketQueue.getInstance().popTicket(t.getNumber());
            }
        }
    }

    /**
     * Finish current ticket
     */
    public void finishCurrentTicket() {
        currentTicket = null;
    }
}
