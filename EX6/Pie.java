import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Pie extends Chart
{


    public Pie(ArrayList<Double> data, ArrayList<String> labels)
    {
        super(data, labels);
        this.data = data;
        this.labels = labels;
    }
// THe method "draw" will draw the diagram as a circle, with each figure appearing as a cut in a different color and relative to its size.
    public void draw(Graphics g, int x, int y, int width, int height)
    {
        {
            Color[] colors = new Color[data.size()];
            Slice[] slices = new Slice[data.size()];
            for (int i = 0; i < slices.length; i++) // create array
            {slices[i] = new Slice((data.get(i) / getSum()), rndColor());}

            double curValue = 0;
            int curCorner = 0;
            for (int i = 0; i < slices.length; i++)
            {    curCorner = (int) (curValue * 360) ;
                int moveAngle = (int) (slices[i].value * 360);

                g.setColor(slices[i].color);
                g.fillArc(x, y, width, height, curCorner, moveAngle);
                curValue += slices[i].value;
                colors[i] = g.getColor();
            }
            Font font = new Font("ariel",Font.BOLD,12);
            g.setFont(font); // set java font
            for (int i = 0; i < labels.size(); i++)
            {
                g.setColor(colors[i]);
                g.fillRect(x-15, y + height , 10, 10);
                g.setColor(Color.black);
                g.drawString(labels.get(i)+"    ", x, y + height+6);
                x +=50;
            }
        }
        }

// return a random color.
    public Color rndColor()
    {  Random rand = new Random();
        int a = rand.nextInt(250-1), b = rand.nextInt(250-1)  ,c = rand.nextInt(250-1);
        return new Color(a,b,c);}

// return the sum of data elements.
    public double getSum(){
        double sum = 0;
        for (Double d :data)
        { sum += d;}
        return sum;
    }

}
class Slice
{
    double value;
    Color color;

    public Slice(double value, Color color)
    {
        this.value = value;
        this.color = color;
    }
}
