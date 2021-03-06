package pl.bal.konrad.wybory2015.sejm;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import pl.bal.konrad.wybory2015.sejm.model.Candidate;
import pl.bal.konrad.wybory2015.sejm.model.Lists;

public class Wykres {
	public static final String KOBIETY = "Kobiety";
	public static final String MEZCZYZNI = "Mężczyźni";
	public static final String CHART_NAME = "Ilość kobiet i mężczyzn startujących w Wyborach do Sejmu 2015";

	
	private CategoryDataset createCategoryDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		DataSource ds = new DataSource("sejm.csv");
		long femaleCount = ds.countFilteredCandidates(Candidate::isFemale);
        long maleCount = ds.countFilteredCandidates(Candidate::isMale);

		for (int i = Lists.PiS; i <= Lists.ObywateleDoParlamentu; i++) {
			List<Candidate> candidateK = null;
			candidateK = pobierzKandydatow(i, false);
			Candidate kandydatK = candidateK.get(0);
			String partyNameK = kandydatK.getListName().replaceAll("Komitet Wyborczy","").replaceAll("Wyborców","");//ladniejsze opisy
			dataset.addValue(candidateK.size(), partyNameK, KOBIETY + " (" + femaleCount +")");

			List<Candidate> candidateM = null;
			candidateM = pobierzKandydatow(i, true);
			Candidate kandydatM = candidateM.get(0);
			String partyNameM = kandydatM.getListName().replaceAll("Komitet Wyborczy","").replaceAll("Wyborców","");//ladniejsze opisy
			dataset.addValue(candidateM.size(), partyNameM, MEZCZYZNI + " (" + maleCount +")");
		}
		return dataset;
	}

	private List<Candidate> pobierzKandydatow(Integer lista, boolean czyMezczyzna) {
		DataSource ds = new DataSource("sejm.csv");
		List<Candidate> candidates = ds
				.getFilteredCandidates(c -> c.getListNumber().equals(lista) && c.isMale() == czyMezczyzna);
		return candidates;
	}

	private JFreeChart create3DBarChart(CategoryDataset dataset, PlotOrientation plotOrientation) {
		
		long iloscKandydatow = getCountallCandidates();

		JFreeChart chart = ChartFactory.createBarChart3D(CHART_NAME, // ChartTitle
				null,
				"Liczba kandydatów ("+iloscKandydatow+")", // Range Axis Label
				dataset, // Data
				plotOrientation, // Orientation
				true, // Include Legend
				true, // Tooltips
				false // Url
		);

		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		final NumberAxis domainAxis = new NumberAxis();
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		axis.setTickLabelFont(new Font("Arial", Font.BOLD, 20));

		CategoryItemRenderer renderer = plot.getRenderer();
		BarRenderer r = (BarRenderer) renderer;
		r.setMaximumBarWidth(0.1);
		chart.setBackgroundPaint(Color.WHITE);

		return chart;
	}
	
	private long getCountallCandidates(){
		DataSource ds = new DataSource("sejm.csv");
		long femaleCount = ds.countFilteredCandidates(Candidate::isFemale);
        long maleCount = ds.countFilteredCandidates(Candidate::isMale);
		
		return femaleCount + maleCount;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int digit, listNumber;
		do {
			System.out.println("Co chcesz zrobić?");
			System.out.println("Wyświetlić wykres - wpisz: 1");
			System.out.println("Wyświetlić kandydatów danej listy - wpisz: 2");
			System.out.println("Zakończyć - wpisz: 3");

			digit = in.nextInt();

			switch (digit) {
			case 1:
				wyswietlWykres();
				break;
			case 2:
				System.out.println("Podaj numer listy do wyświetlenia");
				listNumber = in.nextInt();

				if (!(listNumber < Lists.PiS || listNumber > Lists.ObywateleDoParlamentu)) {
					wyswietlKandydatowDanejListy(listNumber);
				} else {
					System.out.println("Podaj numer listy do wyświetlenia");
					listNumber = in.nextInt();
					wyswietlKandydatowDanejListy(listNumber);
				}
				break;
			default:
				break;
			}
		} while (digit != 3);
		in.close();
	}

	private static void wyswietlKandydatowDanejListy(int listNumber) {
		DataSource ds = new DataSource("sejm.csv");
		List<Candidate> candidates = ds.getFilteredCandidates(c -> c.getListNumber().equals(listNumber));
		int number = 0;
		for (Candidate candidate : candidates) {
			number++;
			System.out.println(number + ". " + candidate);
		}
		System.out.println();

	}

	private static void wyswietlWykres() {
		Wykres chartCreator = new Wykres();

		CategoryDataset categoryDataset = chartCreator.createCategoryDataset();
		JFreeChart chartVertical = chartCreator.create3DBarChart(categoryDataset, PlotOrientation.VERTICAL);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Wybory do Sejmu 2015 - Konrad Bal");

				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

				ChartPanel cp = new ChartPanel(chartVertical);
				frame.getContentPane().add(cp);
			}
		});

	}

}