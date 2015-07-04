/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.test;

import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hugo
 */
public class LoggingTest extends AbstractTestSuite{
    
    @Autowired
    DataSource dataSource;
    
    @Test
    public void printTest(){
        System.out.println("-------------------");
        System.out.println("Imprimiendo mensaje");
        System.out.println("-------------------");
    }
    
    @Test
    public void dataSourceTest(){
        Assert.assertNotNull(dataSource);
    }
    
}
