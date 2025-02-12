package edu.guilford;

import java.util.ArrayList;
import java.util.Random;


/***
 * Lamarckian Poker game, two player card game where aim is to build highest scoring hand. Contains methods to deal, make pool, and turn.
 */
public class LamarckianPoker {
    private Hand player1Hand; 
    private Hand player2Hand; //misleading, specifications state "player and dealer hands"
    private Hand pool; 
    private Deck discard; 
    private Deck deck; 
    private Random rand = new Random();
    private int iTurn; //extra attribute which is unclear as to purpose and is never used except to set to 0 

    /***
     * Constructor for LamarckianPoker class that creates a new deck, calls reset method
     * @see #reset(boolean)
     */
    public LamarckianPoker() {
        reset(true);
    }

    public Hand getPlayer1Hand() { //specification met
        return player1Hand;
    }

    public Hand getPlayer2Hand() { //specification met (typo in specifications, says getPlayer1Hand twice)
        return player2Hand;
    }
 
    public Hand getPool() { //specification technically not met-- says "pool" not "getPool"
        return pool;
    }

    /**
     * Reset the game, creating a new shuffled deck and a new discard pile 
     * @param newDeck
     */
    //should be turned into an abstract method in a superclass
    public void reset(boolean newDeck) { //specification met
        if (newDeck) {
            deck = new Deck();
            discard = new Deck();
            discard.clear();
            deck.shuffle();
        }
        iTurn = 0;
    }

    /***
     * Deal four cards to both players
     * 
     */
    //should be extracted to a superclass method with a param for hand # and hands
    public void deal() { //specification met
        player1Hand = new Hand();
        player2Hand = new Hand();
        for (int iCard = 0; iCard < 4; iCard++) {
            player1Hand.addCard(deck.deal());
            player2Hand.addCard(deck.deal());
        }
    }

    /***
     * Method to create a pool of four cards from the deck
     * 
     */
    public void makePool() { //specification met
        pool = new Hand(); 
        for (int iCard = 0; iCard < 4; iCard++) {
            pool.addCard(deck.deal());
        }
        // System.out.println("Deck size: " + deck.size());
    }

    /***
     * Method to simulate a turn in the game, where players take turns playing cards from their hand to the pool
     * @return boolean true if both players have less than 7 cards, false otherwise
     */
    public boolean turn() {
        if (player1Hand.size() < 7 || player2Hand.size() < 7) {
            makePool();
            // System.out.println("Turn " + iTurn + "\n" + pool);
            Card player1Card = player1Hand.getCard(rand.nextInt(player1Hand.size()));
            Card player2Card = player2Hand.getCard(rand.nextInt(player2Hand.size()));
            Hand firstHand, secondHand;
            Card firstCard, secondCard;
            if (player1Card.getRank().ordinal() > player2Card.getRank().ordinal()) {
                firstHand = player1Hand;
                secondHand = player2Hand;
                firstCard = player1Card;
                secondCard = player2Card;
            } else if (player1Card.getRank().ordinal() < player2Card.getRank().ordinal()) {
                firstHand = player2Hand;
                secondHand = player1Hand;
                firstCard = player2Card;
                secondCard = player1Card;
            } else {
                if (player1Card.getSuit().ordinal() > player2Card.getSuit().ordinal()) {
                    firstHand = player1Hand;
                    secondHand = player2Hand;
                    firstCard = player1Card;
                    secondCard = player2Card;
                } else {
                    firstHand = player2Hand;
                    secondHand = player1Hand;
                    firstCard = player2Card;
                    secondCard = player1Card;
                }

            }

            ArrayList<Card> poolRemove = new ArrayList<Card>();

            for (Card poolCard : pool.getHand()) {
                if (firstCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        firstCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    firstHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            // Remove cards from pool
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            poolRemove.clear();
            pool.addCard(firstCard);
            firstHand.removeCard(firstCard);
            for (Card poolCard : pool.getHand()) {
                if (secondCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        secondCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    secondHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            pool.addCard(secondCard);
            secondHand.removeCard(secondCard);
            for (Card poolCard : pool.getHand()) {
                discard.getDeck().add(poolCard);
            }
            pool.getHand().clear();
            // System.out.println("Discard\n" + discard.size());
            if (deck.size() < 4) {
                for (Card card : discard.getDeck()) {
                    deck.getDeck().add(card);
                }
                discard.clear();
                // System.out.println("Discard\n" + discard.size());
            }
            iTurn++;
            
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "\nPlayer 1: \n" + player1Hand + "\nPlayer 2: \n" + player2Hand + "\nPool: " + pool + "\n";
    }
}
