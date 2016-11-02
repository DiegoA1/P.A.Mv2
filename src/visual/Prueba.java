package visual;

import java.awt.BorderLayout;
import java.time.YearMonth;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class Prueba
{
	public static void main(String[] args)
	{
		JFrame principal = new JFrame();
		JPanel main = new JPanel();
		principal.add(main);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 dataset.setValue(6, "Profit", "Jane");
		 dataset.setValue(7, "Profit", "Tom");
		 dataset.setValue(8, "Profit", "Jill");
		 dataset.setValue(5, "Profit", "John");
		 dataset.setValue(12, "Profit", "Fred");
		 JFreeChart chart = ChartFactory.createBarChart("Comparison between Salesman",
		 "Salesman", "Profit", dataset, PlotOrientation.VERTICAL,
		 false, true, false);
		ChartPanel graph = new ChartPanel(chart);
		main.add(graph);
		principal.pack();
		principal.setVisible(true);
	}
}
