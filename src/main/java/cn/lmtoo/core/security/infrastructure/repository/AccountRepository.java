package cn.lmtoo.core.security.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lmtoo.core.security.domain.UserAccount;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Long> {
	@Query("from UserAccount where username=:username")
	UserAccount findUserAccountByUsername(String username);
}
