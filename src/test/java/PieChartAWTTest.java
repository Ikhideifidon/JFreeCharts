import org.jfree.ui.RefineryUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PieChartAWTTest {

    @Test
    void drawPieChart() {
        PieChartAWT demo = new PieChartAWT("Mobile Sales");
        demo.setSize(560 , 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}