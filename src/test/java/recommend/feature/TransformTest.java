package recommend.feature;

import ch.lambdaj.Lambda;
import org.junit.Test;
import recommend.SampleCorpus;

/**
 * Created by kenny on 2/17/14.
 */
public class TransformTest {

    @Test
    public void transform() {
        System.out.println(Lambda.join(Transform.invert(SampleCorpus.buildMoviedCritics(), "RATING"), "\n"));
    }
}
