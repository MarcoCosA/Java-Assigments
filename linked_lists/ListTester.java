package linked_lists;

import java.util.ArrayList;
import java.util.List;

public class ListTester {
	public static void main(String[] args) {
		System.out.println("Testing singly linked list...");
		SLinkedList<Integer> numList = new SLinkedList<>();
		testListWithIntegers(numList);

		SLinkedList<String> wordList = new SLinkedList<>();
		testListWithStrings(wordList);
		System.out.println("...end of single link tests");

		System.out.println();

		System.out.println("Testing doubly linked list...");
		DLinkedList<Integer> numList2 = new DLinkedList<>();
		testListWithIntegers(numList2);

		DLinkedList<String> wordList2 = new DLinkedList<>();
		testListWithStrings(wordList2);
		System.out.println("...end of double link tests");

	}

	public static void testListWithIntegers(List<Integer> numList) {
		numList.add(12);
		numList.add(3);
		numList.add(0, 15);

		try {
			numList.add(5, 45);
			System.out.println("ERROR - exception missed");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Correctly caught add out of bounds exception");
		}

		numList.add(2, 36);
		System.out.println(numList);
		System.out.println("Expected list: 15, 12, 3, 36");

		int element1 = numList.set(1, 84);
		if (element1 != 12) {
			System.out.println("Error - Unexpected element replaced");
		}

		System.out.println(numList);
		System.out.println("Expected list: 15, 84, 3, 36");

		System.out.println();
	}

	public static void testListWithStrings(List<String> wordList) {
//System.out.println("ADDING HOUSE");
		wordList.add("house");
//		System.out.println("ADDING WINDOW");
		wordList.add("window");
//		System.out.println("ADDING DOOR");
		wordList.add("door");
//		wordList.add("door4");
		wordList.add(1, "roof");

		if (wordList.size() != 4) {
			System.out.println("ERROR - incorrect size");
		}

		System.out.println(wordList);
		System.out.println("Expected list: house, roof, window, door");
//
		String test = wordList.get(2);
		if (!test.equals("window")) {
			System.out.println("Error - Unexpected element at index 2");
		}
//		// test to make sure element was not removed after get
		System.out.println(wordList);
		System.out.println("Expected list: house, roof, window, door");

		wordList.add("room");
		wordList.add("closet");
//
		wordList.remove(0);
		System.out.println(wordList);
		System.out.println("Expected list: roof, window, door, room, closet");
//
		wordList.remove(3);
		System.out.println(wordList);
		System.out.println("Expected list: roof, window, door, closet");
//
		try {
			wordList.remove(12);
			System.out.println("Error - out of IndexOutOfBoundsException not thrown");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception correctly caught");
		}
	}
}