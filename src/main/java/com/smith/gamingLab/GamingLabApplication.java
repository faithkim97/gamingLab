package com.smith.gamingLab;
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

//public class GamingLabApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		System.err.println("WATS UP");
//		startH2Server();
//		SpringApplication.run(GamingLabApplication.class, args);
//	}
//
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		startH2Server();
//		return application.sources(GamingLabApplication.class);
//	}
//
//	private static void startH2Server() {
//		try {
////			"-tcpAllowOthers","-webAllowOthers"
//			Server h2Server = Server.createTcpServer("-webAllowOthers","-tcpAllowOthers").start();
//			System.out.println(h2Server);
//		} catch (SQLException e) {
//			throw new RuntimeException("Failed to start H2 server: ", e);
//		}
//	}


//}

