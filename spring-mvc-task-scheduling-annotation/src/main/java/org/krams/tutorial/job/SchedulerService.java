package org.krams.tutorial.job;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Scheduler for handling jobs
 */
@Service
public class SchedulerService {

	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	@Qualifier("syncWorker")
	private Worker worker;
	
	/**
	 * You can opt for cron expression or fixedRate or fixedDelay
	 * <p>
	 * See Spring Framework 3 Reference:
	 * Chapter 25.5 Annotation Support for Scheduling and Asynchronous Execution
	 */
	//@Scheduled(fixedDelay=5000)
	//@Scheduled(fixedRate=5000)
	@Scheduled(cron="*/5 * * * * ?")
	public void doSchedule() {
		logger.debug("Start schedule");
		
		for (int i = 0; i < 5; i++) {
			logger.debug("Delegate to worker " + i);
			worker.work();
        }
		
		logger.debug("End schedule");
	}
	

}
