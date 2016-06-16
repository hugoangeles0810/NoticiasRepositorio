/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.util;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class Paginacion implements Serializable{
    
    private Long total;
    private List<?> rows;

    public Paginacion() {
    }

    public Paginacion(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
    
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
    
}
