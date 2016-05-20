package simple;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class SimpleJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		for(int i=0;i<10;i++){
			try {
				Thread.currentThread().sleep(i*1000);
				System.out.println("µÚ"+i+"´Î");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
