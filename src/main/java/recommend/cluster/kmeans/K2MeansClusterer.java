package recommend.cluster.kmeans;

import recommend.distance.DistanceFunction;
import recommend.distance.EuclideanDistanceFunction;
import recommend.feature.Item;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kenny on 2/21/14.
 */
public class K2MeansClusterer {

    private DistanceFunction distanceFunction;

    private int maxIterations;

    public K2MeansClusterer() {
        this.distanceFunction = new EuclideanDistanceFunction();
        this.maxIterations = 10;
    }

    public List<Centroid> cluster(List<Item> items) {
        List<Centroid> centroids = createInitialGroups(items);
        for(int iteration = 0; iteration < maxIterations; iteration++) {
            assignItemsToCentroid(centroids, items);
        }
        return centroids;
    }

    private void assignItemsToCentroid(List<Centroid> centroids, List<Item> items) {
        for(Item item : items) {
            Centroid nearest = null;
            double min = Double.MAX_VALUE;
            for(Centroid centroid : centroids) {
                double distance = this.distanceFunction.distance(item, centroid.center());
                if(distance < min) {
                    min = distance;
                    nearest = centroid;
                }
            }
            nearest.add(item);
            // remove from others
            for(Centroid centroid : centroids) {
                if(centroid.equals(nearest)) { continue; }
                centroid.remove(item);
            }
        }
    }

    private List<Centroid> createInitialGroups(List<Item> items) {
        Item max1 = null;
        Item max2 = null;
        double max = Double.MIN_NORMAL;
        for(Item item1 : items) {
            for(Item item2 : items) {
                if(item1.equals(item2)) { continue; }
                double distance = this.distanceFunction.distance(item1, item2);
                if(distance > max) {
                    max = distance;
                    max1 = item1;
                    max2 = item2;
                }
            }
        }
        items.remove(max1);
        items.remove(max2);
        return new LinkedList<>(Arrays.asList(new Centroid(max1), new Centroid(max2)));
    }

    public void setDistanceFunction(DistanceFunction distanceFunction) {
        this.distanceFunction = distanceFunction;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }
}
