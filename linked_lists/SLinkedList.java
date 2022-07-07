package linked_lists;

import java.util.AbstractList;

//Marco Costa
//03/20/22
//COMP 232

public class SLinkedList<E> extends AbstractList<E> {

	private SNode<E> head;
	private int size;

	public SLinkedList() {
		head = new SNode<E>();
		size = 0;
	}

	/* appends element to end of the list */
	public boolean add(E e) {
		add(size, e);
		return false;
	}

	/*
	 * insert element at the given index if the index is out of bounds throw an
	 * IndexOutOfBoundsException
	 */
	public void add(int index, E e) {
		if (index > size)
			throw new IndexOutOfBoundsException(index);
		SNode<E> node = head;
		while (index-- > 0) {
			node = node.next;
		}
		node.next = new SNode<E>(e, node.next);
		size++;
	}

	public void clear() {
		head.next = null;
	}

	/*
	 * get the data from the node at the given index if the index does not exist
	 * throw an IndexOutOfBoundsException
	 */
	public E get(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException(index);
		SNode<E> e = head;
		while (index >= 0) {
			e = e.next;
			index--;
		}
		return e.data;
	}

	/*
	 * remove the node at the given index from the list and return its data if the
	 * index does not exist throw an IndexOutOfBoundsException
	 */
	public E remove(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException(index);
		SNode<E> node = head;
		while (index > 0) {
			node = node.next;
			index--;
		}
		SNode<E> nodeToDelete = node.next;
		node.next = nodeToDelete.next;
		size--;
		return nodeToDelete.data;
	}

	/*
	 * replace the contents at the given index with the data given return the data
	 * that was previously at that index if the index does not exist throw an
	 * IndexOutOfBoundsException
	 */
	public E set(int index, E element) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException(index);
		SNode<E> node = head;
		while (index > 0) {
			node = node.next;
			index--;
		}
		E e = node.next.data;
		node.next.data = element;
		return e;
	}

	public int size() {
		return size;
	}

	public String toString() {
		String s = "";
		SNode<E> node = head.next;
		for (int i = 0; i < size; i++) {
			s += node.data;
			if (node.next != null) {
				s += ", ";
			}
			node = node.next;
		}
		return s;
	}

	// internal class for single linking nodes
	class SNode<E> {
		E data;
		SNode<E> next;

		public SNode() {
			data = null;
			next = null;
		}

		public SNode(E data) {
			this.data = data;
			next = null;
		}

		public SNode(E data, SNode<E> next) {
			this.data = data;
			this.next = next;
		}
	}

}