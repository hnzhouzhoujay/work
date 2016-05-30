package simple;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.concurrent.TimeUnit;

@DisallowConcurrentExecution
public class SimpleJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			TimeUnit.SECONDS.sleep(1);
			String name=(String) context.getMergedJobDataMap().get("name");
			System.out.println("excute "+name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
