package com.assimilate.javafeb.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.assimilate.javafeb.accessmodifires.Employee;

public class HashMapDemo {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();

		Map<Integer, String> map2 = new HashMap<>();
		map2.put(100, "One Hundred");

		// put
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(1, "One");

		System.out.println("size: " + map.size());

		System.out.println(map);
		// It doesent allow duplicate keys, it overwrites value for that key
		String value = map.get(3);
		System.out.println("3=> " + value);
		map.put(3, "THREE");
		value = map.get(3);
		System.out.println("3=> " + value);

		System.out.println("size: " + map.size());

		System.out.println("contains: " + map.containsKey(4));
		System.out.println("contains value: " + map.containsValue("Oneddgfd"));

		System.out.println("Map empty: " + map.isEmpty());
		map.putAll(map2);
		System.out.println("Map: " + map);
		System.out.println(map.remove(3));
		System.out.println("contains: " + map.containsKey(3));

		System.out.println("Values: " + map.values());
		System.out.println("Keys: " + map.keySet());

		Set<Integer> keys = map.keySet();
		System.out.println("Keys: " + keys);
		System.out.println("Map: " + map);
		
		for (Integer key : keys) {
			System.out.println("Map -> "+map.get(key));
		}

		Set<Entry<Integer, String>> entrySet = map.entrySet();

		System.out.println("Interating over hashmap using entry set");
		for (Map.Entry<Integer, String> entry : entrySet) {
//			System.out.println(entry);
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
		}

		Comparator<Employee> employeeComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getId() - o2.getId();
			}
		};

		Map<Employee, String> employeeMap = new TreeMap<Employee, String>(employeeComparator);

		employeeMap.put(new Employee(102, "John"), "Employee-1");
		employeeMap.put(new Employee(103, "Json"), "Employee-2");

		employeeMap.put(new Employee(100, "Jcob"), "Employee-3");
		employeeMap.put(new Employee(101, "Jcob"), "Employee-3");

//		System.out.println(employeeMap);

//		System.out.println("employeeMap size: "+employeeMap.size());
		// while inserting in the map, map checks whether that key is already present or
		// not.

		
//		Internal capacity : 16 (default)
		// Load factor 0.75 -> 75%
		// capacity will be doubled when your hashmpa entries reaches 75% of its capacity 
		
		// ConcurrentHashMap
	
		
		//thread safe map..
		// only one thred can access that map at one time.
		Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<String, String>());
		
		
//		ConcurrentHashMap
		// when you have fewer write operations your write operations, and you want synchronization as well.
	}
}
