package net.ukr.andy777;

/*
 Lesson09add
 2. Напишите метод, который найдет в массиве целых чисел число, модуль которого ближе всего к 0.
 Если есть два таких числа (например 2 и -2), верните положительное.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		// наповнення списку елементами
		for (int i = 0; i < 10; i++)
			arr.add((int) (Math.random() * 20 - 10));
		System.out.println("оригінальний перелік:         \t" + arr);

		List<Integer> res = arr.stream()
				.sorted((n1, n2) -> Math.abs(n1) - Math.abs(n2))
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("сортований по модулю перелік: \t" + res);
		
		Optional<Integer> min =  arr.stream()
				.filter(n -> n != 0)
				.sorted((n1, n2) -> -n1 + n2)
				.collect(Collectors.minBy((n1,n2) -> Math.abs(n1)-Math.abs(n2)));
		System.out.println("мінімальний ненульовий елемент по модулю (позитивний з різнознакових):\t" + min.get());
	}
}
