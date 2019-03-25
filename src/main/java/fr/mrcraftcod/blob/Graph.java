package fr.mrcraftcod.blob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by mrcraftcod (MrCraftCod - zerderr@gmail.com) on 2019-03-25.
 *
 * @author Thomas Couchoud
 * @since 2019-03-25
 */
public class Graph{

	private List<Node> nodes;
	private double dist[][];

	private static final Logger LOGGER = LoggerFactory.getLogger(Graph.class);

	public Graph(Node... nodes) {
		this.nodes = new ArrayList<>();
		this.nodes.addAll(Arrays.asList(nodes));
		this.dist = new double[nodes.length][nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				this.dist[i][j] = -1;
			}
		}
	}
	public Graph(int size) {
		super((Node[])IntStream.range(0, size).mapToObj(i->new Node(i)).toArray());
	}


	public void setDistance(Node i, Node j, double dist) {
		this.dist[i.getID()][j.getID()] = dist;
	}

	public void setUndirectionalDistance(Node i, Node j, double dist) {
		setDistance(i, j, dist);
		setDistance(j, i , dist);
	}

	public double getDistance(Node i, Node j)
	{
		return this.dist[i.getID()][j.getID()];
	}
	
	public Collection<Node> getNodes()
	{
		return nodes;
	}
	
	public static Graph parseFromPath(Path path)
	{
		try
		{
			final var lines = Files.readAllLines(path);
		}
		catch(IOException e){
			LOGGER.error("Error reading file", e);
		}
		return null;
	}
}
