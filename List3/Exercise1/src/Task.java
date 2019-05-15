class Task
{
    int val;
    int priority;

    Task( int val,int priority)
    {
        this.val = val;
        this.priority = priority;
    }


    public String toString()
    {
        return "( "+ val +","+ priority+" )  ";
    }
}