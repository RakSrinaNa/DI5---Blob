package fr.mrcraftcod.blob;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		
		Node node = (Node) o;
		
		return new EqualsBuilder().append(ID, node.ID).isEquals();
	}
	
	@Override
	public int hashCode(){
		return new HashCodeBuilder(17, 37).append(ID).toHashCode();
	}
}
