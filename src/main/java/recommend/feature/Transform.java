package recommend.feature;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kenny on 2/17/14.
 */
public class Transform {

    private Transform() {}

    /**
     * transform item and category information
     * @param categories
     * @return
     */
    public static List<Category> transform(List<Category> categories, String featureToInvert) {
        Map<Item, Category> transformed = new HashMap<>();
        for(Category category : categories) {
            for(Item item : category.getItems().values()) {
                if(!transformed.containsKey(item)) {
                    transformed.put(item, new Category(item.getName()));
                }
                GeneralFeature feature = new GeneralFeature(
                        item.getFeature(featureToInvert).getName(),
                        item.getFeature(featureToInvert).getValue()
                );
                Item newItem = new Item(category.getName());
                newItem.addFeature(feature);

                transformed.get(item).getItems().put(newItem.getName(), newItem);
            }
        }

        return new LinkedList(transformed.values());
    }

//    public static List<Category> transform(List<Category> categories, String featureToInvert) {
//        Map<Item, Category> transformed = new HashMap<>();
//        for(Category category : categories) {
//            for(Item item : category.getItems().values()) {
//                if(!transformed.containsKey(item)) {
//                    Category newCategory = new Category(item.getName());
//                    newCategory.addItem(new Item(item.getName()));
//                    transformed.put(item, newCategory);
//                }
//                GeneralFeature feature = new GeneralFeature(
//                        category.getName(),
//                        item.getFeature(featureToInvert).getValue()
//                );
//                Item newItem = new Item(category.getName());
//                newItem
//
//                transformed.get(item).getItems().get(item.getName()).addFeature(feature);
//            }
//        }
//
//        return new LinkedList(transformed.values());
//    }

}
