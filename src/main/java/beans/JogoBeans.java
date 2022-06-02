package beans;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.DateTimeAtCompleted;

import dao.JogoDao;
import entities.Jogo;

@ManagedBean
public class JogoBeans {

	private Jogo jogo = new Jogo();
	private JogoDao jogoDao = new JogoDao();
	private List<Jogo> listaJogo ;
	private List <Jogo> paresLista;
	private ArrayList<Integer> num = new ArrayList();

	public String salvar() {
		GerarNumero();
		JogoDao.salvar(jogo);
		jogo = new Jogo();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item cadastrado com sucesso!"));
		return null;
	}

	public String listar() {
		listaJogo = JogoDao.listar();
		return "listaJogo";
	}

	public void editar() {
		JogoDao.editar(jogo);
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item editado com sucesso!"));
		 		}

	public void Excluir() {

		JogoDao.remover(jogo);
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item removido com sucesso!"));
		}

 public void GerarNumero() {
     Date data = new Date();
	 Random rd = new Random();
	 		jogo.setV1(rd.nextInt(30) + 1);
			jogo.setV2(rd.nextInt(30) + 1);
			jogo.setV3(rd.nextInt(30) + 1);
			jogo.setV4(rd.nextInt(30) + 1);
			jogo.setV5(rd.nextInt(30) + 1);
			jogo.setV6(rd.nextInt(30) + 1);
			jogo.setV7(rd.nextInt(30) + 1);
			jogo.setV8(rd.nextInt(30) + 1);
			jogo.setV9(rd.nextInt(30) + 1);
			jogo.setV10(rd.nextInt(30) + 1);
			
			jogo.setDataCriacao(data);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Numeros gerados!"));

	}
 
 public String listarNumerosPares() {
	 
	   paresLista = JogoDao.listar();
				
		for(Jogo jogo : paresLista)
		{
			int v1 = jogo.getV1();
			int v2 = jogo.getV2();
			int v3 = jogo.getV3();
			int v4 = jogo.getV4();
			int v5 = jogo.getV5();
			int v6 = jogo.getV6();
			int v7 = jogo.getV7();
			int v8 = jogo.getV8();
			int v9 = jogo.getV9();
			int v10 = jogo.getV10();
			
			if(v1% 2 == 0) 
			{ 
				//num.add(v1);)
			}
			if(v2% 2 == 0) 
			{
				num.add(v2);
			}
			if(v3% 2 == 0) 
			{
				num.add(v3);
			}
			if(v4% 2 == 0) 
			{
				num.add(v4);
			}
			if(v5% 2 == 0) 
			{
				num.add(v5);
			}
			if(v6% 2 == 0) 
			{
				num.add(v6);
			}
			if(v7% 2 == 0) 
			{
				num.add(v7);
			}
			if(v8% 2 == 0) 
			{
				num.add(v8);
			}
			if(v9% 2 == 0) 
			{
				num.add(v9);
			}
			if(v10% 2 == 0) 
			{
				num.add(v10);
			}
			
		}
		
		return "num";
	}
 
 

public Jogo getJogo() {
	return jogo;
}

public void setJogo(Jogo jogo) {
	this.jogo = jogo;
}

public JogoDao getJogoDao() {
	return jogoDao;
}

public void setJogoDao(JogoDao jogoDao) {
	this.jogoDao = jogoDao;
}

public List<Jogo> getListaJogo() {
	return listaJogo;
}

public void setListaJogo(List<Jogo> listaJogo) {
	this.listaJogo = listaJogo;
}

public List<Jogo> getParesLista() {
	return paresLista;
}

public void setParesLista(List<Jogo> paresLista) {
	this.paresLista = paresLista;
}

public ArrayList<Integer> getNum() {
	return num;
}

public void setNum(ArrayList<Integer> num) {
	this.num = num;
}


}