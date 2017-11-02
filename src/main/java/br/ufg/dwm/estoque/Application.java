package br.ufg.dwm.estoque;

import org.springframework.boot.SpringApplication;
//import org.springframework.web.client.RestTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		//RestTemplate restTemplate = new RestTemplate();
		//String result = restTemplate.getForObject("http://www.mocky.io/{t1}/{t2}", String.class, "v2", "59f280662f0000262a54283f");
		//System.out.println(result);
	}
}
 