public class PrintJob implements Prioritizeable
{
    int priority;
    String text;

    //A constructor that receives text and its priority and initializes them as a PrintJob object.
    public PrintJob(String t, int prio)
    {
        this.text = t;

        this.priority = (prio <= MAX_PRIORITY && prio >= MIN_PRIORITY ? prio : 0);
    }

    // getter and setter for priority.
    public int getPriority()
    {
        return this.priority;
    }


    public void setPriority(int p)
    {
        this.priority = (p <= MAX_PRIORITY && p >= MIN_PRIORITY ? p : priority);

    }

    // the getText method return the text for print.
    public String getText()
    {
        return this.text;
    }

    public String toString()
    {
        return this.text + " " + priority;
    }
}
