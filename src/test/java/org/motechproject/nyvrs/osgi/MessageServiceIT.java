package org.motechproject.nyvrs.osgi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.nyvrs.domain.ChannelType;
import org.motechproject.nyvrs.domain.ClientRegistration;
import org.motechproject.nyvrs.domain.EducationLevel;
import org.motechproject.nyvrs.domain.MessageRequest;
import org.motechproject.nyvrs.service.ClientRegistrationService;
import org.motechproject.nyvrs.service.MessageService;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * Verify that MessageService present, functional.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class MessageServiceIT extends BasePaxIT {

    @Inject
    private MessageService messageService;

    @Inject
    private ClientRegistrationService clientRegistrationService;

    @Test
    public void testMessageServicePresent() throws Exception {
        assertNotNull(messageService);
    }

    @Test
    public void shouldMakeACallRequest() throws Exception {
        String callerId = "123456432";
        ClientRegistration clientRegistration = clientRegistrationService.findClientRegistrationByNumber(callerId);
        if (clientRegistration == null) {
            clientRegistration = new ClientRegistration(callerId, "ENGLISH", "M", "21", EducationLevel.OTH, ChannelType.V);
            clientRegistrationService.add(clientRegistration);
        }
        try {
            Assert.assertTrue(messageService.playMessage(new MessageRequest(clientRegistration.getNumber(), 0, 0)));
        } finally {
            clientRegistrationService.delete(clientRegistration);
        }
    }

}
