package br.com.jsn.entity;


import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 *
 * @author JSN
 */
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    
    @Column(name = "usuario_nome")
    private String usuarioNome;
    @Column(name = "usuario_email")
    private String usuarioEmail;
    @Column(name = "usuario_senha")
    private String usuarioSenha;
    
    
    public UsuarioEntity() {
    	
    }


	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


	public String getUsuarioNome() {
		return usuarioNome;
	}


	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}


	public String getUsuarioEmail() {
		return usuarioEmail;
	}


	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}


	public String getUsuarioSenha() {
		return usuarioSenha;
	}


	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}


	@Override
	public String toString() {
		return "UsuarioEntity [usuarioId=" + usuarioId + ", usuarioNome=" + usuarioNome + ", usuarioEmail="
				+ usuarioEmail + ", usuarioSenha=" + usuarioSenha + "]";
	}
    
    
    
    
    
    
}
