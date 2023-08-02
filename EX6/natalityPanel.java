import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class natalityPanel extends JPanel
{
    JButton clear;
    JButton ShowChart;
    JComboBox m;
    String[] chose = {"gender", "Month"};
    File NatalityMini = new File("NatalityMini.csv");
    ArrayList<String> gender = new ArrayList<String>();
    ArrayList<Double> month = new ArrayList<Double>();
// default constructor adds the buttons to the screen and sets them a listeners.
    public natalityPanel()
    {
        clear = new JButton("Clear");
        ShowChart = new JButton("show data");

        m = new JComboBox(chose);
        add(m);
        add(ShowChart);
        add(clear);
        ShowChart.addActionListener(new ButtonListener());
        clear.addActionListener(new ButtonListener());

    }

    private class ButtonListener implements ActionListener
    {
//       Gets an object of type "ActionEvent" and by its type does an action.
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == clear)
            {
                repaint();
            }
            if (e.getSource() == ShowChart)
            {
                if (m.getSelectedIndex() == 0) // gender
                {try{ShowPieOfGender();}
                catch (IOException ex)
                    {return;}
                }
            }
            if (m.getSelectedIndex() == 1)
            {
                try
                {
                    showColumnOfMonth();
                } catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }  // month
        }


    }
    // This method draws a circle from the pie class according to the data in the file.
    private void ShowPieOfGender() throws IOException
    {
        int maleNum = 0, femaleNum = 0;
        readFromFileToArrayList(NatalityMini);
        for (String g : gender)
        {
            if (g.equals("F"))
                femaleNum++;
             if (g.equals("M"))
                maleNum++;
        }
        ArrayList<Double> genders = new ArrayList<>();
        genders.add((double) maleNum);
        genders.add((double) femaleNum);
        ArrayList<String> labels = new ArrayList<>();
        labels.add("males");
        labels.add("females");

       Pie p = new  Pie(genders,labels);
        p.draw(getGraphics(), 100, 100, 500, 500);
    }

    // This method draws a column from the Column class according to the data in the file.
    public void showColumnOfMonth () throws IOException
    {
        readFromFileToArrayList(NatalityMini);
        double[] MonthArr = {0,0,0,0,0,0,0,0,0,0,0,0};
        for (double d: month)
        {
            MonthArr[(int) (d - 1)] ++;
        }
        String[] labels = {"Jan'" ,"Feb'", "March" ,"April" ,"May" ,"June" ,"July", "August" ,"Sept'"," Oct'" ,"Nov'", "Dece'"};
       ArrayList<Double> Month = new ArrayList<>();
        ArrayList<String> label = new ArrayList<>();

        for (int i = 0; i < labels.length; i++)
        {
            Month.add(MonthArr[i]);
            label.add(labels[i]);

        }
        Column c = new Column(Month,label);
        c.draw(getGraphics(), 100, 100, 500, 500);
    }
// This method reading the data from the file and put him to ArrayList.
    public void readFromFileToArrayList(File f) throws IOException
    {
        FileReader fr = new FileReader(f);
        BufferedReader b = new BufferedReader(fr);
        String temp = "";
        try
        {
            while (true)
            {
               temp  = b.readLine();
                String[] tArray = temp.split(",");
                month.add(Double.valueOf(tArray[1]));
                gender.add(tArray[2]);
            }
        } catch (Exception p)
        {
            return;
        }

    }
    public static void main(String[] args)
    {
        natalityPanel N = new natalityPanel();

        JFrame frame = new JFrame();
        frame.add(N);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(20, 20, 800, 800);
        frame.setVisible(true);
    }
}

