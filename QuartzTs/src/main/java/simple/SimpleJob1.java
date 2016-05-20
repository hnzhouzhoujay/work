package simple;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class SimpleJob1 implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		int a=0;
		for(int i=0;i<100000;i++){
			a=i;
		}
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a);
	}

}
