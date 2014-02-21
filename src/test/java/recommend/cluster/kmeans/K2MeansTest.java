package recommend.cluster.kmeans;

import ch.lambdaj.Lambda;
import org.junit.Test;
import recommend.SampleCorpus;

import java.util.List;

import static ch.lambdaj.Lambda.on;

/**
 * Created by kenny on 2/21/14.
 */
public class K2MeansTest {

    @Test
    public void clusterSampleData() {
        K2MeansClusterer clusterer = new K2MeansClusterer();
        clusterer.setMaxIterations(1);

        System.out.println("Iterations = 1");
        List<Centroid> clusters = clusterer.cluster(SampleCorpus.kMeansData());
        System.out.println(Lambda.join(clusters, "\n"));
        System.out.println("New centers:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).center()), "\n"));
        System.out.println("Sizes:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).size()), "\n"));


        clusterer.setMaxIterations(3);
        System.out.println("\n\nIterations = 3");
        clusters = clusterer.cluster(SampleCorpus.kMeansData());
        System.out.println(Lambda.join(clusters, "\n"));
        System.out.println("New centers:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).center()), "\n"));
        System.out.println("Sizes:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).size()), "\n"));


        clusterer.setMaxIterations(10);
        System.out.println("\n\nIterations = 10");
        clusters = clusterer.cluster(SampleCorpus.kMeansData());
        System.out.println(Lambda.join(clusters, "\n"));
        System.out.println("New centers:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).center()), "\n"));
        System.out.println("Sizes:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).size()), "\n"));
    }


    @Test
    public void clusterColors() {
        K2MeansClusterer clusterer = new K2MeansClusterer();
        clusterer.setMaxIterations(1);

        System.out.println("Iterations = 1");
        List<Centroid> clusters = clusterer.cluster(SampleCorpus.buildColors());
        System.out.println(Lambda.join(clusters, "\n"));
        System.out.println("New centers:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).center()), "\n"));
        System.out.println("Sizes:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).size()), "\n"));


        clusterer.setMaxIterations(3);
        System.out.println("\n\nIterations = 3");
        clusters = clusterer.cluster(SampleCorpus.buildColors());
        System.out.println(Lambda.join(clusters, "\n"));
        System.out.println("New centers:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).center()), "\n"));
        System.out.println("Sizes:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).size()), "\n"));


        clusterer.setMaxIterations(10);
        System.out.println("\n\nIterations = 10");
        clusters = clusterer.cluster(SampleCorpus.buildColors());
        System.out.println(Lambda.join(clusters, "\n"));
        System.out.println("New centers:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).center()), "\n"));
        System.out.println("Sizes:");
        System.out.println(Lambda.join(Lambda.extract(clusters, on(Centroid.class).size()), "\n"));
    }

}
