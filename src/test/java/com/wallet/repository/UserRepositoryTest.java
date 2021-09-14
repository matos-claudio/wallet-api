package com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";

	@Autowired
	UserRepository userRepository;
	
	@Before
	public void setUp() {
		User user = new User();
		user.setName("SetUpUser");
		user.setPassword("Senha123");
		user.setEmail(EMAIL);
		userRepository.save(user);
	}
	
	@After
	public void tearDown() {
		userRepository.deleteAll();
	}
	
	@Test
	public void testeSave() {
		User user = new User();
		user.setName("Teste");
		user.setPassword("123456");
		user.setEmail(EMAIL);
		User response = userRepository.save(user);
		assertNotNull(response);
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> response = userRepository.findByEmailEquals(EMAIL);
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
}
