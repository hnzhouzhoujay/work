package custler;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

import service.JobService;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class CallServiceJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String url ="http://localhost:8080/QuartzTs/hessian";
		HessianProxyFactory factory=new HessianProxyFactory();
		try {
			JobService service=(JobService) factory.create(JobService.class, url);
			JobDataMap dataMap = context.getJobDetail().getJobDataMap();
			String nodeName=(String) dataMap.get("nodeName");
			int count=(int) dataMap.get("count");
			dataMap.put("count", ++count);
			service.call("第"+count+"次execute:"+nodeName);
			System.out.println("第"+count+"次execute:"+nodeName);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
