import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.util.Arrays;

@SuppressWarnings("jol")
public class BarChartAWT extends ApplicationFrame {


    public BarChartAWT(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart barchart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataSet(),
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(barchart);
        chartPanel.setPreferredSize(new Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataSet() {
        final String
                tesla = "TESLA",
                audi = "AUDI",
                ford = "FORD",
                speed = "Speed",
                millage = "Millage",
                userRating = "User Rating",
                safety = "Safety";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double[] teslaValues = {1.0, 3.0, 5.0, 5.0};
        double[] audiValues = {5.0, 6, 10, 4};
        double[] fordValues = {4, 2, 3, 6};
        String[] categoryLabels = {speed, millage, userRating, safety};
        String[] modelTypes  = {tesla, audi, ford};
        //noinspection ConstantConditions
        for (int i = 0; i < Math.min(Math.min(teslaValues.length, audiValues.length), fordValues.length); i++) {
            dataset.addValue(teslaValues[i], modelTypes[Arrays.asList(modelTypes).indexOf(tesla)], categoryLabels[i]);
            dataset.addValue(audiValues[i], modelTypes[Arrays.asList(modelTypes).indexOf(audi)], categoryLabels[i]);
            dataset.addValue(fordValues[i], modelTypes[Arrays.asList(modelTypes).indexOf(ford)], categoryLabels[i]);
        }
        return dataset;
    }
}
