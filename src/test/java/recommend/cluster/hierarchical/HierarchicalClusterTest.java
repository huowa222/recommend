package recommend.cluster.hierarchical;

import org.junit.Test;
import recommend.SampleCorpus;
import recommend.feature.Item;

/**
 * Created by kenny on 2/20/14.
 */
public class HierarchicalClusterTest {

    @Test
    public void cluster() {
        HierarchicalCluster hierarchicalCluster = new HierarchicalCluster();
        System.out.println("Colors to be clustered");
        for(Item item : SampleCorpus.buildColors()) {
            System.out.println(item);
        }

        System.out.println("Clustered colors");
        System.out.println(hierarchicalCluster.cluster(SampleCorpus.buildColors()));
    }

}
