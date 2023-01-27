package com.consumingapi.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

public class ReaderClass extends HttpServletRequestWrapper {
	
	private byte[] body;
	 ServletInput servletInput;
	
	 public ReaderClass(HttpServletRequest request) throws IOException {
		 super(request);
		 this.body = StreamUtils.copyToByteArray(request.getInputStream());
	}

	 @Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return new ServletInput(this.body);
	}
	 public void resetInputStream(byte[] newdata) {
		body=newdata;
		servletInput=new ServletInput(newdata);
		servletInput.inputStream= new ByteArrayInputStream(newdata);
	 }

//	public ReaderClass(HttpServletRequest request) throws IOException  {
//		super(request);
//		 StringBuilder stringBuilder = new StringBuilder();
//		    BufferedReader bufferedReader = null;
//		    try {
//		      InputStream inputStream = request.getInputStream();
//		      if (inputStream != null) {
//		        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//		        char[] charBuffer = new char[128];
//		        int bytesRead = -1;
//		        while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
//		          stringBuilder.append(charBuffer, 0, bytesRead);
//		        }
//		      } else {
//		        stringBuilder.append("");
//		      }
//		    } catch (IOException ex) {
//		      throw ex;
//		    } finally {
//		      if (bufferedReader != null) {
//		        try {
//		          bufferedReader.close();
//		        } catch (IOException ex) {
//		          throw ex;
//		        }
//		      }
//		    }
//		    //Store request pody content in 'body' variable 
//		    body = stringBuilder.toString();
//	}
//	
//	@Override
//	public ServletInputStream getInputStream() throws IOException {
//		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
//	    ServletInputStream servletInputStream = new ServletInputStream() {
//	    	
//	      public int read() throws IOException {
//	        return byteArrayInputStream.read();
//	      }
//
//		@Override
//		public boolean isFinished() {
//			return false;
//		}
//
//		@Override
//		public boolean isReady() {
//			return false;
//		}
//
//		@Override
//		public void setReadListener(ReadListener listener) {
//		}
//	    };
//		return servletInputStream;
//	}
	@Override
	public BufferedReader getReader() throws IOException {
		 return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}
//
	public String getBody() {
		String data = new String(this.body,StandardCharsets.UTF_8);
	return data;
	}
}