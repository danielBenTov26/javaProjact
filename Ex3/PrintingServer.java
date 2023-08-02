public class PrintingServer extends PriorityQueue
{
    //    do automatically up casting to the default constructor of  'PriorityQueue'
    public PrintingServer()
    {
    }

    // Gets a print job and adds it to the queue.
    public void acceptJob(PrintJob p)
    {
        insert((Prioritizeable) p);
    }

    // The method prints on the screen the first job in the queue and removes it from the queue.
    public void print()
    {
        System.out.println(((PrintJob) remove()).text);
    }

    // tester
    public static void main(String[] args)
    {
        PrintingServer server = new PrintingServer();
        PrintJob p = new PrintJob("Hello", 7);
        server.acceptJob(p);
        p = new PrintJob("Good Morning", 3);
        server.acceptJob(p);
        p = new PrintJob("How do you do?", 8);
        server.acceptJob(p);
        p = new PrintJob("goodbye", 1);
        server.acceptJob(p);
        server.print();
        server.print();
        p = new PrintJob("Hello again", 10);
        server.acceptJob(p);
        server.print();
        server.print();
        server.print();
    }

}