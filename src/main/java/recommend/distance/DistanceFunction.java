package recommend.distance;

import recommend.feature.FeatureVector;

/**
 * Created by kenny on 2/16/14.
 */
public interface DistanceFunction {

    double distance(FeatureVector featureVector1, FeatureVector featureVector2);
}
