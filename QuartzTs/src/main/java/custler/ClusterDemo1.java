package custler;

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

import simple.SimpleJobListener;
import simple.SimpleTrigger;

public class ClusterDemo1 {
	public static void main(String[] args) {
		try {
			Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
			/*JobDetail job=JobBuilder.newJob(CallServiceJob.class)
				.withIdentity("simpleJob", "clusterJob")
				.usingJobData("nodeName", "节点2")
				.build();
			
			//simpleTrigger
			Trigger trigger=TriggerBuilder.newTrigger()
					.withIdentity("simpleTrigger", "clusterTrigger")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
					.build();
			if(!scheduler.checkExists(new JobKey("simpleJob", "clusterJob"))&&!scheduler.checkExists(new TriggerKey("simpleTrigger", "clusterTrigger"))){
				scheduler.scheduleJob(job, trigger);
				scheduler.getListenerManager().addJobListener(new SimpleJobListener(),KeyMatcher.keyEquals(new JobKey("simpleJob", "clusterJob")));
				scheduler.getListenerManager().addTriggerListener(new SimpleTrigger("简单的"), KeyMatcher.keyEquals(new TriggerKey("simpleTrigger", "clusterTrigger")));
			}*/
			scheduler.start();
		
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}
	

}
