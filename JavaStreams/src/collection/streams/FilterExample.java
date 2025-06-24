
package collection.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		ArrayList<Integer> numberList = new ArrayList<>();
		numberList.add(100);		
		numberList.add(600);
		numberList.add(300);
		numberList.add(200);*/
		
		List<Integer> numberList = Arrays.asList(10,31,54,25,78,89,1000,777,111,90,999,2000,5555);
		
		List<String> namesList = Arrays.asList("java","python","C","Cpp",".net");		
		
		//numberList.stream().forEach(System.out::println);
		
		numberList.stream().forEach(num->System.out.print(num+".."));			
		
		System.out.println("\n==============================");
		
		List<Integer> evenNumberList =  numberList.stream().filter(number-> number%2!=0).collect(Collectors.toList());
		
		evenNumberList.stream().forEach(System.out::println);		
		
		
		/*System.out.println("\n================");
		for(Integer number: numberList) {
			 
			 System.out.print(number+"... ");
		 }*/
		
		
		
	}

}
