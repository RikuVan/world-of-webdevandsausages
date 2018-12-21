/*
 * This file is generated by jOOQ.
*/
package meta.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import meta.enums.EventStatus;
import meta.tables.Event;
import meta.tables.interfaces.IEvent;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


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
public class EventRecord extends UpdatableRecordImpl<EventRecord> implements Record9<Long, String, String, Timestamp, String, String, EventStatus, Integer, Timestamp>, IEvent {

    private static final long serialVersionUID = -852878609;

    /**
     * Setter for <code>public.event.id</code>.
     */
    public EventRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.event.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.event.name</code>.
     */
    public EventRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.event.name</code>.
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.event.contact</code>.
     */
    public EventRecord setContact(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.event.contact</code>.
     */
    @Override
    public String getContact() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.event.date</code>.
     */
    public EventRecord setDate(Timestamp value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.event.date</code>.
     */
    @Override
    public Timestamp getDate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>public.event.details</code>.
     */
    public EventRecord setDetails(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.event.details</code>.
     */
    @Override
    public String getDetails() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.event.location</code>.
     */
    public EventRecord setLocation(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.event.location</code>.
     */
    @Override
    public String getLocation() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.event.status</code>.
     */
    public EventRecord setStatus(EventStatus value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.event.status</code>.
     */
    @Override
    public EventStatus getStatus() {
        return (EventStatus) get(6);
    }

    /**
     * Setter for <code>public.event.max_participants</code>.
     */
    public EventRecord setMaxParticipants(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.event.max_participants</code>.
     */
    @Override
    public Integer getMaxParticipants() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.event.registration_opens</code>.
     */
    public EventRecord setRegistrationOpens(Timestamp value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.event.registration_opens</code>.
     */
    @Override
    public Timestamp getRegistrationOpens() {
        return (Timestamp) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, String, Timestamp, String, String, EventStatus, Integer, Timestamp> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, String, Timestamp, String, String, EventStatus, Integer, Timestamp> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Event.EVENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Event.EVENT.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Event.EVENT.CONTACT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Event.EVENT.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Event.EVENT.DETAILS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Event.EVENT.LOCATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<EventStatus> field7() {
        return Event.EVENT.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Event.EVENT.MAX_PARTICIPANTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return Event.EVENT.REGISTRATION_OPENS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getContact();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getDetails();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventStatus component7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getMaxParticipants();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getRegistrationOpens();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getContact();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDetails();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventStatus value7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getMaxParticipants();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getRegistrationOpens();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value3(String value) {
        setContact(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value4(Timestamp value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value5(String value) {
        setDetails(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value6(String value) {
        setLocation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value7(EventStatus value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value8(Integer value) {
        setMaxParticipants(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord value9(Timestamp value) {
        setRegistrationOpens(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventRecord values(Long value1, String value2, String value3, Timestamp value4, String value5, String value6, EventStatus value7, Integer value8, Timestamp value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    public void from(IEvent from) {
        setId(from.getId());
        setName(from.getName());
        setContact(from.getContact());
        setDate(from.getDate());
        setDetails(from.getDetails());
        setLocation(from.getLocation());
        setStatus(from.getStatus());
        setMaxParticipants(from.getMaxParticipants());
        setRegistrationOpens(from.getRegistrationOpens());
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EventRecord
     */
    public EventRecord() {
        super(Event.EVENT);
    }

    /**
     * Create a detached, initialised EventRecord
     */
    public EventRecord(Long id, String name, String contact, Timestamp date, String details, String location, EventStatus status, Integer maxParticipants, Timestamp registrationOpens) {
        super(Event.EVENT);

        set(0, id);
        set(1, name);
        set(2, contact);
        set(3, date);
        set(4, details);
        set(5, location);
        set(6, status);
        set(7, maxParticipants);
        set(8, registrationOpens);
    }
}
