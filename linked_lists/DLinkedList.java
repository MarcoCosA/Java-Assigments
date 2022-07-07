package linked_lists;

import java.util.AbstractList;

//Marco Costa
//03/20/22
//COMP 232

public class DLinkedList<E> extends AbstractList<E> {
	private DNode<E> head;
	private DNode<E> tail;
	private int size;

	public DLinkedList() {
		head = new DNode<E>();
		tail = head;
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
		if (tail.data == null) {
			tail.data = e;
		} else {
			DNode<E> node;

			int temp = index;
			if (temp > size / 2) {
				node = tail;
				while (temp++ < size) {
					node = node.prev;
				}
			} else {
				node = head;
				while (temp-- > size) {
					node = node.next;
				}
			}
			node.next = new DNode<E>(e, node, node.next);
			if (node.next.next != null)
				node.next.next.prev = node.next;
			if (node == tail) {
				tail = node.next;
			} else if (node == head && index == 0) {
				node.next.data = head.data;
				head.data = e;
			}
			node = null;
		}
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
		DNode<E> e = head;
		while (index > 0) {
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
		DNode<E> node = head;
		while (index > 0) {
			node = node.next;
			index--;
		}
		if (node == tail) {
			tail = node.prev;
		}
		if (node == head)
			head = node.next;

		DNode<E> temp = node;
		if (node.next != null)
			node.next.prev = node.prev;
		if (node.prev != null)
			node.prev.next = node.next;
		size--;
		return temp.data;
	}

	/*
	 * replace the contents at the given index with the data given return the data
	 * that was previously at that index if the index does not exist throw an
	 * IndexOutOfBoundsException
	 */
	public E set(int index, E element) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException(index);
		DNode<E> node = head;
		while (index > 0) {
			node = node.next;
			index--;
		}
		E e = node.data;
		node.data = element;
		return e;
	}

	public int size() {
		return size;
	}

	public String toString() {
		String s = "";
		DNode<E> node = head;
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
	class DNode<E> {
		E data;
		DNode<E> next;
		DNode<E> prev;

		public DNode() {
			this(null);
		}

		public DNode(E data) {
			this.data = data;
			next = null;
			prev = null;
		}

		public DNode(E data, DNode<E> prev, DNode<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

}