package com.mayank.spring.serviceImpl;

import org.springframework.stereotype.Service;

import com.mayank.spring.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

	public String display() {
		// TODO Auto-generated method stub
		return "This is the text returned from the method -- Mayank here";
	}

}
