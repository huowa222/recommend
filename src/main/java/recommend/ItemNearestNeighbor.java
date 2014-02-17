package recommend;

import recommend.distance.DistanceFunction;
import recommend.feature.Item;

import java.util.Collections;
import java.util.List;

/**
 * Created by kenny on 2/16/14.
 */
public class ItemNearestNeighbor {

    private DistanceFunction distanceFunction;

    private List<Item> entities;

    public ItemNearestNeighbor(List<Item> entities) {
        this.entities = entities;
    }

    public List<Item> search(Item baseEntity) {
        return search(baseEntity, 1);
    }

    public List<Item> search(Item baseEntity, int n) {
        for(Item entity : this.entities) {
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
