package recommend.distance;

import recommend.feature.FeatureVector;

import java.util.Set;

/**
 * Created by kenny on 2/16/14.
 */
public class DiscreteDistanceFunction implements DistanceFunction {

    @Override
    public double distance(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);
        if(intersection.size() == 0) {
            return 0.0;
        }

        for(String feature : intersection) {
            if(featureVector1.get(feature) != featureVector2.get(feature)) {
                return 1.0;
            }
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "DiscreteDistanceFunction";
    }

}
