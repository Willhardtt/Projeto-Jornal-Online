package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import modelo.CursoHibernate;

public class DaoCursoHibernate {
	private SessionFactory fabrica;

	public DaoCursoHibernate() throws Exception {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure("hibernate.cfg.xml");
		fabrica = configuration.buildSessionFactory();
	}

	public void incluir(CursoHibernate e) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(e); // comando de incluir no bd
		transacao.commit();
		sessao.close();
	}

	public void alterar(CursoHibernate e) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(e); // comando de alterar no bd
		transacao.commit();
		sessao.close();
	}

	public void excluir(CursoHibernate e) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(e); // comado de excluir
		transacao.commit();
		sessao.close();
	}

	public CursoHibernate consultar(int idCurso) throws Exception {
		CursoHibernate ev = null;
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query consulta = sessao.createQuery("from CursoHibernate where idCurso= :parametro");
		consulta.setInteger("parametro", idCurso);
		ev = (CursoHibernate) consulta.uniqueResult(); // comando de consultar
		transacao.commit();
		sessao.close();
		return ev;
	}
	
	public CursoHibernate consultarPorCurso(String nomeCurso) throws Exception{
    	CursoHibernate ev = null;
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	Query consulta = sessao.createQuery("from  CursoHibernate where nome= :parametro");
    	consulta.setString("parametro", nomeCurso);
    	ev = (CursoHibernate) consulta.uniqueResult(); // comando de consultar
    	transacao.commit();
    	sessao.close();
    	return ev;
    }

	public List<CursoHibernate> listarPorCurso(String nomeCurso) throws Exception {
		Session session = fabrica.openSession();
		Transaction t = session.beginTransaction();
		Query consulta = session.createQuery("from CursoHibernate where nomeCurso = :parametro");
		consulta.setString("parametro", nomeCurso);
		List<CursoHibernate> lista = consulta.list();
		t.commit();
		return lista;
	}

	public List<CursoHibernate> listar() {
		Session session = fabrica.openSession();
		Transaction t = session.beginTransaction();
		List<CursoHibernate> lista = session.createQuery("from CursoHibernate").list();
		t.commit();
		return lista;
	}

}
