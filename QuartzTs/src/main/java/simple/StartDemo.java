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
				.usingJobData("name", "�򵥹���")
				.build();
			
			JobDetail job1=JobBuilder.newJob(SimpleJob1.class)
					.withIdentity("complexJob", "complexJob")
					.usingJobData("name", "���ӹ���")
					.build();
			//simpleTrigger
			Trigger trigger=TriggerBuilder.newTrigger()
					.withIdentity("simpleTrigger", "simpleTrigger")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
					.usingJobData("name", "�򵥹���1")
					.build();
			//cronTrigger
			Trigger conTrigger=TriggerBuilder.newTrigger()
					.withIdentity("conTrigger", "conTrigger")
					.startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
					.usingJobData("name", "���ӹ���1")
					.build();
		
			scheduler.scheduleJob(job, trigger);
			scheduler.scheduleJob(job1, conTrigger);
			
			scheduler.getListenerManager().addJobListener(new SimpleJobListener(),KeyMatcher.keyEquals(new JobKey("simpleJob", "simpleJob")));
			scheduler.getListenerManager().addTriggerListener(new SimpleTrigger("�򵥵�"), KeyMatcher.keyEquals(new TriggerKey("simpleTrigger", "simpleTrigger")));
			
			scheduler.getListenerManager().addJobListener(new SimpleJobListener(),KeyMatcher.keyEquals(new JobKey("complexJob", "complexJob")));
			scheduler.getListenerManager().addTriggerListener(new SimpleTrigger("cron��"), KeyMatcher.keyEquals(new TriggerKey("conTrigger", "conTrigger")));
			scheduler.start();
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
