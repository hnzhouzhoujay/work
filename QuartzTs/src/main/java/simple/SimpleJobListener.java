package simple;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class SimpleJobListener implements JobListener{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "�ҵ�job����";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		// TODO Auto-generated method stub
		System.out.println("job ������ִ��"+context.getMergedJobDataMap().getString("name"));
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		// TODO Auto-generated method stub
		System.out.println("job �Ѿ���ִ��"+context.getMergedJobDataMap().getString("name"));
		
	}

}
