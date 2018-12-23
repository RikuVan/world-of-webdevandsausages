/*
 * This file is generated by jOOQ.
*/
package meta.tables.interfaces;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;

import meta.enums.EventStatus;


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
public interface IEvent extends Serializable {

    /**
     * Getter for <code>public.event.id</code>.
     */
    public Long getId();

    /**
     * Getter for <code>public.event.name</code>.
     */
    public String getName();

    /**
     * Getter for <code>public.event.sponsor</code>.
     */
    public String getSponsor();

    /**
     * Getter for <code>public.event.contact</code>.
     */
    public String getContact();

    /**
     * Getter for <code>public.event.date</code>.
     */
    public Timestamp getDate();

    /**
     * Getter for <code>public.event.details</code>.
     */
    public String getDetails();

    /**
     * Getter for <code>public.event.location</code>.
     */
    public String getLocation();

    /**
     * Getter for <code>public.event.status</code>.
     */
    public EventStatus getStatus();

    /**
     * Getter for <code>public.event.max_participants</code>.
     */
    public Integer getMaxParticipants();

    /**
     * Getter for <code>public.event.registration_opens</code>.
     */
    public Timestamp getRegistrationOpens();
}
