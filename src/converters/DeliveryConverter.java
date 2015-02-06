package converters;

import java.util.function.Function;

import jsprit.core.problem.job.Delivery;
import jsprit.core.util.Coordinate;

public class DeliveryConverter implements Function<models.Delivery, Delivery> {

	@Override
	public Delivery apply(models.Delivery arg0) {
		return (Delivery)Delivery.Builder.newInstance(arg0.getDescription())
				.setCoord(Coordinate.newInstance(arg0.getLatitude(), arg0.getLongitude()))
				.addSizeDimension(0, (int)Math.floor(arg0.getLoadWeight()))
				.addSizeDimension(1, (int)Math.floor(arg0.getLoadVolume()))
				.build();
	}

}
