package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		String jpql = "select m from Movimentacao m join m.categoria c where c= :pCategoria";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao mov : resultados){
			System.out.println("Movimentacao: "+mov.getDescricao());
			System.out.println("Conta.id: "+mov.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
