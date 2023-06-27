package telran.numbers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate implements Iterable<Integer> {
	int minInclusive;
	int maxExclusive;
	Predicate<Integer> predicate;

	public RangePredicate(int minInclusive, int maxExclusive) {
		if(minInclusive >= maxExclusive) {
			throw new IllegalArgumentException("min must be less than max");
		}
		this.minInclusive = minInclusive;
		this.maxExclusive = maxExclusive;
	}

	public Predicate<Integer> getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}

	public int[] toArray() {
		int[] result = new int[maxExclusive - minInclusive];
		int index = 0;
		if (predicate != null) {
			for (int numbers : this) {
				if (getPredicate().test(numbers)) {
					result[index++] = numbers;
				}
			}
		}
		if (predicate == null) {
			for (int numbers : this) {
				result[index++] = numbers;
			}
		}
		return Arrays.copyOf(result, index);
	}

	private class RangePredicateIterator implements Iterator<Integer> {
		int current;
		Predicate<Integer> innerPredicate;
		
		RangePredicateIterator(Predicate<Integer> predicate) {
				innerPredicate = predicate;
				current = minInclusive;
		}
		
		@Override
		public boolean hasNext() {
			if (predicate != null) {
				while (current < maxExclusive && !innerPredicate.test(current)) {
					current++;
				}
			}
			return maxExclusive > current;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			int result = current++;
			return result;
		}

	}

	@Override
	public Iterator<Integer> iterator() {

		return new RangePredicateIterator(predicate);
	}

}
