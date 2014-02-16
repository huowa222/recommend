package recommend;

import recommend.distance.DistanceFunction;
import recommend.distance.EuclideanDistanceFunction;
import recommend.feature.FeatureVector;

import java.util.Collections;
import java.util.List;

/**
 * Created by kenny on 2/16/14.
 */
public class NearestNeighbor {

    private DistanceFunction distanceFunction = new EuclideanDistanceFunction();

    private List<FeatureVector> featureVectors;

    public NearestNeighbor(List<FeatureVector> featureVectors) {
        this.featureVectors = featureVectors;
    }

    public List<FeatureVector> search(FeatureVector baseFeatureVector) {
        return search(baseFeatureVector, 1);
    }

    public List<FeatureVector> search(FeatureVector baseFeatureVector,int n) {
        for(FeatureVector featureVector : this.featureVectors) {
            if(baseFeatureVector.equals(featureVector)) { continue; }
            featureVector.setScore(this.distanceFunction.distance(baseFeatureVector, featureVector));
        }

        Collections.sort(this.featureVectors);
        if(n > this.featureVectors.size()) {
            n = this.featureVectors.size();
        }
        return this.featureVectors.subList(0, n);
    }

    public void setDistanceFunction(DistanceFunction distanceFunction) {
        this.distanceFunction = distanceFunction;
    }

}
