package com.mayank.spring.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.mayank.spring.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

	public String display() {
		// TODO Auto-generated method stub
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
