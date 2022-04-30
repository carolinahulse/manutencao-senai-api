package br.com.senai.manutencaosenaiapi;
import java.time.LocalDate;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.enums.Sexo;
import br.com.senai.manutencaosenaiapi.repository.PecasRepository;
import br.com.senai.manutencaosenaiapi.repository.TecnicosRepository;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.OrdemDeServicoService;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;
@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Autowired
	private TecnicoService service;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private OrdemDeServicoService ordemService;
	
	@Autowired
	private PecasRepository pecasRepository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private TecnicosRepository tecnicosRepository;
	
	@Transactional
	@Bean
	public CommandLineRunner comandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				Cliente novoCliente = new Cliente();
				novoCliente.setNome("Fernando");
				novoCliente.setSobrenome("Gomes");
				novoCliente.setDataDeNascimento(LocalDate.of(2000, 01, 01));
				novoCliente.setCpf("111.222.333-45");
				novoCliente.setSexo(Sexo.M);
				novoCliente.setEndereco("Rua Laguna");
				this.clienteService.inserir(novoCliente);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
}