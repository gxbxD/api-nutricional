package online.nutritabapi.api_nutricional.model;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.detDSA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alimentos")
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String tipo;
    private double agua;
    private double calorias;
    private double carboidratos;
    private double proteina;
    private double gord_saturada;
    private double gord_insaturada;
    private double gord_total;
    private double fibras;
    private double colesterol;
    private double calcio;
    private double ferro;
    private double sodio;
    private double magnesio;
    private double fosforo;
    private double potassio;
    private double manganes;
    private double zinco;
    private double cobre;
    private double selenio;
    private double vitamina_a;
    private double vitamina_d;
    private double vitamina_e;
    private double tiamina;
    private double riboflavina;
    private double niacina;
    private double vitamina_b6;
    private double vitamina_b12;
    private double vitamina_c;

    // Constructor

    public Alimento(Long id, String nome, String descricao, String tipo, double agua, double calorias,
            double carboidratos, double proteina, double gord_saturada, double gord_insaturada, double gord_total,
            double fibras, double colesterol, double calcio, double ferro, double sodio, double magnesio,
            double fosforo, double potassio, double manganes, double zinco, double cobre, double selenio,
            double vitamina_a, double vitamina_d, double vitamina_e, double tiamina, double riboflavina, double niacina,
            double vitamina_b6, double vitamina_b12, double vitamina_c) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.agua = agua;
        this.calorias = calorias;
        this.carboidratos = carboidratos;
        this.proteina = proteina;
        this.gord_saturada = gord_saturada;
        this.gord_insaturada = gord_insaturada;
        this.gord_total = gord_total;
        this.fibras = fibras;
        this.colesterol = colesterol;
        this.calcio = calcio;
        this.ferro = ferro;
        this.sodio = sodio;
        this.magnesio = magnesio;
        this.fosforo = fosforo;
        this.potassio = potassio;
        this.manganes = manganes;
        this.zinco = zinco;
        this.cobre = cobre;
        this.selenio = selenio;
        this.vitamina_a = vitamina_a;
        this.vitamina_d = vitamina_d;
        this.vitamina_e = vitamina_e;
        this.tiamina = tiamina;
        this.riboflavina = riboflavina;
        this.niacina = niacina;
        this.vitamina_b6 = vitamina_b6;
        this.vitamina_b12 = vitamina_b12;
        this.vitamina_c = vitamina_c;
    }

    //Constructor padrao
    public Alimento() {
    }

    // getters e setters

    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // descriçao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Calorias
    public double getCalorias() {
        return calorias;
    }
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    //agua
    public double getAgua() {
        return agua;
    }
    public void setAgua(double agua) {
        this.agua = agua;
    }

    //carboidratos
    public double getCarboidratos() {
        return carboidratos;
    }
    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    //Proteina
    public double getProteina() {
        return proteina;
    }
    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    //Gordura saturada
    public double getGord_saturada() {
        return gord_saturada;
    }
    public void setGord_saturada(double gord_saturada) {
        this.gord_saturada = gord_saturada;
    }

    //Gordura insaturada
    public double getGord_insaturada() {
        return gord_insaturada;
    }
    public void setGord_insaturada(double gord_insaturada) {
        this.gord_insaturada = gord_insaturada;
    }

    //Gordura total
    public double getGord_total() {
        return gord_total;
    }
    public void setGord_total(double gord_total) {
        this.gord_total = gord_total;
    }

    //Fibras
    public double getFibras() {
        return fibras;
    }
    public void setFibras(double fibras) {
        this.fibras = fibras;
    }

    //Colesterol
    public double getColesterol() {
        return colesterol;
    }
    public void setColesterol(double colesterol) {
        this.colesterol = colesterol;
    }

    //Calcio
    public double getCalcio() {
        return calcio;
    }
    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

    //Ferro
    public double getFerro() {
        return ferro;
    }
    public void setFerro(double ferro) {
        this.ferro = ferro;
    }

    //Sodio
    public double getSodio() {
        return sodio;
    }
    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    //Magnesio
    public double getMagnesio() {
        return magnesio;
    }
    public void setMagnesio(double magnesio) {
        this.magnesio = magnesio;
    }

    //Fosforo
    public double getFosforo() {
        return fosforo;
    }
    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    //Potassio
    public double getPotassio() {
        return potassio;
    }
    public void setPotassio(double potassio) {
        this.potassio = potassio;
    }

    //Manganes
    public double getManganes() {
        return manganes;
    }
    public void setManganes(double manganes) {
        this.manganes = manganes;
    }

    //Zinco
    public double getZinco() {
        return zinco;
    }
    public void setZinco(double zinco) {
        this.zinco = zinco;
    }

    //Cobre
    public double getCobre() {
        return cobre;
    }
    public void setCobre(double cobre) {
        this.cobre = cobre;
    }

    //Selenio
    public double getSelenio() {
        return selenio;
    }
    public void setSelenio(double selenio) {
        this.selenio = selenio;
    }

    //Vitamina A
    public double getVitamina_a() {
        return vitamina_a;
    }
    public void setVitamina_a(double vitamina_a) {
        this.vitamina_a = vitamina_a;
    }

    //Vitamina D
    public double getVitamina_d() {
        return vitamina_d;
    }
    public void setVitamina_d(double vitamina_d) {
        this.vitamina_d = vitamina_d;
    }

    //Vitamina E
    public double getVitamina_e() {
        return vitamina_e;
    }
    public void setVitamina_e(double vitamina_e) {
        this.vitamina_e = vitamina_e;
    }

    //Tiamina
    public double getTiamina() {
        return tiamina;
    }
    public void setTiamina(double tiamina) {
        this.tiamina = tiamina;
    }

    //Riboflavina
    public double getRiboflavina() {
        return riboflavina;
    }
    public void setRiboflavina(double riboflavina) {
        this.riboflavina = riboflavina;
    }

    //Niacina
    public double getNiacina() {
        return niacina;
    }
    public void setNiacina(double niacina) {
        this.niacina = niacina;
    }

    //Vitamina B6
    public double getVitamina_b6() {
        return vitamina_b6;
    }
    public void setVitamina_b6(double vitamina_b6) {
        this.vitamina_b6 = vitamina_b6;
    }

    //Vitamina B12
    public double getVitamina_b12() {
        return vitamina_b12;
    }
    public void setVitamina_b12(double vitamina_b12) {
        this.vitamina_b12 = vitamina_b12;
    }

    //Vitamina C
    public double getVitamina_c() {
        return vitamina_c;
    }
    public void setVitamina_c(double vitamina_c) {
        this.vitamina_c = vitamina_c;
    }

}
