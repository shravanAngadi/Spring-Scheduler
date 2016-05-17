/*
 * Copyright © 2014 AirWatch, LLC. All rights reserved.
 * This product is protected by copyright and intellectual property laws
 * in the United States and other countries as well as by international treaties.
 * AirWatch products may be covered by one or more patents listed at
 * http://www.vmware.com/go/patents.
 */

package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sangadi on 5/10/2016.
 */
@Component
public class Scheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final Logger log = LoggerFactory.getLogger(Scheduler.class);

    public void setL(Long l) {
        this.l = l;
    }

    @Autowired
    private TaskScheduler taskScheduler;
    @Autowired
    Task task;

    Long l = 2000l;

    @PostConstruct
    public void reportCurrentTime() {
        Trigger trigger = new PeriodicTrigger(2000l);
        taskScheduler.schedule(task, trigger);

                log.debug("debug");
        log.info("info");
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}

