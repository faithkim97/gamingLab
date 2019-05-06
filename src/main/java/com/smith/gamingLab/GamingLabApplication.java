package com.smith.gamingLab;
//import org.h2.tools.Server;
//import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class GamingLabApplication {
	public static void main(String[] args) {
		SpringApplication.run(GamingLabApplication.class, args);
	}
}
//public class GamingLabApplication {
//	public static void main(String[] args) {
//		try {
//			Server.createTcpServer().start();
//			SpringApplication.run(GamingLabApplication.class, args);
//		} catch(SQLException e) {
//			System.exit(-1);
//
//		}
//	}
//
//}

