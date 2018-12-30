/*
 * This file is generated by jOOQ.
*/
package meta.tables.pojos;


import java.sql.Timestamp;

import javax.annotation.Generated;

import meta.enums.ParticipantStatus;
import meta.tables.interfaces.IParticipant;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Participant implements IParticipant {

    private static final long serialVersionUID = -1237748856;

    private final Long              id;
    private final String            firstName;
    private final String            lastName;
    private final String            email;
    private final String            affiliation;
    private final String            verificationToken;
    private final Integer           orderNumber;
    private final Long              eventId;
    private final ParticipantStatus status;
    private final Timestamp         createdOn;
    private final Timestamp         updatedOn;

    public Participant(Participant value) {
        this.id = value.id;
        this.firstName = value.firstName;
        this.lastName = value.lastName;
        this.email = value.email;
        this.affiliation = value.affiliation;
        this.verificationToken = value.verificationToken;
        this.orderNumber = value.orderNumber;
        this.eventId = value.eventId;
        this.status = value.status;
        this.createdOn = value.createdOn;
        this.updatedOn = value.updatedOn;
    }

    public Participant(
        Long              id,
        String            firstName,
        String            lastName,
        String            email,
        String            affiliation,
        String            verificationToken,
        Integer           orderNumber,
        Long              eventId,
        ParticipantStatus status,
        Timestamp         createdOn,
        Timestamp         updatedOn
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.affiliation = affiliation;
        this.verificationToken = verificationToken;
        this.orderNumber = orderNumber;
        this.eventId = eventId;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getAffiliation() {
        return this.affiliation;
    }

    @Override
    public String getVerificationToken() {
        return this.verificationToken;
    }

    @Override
    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    @Override
    public Long getEventId() {
        return this.eventId;
    }

    @Override
    public ParticipantStatus getStatus() {
        return this.status;
    }

    @Override
    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    @Override
    public Timestamp getUpdatedOn() {
        return this.updatedOn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Participant (");

        sb.append(id);
        sb.append(", ").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(email);
        sb.append(", ").append(affiliation);
        sb.append(", ").append(verificationToken);
        sb.append(", ").append(orderNumber);
        sb.append(", ").append(eventId);
        sb.append(", ").append(status);
        sb.append(", ").append(createdOn);
        sb.append(", ").append(updatedOn);

        sb.append(")");
        return sb.toString();
    }
}
