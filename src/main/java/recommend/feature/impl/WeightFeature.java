package recommend.feature.impl;

import recommend.feature.Feature;
import recommend.math.Transform;

/**
 * Created by kenny on 2/13/14.
 */
public class WeightFeature extends Feature {

    private static final double MAX_VALUE = 400;

    private static final double MIN_VALUE = 80;

    public WeightFeature(double value) {
        super("WEIGHT", value);
    }

    @Override
    public double normalize(double value) {
        return Transform.normalize(value, MIN_VALUE, MAX_VALUE);
    }

    @Override
    public String toString() {
        return "WeightFeature{" +
                "value=" + getOriginalValue() + " lb" +
                '}';
    }

}
