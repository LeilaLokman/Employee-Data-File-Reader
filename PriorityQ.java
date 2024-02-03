/**
 * Class used to store countries in a priority queue and manipulating it
 * 
 * @author Leila Lokman
 * @version 10/27/2023
 */
public class PriorityQ {
    private Country[] countries = new Country[128];

    private Node first;
    private Node last;

    public PriorityQ() {
        first = null;
        last = null;
    }
    /**
     * method used to insert a country into the priority queue
     * 
     * @param country data from file
     * @return void
     */
    public void insert(Country country) {
        Node newNode = new Node(country);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            Node current = first;
            Node previous = null;

            while (current != null && country.getPopulation() < current.country.getPopulation()) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                // Insert at the beginning
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
            } else if (current == null) {
                // Insert at the end
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            } else {
                // Insert in the middle
                newNode.prev = previous;
                newNode.next = current;
                previous.next = newNode;
                current.prev = newNode;
            }
        }
    }
    /**
     * method used to remove a country from the priority queue
     * 
     */
    public Country remove() {
        if (isEmpty()) {
            return null;
        }

        Country removedCountry = first.country;
        first = first.next;

        if (first != null) {
            first.prev = null;
        } else {

            last = null;
        }

        return removedCountry;
    }
/**
 * method used to delete multiple links based off user input
 * 
 * @param start starting interval from user
 * @param end ending interval from user
 * @return boolean
 */
    public boolean intervalDelete(double start, double end) {
        boolean deleted = false;
        Node current = first;

        while (current != null) {
            if (current.country.getHappinessIndex() >= start && current.country.getHappinessIndex() <= end) {
                if (current == first) {
                    first = current.next;
                    if (first != null) {
                        first.prev = null;
                    }
                } else if (current == last) {
                    last = current.prev;
                    last.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                deleted = true;
            }

            current = current.next;
        }

        return deleted;
    }

    public void recursivePrintPriorityQ() {
        recursivePrintPriorityQ(last);
    }
    /**
     * method used to print most updated priority queue
     * 
     * @param node a country's data
     */
    private void recursivePrintPriorityQ(Node node) {
        if (node == null) {
            return;
        }

        Country country = node.country;
        double GDPPC = (double) country.getGDP() / (double) country.getPopulation();
        double APC = (double) country.getArea() / (double) country.getPopulation();

        System.out.printf("%-15s %-15s %-15.3f %-15.6f %-15.3f%n", country.getCountryName(), country.getCapital(), GDPPC, APC, country.getHappinessIndex());

        recursivePrintPriorityQ(node.prev);
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        Country country;
        Node prev;
        Node next;

        Node(Country country) {
            this.country = country;
            prev = null;
            next = null;
        }
    }
}
