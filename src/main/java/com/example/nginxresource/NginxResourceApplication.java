package com.example.nginxresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;

@SpringBootApplication
public class NginxResourceApplication {

	public static void main(String[] args) throws IOException {
		startNginx();
		SpringApplication.run(NginxResourceApplication.class, args);
	}

	private static void startNginx() throws IOException {
		String nginx_home="G:\\apr\\nginx-resource\\server\\nginx-1.13.7";
		ProcessBuilder builder =new ProcessBuilder().directory(Paths.get(nginx_home).toFile());
		builder.command("cmd","/c","start.bat");
		builder.inheritIO();
		builder.start();
	}
}
