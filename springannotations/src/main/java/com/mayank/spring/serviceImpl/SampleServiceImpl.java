package com.mayank.spring.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mayank.spring.model.Emp;
import com.mayank.spring.repo.TestRepository;
import com.mayank.spring.service.SampleService;

@Service
@Transactional	
public class SampleServiceImpl implements SampleService{

	@Inject
	private TestRepository testRepository;
	
	public String display() {
		// TODO Auto-generated method stub
		Emp e = new Emp();
		e.setId(20);
		e.setName("mayank");
		testRepository.save(e);
		
		return "This is the text returned from the method -- Mayank here";
	}

	public void FileReader() throws IOException{
		
		FileOutputStream fout = null;
		int flag =1;
		   try{  
		     fout = new FileOutputStream("");  
		     String s = "Sachin Tendulkar is my favourite player";  
		     byte b[] = s.getBytes();//converting string into byte array  
			 fout.write(b);  
		     System.out.println("success...");  
		    }
		   catch(Exception e)
		   {
			   System.out.println("file not fnd");
			   flag=2;
		   }  
		   finally
		   {
				System.out.println(flag);

					fout.close();
		   }
	}
	
	
	
}
