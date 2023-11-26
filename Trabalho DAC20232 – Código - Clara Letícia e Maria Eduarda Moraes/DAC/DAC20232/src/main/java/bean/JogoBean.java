package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.JogoDAO;
import entidades.Jogo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@RequestScoped
public class JogoBean {
 
    private Jogo jogo = new Jogo();
    private List<Jogo> jogos = new ArrayList<Jogo>();

    public Jogo getJogo() {
        return jogo;
    }
    public List<Jogo> getJogos() {
    	try {
            JogoDAO jogoDAO = new JogoDAO(); // Criando uma instância de JogoDAO
            jogos = jogoDAO.listar(); // Chamando o método salvar através da instância de JogoDAO
            System.out.println(jogos);
            return jogos;
        } catch (Exception e) {
            e.printStackTrace();
            return jogos;
        }
    }
    
    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public void salvarJogo() {
        if (isTimesIguais()) {
            exibirMensagemErro("Os times não podem ser iguais.");
        } else {
            preencherDataCadastro(); // Preenche a data de cadastro automaticamente
            boolean salvouComSucesso = salvarNoBanco(); // Tenta salvar o jogo no banco de dados

            if (salvouComSucesso) {
                exibirMensagemSucesso("Jogo salvo com sucesso.");
            } else {
                exibirMensagemErro("Erro ao salvar o jogo. Tente novamente.");
            }
        }
    }

    private boolean isTimesIguais() {
        return jogo.getTime1().equals(jogo.getTime2());
    }

    private void preencherDataCadastro() {
        jogo.setDataCadastro(new Date()); // Define a data de cadastro como a data/hora atuais
    }
 
    private boolean salvarNoBanco() {
        try {
            JogoDAO jogoDAO = new JogoDAO(); // Criando uma instância de JogoDAO
            jogoDAO.salvar(jogo); // Chamando o método salvar através da instância de JogoDAO
            return true;
        } catch (Exception e) {
            // Tratamento de exceção aqui
            e.printStackTrace();
            return false;
        }
    }
    
    private void exibirMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", mensagem));
    }

    private void exibirMensagemSucesso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", mensagem));
    }
}