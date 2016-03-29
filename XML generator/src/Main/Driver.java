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
	public Driver(int stressLevel){
		this.stressLevel = stressLevel;
	}
	
	public String getStressLevel() {
		return stressLevel.toString();
	}

	
	
	public void moreStress(){
		this.stressLevel += 5; 
	}
	
	public void lessStress(){
		this.stressLevel += 5; 
	}
}
