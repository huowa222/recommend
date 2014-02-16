package recommend.feature;

/**
 * Created by kenny on 2/13/14.
 */
public abstract class Feature implements Normalizable {

    private final String name;

    private final double value;

    private final double originalValue;

    public Feature(String name, double value) {
        this.name = name;
        this.originalValue = value;
        this.value = normalize();
    }

    public String getName() {
        return name;
    }

    /**
     * get normalized value
     */
    public double getValue() {
        return value;
    }

    public double getOriginalValue() {
        return originalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feature)) return false;

        Feature feature = (Feature) o;

        if (Double.compare(feature.value, value) != 0) return false;
        if (!name.equals(feature.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Feature{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

}
