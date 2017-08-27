/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.votoseguro.controller;
import com.votoseguro.entity.Tbldepartamento;
import com.votoseguro.facade.DepartamentoFacade;
import com.votoseguro.util.ValidationBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Luis Eduardo Valdez
 */
@ViewScoped
@ManagedBean(name = "deptoController")
public class DeptoController {
    
    @EJB
    DepartamentoFacade df;
    @EJB
    ValidationBean vb;
    
    private @Getter
    @Setter
    List<Tbldepartamento> listaDeptos = new ArrayList<>();
    private @Getter @Setter Tbldepartamento depto = new Tbldepartamento();
    
    @PostConstruct
    public void init(){
        listaDeptos = df.obtenerDeptos();
        
    }
    
    public void insert(){
    df.insert(depto);
    limpiar();
    listaDeptos = df.obtenerDeptos();
    }
    
    public void limpiar(){
    depto = new Tbldepartamento();
    }
    
}
