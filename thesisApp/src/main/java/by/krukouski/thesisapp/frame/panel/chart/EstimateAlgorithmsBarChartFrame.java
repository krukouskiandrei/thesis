package by.krukouski.thesisapp.frame.panel.chart;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import by.krukouski.prime.utils.symbols.TimeTracker;

public class EstimateAlgorithmsBarChartFrame extends JFrame {
	
	private final static String SOLOVAY_USUAL_SERIES = "Solovay-Strassen: usual";
	private final static String SOLOVAY_BINARY_SERIES = "Solovay-Strassen: binary";
	private final static String SOLOVAY_LOG_SERIES = "Solovay-Strassen: log";
	private final static String MILLER_SERIES = "Miller-Rabin";
	
	private final static String CATEGORY = "Probapility tests";
	
	public EstimateAlgorithmsBarChartFrame(final String nameFrame) {
		
		super(nameFrame);
		
		final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
		
	}
	
	private CategoryDataset createDataset() {
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		/*dataset.addValue(1.0, SOLOVAY_USUAL_SERIES, CATEGORY);
        dataset.addValue(4.0, SOLOVAY_BINARY_SERIES, CATEGORY);
        dataset.addValue(3.0, SOLOVAY_LOG_SERIES, CATEGORY);
        dataset.addValue(5.0, MILLER_SERIES, CATEGORY);*/
		Map<String, Long> timeTracker = TimeTracker.getInstance().getTracker();
        dataset.addValue(timeTracker.get("Solovay-Strassen, Usualy method"), SOLOVAY_USUAL_SERIES, CATEGORY);
        dataset.addValue(timeTracker.get("Solovay-Strassen, Binary method"), SOLOVAY_BINARY_SERIES, CATEGORY);
        dataset.addValue(timeTracker.get("MillerRabin, usual method"), MILLER_SERIES, CATEGORY);
        
        return dataset;
        
	}
	
	private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Probability Algorithm",       // chart title
            "Algorithm",               // domain axis label
            "Time, ms",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                    // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setUpperMargin(0.15);
        
        // disable bar outlines...
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
        
        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }


}
