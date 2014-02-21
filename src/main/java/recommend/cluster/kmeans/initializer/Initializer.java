package recommend.cluster.kmeans.initializer;

import recommend.cluster.kmeans.Centroid;
import recommend.feature.Item;

import java.util.List;

/**
 * Created by kenny on 2/21/14.
 */
public interface Initializer {

    List<Centroid> initialize(List<Item> items, int k);

}
