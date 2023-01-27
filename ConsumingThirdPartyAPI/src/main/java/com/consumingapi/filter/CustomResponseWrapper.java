package com.consumingapi.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.util.FastByteArrayOutputStream;

public class CustomResponseWrapper extends HttpServletResponseWrapper {
	private final FastByteArrayOutputStream capture;
	private ServletOutputStream output;
	private PrintWriter writer;
	

	public CustomResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
		capture = new FastByteArrayOutputStream(response.getBufferSize());
	}
	
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		 if (writer != null) {
		        throw new IllegalStateException("getWriter() has already been called on this response.");
		    }
output=new ServletOutput(output);
//		    if (output == null) {
//		        // inner class - lets the wrapper manipulate the response 
//		        output = new ServletOutputStream() {
//		            @Override
//		            public void write(int b) throws IOException {
//		                capture.write(b);
//		            }
//
//		            @Override
//		            public void flush() throws IOException {
//		                capture.flush();
//		            }
//
//		            @Override
//		            public void close() throws IOException {
//		                capture.close();
//		            }
//
//		            @Override
//		            public boolean isReady() {
//		                return false;
//		            }
//
//		            @Override
//		            public void setWriteListener(WriteListener arg0) {
//		            }
//		        };
//		    }
		    return output;
	}
	
	
	@Override
	public PrintWriter getWriter() throws IOException {
		 if (output != null) {
		        throw new IllegalStateException("getOutputStream() has already been called on this response.");
		    }

		    if (writer == null) {
		        writer = new PrintWriter(new OutputStreamWriter(capture,
		                getCharacterEncoding()));
		    }

		    return writer;
	}
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		super.flushBuffer();
		if (writer != null) {
	        writer.flush();
	    } else if (output != null) {
	        output.flush();
	    }
	}
	public byte[] getCaptureAsBytes() throws IOException {
//	    if (writer != null) {
//	        writer.close();
//	    } else if (output != null) {
//	        output.close();
//	    }

	    return capture.toByteArray();
	}
	public int getContentSize() {
		return this.capture.size();
	}


	public String getCaptureAsString() throws IOException {
	    return new String(this.capture.toByteArray(), StandardCharsets.UTF_8);
	}
	
	
	
	
	
	/// Extended Class//////////////////////////////////////////////////////
	
	class ServletOutput extends ServletOutputStream{
ServletOutputStream outputStream;


public ServletOutput(ServletOutputStream outputStream) {
	this.outputStream=outputStream;
	// TODO Auto-generated constructor stub
}
		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return this.outputStream.isReady();
		}

		@Override
		public void setWriteListener(WriteListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void write(int b) throws IOException {
			capture.write(b);
		}
		
		@Override
				public void write(byte[] b, int off, int len) throws IOException {
					// TODO Auto-generated method stub
					capture.write(b, off, len);
				}
		@Override
				public void flush() throws IOException {
					// TODO Auto-generated method stub
					capture.flush();
				}
		
	}

}
