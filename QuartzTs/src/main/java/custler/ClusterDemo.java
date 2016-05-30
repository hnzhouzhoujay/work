package custler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import java.util.concurrent.TimeUnit;

import simple.SimpleJobListener;
import simple.SimpleTrigger;

public class ClusterDemo {
	public static void main(String[] args) {
		try {
			Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
			scheduler.clear();
			JobDetail job=JobBuilder.newJob(CallServiceJob.class)
				.withIdentity("simpleJob", "clusterJob")
				.usingJobData("nodeName", "节点1")
				.usingJobData("count", 0)
				.build();
			
			//simpleTrigger
			Trigger trigger=TriggerBuilder.newTrigger()
					.withIdentity("simpleTrigger", "clusterTrigger")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
					.build();
	
			if(!scheduler.checkExists(new JobKey("simpleJob", "clusterJob"))&&!scheduler.checkExists(new TriggerKey("simpleTrigger", "clusterTrigger"))){
				scheduler.scheduleJob(job, trigger);
				scheduler.getListenerManager().addJobListener(new SimpleJobListener(),KeyMatcher.keyEquals(new JobKey("simpleJob", "clusterJob")));
				scheduler.getListenerManager().addTriggerListener(new SimpleTrigger("简单的"), KeyMatcher.keyEquals(new TriggerKey("simpleTrigger", "clusterTrigger")));
			}
			
			scheduler.start();
			try {
				
				TimeUnit.MINUTES.sleep(1);
				scheduler.shutdown();
			} catch (Exception e) {
			}
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}
	

}
