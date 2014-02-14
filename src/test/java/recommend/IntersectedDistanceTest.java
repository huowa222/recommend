package recommend;

import ch.lambdaj.Lambda;
import org.junit.Test;
import recommend.feature.FeatureVector;
import recommend.feature.impl.HeightFeature;
import recommend.feature.impl.WaistFeature;
import recommend.feature.impl.WeightFeature;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by kenny on 2/13/14.
 */
public class IntersectedDistanceTest {

    private static final FeatureVector KENNY = buildKenny();

    private static final FeatureVector PERSON = buildRandomPerson();

    @Test
    public void euclideanDistance() {
        System.out.println("Euclidean Distance Test");
        double score = IntersectedDistance.euclidean(KENNY, PERSON);
        System.out.println(KENNY);
        System.out.println(PERSON);
        System.out.println(DistanceFunctionTypes.EUCLIDEAN + ": " + score);

        score = IntersectedDistance.euclidean(KENNY, KENNY);
        System.out.println("kenny vs kenny");
        System.out.println(DistanceFunctionTypes.EUCLIDEAN + ": " + score);
    }

    @Test
    public void pearsonsCoefficient() {
        System.out.println("Pearson Coefficient Test");
        double score = IntersectedDistance.pearsonCoefficient(KENNY, PERSON);
        System.out.println(KENNY);
        System.out.println(PERSON);
        System.out.println(DistanceFunctionTypes.PEARSON + ": " + score);

        score = IntersectedDistance.pearsonCoefficient(KENNY, KENNY);
        System.out.println("kenny vs kenny");
        System.out.println(DistanceFunctionTypes.PEARSON + ": " + score);
    }

    @Test
    public void massScoreTest() {
        FeatureVector kenny = buildKenny();

        List<FeatureVector> people = buildRandomPeople(100000);

        massScoreTest(kenny, people, DistanceFunctionTypes.DISCRETE);
        massScoreTest(kenny, people, DistanceFunctionTypes.EUCLIDEAN);
        massScoreTest(kenny, people, DistanceFunctionTypes.COSINE);
        massScoreTest(kenny, people, DistanceFunctionTypes.PEARSON);
        massScoreTest(kenny, people, DistanceFunctionTypes.JACCARD, 0.3);
    }

    private void massScoreTest(FeatureVector person, List<FeatureVector> people, DistanceFunctionTypes distanceFunction, double ... params) {
        List<FeatureVector> sortedPeople = IntersectedDistance.score(person, people, 5, distanceFunction, params);
        System.out.println("Top 5 for: " + person);
        System.out.println("Using: " + distanceFunction + ", params: " + Arrays.toString(params));
        System.out.println(Lambda.join(sortedPeople, "\n"));
    }

    private static FeatureVector buildKenny() {
        FeatureVector kenny = new FeatureVector("kenny");
        kenny.add(new HeightFeature(73));
        kenny.add(new WeightFeature(213));
        kenny.add(new WaistFeature(34));
        //kenny.add(new NeckFeature(15.5));
        //kenny.add(new ChestFeature(43));

        return kenny;
    }

    private static FeatureVector buildRandomPerson() {
        return buildRandomPeople(1).get(0);
    }

    private static List<FeatureVector> buildRandomPeople(int number) {
        List<FeatureVector> persons = new LinkedList<>();

        Random random = new Random();
        for(int i = 0; i < number; i++) {
            FeatureVector person = new FeatureVector("PERSON_" + i);
            person.add(new HeightFeature(58 + random.nextInt(26)));
            person.add(new WeightFeature(100 + random.nextInt(200)));
            //person.add(new NeckFeature(13 + random.nextInt(6)));
            //person.add(new ChestFeature(35 + random.nextInt(20)));
            person.add(new WaistFeature(28 + random.nextInt(14)));

            persons.add(person);
        }
        return persons;
    }

}
