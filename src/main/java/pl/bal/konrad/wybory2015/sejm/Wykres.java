package pl.bal.konrad.wybory2015.sejm;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Wykres {

	private CategoryDataset createCategoryDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(225, "15 Years", "Faceci");
		dataset.addValue(419, "20 Years", "Faceci");
		dataset.addValue(141, "30 Years", "Faceci");
		dataset.addValue(14, "50 Years", "Faceci");
		dataset.addValue(225, "55 Years", "Faceci");
		dataset.addValue(419, "203 Years", "Faceci");
		dataset.addValue(141, "304 Years", "Faceci");
		dataset.addValue(142, "506 Years", "Faceci");
		dataset.addValue(225, "152 Years", "Faceci");
		dataset.addValue(419, "2030 Years", "Faceci");
		dataset.addValue(141, "3040 Years", "Faceci");
		dataset.addValue(142, "5060 Years", "Faceci");
		dataset.addValue(225, "1520 Years", "Faceci");
		dataset.addValue(419, "2031 Years", "Faceci");
		dataset.addValue(141, "3041 Years", "Faceci");
		dataset.addValue(142, "5061 Years", "Faceci");

		dataset.addValue(634.0, "15-20 Years", "Kobiety");
		dataset.addValue(229.0, "20-30 Years", "Kobiety");
		dataset.addValue(433.0, "30-40 Years", "Kobiety");
		return dataset;

	}

	private JFreeChart create3DBarChart(CategoryDataset dataset, PlotOrientation plotOrientation) {
		JFreeChart chart = ChartFactory.createBarChart3D("Wykres test", // Chart
																		// Title
				"Płeć", // Domain Axis Label
				"Ilość", // Range Axis Label
				dataset, // Data
				plotOrientation, // Orientation
				true, // Include Legend
				true, // Tooltips
				false // Urls
		);

		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 16.0));

		CategoryItemRenderer renderer = plot.getRenderer();
		BarRenderer r = (BarRenderer) renderer;
		r.setMaximumBarWidth(0.1);
		chart.setBackgroundPaint(Color.WHITE);

		return chart;

	}

	public static void main(String[] args) {
		Wykres chartCreator = new Wykres();

		CategoryDataset categoryDataset = chartCreator.createCategoryDataset();
		JFreeChart chartVertical = chartCreator.create3DBarChart(categoryDataset, PlotOrientation.VERTICAL);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Wykres - Konrad Bal");

				frame.setSize(800, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				ChartPanel cp = new ChartPanel(chartVertical);
				frame.getContentPane().add(cp);
			}
		});

	}

}