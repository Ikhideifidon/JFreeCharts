import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("jol")
public class PieChartGenerationBasedOnFile extends ApplicationFrame {
    File file;

    public PieChartGenerationBasedOnFile(String title, File file) throws IOException {
        super(title);
        this.file = file;
        setContentPane(createDemoPanel());
    }

    private PieDataset<String> createDataset() throws IOException {
        final DefaultPieDataset<String> dataset = new DefaultPieDataset<>();

        InputStream in = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;


        // Text Formatting
        while ((line = reader.readLine()) != null) {
            String[] string = line.split(",+");
            // Format string at index 0;
            // Replace all non-word characters except white-space between words only.
            String stringValue, stringDigit;
            stringValue = string[0].replaceAll("[^\\w\\s]+", "").trim();

            // Format string at index 1
            stringDigit = findDigitsInStrings(string[1]);
            Double value;
            if (stringDigit != null) value = Double.valueOf(stringDigit); else continue;
            dataset.setValue(stringValue, value);
        }
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

    public JPanel createDemoPanel() throws IOException {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }

    private String findDigitsInStrings(String string) {
        String regex = "\\d+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        // this will return the first set of digits found.
        return m.find() ? m.group() : null;
        }
}
