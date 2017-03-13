package by.krukouski.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner {
	
	public static void main(String[] args){
		
		/*List<String> mList = Arrays.asList("aa1", "cc2", "cc1", "aa2", "bb1");
		
		mList
			.stream()
			.filter(s -> s.startsWith("a"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);*/
		/*Arrays.asList("cc2", "cc1", "cc3")
			.stream()
			.findFirst()
			.ifPresent(System.out::println);*/
		
		/*Stream.of("cc1", "cc2", "cc3")
			.findFirst()
			.ifPresent(System.out::println);*/
		
		/*IntStream.range(8, 12)
			.forEach(System.out::println);*/
		
		/*Stream.of("c1", "c2", "c3")
			.map(s -> s.substring(1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(System.out::println);*/
			
		
		/*Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
			.filter(s -> {
				System.out.println("Filter: " + s);
				return true;
			})
			.forEach(s -> System.out.println("Print from forEach: " + s));*/
		
		/*Stream.of("dd2", "aa2", "bb3", "bb1", "cc1")
			.map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
			.anyMatch(s -> {
				System.out.println("anyMatch: " + s);
				return s.startsWith("A");
			});*/
		
		 Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
		 	.filter(s -> {
		 		System.out.println("filter: " + s);
		 		return s.startsWith("a");
		 	})		
		 	.sorted((s1, s2) -> {
		 		System.out.printf("sort: %s; %s\n", s1, s2);
		 		return s1.compareTo(s2);
		 	})
		 	.map(s -> {
		 		System.out.println("map: " + s);
		 		return s.toUpperCase();
		 	})
		 	.forEach(s -> System.out.println("forEach: " + s));
			
		
		
		
		
	}
	

}
