package fr.mrcraftcod.blob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

/**
 * Created by mrcraftcod (MrCraftCod - zerderr@gmail.com) on 2019-03-25.
 *
 * @author Thomas Couchoud
 * @since 2019-03-25
 */
public class Graph{
	private static final Logger LOGGER = LoggerFactory.getLogger(Graph.class);
	public double getDistance(Node i, Node j)
	{
		return 0; //TODO
	}
	
	public Collection<Node> getNodes()
	{
		return null; //TODO
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
		return null; //TODO
	}
}
