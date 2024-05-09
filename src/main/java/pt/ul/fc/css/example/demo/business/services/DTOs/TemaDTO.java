package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;

@Component
public class TemaDTO {

    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    private String titulo;
    private String descricao;
    private float remunMensal;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getRemunMensal() {
        return remunMensal;
    }

    public void setRemunMensal(float remunMensal) {
        this.remunMensal = remunMensal;
    }
}
