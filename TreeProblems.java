/*
 * *** Nick Cwikla / COMP 272-001 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */
  
  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
    // New tree set to store the results of set A.
    TreeSet<Integer> result = new TreeSet<>(setA);
    // Add elements of set B to the result of elements in set A.
    result.addAll(setB);
    // Create a second tree set to find where set A and B meet.
    TreeSet<Integer> meetingPoint = new TreeSet<>(setA);
    // Retain the elements that are commonly found in both sets.
    meetingPoint.retainAll(setB);
    // Remove all the elements that are in the meeting point.
    result.removeAll(meetingPoint);
   // Return result.
    return result;
  }


  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

  public static void removeEven(Map<Integer, String> treeMap) {
    // Iterator needs to be created to iterate through the keys of the tree map.
    Iterator<Integer> iterator = treeMap.keySet().iterator();
    // Go through the keys.
    while (iterator.hasNext()) {
      Integer key = iterator.next();
      // When the key is even, remove the entry.
      if (key % 2 == 0) {
        // Remove during iteration.
        iterator.remove();
      }
    }
  }


  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {
    // Compare both map sizes to see if they are the same.
    if (tree1.size() != tree2.size()) {
      return false;
    }
    // Iterate through tree1 and compare that with the entries in tree2.
    for (Map.Entry<Integer, String> entry : tree1.entrySet()) {
      // Use the key and the value from tree1
      Integer key = entry.getKey();
      String value = entry.getValue();

      // Make sure tree2 has the key and if it does the value is the same.
      if (!tree2.containsKey(key) || !tree2.get(key).equals(value)) {
        // False returned because of both maps not being equal.
        return false;
      }
    }
    // No mismatches are found so return that maps are equal.
    return true;

  }

} // end treeProblems class
