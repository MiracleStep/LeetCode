package mirac.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph<V,E> {
	private Map<V, E> vertices = new HashMap<>();
	
	private static class Vertex<V, E>{
		V value;

		public Vertex(V value) {
			super();
			this.value = value;
		}
	}
	
	public void addVertex(V v) {
		if(vertices.containsKey(v))return;
		vertices.put(v, new Vertex<>(v));
	}
}
