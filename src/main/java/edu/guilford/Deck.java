package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();  //specification met
    private Random rand = new Random();  //specification met

    /***
     * Constructor for Deck class that builds a deck of cards through build()
     * @see #build()
     * 
     */
    public Deck() {  //specification met
        build();
    }

    public ArrayList<Card> getDeck() {  //specification met
        return deck;
    }
    
    public void clear() {  //specification met
        deck.clear();
    }

    /***
     * Method to build a deck of cards with all possible combinations of suits and ranks
     * @see Card.Rank
     * @see Card.Suit
     */
    public void build() {  //specification met
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /***
     * Method to shuffle the deck of cards by putting each card into a random location in a copy of a deck 
     * 
     */
    public void shuffle() { //specification met
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        while (deck.size() > 0) {
            int loc = rand.nextInt(deck.size());
            tempDeck.add(deck.get(loc));
            deck.remove(loc);
        }
        deck = tempDeck;
    }

    /***
     * Method to pick a card from the deck, removing it from the Arraylist
     * @param i Index of the card to pick
     * @return Card 
     */
    public Card pick(int i) { //specification met
        Card picked = deck.remove(i);
        return picked;
    }

    public Card deal() { //specification met
        return deck.remove(0);
    }

    public int size() { //specification met
        return deck.size();
    }

    public String toString() { //specification met
        String deckString = "";
        for (Card card : deck) {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
}
