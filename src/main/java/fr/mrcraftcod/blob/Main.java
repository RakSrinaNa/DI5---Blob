package fr.mrcraftcod.blob;

import java.util.Objects;
import java.util.Random;

/**
 * Created by mrcraftcod (MrCraftCod - zerderr@gmail.com) on 2019-03-25.
 *
 * @author Thomas Couchoud
 * @since 2019-03-25
 */
public class Main{
	public static void main(String[] args){
		final var graph = new Graph(6);
		graph.getNode(0).ifPresent(n0 -> {
			graph.getNode(1).ifPresent(n1 -> graph.setUndirectionalDistance(n0, n1, 0.5));
			graph.getNode(3).ifPresent(n3 -> graph.setUndirectionalDistance(n0, n3, 0.5));
		});
		
		graph.getNode(1).ifPresent(n1 -> {
			graph.getNode(2).ifPresent(n2 -> graph.setUndirectionalDistance(n1, n2, 0.2028));
			graph.getNode(4).ifPresent(n4 -> graph.setUndirectionalDistance(n1, n4, 0.2942));
		});
		graph.getNode(3).ifPresent(n3 -> {
			graph.getNode(2).ifPresent(n2 -> graph.setUndirectionalDistance(n3, n2, 0.2058));
			graph.getNode(5).ifPresent(n5 -> graph.setUndirectionalDistance(n3, n5, 0.2942));
		});
		graph.getNode(6).ifPresent(n6 -> {
			graph.getNode(2).ifPresent(n2 -> graph.setUndirectionalDistance(n6, n2, 0.4116));
			graph.getNode(4).ifPresent(n4 -> graph.setUndirectionalDistance(n6, n4, 0.2942));
			graph.getNode(5).ifPresent(n5 -> graph.setUndirectionalDistance(n6, n5, 0.2942));
		});
		
		//Init
		final var rnd = new Random();
		final var d = new double[graph.getNodeCount()][graph.getNodeCount()];
		final var q = new double[graph.getNodeCount()][graph.getNodeCount()];
		for(int i = 0; i < graph.getNodeCount(); i++){
			for(int j = 0; j < graph.getNodeCount(); j++){
				d[i][j] = rnd.nextDouble();
				q[i][j] = 0D;
			}
		}
		graph.getNodes().forEach(n -> n.setPressure(0D));
		var count = 1;
		var shouldStop = false;
		
		final var ns = graph.getNode(0).orElseThrow();
		final var ne = graph.getNode(6).orElseThrow();
		
		//Loop
		do{
			ne.setPressure(0);
			
			//TODO: Calculate pressure of every node
			
			for(var ni : graph.getNodes()){
				for(var nj : graph.getNodes()){
					if(!Objects.equals(ni, nj)){
						q[ni.getID()][nj.getID()] = (d[ni.getID()][nj.getID()] * (ni.getPressure() - nj.getPressure())) / (graph.getDistance(ni, nj));
					}
				}
			}
			for(var ni : graph.getNodes()){
				for(var nj : graph.getNodes()){
					if(!Objects.equals(ni, nj)){
						d[ni.getID()][nj.getID()] = (1 / 2D) * ((q[ni.getID()][nj.getID()] * (ni.getPressure() - nj.getPressure())) / (graph.getDistance(ni, nj) * (ns.getPressure() - ne.getPressure()))) + d[ni.getID()][nj.getID()];
					}
				}
			}
			
			count++;
			shouldStop = count > 10000;
		}
		while(!shouldStop);
	}
}
