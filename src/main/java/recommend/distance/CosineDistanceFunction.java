package recommend.distance;

import recommend.feature.FeatureVector;
import recommend.math.Normalize;

import java.util.Set;

/**
 * Created by kenny on 2/16/14.
 */
public class CosineDistanceFunction implements DistanceFunction {

    @Override
    public double distance(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);

        double sumProd = 0;
        for(String feature : intersection) {
            sumProd += featureVector1.get(feature) * featureVector2.get(feature);
        }

        double sum1sq = 0;
        for(String feature : intersection) {
            sum1sq += featureVector1.get(feature) * featureVector1.get(feature);
        }
        sum1sq = Math.sqrt(sum1sq);

        double sum2sq = 0;
        for(String feature : intersection) {
            sum2sq += featureVector2.get(feature) * featureVector2.get(feature);
        }
        sum2sq = Math.sqrt(sum2sq);

        if(sum1sq * sum2sq == 0) {
            return 1.0;
        }
        double cosineSimilarity = sumProd / (sum1sq * sum2sq); // -1 opposite, 0 indifferent, 1 exactly the same
        return 1 - Normalize.linear(cosineSimilarity, -1, 1); // scale to 0 same 1 opposites
    }

    @Override
    public String toString() {
        return "CosineDistanceFunction";
    }

}
