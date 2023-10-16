package com.microservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {

	@Override
	public List<Integer> getFibonacci(int limit) {
		List<Integer> fibList = new ArrayList<>();
		for (int i = 0; i < limit; i++) {
			fibList.add(findFib(i));
		}
		return fibList;
	}

	public static int findFib(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		return findFib(n - 1) + findFib(n - 2);
	}

}
