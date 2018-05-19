package com.gestionusuariosfp.funciones;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.gestionusuariosfp.quartz.QuartzProcess;

public class QuartzJob {
	
	public void executeQuartz() throws SchedulerException  {
		
		JobDetail job = JobBuilder.newJob(QuartzProcess.class).build();
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/5 * 1/1 * ? *");
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
	
		     
}
