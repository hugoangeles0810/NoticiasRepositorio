/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import java.io.File;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Hugo
 */
public interface ImageService {
    
    public void saveImage(MultipartFile image, File file);
    
}
