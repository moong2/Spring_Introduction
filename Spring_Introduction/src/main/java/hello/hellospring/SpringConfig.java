package hello.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public MemberRepository memberRepository() {
		// return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
}
