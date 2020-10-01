package com.mazze.schedular.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class PromptJobConfiguration {

	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob().ofType(PromptJob.class).withIdentity("Prompt job key")
				.withDescription("Prompt job description").storeDurably().build();

	}

	@Bean
	public Trigger trigger(JobDetail jobDetail) {
		return TriggerBuilder.newTrigger().forJob(jobDetail).withIdentity("Prompt trigger identity")
				.withDescription("Prpopmpt trigger description")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();
	}

	@Bean
	public Scheduler scheduler(Trigger trigger, JobDetail job, SchedulerFactoryBean factory) throws SchedulerException {
		Scheduler scheduler = factory.getScheduler();
		if (scheduler.checkExists(trigger.getKey()))
			if (scheduler.checkExists(job.getKey()) || scheduler.checkExists(trigger.getKey())) {
				scheduler.deleteJob(job.getKey());
			}
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
		return scheduler;

	}

}
