package recommend.cluster.hierarchical;

import recommend.feature.Item;

import java.util.Set;

/**
 * Created by kenny on 2/20/14.
 */
public interface Cluster {

    String getName();

    Item getItem();

    Set<Cluster> getParents();

}
