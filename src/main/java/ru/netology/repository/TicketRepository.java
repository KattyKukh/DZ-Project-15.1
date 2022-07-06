package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findById(int id) {
        Ticket[] tmp = new Ticket[1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                tmp[0] = tickets[copyToIndex];
                return tmp;
            } else {
                copyToIndex++;
            }
        }
        return null;
    }

    public void save(Ticket ticket) {
//        if (findById(ticket.getId()) != null) {
//            throw new AlreadyExistsException("Element with id: " + ticket.getId() + " already exists!");
//        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] removeById(int id) {
//        if (findById(id) == null) {
//            throw new NotFoundException("Element with id: " + id + " not found");
//        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                copyToIndex++;
                tmp[copyToIndex - 1] = ticket;
            }
        }
        tickets = tmp;
        return tickets;
    }

    public Ticket[] getTickets() {
        return tickets;
    }
}
