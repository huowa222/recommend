package recommend;

import recommend.feature.FeatureVector;
import recommend.math.Transform;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntersectedDistance {

    public static double discrete(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);
        if(intersection.size() == 0) {
            return 0.0;
        }

        for(String feature : intersection) {
            if(featureVector1.get(feature) != featureVector2.get(feature)) {
                return 1.0;
            }
        }
        return 0.0;
    }

	public static double euclidean(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);

		double sumSq = 0;
		for(String feature : intersection) {
			sumSq += Math.pow(featureVector1.get(feature) - featureVector2.get(feature), 2);
		}
		return Math.sqrt(sumSq);
	}

    public static double cosine(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);

        double sumProd = 0;
        for(String feature : intersection) {
            sumProd += featureVector1.get(feature) * featureVector2.get(feature);
        }

        double sum1sq = 0;
        for(String feature : intersection) {
            sum1sq += featureVector1.get(feature) * featureVector1.get(feature);
        }
        sum1sq = Math.sqrt(sum1sq);

        double sum2sq = 0;
        for(String feature : intersection) {
            sum2sq += featureVector2.get(feature) * featureVector2.get(feature);
        }
        sum2sq = Math.sqrt(sum2sq);

        if(sum1sq * sum2sq == 0) {
            return 1.0;
        }
        double cosineSimilarity = sumProd / (sum1sq * sum2sq); // -1 opposite, 0 indifferent, 1 exactly the same
        return 1 - Transform.normalize(cosineSimilarity, -1, 1); // scale to 0 same 1 opposites
    }

	public static double pearsonCoefficient(FeatureVector featureVector1, FeatureVector featureVector2) {
        Set<String> intersection = featureVector1.intersection(featureVector2);
        if(intersection.size() == 0) {
            return 0.0;
        }
		double sum1 = 0;
		double sum2 = 0;
		double sum1Sq = 0;
		double sum2Sq = 0;
		double pSum = 0;
		for(String feature : intersection) {
			// sum up all preferences
			sum1 += featureVector1.get(feature);
			sum2 += featureVector2.get(feature);
			
			// sum up squares
			sum1Sq += Math.pow(featureVector1.get(feature), 2);
			sum2Sq += Math.pow(featureVector2.get(feature), 2);
			
			// sum up products
			pSum += featureVector1.get(feature) * featureVector2.get(feature);
		}
		
		// calculate Pearson's score
		double num = pSum - (sum1 * sum2 / intersection.size());
		double den = Math.sqrt(
						(sum1Sq - Math.pow(sum1, 2) / intersection.size()) *
						(sum2Sq - Math.pow(sum2, 2) / intersection.size())
		);
		if(den == 0) { return 0; }
		return Math.abs(num / den - 1);
    }
	
	/**
	 * J(A,B) = |A ∩ B| / |A ∪ B|
     * dJ(A,B) = 1 - J(A,B)
     *
     * M11 represents the total number of attributes where A and B both have a value of 1.
     * M01 represents the total number of attributes where the attribute of A is 0 and the attribute of B is 1.
     * M10 represents the total number of attributes where the attribute of A is 1 and the attribute of B is 0.
     * M00 represents the total number of attributes where A and B both have a value of 0.
	 * dJ = (M01 + M10) / (M01 + M10 + M11)
     */
	public static double jaccardCoefficient(FeatureVector featureVector1, FeatureVector featureVector2, double positiveThreshold) {
        Set<String> intersection = featureVector1.intersection(featureVector2);

		double m11 = 0;
        double m01 = 0;
        double m10 = 0;
        double m00 = 0; // unused
		for(String feature : intersection) {
            boolean a = featureVector1.get(feature) >= positiveThreshold ? true : false;
            boolean b = featureVector2.get(feature) >= positiveThreshold ? true : false;
            if(a & b) {
                m11++;
            } else if(!a & b) {
                m01++;
            } else if(a & !b) {
                m10++;
            } else {
                m00++;
            }
		}
		if(m01 + m10 + m11 == 0) {
			return 0;
		}
		return (m01 + m10) / (m01 + m10 + m11);
	}


	public static List<FeatureVector> score(FeatureVector baseFeatureVector, List<FeatureVector> featureVectors, int n, DistanceFunctionTypes distanceFunction, double... params) {
		List<FeatureVector> scored = new LinkedList<>();
		for(FeatureVector featureVector : featureVectors) {
			if(baseFeatureVector.equals(featureVector)) { continue; }
            double distance = 0;
            switch(distanceFunction) {
                case DISCRETE:
                    distance = discrete(baseFeatureVector, featureVector);
                    break;

                case EUCLIDEAN:
                    distance = euclidean(baseFeatureVector, featureVector);
                    break;

                case COSINE:
                    distance = cosine(baseFeatureVector, featureVector);
                    break;

                case PEARSON:
                    distance = pearsonCoefficient(baseFeatureVector, featureVector);
                    break;

                case JACCARD:
                    distance = jaccardCoefficient(baseFeatureVector, featureVector, params[0]);
                    break;

            }
            featureVector.setScore(distance);
            scored.add(featureVector);
		}

		Collections.sort(scored);
        if(n > scored.size()) {
            n = scored.size();
        }
		return scored.subList(0, n - 1);
    }
	
}
