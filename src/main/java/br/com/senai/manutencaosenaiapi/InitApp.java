package br.com.senai.manutencaosenaiapi;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.repository.PecasRepository;
@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Autowired
	private PecasRepository pecasRepository;
	
	@Bean
	public CommandLineRunner comandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				/*Peca novaPeca = new Peca();
				novaPeca.setDescricao("Placa Mãe Gigabyte");
				novaPeca.setEspecificacoes("Boa placa");
				novaPeca.setQtdEmEstoque(10);
				Peca pecaSalva = this.pecasRepository.save(novaPeca);
				System.out.println("Id da peça: "+pecaSalva.getId());*/
				
				Optional<Peca> pecaEncontrada = pecasRepository.findById(2);
				pecaEncontrada.get().setEspecificacoes("Não é boa");
				
				Peca pecaAlterada = pecasRepository.save(pecaEncontrada.get());
				System.out.println(pecaAlterada);
				System.out.println("Peça encontrada: "+pecaEncontrada.get());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
}