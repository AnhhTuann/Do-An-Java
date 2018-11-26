public class StateMachine<T>
{
    /*Constructor*/
    public StateMachine(T owner) {
        this.owner = owner;
        currentState = null;
        previousState = null;
    }

    /*Members*/
    private State<T> currentState;
    private State<T> previousState;
    private T owner;

    /*Get methods*/
    public State<T> getCurrentState() { return currentState; }
    public State<T> getPreviousState() { return previousState; }

    /*Set methods*/
    public void setCurrentState(State<T> state) { currentState = state; }
    public void setPreviousState(State<T> state) { previousState = state; }

    /*Other methods*/
    public void update()
    {
        if (currentState != null)
            currentState.execute(owner);
    }

    public void changeState(State<T> state) {
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