package recommend.distance;

import recommend.feature.FeatureVector;

import java.util.Set;

/**
 * Created by kenny on 2/16/14.
 */
public class PearsonDistanceFunction implements DistanceFunction {

    @Override
    public double distance(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);
        if(intersection.size() == 0) {
            return 0.0;
        }
        double sum1 = 0;
        double sum2 = 0;
        double sum1Sq = 0;
        double sum2Sq = 0;
        double pSum = 0;
        for(String feature : intersection) {
            // sum up all preferences
            sum1 += featureVector1.get(feature);
            sum2 += featureVector2.get(feature);

            // sum up squares
            sum1Sq += Math.pow(featureVector1.get(feature), 2);
            sum2Sq += Math.pow(featureVector2.get(feature), 2);

            // sum up products
            pSum += featureVector1.get(feature) * featureVector2.get(feature);
        }

        // calculate Pearson's score
        double num = pSum - (sum1 * sum2 / intersection.size());
        double den = Math.sqrt(
                (sum1Sq - Math.pow(sum1, 2) / intersection.size()) *
                        (sum2Sq - Math.pow(sum2, 2) / intersection.size())
        );
        if(den == 0) { return 0; }
        return Math.abs(num / den - 1);
    }

    @Override
    public String toString() {
        return "PearsonDistanceFunction";
    }

}
