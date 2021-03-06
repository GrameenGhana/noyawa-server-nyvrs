package org.motechproject.nyvrs.repository;

import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;
import org.motechproject.nyvrs.domain.MessageRequest;
import org.motechproject.nyvrs.domain.MessageRequestStatus;

import java.util.List;

public interface MessageRequestDataService extends MotechDataService<MessageRequest> {

    @Lookup
    MessageRequest findMessageRequestByCallerIdAndStatus(@LookupField(name = "callerId") String callerId,
                                                @LookupField(name = "status") MessageRequestStatus status);

    @Lookup
    List<MessageRequest> findMessageRequestsByStatus(@LookupField(name = "status") MessageRequestStatus status);

}
