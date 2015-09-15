package org.waylab.sgy.repositories.mongo;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public String getCurrentAuditor() {
		return "system";
	}

}
