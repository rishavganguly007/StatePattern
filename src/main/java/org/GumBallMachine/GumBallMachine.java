package org.GumBallMachine;

public class GumBallMachine {
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    GumBallMachine(int count){
        this.count = count;
        if(count > 0) {
            state = NO_QUARTER;
        }
    }

    // Now start implementing the actions as methods

    public void insertQuarter() {

        if(state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("coin inserted");
        } else if (state == HAS_QUARTER) {
            System.out.println("quarter already inserted");
        } else if (state == SOLD) {
            System.out.println("Please wiat, we are already giving you a Gumball");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't gave a quarter yet");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        } else if (state == SOLD) {
            System.out.println("Sorry, you already turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }

    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball!");
        } else if (state == NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs");
        } else if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    public void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if (count == 0) {
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("You need to pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_QUARTER) {
            System.out.println("You need to turn the crank");
        }
    }
    // other methods here like toString() and refill()

}
