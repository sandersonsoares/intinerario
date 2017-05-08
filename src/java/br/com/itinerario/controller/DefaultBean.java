package br.com.itinerario.controller;

import br.com.itinerario.facade.Facade;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
public class DefaultBean implements Serializable {

    private Facade facade;

    public DefaultBean() {
        facade = new Facade();
    }

    protected void imprimirMensagem(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
    }

    protected void imprimirErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
    }

    protected void abrirDialog(String dialog) {
        RequestContext request = RequestContext.getCurrentInstance();
        request.execute("PF('" + dialog + "').show()");
    }

    protected void fecharDialog(String dialog) {
        RequestContext request = RequestContext.getCurrentInstance();
        request.execute("PF('" + dialog + "').hide()");
    }

}
