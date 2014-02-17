package recommend;

import ch.lambdaj.Lambda;
import org.junit.Test;
import recommend.distance.PearsonsCoefficientFunction;
import recommend.feature.Category;
import recommend.feature.Transform;

import java.util.List;

/**
 * Created by kenny on 2/16/14.
 */
public class SimilarMovieRecommenderTest {

    private static final PearsonsCoefficientFunction DISTANCE_FUNCTION = new PearsonsCoefficientFunction("RATING");

    private static final List<Category> MOVIES_RATINGS = Transform.transform(SampleCorpus.buildMoviedCritics(), "RATING");

    private static final Category SUPERMAN_MOVIE = buildSuperManMovie();

    @Test
    public void recommendMovies() {

        CategoryNearestNeighbor nearestNeighbor = new CategoryNearestNeighbor(MOVIES_RATINGS);
        nearestNeighbor.setDistanceFunction(DISTANCE_FUNCTION);

        System.out.println("Recommend for: " + SUPERMAN_MOVIE.getName());
        System.out.println(Lambda.join(nearestNeighbor.topMatches(SUPERMAN_MOVIE, 5), "\n"));
        System.out.println();

    }


    private static Category buildSuperManMovie() {
        for(Category category : MOVIES_RATINGS) {
            if(category.getName().equals("Superman Returns")) {
                return category;
            }
        }
        return null;
    }

}
