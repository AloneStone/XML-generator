import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class Sign extends Signaling{

	public Sign(Integer id, Position position, Collection<Integer> idSignalingPosible) {
		
		super(id, position, idSignalingPosible);
	}

	@Override
	String getType() {

		return "Sign";
	}

}
