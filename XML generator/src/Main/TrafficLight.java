package Main;

import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class TrafficLight extends Signaling {

	public Integer redDuration;
	public Integer greenDuration;

	public TrafficLight(Integer id, Position position,
			Collection<Integer> idSignalingPosible, Integer rd, Integer gd) {
		super(id, position, idSignalingPosible);
		this.redDuration = rd;
		this.greenDuration = gd;
	}

	@Override
	String getType() {

		return "TrafficLight";
	}

	@Override
	Integer getRedDuration() {
		// TODO Auto-generated method stub
		return redDuration;
	}

	@Override
	Integer getGreenDuration() {
		// TODO Auto-generated method stub
		return greenDuration;
	}

}
