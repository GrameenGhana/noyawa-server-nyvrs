package org.motechproject.nyvrs.service;

import org.motechproject.nyvrs.domain.MessageRequest;

public interface SchedulerService {

    void schedule(MessageRequest messageRequest);

}