package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    AviaSouls avia = new AviaSouls();

    Ticket ticket1 = new Ticket("Самара", "Москва", 5_000, 19, 22);
    Ticket ticket2 = new Ticket("Самара", "Москва", 900, 0, 2);
    Ticket ticket3 = new Ticket("Самара", "Москва", 30_000, 3, 23);
    Ticket ticket4 = new Ticket("Самара", "Москва", 5_000, 14, 15); // == по цене с t1
    Ticket ticket5 = new Ticket("Самара", "Москва", 7_000, 5, 7); // == по времени с t2

    Ticket ticket6 = new Ticket("Самара", "Казань", 11_000, 5, 7);
    Ticket ticket7 = new Ticket("Казань", "Москва", 15_000, 10, 14);


    @Test
    public void addTickets() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] act = avia.findAll();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void compareToIfLess() {

        int exp = -1;
        int act = ticket2.compareTo(ticket1);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compareToIfMore() {

        int exp = 1;
        int act = ticket3.compareTo(ticket4);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compareToIfEqual() {

        int exp = 0;
        int act = ticket1.compareTo(ticket4);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compareIfLess() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        int exp = -1;
        int act = comparator.compare(ticket1, ticket3);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compareIfMore() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        int exp = 1;
        int act = comparator.compare(ticket5, ticket4);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compareIfEqual() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        int exp = 0;
        int act = comparator.compare(ticket2, ticket5);

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void searchAndSortByPriceFromYesToYes() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {ticket2, ticket1, ticket4, ticket5, ticket3};
        Ticket[] act = avia.search("Самара", "Москва");

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void searchFromYesToNo() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {};
        Ticket[] act = avia.search("Казань", "Волгоград");

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void searchFromNoToYes() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {};
        Ticket[] act = avia.search("Волгоград", "Казань");

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void searchFromNoToNo() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {};
        Ticket[] act = avia.search("Волгоград", "Пенза");

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void searchAndSortByTimeFromYesToYes() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {ticket4, ticket2, ticket5, ticket1, ticket3};
        Ticket[] act = avia.searchAndSortBy("Самара", "Москва", comparator);
        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void searchAndSortByTimeFromYesToNo() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {};
        Ticket[] act = avia.searchAndSortBy("Самара", "Таганрог", comparator);
        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void searchAndSortByTimeFromNoToYes() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {};
        Ticket[] act = avia.searchAndSortBy("Саратов", "Москва", comparator);
        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void searchAndSortByTimeFromNoToNo() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] exp = {};
        Ticket[] act = avia.searchAndSortBy("Саратов", "Саранск", comparator);
        Assertions.assertArrayEquals(exp, act);
    }


}
