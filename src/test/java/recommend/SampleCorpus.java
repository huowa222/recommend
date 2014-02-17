package recommend;

import recommend.feature.Category;
import recommend.feature.Item;
import recommend.feature.impl.RatingFeature;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kenny on 2/16/14.
 */
public class SampleCorpus {


    public static List<Category> buildMoviedCritics() {
        List<Category> categories = new LinkedList<>();
        Category lisa = new Category("Lisa Rose");
        lisa.addItem(new Item("Lady in the Water", new RatingFeature(2.5)));
        lisa.addItem(new Item("Snakes on a plane", new RatingFeature(3.5)));
        lisa.addItem(new Item("Just My Luck", new RatingFeature(3.0)));
        lisa.addItem(new Item("Superman Returns", new RatingFeature(3.5)));
        lisa.addItem(new Item("You, Me and Dupree", new RatingFeature(2.5)));
        lisa.addItem(new Item("The Night Listener", new RatingFeature(3.0)));
        categories.add(lisa);

        Category gene = new Category("Gene Seymour");
        gene.addItem(new Item("Lady in the Water", new RatingFeature(3.0)));
        gene.addItem(new Item("Snakes on a plane", new RatingFeature(3.5)));
        gene.addItem(new Item("Just My Luck", new RatingFeature(1.5)));
        gene.addItem(new Item("Superman Returns", new RatingFeature(5.0)));
        gene.addItem(new Item("You, Me and Dupree", new RatingFeature(3.5)));
        gene.addItem(new Item("The Night Listener", new RatingFeature(3.0)));
        categories.add(gene);

        Category michael = new Category("Michael Phillips");
        michael.addItem(new Item("Lady in the Water", new RatingFeature(2.5)));
        michael.addItem(new Item("Snakes on a plane", new RatingFeature(3.0)));
        michael.addItem(new Item("Superman Returns", new RatingFeature(3.5)));
        michael.addItem(new Item("The Night Listener", new RatingFeature(4.0)));
        categories.add(michael);

        Category claudia = new Category("Claudia Puig");
        claudia.addItem(new Item("Snakes on a plane", new RatingFeature(3.5)));
        claudia.addItem(new Item("Just My Luck", new RatingFeature(3.0)));
        claudia.addItem(new Item("Superman Returns", new RatingFeature(4.0)));
        claudia.addItem(new Item("The Night Listener", new RatingFeature(4.5)));
        claudia.addItem(new Item("You, Me and Dupree", new RatingFeature(2.5)));
        categories.add(claudia);

        Category mick = new Category("Mick LaSalle");
        mick.addItem(new Item("Lady in the Water", new RatingFeature(3.0)));
        mick.addItem(new Item("Snakes on a plane", new RatingFeature(4.0)));
        mick.addItem(new Item("Just My Luck", new RatingFeature(2.0)));
        mick.addItem(new Item("Superman Returns", new RatingFeature(3.0)));
        mick.addItem(new Item("The Night Listener", new RatingFeature(3.0)));
        mick.addItem(new Item("You, Me and Dupree", new RatingFeature(2.0)));
        categories.add(mick);

        Category jack = new Category("Jack Matthews");
        jack.addItem(new Item("Lady in the Water", new RatingFeature(3.0)));
        jack.addItem(new Item("Snakes on a plane", new RatingFeature(4.0)));
        jack.addItem(new Item("Superman Returns", new RatingFeature(5.0)));
        jack.addItem(new Item("The Night Listener", new RatingFeature(3.0)));
        jack.addItem(new Item("You, Me and Dupree", new RatingFeature(3.5)));
        categories.add(jack);

        Category toby = new Category("Toby");
        toby.addItem(new Item("Snakes on a plane", new RatingFeature(4.5)));
        toby.addItem(new Item("Superman Returns", new RatingFeature(4.0)));
        toby.addItem(new Item("You, Me and Dupree", new RatingFeature(1.0)));
        categories.add(toby);

        return categories;
    }

}
