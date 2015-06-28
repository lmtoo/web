package cn.lmtoo.core.security.application;

import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lmtoo.core.security.domain.UserAccount;
import cn.lmtoo.core.security.infrastructure.repository.AccountRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private AccountRepository userAccountDao;
	@Autowired
	private PasswordService passwordService;

	@Transactional
	public void register(UserAccount userAccount) {

		Object password = userAccount.getCredentials();

		Object encrypted = passwordService.encryptPassword(password);

		userAccount.setPassword(encrypted.toString());

		userAccountDao.save(userAccount);
	}
}