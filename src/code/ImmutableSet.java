package code;

public class ImmutableSet {

	private final Node root;
	
	private static class Node {
		public final int value;
		public final Node next;

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}	
	
	
	public ImmutableSet(Node root) {
		this.root = root;
	}
	
	public ImmutableSet add(int value) {	
		return new ImmutableSet(new Node(value, root));
	}
	
}
