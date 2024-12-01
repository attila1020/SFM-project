package hu.unideb.gasstation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.cdi.Eager;

@Entity
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String terminal;
    private int stock;


    public Terminal(String terminal, int stock) {
        this.terminal = terminal;
        this.stock = stock;
    }

    public Terminal() {

    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
