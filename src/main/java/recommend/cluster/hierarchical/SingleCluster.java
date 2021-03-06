package recommend.cluster.hierarchical;

import recommend.feature.Item;

import java.util.Set;

/**
 * Created by kenny on 2/20/14.
 */
public class SingleCluster implements Cluster {

    private final Item item;

    public SingleCluster(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public Set<Cluster> getParents() {
        return null;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public String toString() {
        return getName();
    }

}
