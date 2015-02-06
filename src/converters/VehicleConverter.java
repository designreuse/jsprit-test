package converters;

import java.util.function.Function;

import jsprit.core.problem.vehicle.VehicleImpl;
import jsprit.core.problem.vehicle.VehicleTypeImpl;
import jsprit.core.util.Coordinate;

public class VehicleConverter implements Function<models.Vehicle, VehicleImpl> {

	@Override
	public VehicleImpl apply(models.Vehicle t) {
		VehicleTypeImpl vehicleType = VehicleTypeImpl.Builder.newInstance(t.getDescription())
				.addCapacityDimension(0, (int)Math.floor(t.getConstraintLoadWeightCapacity()))
				.addCapacityDimension(1, (int)Math.floor(t.getConstraintLoadVolumeCapacity()))
				.build();
		
		return VehicleImpl.Builder.newInstance(t.getDescription())
				.setType(vehicleType)
				.setStartLocationCoordinate(Coordinate.newInstance(t.getStartingAddressLongitude(), t.getStartingAddressLongitude()))
				.setStartLocationCoordinate(Coordinate.newInstance(t.getFinalAddressLatitude(), t.getFinalAddressLongitude()))
				.build();
	}
}
