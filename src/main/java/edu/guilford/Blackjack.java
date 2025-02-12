package edu.guilford;

/***
 * Class that represents a game of Blackjack, with methods to simulate player and dealer turns, and reset the game
 */
public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    /***
     * Constructor for Blackjack class that creates a new deck, calls reset method
     * @see #reset(boolean)
     */
    public Blackjack() { //specification met
        reset(true);
    }

    

    public Hand getPlayerHand() { //specification met
        return playerHand;
    }


    public Hand getDealerHand() { //specification met
        return dealerHand;
    }


    public Deck getDeck() { //specification met
        return deck;
    }

    /**
     * Method to reset the game, creating a new shuffled deck 
     * @param newDeck
     */
    public void reset(boolean newDeck) { //specification met
        if (newDeck) {
            deck = new Deck();
            deck.shuffle();
        }
    }

    /**
     * Method to deal two cards to the player and two cards to the dealer
     * 
     */
    public void deal() { //specification met
        dealerHand = new Hand();
        playerHand = new Hand();
        playerHand.addCard(deck.deal()); 
        dealerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
    }
    /**
     * Method to simulate player turn, keep pulling cards until total value is 16 or higher
     * @return boolean true if player total value is less than or equal to 21, false otherwise
     */
    public boolean playerTurn() { //specification met
        while (playerHand.getTotalValue() < 16) {
            playerHand.addCard(deck.deal());
        }
        return playerHand.getTotalValue() <= 21;

    }

    /**
     * Method to simulate dealer turn, keep pulling cards until total value is 17 or higher
     * @return boolean true if dealer total value is less than or equal to 21, false otherwise
     */
    public boolean dealerTurn() { //specification met
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.deal());
        }
        return dealerHand.getTotalValue() <= 21;
    }

    // Override toString
    public String toString() { //specification met
        String result = "Player's Hand:\n";
        for (int i = 0; i < playerHand.size(); i++) {
            result += playerHand.getCard(i) + "\n";
        }
        result += "Player's Total: " + playerHand.getTotalValue() + "\n\n";
        result += "Dealer's Hand:\n";
        for (int i = 0; i < dealerHand.size(); i++) {
            result += dealerHand.getCard(i) + "\n";
        }
        result += "Dealer's Total: " + dealerHand.getTotalValue() + "\n\n";
        return result;
    }

}
