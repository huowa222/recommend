package recommend.feature;

import ch.lambdaj.Lambda;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by kenny on 2/13/14.
 */
public class FeatureVector implements Iterable<Feature>, Comparable<FeatureVector> {

    private static final double DEFAULT_VALUE = 0.0;

    private final String id;

    private double score = 0;

    private Map<String, Feature> features = new HashMap<>();

    public FeatureVector(String id) {
        this.id = id;
    }

    public boolean contains(String feature) {
        return features.containsKey(feature);
    }

    public double get(String feature) {
        if(contains(feature)) {
            return features.get(feature).getValue();
        }
        return DEFAULT_VALUE;
    }

    public void add(Feature feature) {
        features.put(feature.getName(), feature);
    }

    public Set<String> features() {
        return features.keySet();
    }

    public String getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public Iterator<Feature> iterator() {
        return features.values().iterator();
    }

    public Set<String> union(FeatureVector featureVector2) {
        Set<String> union = new TreeSet<>(features());
        union.addAll(featureVector2.features());
        return union;
    }

    public Set<String> intersection(FeatureVector featureVector2) {
        Set<String> intersection = new TreeSet<>(features());
        intersection.retainAll(featureVector2.features());
        return intersection;
    }

    @Override
    public String toString() {
        return "FeatureSet{" +
                "id=" + id +
                ", score=" + score +
                ", features=" + Lambda.join(features) +
                '}';
    }

    @Override
    public int compareTo(FeatureVector features) {
        if(getScore() < features.getScore()) { return -1; }
        if(getScore() > features.getScore()) { return 1; }
        return 0;
    }

}
