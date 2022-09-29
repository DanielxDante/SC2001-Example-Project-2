package b;
import java.util.Comparator;

public class WeightComparator implements Comparator<QueueNode> {
	public int compare(QueueNode a, QueueNode b) {
		Integer w1 = a.getWeight();
		Integer w2 = b.getWeight();
		return w1.compareTo(w2);
	}
}
