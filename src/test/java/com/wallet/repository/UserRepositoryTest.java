package com.wallet.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("Teste");
		user.setPassword("123456");
		user.setEmail("teste@teste.com");
		User response = userRepository.save(user);
		
		assertNotNull(response);
	}
}
