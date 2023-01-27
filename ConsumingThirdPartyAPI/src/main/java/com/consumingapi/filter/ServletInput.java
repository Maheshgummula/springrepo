package com.consumingapi.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ReadListener;

public class ServletInput extends javax.servlet.ServletInputStream{

     InputStream inputStream; 
    
	public  ServletInput(byte[] body) {
        this.inputStream = new ByteArrayInputStream(body);
        
    }
     

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		try {
            
            return inputStream.available() == 0;
             
        }catch(Exception e) {
             
            return false;
        }
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setReadListener(ReadListener listener) {
	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return this.inputStream.read();
	}

}
