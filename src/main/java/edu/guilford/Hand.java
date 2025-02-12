package edu.guilford;

import java.util.ArrayList;

/**
 * Hand class that represents a hand of cards, with methods to add, remove, score Blackjack hands
 */
public class Hand {
    private ArrayList<Card> hand;

    

    public Hand() { //specification met 
        hand = new ArrayList<Card>();
    }

    public void addCard(Card card) { //specification met
        hand.add(card);
    }

    public void removeCard(Card card) { //specification met
        hand.remove(card);
    }

    public void reset() { //specification met
        hand.clear();
    }

    public int size() { //not in specifications, but is useful additional method 
        return hand.size();
    }

    public Card getCard(int index) { //specification met
        return hand.get(index);
    }

    // Calculate the value of the hand
    /**
     * Method to calculate the total value of a hand of cards, with aces being worth 1 or 11 depending on the total value of the hand
     * @return int total value 
     */
    public int getTotalValue() { 
        int value = 0;
        int aces = 0;
        for (Card card : hand) {
            switch (card.getRank()) {
                case TWO:
                    value += 2;
                    break;
                case THREE:
                    value += 3;
                    break;
                case FOUR:
                    value += 4;
                    break;
                case FIVE:
                    value += 5;
                    break;
                case SIX:
                    value += 6;
                    break;
                case SEVEN:
                    value += 7;
                    break;
                case EIGHT:
                    value += 8;
                    break;
                case NINE:
                    value += 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    value += 10;
                    break;
                case ACE:
                    aces++;
                    break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }
        return value;
    }

    // Override toString method
    public String toString() { //specification met
        String handString = "";
        for (Card card : hand) {
            handString += card.toString() + "\n";
        }
        return handString;
    }

    public ArrayList<Card> getHand() { //not in specifications, but is useful additional method
        return hand;
    }

}
