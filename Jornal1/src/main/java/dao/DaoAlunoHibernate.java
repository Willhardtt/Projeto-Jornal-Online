package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import modelo.AlunoHibernate;

public class DaoAlunoHibernate {
	private SessionFactory fabrica;

	public DaoAlunoHibernate() throws Exception {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure("hibernate.cfg.xml");
		fabrica = configuration.buildSessionFactory();
	}

	public void incluir(AlunoHibernate e) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(e); // comando de incluir no bd
		transacao.commit();
		sessao.close();
	}

	public void alterar(AlunoHibernate e) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(e); // comando de alterar no bd
		transacao.commit();
		sessao.close();
	}

	public void excluir(AlunoHibernate e) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(e); // comado de excluir
		transacao.commit();
		sessao.close();
	}
	
	public AlunoHibernate consultar(int idAluno) throws Exception {
		AlunoHibernate ev = null;
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		Query consulta = sessao.createQuery("from AlunoHibernate where idAluno= :parametro");
		consulta.setInteger("parametro", idAluno);
		ev = (AlunoHibernate) consulta.uniqueResult(); // comando de consultar
		transacao.commit();
		sessao.close();
		return ev;
	}
	
	public AlunoHibernate consultarPorAluno(String nome) throws Exception{
    	AlunoHibernate ev = null;
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	Query consulta = sessao.createQuery("from  AlunoHibernate where idAluno= :parametro");
    	consulta.setString("parametro", nome);
    	ev = (AlunoHibernate) consulta.uniqueResult(); // comando de consultar
    	transacao.commit();
    	sessao.close();
    	return ev;
    }

	public List<AlunoHibernate> listarPorAluno(String nome) throws Exception {
		Session session = fabrica.openSession();
		Transaction t = session.beginTransaction();
		Query consulta = session.createQuery("from AlunoHibernate where idAluno = :parametro");
		consulta.setString("parametro", nome);
		List<AlunoHibernate> lista = consulta.list();
		t.commit();
		return lista;
	}

	public List<AlunoHibernate> listar() {
		Session session = fabrica.openSession();
		Transaction t = session.beginTransaction();
		List<AlunoHibernate> lista = session.createQuery("from AlunoHibernate").list();
		t.commit();
		return lista;
	}

}
