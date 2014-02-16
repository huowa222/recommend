package recommend.distance;

import recommend.feature.FeatureVector;

import java.util.Set;

/**
 * Created by kenny on 2/16/14.
 */
public class EuclideanDistanceFunction implements DistanceFunction {

    @Override
    public double distance(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);

        double sumSq = 0;
        for(String feature : intersection) {
            sumSq += Math.pow(featureVector1.get(feature) - featureVector2.get(feature), 2);
        }
        return Math.sqrt(sumSq);
    }

    @Override
    public String toString() {
        return "EuclideanDistanceFunction";
    }

}
