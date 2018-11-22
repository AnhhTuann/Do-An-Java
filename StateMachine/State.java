public interface State<T>
{
    public void enter(T owner);
    public void excute(T owner);
    public void exit(T owner);
}