package recommend;

import ch.lambdaj.Lambda;
import org.junit.Test;
import recommend.distance.DistanceFunction;
import recommend.distance.PearsonsCoefficientFunction;
import recommend.feature.Category;
import recommend.feature.Item;
import recommend.feature.impl.RatingFeature;

import java.util.List;

/**
 * Created by kenny on 2/16/14.
 */
public class CategoryNearestNeighborTest {

    private static final PearsonsCoefficientFunction FUNCTION = new PearsonsCoefficientFunction("RATING");

    private static final Category KENNY = buildKenny();

    private static final Category TOBY = buidToby();

    @Test
    public void recommendMovie() {
         List<Category> critics = SampleCorpus.buildMoviedCritics();

         massScoreTest(KENNY, critics, new PearsonsCoefficientFunction("RATING"), 3) ;
         massScoreTest(TOBY, critics, new PearsonsCoefficientFunction("RATING"), 3);
    }

    private void massScoreTest(Category person, List<Category> people, DistanceFunction distanceFunction, int n) {
        CategoryNearestNeighbor nearestNeighbor = new CategoryNearestNeighbor(people);
        nearestNeighbor.setDistanceFunction(distanceFunction);

        List<Category> sortedPeople = nearestNeighbor.search(person, n);
        System.out.println("Top " + n + " for: " + person);
        System.out.println("Using: " + distanceFunction);
        System.out.println(Lambda.join(sortedPeople, "\n"));
        System.out.println("\n");
    }

    private static Category buidToby() {
        Category toby = new Category("Toby");
        toby.addItem(new Item("Snakes on a plane", new RatingFeature(4.5)));
        toby.addItem(new Item("Superman Returns", new RatingFeature(4.0)));
        toby.addItem(new Item("You, Me and Dupree", new RatingFeature(1.0)));

        return toby;
    }

    private static Category buildKenny() {
        Category kenny = new Category("kenny");
        kenny.addItem(new Item("Lady in the Water", new RatingFeature(2.0)));
        kenny.addItem(new Item("Snakes on a plane", new RatingFeature(1.5)));
        kenny.addItem(new Item("Just My Luck", new RatingFeature(1.5)));
        kenny.addItem(new Item("Superman Returns", new RatingFeature(5.0)));
        kenny.addItem(new Item("You, Me and Dupree", new RatingFeature(1.0)));
        kenny.addItem(new Item("The Night Listener", new RatingFeature(5.0)));

        return kenny;
    }

}
