import org.jfree.ui.RefineryUtilities;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[ ] args) throws IOException {
        pieChartGenerationBasedOnFile();
//        barChart();
        check();
    }

    public static void pieChartGenerationBasedOnFile() throws IOException {
        PieChartGenerationBasedOnFile demo = new PieChartGenerationBasedOnFile("Mobile Sales", new File("src/main/java/stevens"));
        demo.setSize(560 , 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    public static void barChart() {
        BarChartAWT chart = new BarChartAWT("Car Usage Statistics", "Which car do you like?");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

    public static void check() throws IOException {
        InputStream in = new FileInputStream(new File("src/main/java/stevens"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            if (reader.ready())
                stringBuilder.append("#@*6");
        }
        String[] returnedString = stringBuilder.toString().split("#@[*]6");
        System.out.println(Arrays.toString(returnedString));
        System.out.println(returnedString[1]);
    }
}
