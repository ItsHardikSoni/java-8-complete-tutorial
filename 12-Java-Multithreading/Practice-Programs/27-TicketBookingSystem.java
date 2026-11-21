class TicketCounter {
    private int availableTickets;

    TicketCounter(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    synchronized void book(String customer) {
        if (availableTickets > 0) {
            availableTickets--;
            System.out.println(customer + " booked a ticket");
        } else {
            System.out.println(customer + ": sold out");
        }
    }
}

class TicketBookingSystem {
    public static void main(String[] args) throws InterruptedException {
        TicketCounter counter = new TicketCounter(3);
        Thread[] users = new Thread[5];
        for (int i = 0; i < users.length; i++) {
            String customer = "Customer " + (i + 1);
            users[i] = new Thread(() -> counter.book(customer));
            users[i].start();
        }
        for (Thread user : users) {
            user.join();
        }
    }
}
