package br.com.senai.manutencaosenaiapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
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
	
	@Bean
	public CommandLineRunner comandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				/*Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("Josevildo Soares");
				LocalDate dataDeAdmissao = LocalDate.of(2022, 4, 7);
				novoTecnico.setDataDeAdmissao(dataDeAdmissao);
				this.service.inserir(novoTecnico);*/
				
				/*Tecnico tecnicoSalvo = new Tecnico();
				tecnicoSalvo.setId(1);
				tecnicoSalvo.setNomeCompleto("Joanecleidson");
				tecnicoSalvo.setDataDeAdmissao(LocalDate.now());
				this.service.alterar(tecnicoSalvo);
				System.out.println("Técnico salvo com sucesso");*/
				
				/*this.service.listarPor("Carlos Eduardo");
				this.service.removerPor(0);*/
				
				/*Cliente novoCliente = new Cliente();
				novoCliente.setNome("João");
				novoCliente.setSobrenome("da Silva");
				novoCliente.setCpf("113.586.329-60");
				novoCliente.setSexo(Sexo.MASCULINO);
				novoCliente.setEndereco("Rua das Couves");
				novoCliente.setDataDeNascimento(LocalDate.of(2018, 9, 14));
				this.clienteService.inserir(novoCliente);
				System.out.println("Cliente salvo com sucesso");*/
				
				Peca novaPeca = new Peca();
				novaPeca.setDescricao("Teclado");
				novaPeca.setQtdEmEstoque(10);
				System.out.println(novaPeca);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
}