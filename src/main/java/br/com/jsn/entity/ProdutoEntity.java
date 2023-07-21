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
@Table(name = "produto")
public class ProdutoEntity implements Serializable {
	

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "produto_id")
    private Integer produtoId;    
    @Column(name = "produto_nome")
    private String produtoNome;
    @Column(name = "produto_fornecedor")
    private String produtoFornecedor;
    @Column(name = "produto_valor")
    private String produtoValor;
    @Column(name = "usuario_id")
    private Integer usuarioId;
    
    public ProdutoEntity() {}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public String getProdutoFornecedor() {
		return produtoFornecedor;
	}

	public void setProdutoFornecedor(String produtoFornecedor) {
		this.produtoFornecedor = produtoFornecedor;
	}

	public String getProdutoValor() {
		return produtoValor;
	}

	public void setProdutoValor(String produtoValor) {
		this.produtoValor = produtoValor;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "Produto [produtoId=" + produtoId + ", produtoNome=" + produtoNome + ", produtoFornecedor="
				+ produtoFornecedor + ", produtoValor=" + produtoValor + ", usuarioId=" + usuarioId + "]";
	}
    
    
    

}
