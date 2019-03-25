package fr.mrcraftcod.blob;

/**
 * Created by mrcraftcod (MrCraftCod - zerderr@gmail.com) on 2019-03-25.
 *
 * @author Thomas Couchoud
 * @since 2019-03-25
 */
public class Node{

	final int ID;

	double pressure;
	
	public Node(int id){ID = id;}
	
	public double getPressure(){
		return pressure;
	}
	
	public void setPressure(double pressure){
		this.pressure = pressure;
	}
	
	public int getID(){
		return ID;
	}
}
