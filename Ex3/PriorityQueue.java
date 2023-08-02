import java.util.Arrays;

public class PriorityQueue
{
    Prioritizeable[] PArray;
    int priority;


    // default constructor Initializes a blank queue the size of a hundred.
    public PriorityQueue()
    {this.PArray = new Prioritizeable[100];}

    public void insert(Prioritizeable element)
    { // Gets an object of type Prioritizeable, and puts it in the last cell that is free in the array.
        int count = 0;
        for (int i = 0; i < PArray.length; i++)
        {
            count++;
            if (PArray[i] == null)
            {
                PArray[i] = element;

                break;
            }
        }
        // Sort the array by the value of the Priority.
        selectionSortByPriority(this.PArray, 0, count);
    }

// The method returns the first limb in priority and removes it from the array.
    public Prioritizeable remove()
    {
        Prioritizeable temp = PArray[0];
        for (int i = 0; i < PArray.length-1; i++)
        {
            PArray[i] = PArray[i + 1];
            if (PArray[i] == null) break;
        }
        return temp;
    }
// A toString method, Prints the objects as each in a different line
    public String toString()
    {
        for (Prioritizeable prioritizeable : PArray)
        {
            if (prioritizeable == null) return "";

        }
        return "";
    }

// A recursive method that pushes the smallest limb to the edge of the array
// and returns the array recursively without the last limb until it finishes passing over the entire array.
    private void selectionSortByPriority(Prioritizeable[] A, int i, int and)
    {
        if (i == and || and == 1)
            return;
        int j = 0;
        while (j != and - 1)
        {
            if (A[j].getPriority() < A[j + 1].getPriority())
                swap(A, j, j + 1);
            j++;
        }

        selectionSortByPriority(A, i, and - 1);
    }
    // Switches between 2 values she receives.
    private void swap(Prioritizeable[] A, int a, int b)
    {
        Prioritizeable temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
