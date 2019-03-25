package fr.mrcraftcod.blob;

/**
 * Created by mrcraftcod (MrCraftCod - zerderr@gmail.com) on 2019-03-25.
 *
 * @author Thomas Couchoud
 * @since 2019-03-25
 */
public class Main{
	public static void main(String[] args){
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);

		final var graph = new Graph(n0, n1, n2,n3, n4, n5, ,6);
		graph.setUndirectionalDistance(1, 2, 0.5d);

	}
}
