package org.krams.tutorial.job;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * A synchronous worker
 */
@Component("syncWorker")
public class SyncWorker implements Worker {

	protected static Logger logger = Logger.getLogger("service");

	public void work() {
		String threadName = Thread.currentThread().getName();
		logger.debug("   " + threadName + " has began working.");
        try {
        	logger.debug("working...");
            Thread.sleep(10000); // simulates work
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        logger.debug("   " + threadName + " has completed work.");
	}
	
}
