public interface State
{
    public void enter(Shop owner);
    public void execute(Shop owner);
    public void exit(Shop owner);
}