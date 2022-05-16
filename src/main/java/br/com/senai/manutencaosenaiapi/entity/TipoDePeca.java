package br.com.senai.manutencaosenaiapi.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "TipoDePeca")
@Table(name = "tipoDePeca")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoDePeca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "descricao")
	@NotEmpty(message = "A descrição é obrigatória")
	@Size(max = 200, message = "A descrição deve conter no máximo 200 caracteres")
	private String descricao;
}