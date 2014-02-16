package recommend.feature;

import org.junit.Test;
import recommend.feature.impl.WeightFeature;

/**
 * Created by kenny on 2/16/14.
 */
public class WeightFeatureTest {

    @Test
    public void normalizeTest() {
        for(int lb = 90; lb < 450; lb += 15) {
            WeightFeature weightFeature = new WeightFeature(lb);
            System.out.println(lb + "lb: " + weightFeature.getValue());
        }
    }

}
