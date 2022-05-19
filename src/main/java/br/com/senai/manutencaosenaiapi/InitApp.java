package br.com.senai.manutencaosenaiapi;
import java.awt.EventQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.view.TelaCadastroDeTiposPeca;
import br.com.senai.manutencaosenaiapi.view.TelaConsultaDeTipoPeca;

@SpringBootApplication
public class InitApp {
	
	@Autowired
	private TelaConsultaDeTipoPeca telaDeConsulta;
	
	//@Autowired
	//private TelaCadastroDeTiposPeca telaDeCadastro;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
	}
	
	@Bean
	public CommandLineRunner comandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//telaDeCadastro.setVisible(true);
							telaDeConsulta.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
}