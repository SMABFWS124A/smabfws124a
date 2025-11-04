package code;

import java.util.Iterator;

public class ImmutableSet implements Iterable<Integer>{

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

    public ImmutableSet() {
		this(null);
	}
	
	public ImmutableSet add(int value) {	
		return new ImmutableSet(new Node(value, root, false));
	}
	

	public ImmutableSet remove(int value){
		return new ImmutableSet(new Node(value, root, true)); 
	}

    public boolean contains(int value){
        Node current = root;
        while(current != null){
            if(current.value == value){
                return !current.removed;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ImmutableSet set = new ImmutableSet();
        System.out.println(set.contains(5));
        set = set.add(5).add(6).add(0).remove(6);
        System.out.println(set.contains(5));
        System.out.println(set.contains(6));
        System.out.println(set.contains(0));
        System.out.println(set.contains(7));
        for(int value:set){
            System.out.println(value);
        }
    }

    private static class ImmutableSetIterator implements Iterator<Integer>{

        private ImmutableSet visited;
        private Node current;

        public ImmutableSetIterator(ImmutableSet immutableSet) {
            visited = new ImmutableSet();
            current = immutableSet.root;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
        }

        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new ImmutableSetIterator(this);
    }
}
