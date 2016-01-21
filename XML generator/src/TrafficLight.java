import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class TrafficLight extends Signaling{
	

	public Integer redDuration;
	public Integer greensDuration;
	
	public TrafficLight(Integer id, Position position, Collection<Integer> idSignalingPosible,Integer rd,Integer gd) {
		super(id, position, idSignalingPosible);
		this.redDuration = rd;
		this.greensDuration = gd;
	}

	@Override
	String getType() {
		
		return "TrafficLight";
	}
	
	
}
