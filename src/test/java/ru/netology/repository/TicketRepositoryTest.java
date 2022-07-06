package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketRepositoryTest {

    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 11000, "LED", "DME", 95);
    Ticket ticket2 = new Ticket(2, 20000, "LED", "AAQ", 295);
    Ticket ticket3 = new Ticket(3, 25000, "LED", "AER", 295);
    Ticket ticket4 = new Ticket(4, 18000, "LED", "MCX", 235);
    Ticket ticket5 = new Ticket(5, 50000, "LED", "VVO", 975);
    Ticket ticket6 = new Ticket(6, 21000, "LED", "KHV", 480);
    Ticket ticket7 = new Ticket(7, 36000, "LED", "MVR", 325);
    Ticket ticket8 = new Ticket(8, 16000, "LED", "PES", 185);
    Ticket ticket9 = new Ticket(9, 10000, "LED", "DME", 89);
    Ticket ticket10 = new Ticket(10, 35000, "LED", "VVO", 975);


    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);

    }


    @Test
    public void shouldSaveTicketAndFindAll() {
        setup();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = repo.getTickets();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNullIfNoSaveTicket() {
        Ticket[] expected = {};
        Ticket[] actual = repo.getTickets();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        setup();
        Ticket[] expected = {ticket3};
        Ticket[] actual = repo.findById(3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNullIfFindByNotExistingId() {
        setup();
        Ticket[] expected = null;
        Ticket[] actual = repo.findById(22);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByValidId() {
        setup();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket10};
        Ticket[] actual = repo.removeById(9);
        assertArrayEquals(expected, actual);
    }
}
