package org.kimp;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistrationTable {
    private static final int LUNCH_TIME_H = 15;

    public TicketType [] getAvailableServices() {
        if ((new GregorianCalendar()).get(Calendar.HOUR_OF_DAY) < LUNCH_TIME_H) {
            return new TicketType[]{TicketType.CARD, TicketType.BUSINESS, TicketType.CREDIT, TicketType.PAYMENT};
        } else return new TicketType[]{TicketType.DOCUMENT};
    }

    public TicketQueue.Ticket requestService(TicketType type) {
        if (Arrays.asList(getAvailableServices()).contains(type)) {
            return TicketQueue.getInstance().addTicket(type);
        }
        // It is impossible because we choose service type from available
        return null;
    }
}
