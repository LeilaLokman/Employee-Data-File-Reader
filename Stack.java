/**
 * Class used to store countries in a stack and manipulate it
 * 
 * @author Leila Lokman
 * @version 10/27/2023
 */
public class Stack {
    private Node top;
    private Node tail;
    private int size;

    public Stack() {
        top = null;
        tail = null;
        size = 0;
    }
/**
 * method used to push a country onto the stack
 * 
 * @param country data from file
 * @return void
 */
    public void push(Country country) {
        Node newNode = new Node(country);
        if (isEmpty()) {
            top = newNode;
            tail = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
/**
 * method used to pop country from the stack
 * 
 */
    public Country pop() {
        if (isEmpty()) {
            return null;
        }
        Country poppedCountry = top.data;
        top = top.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return poppedCountry;
    }

    public void recursivePrintStack() {
        recursivePrintStack(top);
    }
/**
 * method used to print most updated stack
 * 
 * @param node a country's data
 */
    private void recursivePrintStack(Node node) {
        if (node == null) {
            return;
        }
        recursivePrintStack(node.next);

        Country country = node.data;
        double GDPPC = (double) country.getGDP() / (double) country.getPopulation();
        double APC = (double) country.getArea() / (double) country.getPopulation();

        System.out.printf("%-15s %-15s %-15.3f %-15.6f %-15.3f%n", country.getCountryName(), country.getCapital(), GDPPC, APC, country.getHappinessIndex());
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    private class Node {
        Country data;
        Node next;

        Node(Country country) {
            this.data = country;
            this.next = null;
        }
    }
}

