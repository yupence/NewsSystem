package com.zr.realm;

import com.zr.po.Permission;
import com.zr.po.Role;
import com.zr.po.User;
import com.zr.service.UserService;
import org.apache.shiro.authc.*;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class NewsRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    public void setName(String name) {
        setName("newsRealm");
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user= (User) principalCollection.getPrimaryPrincipal();
        Set<Role> roles = user.getRoles();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        for(Role role:roles){
            info.addRole(role.getName());
            for(Permission p:role.getPermissions()){
                info.addStringPermission(p.getCode());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());
        User user = userService.checkUser(username, password);
        if(user!=null){
            return new SimpleAuthenticationInfo(user,password,this.getName());
        }
        return null;
    }
}
