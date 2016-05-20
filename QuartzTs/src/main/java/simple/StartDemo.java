package simple;

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


public class StartDemo {
	public static void main(String[] args) {
		try {
			Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
		
			JobDetail job=JobBuilder.newJob(SimpleJob.class)
				.withIdentity("simpleJob", "simpleJob")
				.usingJobData("name", "简单工作")
				.build();
			
			JobDetail job1=JobBuilder.newJob(SimpleJob1.class)
					.withIdentity("complexJob", "complexJob")
					.usingJobData("name", "复杂工作")
					.build();
			//simpleTrigger
			Trigger trigger=TriggerBuilder.newTrigger()
					.withIdentity("simpleTrigger", "simpleTrigger")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
					.usingJobData("name", "简单工作1")
					.build();
			//cronTrigger
			Trigger conTrigger=TriggerBuilder.newTrigger()
					.withIdentity("conTrigger", "conTrigger")
					.startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
					.usingJobData("name", "复杂工作1")
					.build();
		
			scheduler.scheduleJob(job, trigger);
			scheduler.scheduleJob(job1, conTrigger);
			
			scheduler.getListenerManager().addJobListener(new SimpleJobListener(),KeyMatcher.keyEquals(new JobKey("simpleJob", "simpleJob")));
			scheduler.getListenerManager().addTriggerListener(new SimpleTrigger("简单的"), KeyMatcher.keyEquals(new TriggerKey("simpleTrigger", "simpleTrigger")));
			
			scheduler.getListenerManager().addJobListener(new SimpleJobListener(),KeyMatcher.keyEquals(new JobKey("complexJob", "complexJob")));
			scheduler.getListenerManager().addTriggerListener(new SimpleTrigger("cron的"), KeyMatcher.keyEquals(new TriggerKey("conTrigger", "conTrigger")));
			scheduler.start();
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
