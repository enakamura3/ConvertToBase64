package org.naka.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Base64Utils;
import org.springframework.util.StreamUtils;

@SpringBootApplication
public class ConvertToBase64 {

    public static void main(String[] args) {
	SpringApplication.run(ConvertToBase64.class, args);
//	SpringApplication sa = new SpringApplication(ConvertToBase64.class);
//	sa.setBannerMode(Banner.Mode.OFF);
//	sa.run(args);
	try {
	    String filePath = args[0];
	    execute(filePath);
	}catch (Exception e) {
	    System.out.println("Enter a valid file path!");
	}

	
    }

    public static void execute(String filePath) {
	Path path = Paths.get(filePath);
	try (InputStream is = new FileInputStream(path.toFile());) {
	    String base64File = Base64Utils.encodeToString(StreamUtils.copyToByteArray(is));
	    System.out.println(String.format("Encoded file to base 64: %s", base64File));
	} catch (Exception e) {
	    System.out.println(String.format("Errou: %s", e.getMessage()));
	}
    }
}
