package com.zzyy.rs.security;


import com.zzyy.rs.entities.User;
import com.zzyy.rs.entities.UserInfo;
import com.zzyy.rs.service.AccountService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * implements UserDetailsService
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    AccountService accountService;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {

        UserInfo user = null;
        try {
//            User dbUser = accountService
//                    .findUserAccountByUsername(username);
            // Populate the Spring User object with details from the dbUser
            // Here we just pass the username, password, and access level
            // getAuthorities() will translate the access level to the correct
            // role type
            user = new UserInfo("admin","password", true, true,
                    true, true, getAuthorities("superadmin"));
            user.setNickname("superadmin");
            user.setLoginTime(new Date());
        } catch (Exception e) {
            logger.error("Error in retrieving user < " + username + " >", e);
            throw new UsernameNotFoundException("Error in retrieving user < "
                    + username + " >");
        }

        return user;
    }

    /**
     * 获得访问角色权限
     *
     * @param role
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(String... role) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        for (String temp : role) {
            authList.add(new SimpleGrantedAuthority(temp));
        }
        return authList;
    }
}
