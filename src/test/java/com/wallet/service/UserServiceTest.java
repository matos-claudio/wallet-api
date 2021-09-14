package com.wallet.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class UserServiceTest {
	
	@MockBean
	UserRepository userReposistory;
	
	@Autowired
	UserService userService;
	
	@Before
	public void setUp() {
		//Quando o metodo for acionado, retorna um new User, enviando qualquer string e mocando o resultado
		BDDMockito.given(userReposistory.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> user = userService.findByEmail("email@teste.com");
		assertTrue(user.isPresent());
	}
}
