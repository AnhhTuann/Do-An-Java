public interface State<T>
{
    public void enter(T owner);
    public void execute(T owner);
    public void exit(T owner);
}