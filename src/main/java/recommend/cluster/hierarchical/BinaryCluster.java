package recommend.cluster.hierarchical;

import recommend.feature.Item;
import recommend.math.Stats;

/**
 * Created by kenny on 2/20/14.
 */
public class BinaryCluster implements Cluster {

    private final Item averagedItem;

    private final Cluster cluster1;

    private final Cluster cluster2;

    public BinaryCluster(Cluster cluster1, Cluster cluster2) {
        this.cluster1 = cluster1;
        this.cluster2 = cluster2;

        this.averagedItem = Stats.average(cluster1.getItem(), cluster2.getItem());
    }

    public Item getItem() {
        return averagedItem;
    }

    @Override
    public String getName() {
        return averagedItem.getName();
    }

    @Override
    public String toString() {
        return getName();
    }

}
