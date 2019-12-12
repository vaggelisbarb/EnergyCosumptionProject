package timeaggregation;

public class AggregatorFactory {
	public IAggregator createAggregator(String timeUnit,String aggFunction) {
			return new Aggregator(timeUnit,aggFunction);
	}
}
