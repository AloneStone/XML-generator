package Main;
import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class Crossroad extends Signaling{

	public Crossroad(Integer id, Position position,Collection<Integer> idSignalingPosible) {
		super(id, position, idSignalingPosible);

	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "Crossroad";
	}

	@Override
	Integer getRedDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Integer getGreenDuration() {
		// TODO Auto-generated method stub
		return null;
	}

}
