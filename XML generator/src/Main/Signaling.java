package Main;

import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public abstract class Signaling {

	public Integer id;
	public Position position;
	// Carrefour a coté
	public Collection<Integer> idSignalingPosible;

	public Signaling(Integer id, Position position,
			Collection<Integer> idSignalingPosible) {

		this.id = id;
		this.position = position;
		this.idSignalingPosible = idSignalingPosible;
	}

	abstract String getType();

	abstract Integer getRedDuration();

	abstract Integer getGreenDuration();

	public Integer getId() {
		return id;
	}

	public Position getPosition() {
		return position;
	}

	public Collection<Integer> getIdSignalingPosible() {
		return idSignalingPosible;
	}

}
