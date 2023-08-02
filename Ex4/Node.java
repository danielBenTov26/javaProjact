public class Node<E>
{
    private E data;
    private Node<E> leftSon;
    private Node<E> rightSon;

    // A constructor that receives the value of the member and the 2 members it points to and initialize them.
    public Node(E data, Node<E> left, Node<E> right)
    {
        this.data = data;
        this.leftSon = left;
        this.rightSon = right;
    }

    // getters and setters.
    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    public Node<E> getLeftSon()
    {
        return leftSon;
    }

    public void setLeftSon(Node<E> leftSon)
    {
        this.leftSon = leftSon;
    }


    public Node<E> getRightSon()
    {
        return rightSon;
    }


    public void setRightSon(Node<E> rightSon)
    {
        this.rightSon = rightSon;
    }


}
