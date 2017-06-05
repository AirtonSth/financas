package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Airton");
		conta.setBanco("Caixa");
		conta.setAgencia("9876");
		conta.setNumero("123");
		
		EntityManager em = new JPAUtil().getEntityManager();
		conta = em.find(Conta.class, 1);
		
		em.getTransaction().begin();
		em.remove(conta);
		em.getTransaction().commit();
		em.close();
		
	}
}
