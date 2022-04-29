package br.com.senai.manutencaosenaiapi.service;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.repository.PecasRepository;

@Service
@Validated
public class PecaService {
	
	@Autowired
	private PecasRepository repository;
	
	public Peca inserir(
			@Valid
			@NotNull(message = "A peça não pode ser nula")
			Peca novaPeca) {
		Peca pecaSalva = repository.save(novaPeca);
		return pecaSalva;
	}
	
	public Peca alterar(
			@Valid
			@NotNull(message = "A peça não pode ser nula")
			Peca pecaSalva) {
		Peca pecaAtualizada = repository.save(pecaSalva);
		return pecaAtualizada;
	}
	
	public List<Peca> listarPor(
			@NotEmpty(message = "A descrição da busca é obrigatória")
			@NotBlank(message = "A descrição não pode conter espaço vazio")
			String descricao) {
		return new ArrayList<Peca>();
	}	
}