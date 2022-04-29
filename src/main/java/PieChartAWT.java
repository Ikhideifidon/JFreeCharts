import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;

@SuppressWarnings("jol")
public class PieChartAWT extends ApplicationFrame {
    
    public PieChartAWT(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    private static PieDataset<String> createDataset() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        String[] keys = {"Iphone", "Samsung", "Nokia", "Motorola", "LG", "Sony"};
        double[] values = {30, 20, 15, 10, 5};

        // The use of Math.min is very significant in the case where both the keys and the values
        // are read from a scanner or file.
        //noinspection ConstantConditions
        for (int i = 0; i < Math.min(keys.length, values.length); i++)
            dataset.setValue(keys[i], values[i]);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset<String> dataset) {
        return ChartFactory.createPieChart(
                "Mobile Sales",
                dataset,
                true,
                true,
                false
        );
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }


}
