package edu.guilford;

import java.util.Random;

public class Card implements Comparable<Card>{ //specification met
    // enum for the suits
    /***
     * Enum for suits Clubs, Diamonds, Hearts, Spades
     */
    public enum Suit {  //specification met
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    // enum for the ranks
    /***
     * Enum for ranks Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten,
     * Jack, Queen, King
     */
    public enum Rank {  //specification met
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
        KING
    }

    // instance variables
    private Suit suit;
    private Rank rank;

    // constructor
    /***
     * Constructor for Card class that produces specific card
     * @param suit Suit of the card
     * @param rank Rank of the card
     */
    public Card(Suit suit, Rank rank) {  //specification met
        this.suit = suit;
        this.rank = rank;
    }

    /***
     * Constructor for Card class that produces random card per the enum values
     */
    public Card() {  //specification met
        // random Card
        Random rand = new Random();
        int suit = rand.nextInt(Suit.values().length);
        int rank = rand.nextInt(Rank.values().length);
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }

    // getters
    public Suit getSuit() {  //specification met
        return suit;
    }

    public Rank getRank() {  //specification met
        return rank;
    }

    // toString

    public String toString() {  //specification met
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card otherCard) {  //specification met
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