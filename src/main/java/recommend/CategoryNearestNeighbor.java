package recommend;

import recommend.distance.DistanceFunction;
import recommend.feature.Category;

import java.util.Collections;
import java.util.List;

/**
 * Created by kenny on 2/16/14.
 */
public class CategoryNearestNeighbor {

    private DistanceFunction distanceFunction;

    private List<Category> entities;

    public CategoryNearestNeighbor(List<Category> entities) {
        this.entities = entities;
    }

    public List<Category> search(Category baseEntity) {
        return search(baseEntity, 1);
    }

    public List<Category> search(Category baseEntity, int n) {
        for(Category entity : this.entities) {
            if(baseEntity.equals(entity)) { continue; }
            entity.setScore(this.distanceFunction.distance(baseEntity, entity));
        }

        Collections.sort(this.entities);
        if(n > this.entities.size()) {
            n = this.entities.size();
        }
        return this.entities.subList(0, n);
    }

    public void setDistanceFunction(DistanceFunction distanceFunction) {
        this.distanceFunction = distanceFunction;
    }

}
