package cn.lmtoo.core.security.extend.session.mgt.eis;

import java.io.Serializable;
import java.util.Random;

import org.apache.shiro.session.mgt.eis.RandomSessionIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.lmtoo.core.tools.IdGenerator;

public class RandomIdGenerator implements IdGenerator {
	private static final Logger log = LoggerFactory.getLogger(RandomSessionIdGenerator.class);

	private static final String RANDOM_NUM_GENERATOR_ALGORITHM_NAME = "SHA1PRNG";
	private Random random;

	public RandomIdGenerator() {
		try {
			this.random = java.security.SecureRandom.getInstance(RANDOM_NUM_GENERATOR_ALGORITHM_NAME);
		} catch (java.security.NoSuchAlgorithmException e) {
			log.debug("The SecureRandom SHA1PRNG algorithm is not available on the current platform.  Using the " + "platform's default SecureRandom algorithm.", e);
			this.random = new java.security.SecureRandom();
		}
	}

	public Random getRandom() {
		return this.random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Serializable generateId(Object target) {
		return Long.toString(getRandom().nextLong());
	}
}