package org.motechproject.nyvrs.web.domain;

import org.motechproject.nyvrs.domain.ChannelType;
import org.motechproject.nyvrs.domain.EducationLevel;

import java.util.ArrayList;
import java.util.List;

public class RegistrationRequest {

    private Long callerId;
    private Language language;
    private Integer age;
    private Gender gender;
    private EducationLevel educationLevel;
    private ChannelType channel;
    private String source;
    private String location;
    private String region;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String callerId, String language, String age, String gender, String educationLevel, String channel) {
        this.callerId = Long.parseLong(callerId);
        this.language = Language.valueOf(language);
        this.age = Integer.parseInt(age);
        this.gender = Gender.valueOf(gender);
        this.educationLevel = EducationLevel.valueOf(educationLevel);
        this.channel = ChannelType.valueOf(channel);
    }

    public RegistrationRequest(String callerId, String language, String age, String gender, String educationLevel, String channel, String source, String location, String region) {
        this.callerId = Long.parseLong(callerId);
        this.language = Language.valueOf(language);
        this.age = Integer.parseInt(age);
        this.gender = Gender.valueOf(gender);
        this.educationLevel = EducationLevel.valueOf(educationLevel);
        this.channel = ChannelType.valueOf(channel);
    }

    public RegistrationRequest(Long callerId, Language language, Integer age, Gender gender, EducationLevel educationLevel,
            ChannelType channel) {
        this.callerId = callerId;
        this.language = language;
        this.age = age;
        this.gender = gender;
        this.educationLevel = educationLevel;
        this.channel = channel;
    }

    public Long getCallerId() {
        return callerId;
    }

    public Language getLanguage() {
        return language;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public ChannelType getChannel() {
        return channel;
    }

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();

        if (callerId == null || callerId <= 0) {
            errors.add(new ValidationError("Invalid caller id"));
        }
        if (language == null) {
            errors.add(new ValidationError("Invalid language"));
        }
        if (age == null || age < 15 || age > 24) {
            errors.add(new ValidationError("Age should be between 15 and 24"));
        }
        if (gender == null) {
            errors.add(new ValidationError("Invalid gender"));
        }
        if (educationLevel == null) {
            errors.add(new ValidationError("Invalid education level"));
        }
        if (channel == null) {
            errors.add(new ValidationError("Invalid channel"));
        }
        if (region == null) {
            region = "";
        }
        if (location == null) {
            location = "";
        }
        if (source == null) {
            location = "";
        }

        return errors;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

}
