import java.awt.*;
import java.util.ArrayList;

public class Column extends Chart
{

    public Column(ArrayList<Double> data, ArrayList<String> labels)
    {
        super(data, labels);
        this.data = data;
        this.labels = labels;
    }

    //drawing the columns
     public void draw(Graphics g, int x, int y, int width, int height)
    {

        double[] blockRatio = new double[data.size()];
        for (int i = 0; i < blockRatio.length; i++)
        {
            blockRatio[i] = (data.get(i) / getSum());
        }

        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        int lineRat = (int) (height / 12);

        for (int i = 1; i <= 11; i++)
        {
            g.drawString(String.valueOf((i - 1) * 10) + "%", x + 5, height + y + 3 - i * lineRat);
            g.drawLine(x + 38, height + y - lineRat * i, x + width - 10, height + y - i * lineRat);
        }

        Font font = new Font("ariel", Font.TYPE1_FONT, 10);
        g.setFont(font); // set java font
        int step = width / (data.size() + 1);
        for (int i = 0; i < data.size(); i++)
        {
            int b = i + 1;
            double temp = (data.get(i) / (getSum() * 2 / data.size())) * (height - lineRat);
            g.setColor(Color.BLUE);
            g.fillRect(x + step * b, y + height - lineRat - (int) temp, 200 / data.size(), (int) temp);
            g.setColor(Color.GRAY);
            g.drawString(labels.get(i), x + step * b - 1, y + height - lineRat + 10);
        }


    }

// return the sum of data elements.

    public double getSum()
    {
        double sum = 0;
        for (Double d : data)
        {
            sum += d;
        }
        return sum;
    }
}


