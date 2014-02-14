package recommend.feature.impl;

import recommend.feature.Feature;
import recommend.math.Transform;

/**
 * Created by kenny on 2/13/14.
 */
public class WaistFeature extends Feature {

    private static final double MAX_VALUE = 60;

    private static final double MIN_VALUE = 24;

    public WaistFeature(double value) {
        super("WAIST", value);
    }

    @Override
    public double normalize(double value) {
        return Transform.normalize(value, MIN_VALUE, MAX_VALUE);
    }

    @Override
    public String toString() {
        return "WaistFeature{" +
                "value=" + getOriginalValue() + " inches" +
                '}';
    }

}
