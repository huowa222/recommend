package recommend.distance;

import recommend.feature.Category;
import recommend.feature.Item;

/**
 * Created by kenny on 2/16/14.
 */
public interface DistanceFunction {

    double distance(Item item1, Item item2);

    double distance(Category category1, Category category2);

}
