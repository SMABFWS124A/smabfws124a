package code;

public class ImmutableSet {

	private final Node root;
	
	private static class Node {
		public final int value;
		public final Node next;
		public final boolean removed;

		Node(int value, Node next, boolean removed) {
			this.value = value;
			this.next = next;
			this.removed = removed;
		}
	}	
	
	
	public ImmutableSet(Node root) {
		this.root = root;
	}
	
	public ImmutableSet add(int value) {	
		return new ImmutableSet(new Node(value, root, false));
	}
	

	public ImmutableSet remove(int value){
		return new ImmutableSet(new Node(value, root, true)); 
	}
}
