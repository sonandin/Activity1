package com.microservice.service;

import org.springframework.stereotype.Service;

@Service
public class AddSubServiceImpl implements AddSubService {

	@Override
	public int add(int a, int b) {
		if (a <= 0 || b <= 0)
			throw new IllegalArgumentException("Numbers should be positive");
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		if (a <= 0 || b <= 0)
			throw new IllegalArgumentException("Numbers should be positive");
		return a - b;
	}

}
