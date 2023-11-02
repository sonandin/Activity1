package com.microservice.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService{

	@Override
	public String isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return s + " is Not a Palindrome";
			i++;
			j--;
		}
		return s + " is a Palindrome";
	}
}
