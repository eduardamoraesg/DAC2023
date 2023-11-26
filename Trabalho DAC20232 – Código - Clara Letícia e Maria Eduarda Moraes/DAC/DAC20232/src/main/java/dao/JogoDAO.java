package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Jogo;
import util.JPAUtil;

import java.util.List;

public class JogoDAO {

    private EntityManager em;

    public JogoDAO() {
        em = JPAUtil.criarEntityManager();
    }

    public void salvar(Jogo jogo) {
        em.getTransaction().begin();
        em.persist(jogo);
        em.getTransaction().commit();
    }

    public void editar(Jogo jogo) {
        em.getTransaction().begin();
        em.merge(jogo);
        em.getTransaction().commit();
    }

    public void excluir(Jogo jogo) {
        em.getTransaction().begin();
        em.remove(em.merge(jogo));
        em.getTransaction().commit();
    }

    public List<Jogo> listar() {
        Query query = em.createQuery("SELECT j FROM Jogo j");
        return query.getResultList();
    }

	// public void listar(List<Jogo> jogos) {
		// TODO Auto-generated method stub
		//}
}