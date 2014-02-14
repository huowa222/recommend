package recommend.math;

/**
 * Created by kenny on 2/13/14.
 */
public class Transform {

    private Transform() {}

    public static double normalize(double value, double min, double max) {
        return (value - min) / (max - min);
    }

}
