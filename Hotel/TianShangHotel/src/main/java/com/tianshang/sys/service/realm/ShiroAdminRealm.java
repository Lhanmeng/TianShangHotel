package com.tianshang.sys.service.realm;



import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import 
org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshang.sys.dao.AdminDao;
import com.tianshang.sys.entity.Admin;

@Service
public class ShiroAdminRealm extends AuthorizingRealm {
	@Autowired
	private AdminDao adminDao;


	/**
	 * 设置凭证匹配器
	 * @param credentialsMatcher
	 */
	@Override
	public void setCredentialsMatcher(
			CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher=
				new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		super.setCredentialsMatcher(cMatcher);
	}



	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.从principals中获取登录用户的信息
				Object principal = principals.getPrimaryPrincipal();
				
				//2.利用登录用户的信息获取当前用户的角色（有数据库的话，从数据库中查询）
				Set<String> roles = new HashSet<String>();//放置用户角色的set集合(不重复)
				roles.add("user");//放置所有用户都有的普通用户角色
				if("administrator".equals(principal)){
					roles.add("admin");//当账号为administrator时，添加admin角色
				}
				
				//3.创建SimpleAuthorizationInfo，并设置其roles属性
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
				
				//4.返回SimpleAuthorizationInfo对象
				return info;
	}

	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.获取用户身份对象(例如用户名)
		String name = (String) token.getPrincipal();
		System.out.println("name="+name);
		// 2.基于用户名从数据库查询记录
		Admin admin = adminDao.findAdminByAdminName(name);
		System.out.println(admin);
		// 3.对查询结果进行验证,用户不存在则抛出异常
		if (admin == null)throw new AuthenticationException("用户名或密码错误");
		if(admin.getValid()==0)throw new AuthenticationException("用户已被禁用");
		// 4.对数据库查询出的相关信息进行封装
		ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				admin, // principal (身份对象)
				admin.getPassword(), // hashedCredentials(已加密的密码)
				credentialsSalt, // credentialsSalt (盐)
				this.getName());
		// 5.返回封装结果(传递给认证管理器)
		return info;
	}

	
}

