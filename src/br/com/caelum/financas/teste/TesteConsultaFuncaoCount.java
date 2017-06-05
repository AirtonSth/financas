package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 2);
		Query query = em.createQuery("select count(m) from Movimentacao m where m.conta= :pConta");
		query.setParameter("pConta", conta);
		Long totalMov = (Long) query.getSingleResult();
		System.out.println("Total Movimentações: "+totalMov);
		
		em.getTransaction().commit();
		em.close();

	}

}
