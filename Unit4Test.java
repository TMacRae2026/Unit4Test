/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unit4test;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author TMacRae2026
 */

public class Unit4Test {

    public static void main(String[] args) {
        Random rand = new Random();
        
        ArrayList<Card> cards = new ArrayList<>(); //arraylist will act as our 'hand' of cards
        
        for(int i = 0; i < 5; i++) { // generate random cards
            Card c = new Card(getRandomEnum(Suit.class), rand.nextInt(1, 13));
            
            if(listContains(c, cards)) { // if the list already has that card we generate a new random card
                i--;
                continue;
            }
            cards.add(c); // add the new card to the list after it has been checked
        }
        
        for(Card c : cards) { // print the value of all the cards
            System.out.println(c.toString());
        }
        
    }
    //Gets a random value from an enum
    static <T extends Enum<T>> T getRandomEnum(Class<T> clazz) {
        Random random = new Random();
        //get all enum constants of the specified class
        T[] values = clazz.getEnumConstants();
        //generate a random index and get the value of that index
        return values[random.nextInt(values.length)];
    }
    
    //Linearly search through a list to find if a list contains a value
    static boolean listContains(Card value, ArrayList<Card> list) {
        for(Card c : list) {
            if(c.getValue() == value.getValue()
                    && c.getSuit() == value.getSuit()) {
                return true;
            }
        }
        return false;
    }
    
}

class Card {
    private Suit suit;
    private int value;

    public Card(Suit suit, int value) { //card constructor
        this.suit = suit;
        this.value = value;
    }
    
    @Override
    public String toString() {
        String stringValue = "" + value;
        switch(value) { //switch statement determines the name of cards with non-number names
            case 1 -> stringValue = "Ace";
            case 11 -> stringValue = "Jack";
            case 12 -> stringValue = "Queen";
            case 13 -> stringValue = "King";
        }
        //switch statement determines the name of cards with non-number names
        return stringValue + " of " + suit;
    }
    
    //getters and setters for all private class values
    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

enum Suit{ //enum of all the suits of cards
    Diamonds,
    Spades,
    Hearts,
    Clubs;
}
