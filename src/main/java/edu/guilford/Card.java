package edu.guilford;

import java.util.Random;

public class Card implements Comparable<Card>{
    // enum for the suits
    /***
     * Enum for suits Clubs, Diamonds, Hearts, Spades
     */
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    // enum for the ranks
    /***
     * Enum for ranks Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten,
     * Jack, Queen, King
     */
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
        KING
    }

    // instance variables
    private Suit suit;
    private Rank rank;

    // constructor
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card() {
        // random Card
        Random rand = new Random();
        int suit = rand.nextInt(Suit.values().length);
        int rank = rand.nextInt(Rank.values().length);
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }

    // getters
    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    // toString

    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card otherCard) {
        // TODO Auto-generated method stub
        if (this.rank.ordinal() > otherCard.rank.ordinal()) {
            return 1;
        }
        else if (this.rank.ordinal() < otherCard.rank.ordinal()) {
            return -1;
        }
        else {
            if (this.suit.ordinal() > otherCard.suit.ordinal()) {
                return 1;
            }
            else if (this.suit.ordinal() < otherCard.suit.ordinal()) {
                return -1;
            }
        }

        return 0;
    }

    
}