package org.kimp;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(5, 1);

        bank.getRegistrationTables()[0].requestService(TicketType.BUSINESS);
        bank.getRegistrationTables()[0].requestService(TicketType.PAYMENT);
        bank.getRegistrationTables()[0].requestService(TicketType.CREDIT);
        bank.getRegistrationTables()[0].requestService(TicketType.CARD);
        bank.getDisplay().printQueue();

        bank.getServiceWindows()[0].requestNextTicket();
        bank.getServiceWindows()[1].requestNextTicket();
        bank.getServiceWindows()[4].requestNextTicketWithType(TicketType.CARD);

        bank.getDisplay().printQueue();
    }
}
