package recommend.feature;

/**
 * Created by kenny on 2/16/14.
 */
public interface Measurable<C> extends Comparable<C> {

    double getScore();

    void setScore(double score);

}
