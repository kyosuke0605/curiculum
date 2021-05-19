package com.example.security.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.springsecurity.account.AccountService;

@EnableWebSecurity//セキュリティ機能を有効にする
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccountService userService;

	@Override// 
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()   //アクセス権限の設定
		.antMatchers("/login", "/login-error").permitAll()//アクセス制限の無いURL
		.antMatchers("/**").hasRole("USER")//管理画面USER権限が無いとアクセス
		.and()
		.formLogin()//ログイン画面とログインに関わる処理.
		.loginPage("/login").failureUrl("/login-error");//oginPageにはログイン画面のURLを指定failureUreにはログイン失敗のURl先を指定
		
	}


	//変更点 ロード時に、「admin」ユーザを登録する。
	@Override 
	//ログインできるユーザ名とそのパスワードを登録
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userService)
		.passwordEncoder(passwordEncoder());

		if (userService.findAllList().isEmpty()) {
			userService.registerAdmin("admin", "secret", "admin@localhost");
			userService.registerManager("manager", "secret", "manager@localhost");
			userService.registerUser("user", "secret", "user@localhost");
		}
	}
	//変更点 PasswordEncoder(BCryptPasswordEncoder)メソッド
	@Bean
	public PasswordEncoder passwordEncoder() {
		//
		return new BCryptPasswordEncoder();
	}

}