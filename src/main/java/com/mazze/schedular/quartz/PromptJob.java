package com.mazze.schedular.quartz;

import javax.swing.JOptionPane;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class PromptJob implements Job {
	private static int count = 0;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String proptMesage = null;
		if (count == 0) {
			proptMesage = "You have just started your system";
		} else {
			proptMesage = "You are using the system from last " + count + " hour ";
		}
		count++;
		JOptionPane.showMessageDialog(null, proptMesage, "Usage Message", JOptionPane.INFORMATION_MESSAGE);
	}

}
