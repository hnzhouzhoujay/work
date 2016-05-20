package simple;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class SimpleJobListener implements JobListener{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "我的job监听";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		// TODO Auto-generated method stub
		System.out.println("job 即将被执行"+context.getMergedJobDataMap().getString("name"));
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		// TODO Auto-generated method stub
		System.out.println("job 已经被执行"+context.getMergedJobDataMap().getString("name"));
		
	}

}
