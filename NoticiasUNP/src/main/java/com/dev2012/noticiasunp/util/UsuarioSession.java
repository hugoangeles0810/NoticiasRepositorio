/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUser;

/**
 *
 * @author Hugo
 */
public class UsuarioSession extends SocialUser {
 
    private Long id;
 
    private String firstName;
 
    private String lastName;
 
    private Role role;
 
    private SocialMediaService socialSignInProvider;
    
    private String imageUrl;
 
    public UsuarioSession(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public SocialMediaService getSocialSignInProvider() {
        return socialSignInProvider;
    }

    public void setSocialSignInProvider(SocialMediaService socialSignInProvider) {
        this.socialSignInProvider = socialSignInProvider;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public static Builder getBuilder(){
        return new Builder();
    }
 
    public static class Builder {
 
        private Long id;
 
        private String username;
 
        private String firstName;
 
        private String lastName;
 
        private String password;
 
        private Role role;
 
        private SocialMediaService socialSignInProvider;
 
        private Set<GrantedAuthority> authorities;
        
        private String imageurl;
 
        public Builder() {
            this.authorities = new HashSet<>();
        }
 
        /**
         *
         * @param firstName
         * @return
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
 
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
 
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
 
        public Builder password(String password) {
            if (password == null) {
                password = "SocialUser";
            }
 
            this.password = password;
            return this;
        }
 
        public Builder role(Role role) {
            this.role = role;
 
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
            this.authorities.add(authority);
 
            return this;
        }
 
        public Builder socialSignInProvider(SocialMediaService socialSignInProvider) {
            this.socialSignInProvider = socialSignInProvider;
            return this;
        }
 
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        
        public Builder imageurl(String imageurl) {
            this.imageurl = imageurl;
            return this;
        }
 
        public UsuarioSession build() {
            UsuarioSession user = new UsuarioSession(username, password, authorities);
 
            user.id = id;
            user.firstName = firstName;
            user.lastName = lastName;
            user.role = role;
            user.socialSignInProvider = socialSignInProvider;
            user.imageUrl = imageurl;
            return user;
        }
    }
}
