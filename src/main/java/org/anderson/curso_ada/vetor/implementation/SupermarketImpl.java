package org.anderson.curso_ada.vetor.implementation;

public class SupermarketImpl implements Supermarket {

    private final String[] items;

    private int lastIndex;

    public SupermarketImpl(int size) {
        this.items = new String[size];
        this.lastIndex = -1;
    }

    @Override
    public void add(final String item) {
        if (lastIndex == items.length-1) {
            System.err.println("complete supermarket list");
        }
        else {
            lastIndex++;
            items[lastIndex] = item;
        }
    }

    @Override
    public void print() {
        if(lastIndex < 0) {
            System.err.println("empty supermarket list");
        }
        System.out.println("###################################################");
        for(int i = 0; i <= lastIndex; i++) {
            System.out.println(i + ": " + items[i]);
        }
        System.out.println("###################################################");
    }

    @Override
    public void delete(final int index) {
        if(index >= 0 && index <= lastIndex) {
            shift(index);
            lastIndex--;
        } else {
            System.err.println("index invalid: " + index);
        }
    }

    private void shift(final int index) {
        for (int i = index; i < lastIndex; i++) {
            items[i] = items[i+1];
        }
    }
}
