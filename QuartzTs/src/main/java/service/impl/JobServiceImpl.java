package service.impl;



import java.util.logging.Logger;

import service.JobService;

public class JobServiceImpl implements JobService {
	private final Logger log = Logger.getLogger("JobServiceImpl");
	@Override
	public void call(String param) {
		log.info(param);
	}

}
