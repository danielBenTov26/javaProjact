public class BTree<E>
{
    private Node<E> root;
    private int size;

    // A default constructor initializes root and size to Null and 0.
    public BTree()
    {
        this.root = null;
        this.size = 0;
    }

    // The method adds a new node according to the string it receives
    public boolean addByPath(E data, String path)
    {
        if (path.equals("") && this.root == null)
        { // if the string is empty we initialize the root = data.
            root = new Node<>(data, null, null);
            size++;
            return true;
        }
        if (this.root == null)
            return false;
        Node<E> treeNode = root;
        for (int i = 0; i < path.length(); i++)
        {// Go over the string each character if it is equal to R or L go in the right direction and check for the length of the string in relation to the cell value.

            if (path.charAt(i) == 'R')
            {
                if (i + 1 == path.length() && treeNode.getRightSon() == null)
                {
                    treeNode.setRightSon(new Node<>(data, null, null));
                    size++;
                    return true;
                } else if (i + 1 == path.length() || treeNode.getRightSon() == null) return false;
                else
                {
                    treeNode = treeNode.getRightSon();
                }

            } else if (path.charAt(i) == 'L')
            {
                if (i + 1 == path.length() && treeNode.getLeftSon() == null)
                {
                    treeNode.setLeftSon(new Node<>(data, null, null));
                    size++;
                } else if (i + 1 == path.length() || treeNode.getLeftSon() == null) return false;
                else
                {
                    treeNode = treeNode.getLeftSon();
                }

            } else return false;

        }
        return true;
    }

//  The method returns a string that represents the information at the tree nodes by pre-order transition.
    public String pre()
    {
        return printPreorder(this.root, "");
    }
//A recursive method that returns a string of all the organs in the tree.
    public String printPreorder(Node<E> temp, String n)
    {
        if (temp == null)
            return "";
        n += temp.getData() + ", " + printPreorder(temp.getLeftSon(), n) + printPreorder(temp.getRightSon(), n);
        return n;
    }
//  Returns the number of organs in the tree.
    public int getSize()
    {
        return this.size;
    }

// The method receives a string consisting of the characters 'R' and 'L',
// and according to the string it progresses through the tree and returns the organ to which it reaches.
    public E findByPath(String path)
    {
        if (path.equals(""))
            if (root == null)
                return null;
            else return root.getData();


        Node<E> treeNode = root;
        for (int i = 0; i < path.length() && treeNode != null; i++)
        {
            if (path.charAt(i) == 'R')
            {
                treeNode = treeNode.getRightSon();
                if (i + 1 == path.length())
                {
                    if (treeNode == null) return null;
                    else
                        return (E) treeNode.getData();
                }
            } else if (path.charAt(i) == 'L')
            {
                treeNode = treeNode.getLeftSon();
                if (i + 1 == path.length())
                {
                    if (treeNode == null) return null;
                    else
                        return treeNode.getData();
                }

            } else return null;
        }
        return null;
    }
}