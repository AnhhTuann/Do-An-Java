public class StateMachine
{
    /*Constructor*/
    public StateMachine(Shop owner) {
        this.owner = owner;
        currentState = null;
        previousState = null;
    }

    /*Members*/
    private State currentState;
    private State previousState;
    private Shop owner;

    /*Get methods*/
    public State getCurrentState() { return currentState; }
    public State getPreviousState() { return previousState; }

    /*Set methods*/
    public void setCurrentState(State state) { currentState = state; }
    public void setPreviousState(State state) { previousState = state; }

    /*Other methods*/
    public void update() {
        if (currentState != null)
            currentState.execute(owner);
    }

    public void changeState(State state) {
        if (state != null)
        {
            currentState.exit(owner);
            currentState = state;
            currentState.enter(owner);
        }
        else
            System.out.println("Failed! Trying to change to a null state!");
    }

    public void revertToPreviousState() {
        changeState(previousState);
    }
}