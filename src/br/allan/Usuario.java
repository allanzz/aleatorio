package br.allan;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Comparable<Usuario>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private BigDecimal saldo;
	public Usuario(){}
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public Usuario(String nome,BigDecimal saldo)
	{
		this.nome = nome;
		this.saldo= saldo;
		
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", saldo=" + saldo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}	
	public int compareTo(Usuario outroUsuario)
	{
		return this.saldo.compareTo(outroUsuario.getSaldo());
	}	
}
