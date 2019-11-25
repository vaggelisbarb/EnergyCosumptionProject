package timeaggregation;

public class AggregatorFactory {
	public IAggregator createAggregator(String aggrType) {
		if(aggrType.equals("Aggregator"))
			return new Aggregator();
		else
			return null;
	}
}
