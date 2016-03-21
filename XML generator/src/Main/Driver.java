package Main;
/**
 * 
 * @author Bastien26
 *
 */
public class Driver {

	public Integer stressLevel;
	
	public Driver(){
		this.stressLevel = 0;
	}
	
	
	public Integer getStressLevel() {
		return stressLevel;
	}

	
	
	public void moreStress(){
		this.stressLevel += 5; 
	}
	
	public void lessStress(){
		this.stressLevel += 5; 
	}
}
