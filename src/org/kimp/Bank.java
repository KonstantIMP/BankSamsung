package org.kimp;

/**
 * Unites queue, service window and registration tables
 */
public class Bank {
    private QueueDisplay display = new QueueDisplay();
    private ServiceWindow [] serviceWindows;
    private RegistrationTable [] registrationTables;

    public Bank(int numOfServiceWindows, int numOfRegistrationTables) {
        serviceWindows = new ServiceWindow[numOfServiceWindows];
        for (int i = 0; i < numOfServiceWindows; i++) {
            serviceWindows[i] = new ServiceWindow(i + 1);
            display.connectServiceWindow(serviceWindows[i]);
        }

        registrationTables = new RegistrationTable[numOfRegistrationTables];
        for (int i = 0; i < numOfRegistrationTables; i++) {
            registrationTables[i] = new RegistrationTable();
        }
    }

    public ServiceWindow[] getServiceWindows() {
        return serviceWindows;
    }

    public RegistrationTable[] getRegistrationTables() {
        return registrationTables;
    }

    public QueueDisplay getDisplay() {
        return display;
    }
}
