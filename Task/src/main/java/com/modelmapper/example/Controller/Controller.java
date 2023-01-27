package com.modelmapper.example.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

//	@Value("${app.title}")
//	  private String appTitle;
	
	@Autowired
	Environment environment;
	
//	@PostMapping(value = "posting")
//	public String get(@RequestParam String url,@RequestBody Map<Object, Object> map) {
//		System.setProperty("key", url);
//		
//		System.out.println(environment.getProperty("key"));
//		return url;
//		
//	}
	
	@PostMapping(value = "posting")
	public String get(@RequestParam String url,@RequestBody Map<Object, Object> map) throws IOException {
//		File path=new ClassPathResource("src/main/resources/application.properties").getFile();
//		String data=new String(Files.readAllBytes(path.toPath()));
//		System.out.println(data);
	
		
//		
//		try 
//		{
//		    RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Mahesh.Gummula\\spring-workspace\\Task\\src\\main\\resources\\application.properties", "rw");
//		    long length = raf.length();
//		    System.out.println(length);
//		    raf.setLength(length + 1); //+ (integer value) for spacing
//		    raf.seek(raf.length());
//		    raf.writeBytes("111111111");
//		    raf.close();
//		} 
//		catch (Exception e) {
//		    System.out.println(e);
//		}
		
//		 PrintWriter out = new PrintWriter(new FileOutputStream("C:\\Users\\Mahesh.Gummula\\spring-workspace\\Task\\src\\main\\resources\\application.properties",true));
//		    out.append("########## ");
//		    out.close();
		
//		
//		FileInputStream inputStream=new FileInputStream("C:\\Users\\Mahesh.Gummula\\spring-workspace\\Task\\src\\main\\resources\\application.properties");
		FileOutputStream fOut = new FileOutputStream("C:\\Users\\Mahesh.Gummula\\spring-workspace\\Task\\src\\main\\resources\\application.properties", true);
//		OutputStreamWriter osw = new OutputStreamWriter(fOut);
		 Properties prop = new Properties();
		    prop.setProperty("Compan", map.get("name").toString());
		    prop.setProperty("email", "mahesh.gummula@Teknopoint.in");
//		    prop.load(inputStream);
		prop.store(fOut, "myInfo");
//		osw.write("000000000000000000");
//        p.store(prop, osw, "header");
		
//		osw.close();
		System.out.println("done");
		
		
		
		
		
//		 try{
//			  FileWriter fstream = new FileWriter(path,true);
//			  BufferedWriter out = new BufferedWriter(fstream);
//			  out.append(map.toString());
//			  out.append("hoo");
//			  out.close();
//			  fstream.close();
//			  System.out.println("done");
//		  }catch (Exception e){
//			 System.err.println("Error while writing to file: " +
//		          e.getMessage());
//		  }
		
		
		
		
		
		
		
		
		
		
//		OutputStream os = null;
//	    Properties prop = new Properties();
//	    prop.setProperty("na", "java2novice");
//	    prop.setProperty("domain", "lllllllllllllllll");
//	    prop.setProperty("email", "555555555555");
////	    System.out.println(path.getAbsolutePath());
//	    String pathh=path.getPath();
//	    System.out.println(pathh);
//	    try {
//	        os = new FileOutputStream("C:/Users/Mahesh.Gummula/spring-workspace/Task/target/classes/application.properties");
//	        //C:\Users\Mahesh.Gummula\spring-workspace\Task\src\main\resources
//	        prop.store(os, "Dynamic Property File");
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return url;
		
	}
	
	//path.getAbsolutePath gives you the path of target folders application propertie 
	
	
     
}
//	
//	
//	@PostConstruct
//	  public void startApplication() {
//		System.setProperty("appTitle", "kjklj");
//		
//		System.out.println(environment.getProperty("appTitle"));
////	      System.out.printf("-- running application: %s --%n", appTitle);
////
//	  }

