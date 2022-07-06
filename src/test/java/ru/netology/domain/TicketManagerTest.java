package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 11000, "LED", "DME", 95);
    Ticket ticket2 = new Ticket(2, 20000, "LED", "AAQ", 295);
    Ticket ticket3 = new Ticket(3, 25000, "LED", "PES", 195);
    Ticket ticket4 = new Ticket(4, 18000, "LED", "MCX", 235);
    Ticket ticket5 = new Ticket(5, 50000, "LED", "VVO", 975);
    Ticket ticket6 = new Ticket(6, 21000, "LED", "KHV", 480);
    Ticket ticket7 = new Ticket(7, 36000, "LED", "MVR", 325);
    Ticket ticket8 = new Ticket(8, 16000, "LED", "PES", 185);
    Ticket ticket9 = new Ticket(9, 9000, "LED", "DME", 89);
    Ticket ticket10 = new Ticket(10, 50000, "LED", "VVO", 975);
    Ticket ticket11 = new Ticket(11, 45000, "LED", "AER", 295);
    Ticket ticket12 = new Ticket(12, 52000, "LED", "KHV", 480);
    Ticket ticket13 = new Ticket(13, 50000, "LED", "VVO", 880);
    Ticket ticket14 = new Ticket(14, 25000, "LED", "MVR", 235);
    Ticket ticket15 = new Ticket(15, 10000, "LED", "PES", 280);
    Ticket ticket16 = new Ticket(16, 27000, "LED", "MCX", 200);
    Ticket ticket17 = new Ticket(17, 20000, "LED", "AAQ", 295);
    Ticket ticket18 = new Ticket(18, 18000, "LED", "PES", 185);
    Ticket ticket19 = new Ticket(19, 57000, "LED", "KHV", 480);
    Ticket ticket20 = new Ticket(20, 9000, "LED", "DME", 95);

    @BeforeEach
    public void prepare() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);
        manager.add(ticket14);
        manager.add(ticket15);
        manager.add(ticket16);
        manager.add(ticket17);
        manager.add(ticket18);
        manager.add(ticket19);
        manager.add(ticket20);
    }

    @Test
    public void shouldFindTicketsAndSortByIncludedEqualsPriceAndTravelTime() {
        Ticket[] expected = {ticket9, ticket20, ticket1};
        Ticket[] actual = manager.findAll("LED", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsAndSortByPriceAndTravelTime() {
        Ticket[] expected = {ticket15, ticket8, ticket18, ticket3};
        Ticket[] actual = manager.findAll("LED", "PES");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsAndNotSortByPriceIfPricesAndTravelTimeIsEquals() {
        Ticket[] expected = {ticket2, ticket17};
        Ticket[] actual = manager.findAll("LED", "AAQ");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsAndSortByTravelTimeIfPricesIsEquals() {
        Ticket[] expected = {ticket13, ticket5, ticket10};
        Ticket[] actual = manager.findAll("LED", "VVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTickets() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DME", "MCX");
        assertArrayEquals(expected, actual);
    }
}
