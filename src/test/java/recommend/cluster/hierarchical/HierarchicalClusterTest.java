package recommend.cluster.hierarchical;

import org.junit.Test;
import recommend.SampleCorpus;
import recommend.feature.Item;

import java.util.Collection;

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
        Cluster hCluster = hierarchicalCluster.cluster(SampleCorpus.buildColors());
        System.out.println(hCluster);

        System.out.println("Traverse Parents...");
        System.out.println("Base Parents:");
        Collection<Cluster> parents = hCluster.getParents();
        for(Cluster parent : parents) {
            System.out.println(parent);
        }

        System.out.println("\nBase GrandParents");
        for(Cluster parent : parents) {
            Collection<Cluster> grandParents = parent.getParents();
            if(grandParents == null) { continue; }
            for(Cluster grandParent : grandParents) {
                System.out.println(grandParent);
            }
        }

        System.out.println("\nBase Great GrandParents");
        for(Cluster parent : parents) {
            Collection<Cluster> grandParents = parent.getParents();
            if(grandParents == null) { continue; }
            for(Cluster grandParent : grandParents) {
                Collection<Cluster> greatGrandParents = grandParent.getParents();
                if(greatGrandParents == null) { continue; }
                for(Cluster greatGrandParent : greatGrandParents) {
                    System.out.println(greatGrandParent);
                }
            }
        }
    }

}
