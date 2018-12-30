/*
 * This file is generated by jOOQ.
*/
package meta.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import meta.enums.ParticipantStatus;
import meta.tables.Participant;
import meta.tables.interfaces.IParticipant;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
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
public class ParticipantRecord extends UpdatableRecordImpl<ParticipantRecord> implements Record11<Long, String, String, String, String, String, Integer, Long, ParticipantStatus, Timestamp, Timestamp>, IParticipant {

    private static final long serialVersionUID = -1367561249;

    /**
     * Setter for <code>public.participant.id</code>.
     */
    public ParticipantRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.participant.first_name</code>.
     */
    public ParticipantRecord setFirstName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.first_name</code>.
     */
    @Override
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.participant.last_name</code>.
     */
    public ParticipantRecord setLastName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.last_name</code>.
     */
    @Override
    public String getLastName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.participant.email</code>.
     */
    public ParticipantRecord setEmail(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.email</code>.
     */
    @Override
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.participant.affiliation</code>.
     */
    public ParticipantRecord setAffiliation(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.affiliation</code>.
     */
    @Override
    public String getAffiliation() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.participant.verification_token</code>.
     */
    public ParticipantRecord setVerificationToken(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.verification_token</code>.
     */
    @Override
    public String getVerificationToken() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.participant.order_number</code>.
     */
    public ParticipantRecord setOrderNumber(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.order_number</code>.
     */
    @Override
    public Integer getOrderNumber() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.participant.event_id</code>.
     */
    public ParticipantRecord setEventId(Long value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.event_id</code>.
     */
    @Override
    public Long getEventId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.participant.status</code>.
     */
    public ParticipantRecord setStatus(ParticipantStatus value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.status</code>.
     */
    @Override
    public ParticipantStatus getStatus() {
        return (ParticipantStatus) get(8);
    }

    /**
     * Setter for <code>public.participant.created_on</code>.
     */
    public ParticipantRecord setCreatedOn(Timestamp value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.created_on</code>.
     */
    @Override
    public Timestamp getCreatedOn() {
        return (Timestamp) get(9);
    }

    /**
     * Setter for <code>public.participant.updated_on</code>.
     */
    public ParticipantRecord setUpdatedOn(Timestamp value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.participant.updated_on</code>.
     */
    @Override
    public Timestamp getUpdatedOn() {
        return (Timestamp) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, String, String, Integer, Long, ParticipantStatus, Timestamp, Timestamp> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, String, String, Integer, Long, ParticipantStatus, Timestamp, Timestamp> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Participant.PARTICIPANT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Participant.PARTICIPANT.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Participant.PARTICIPANT.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Participant.PARTICIPANT.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Participant.PARTICIPANT.AFFILIATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Participant.PARTICIPANT.VERIFICATION_TOKEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Participant.PARTICIPANT.ORDER_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return Participant.PARTICIPANT.EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ParticipantStatus> field9() {
        return Participant.PARTICIPANT.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field10() {
        return Participant.PARTICIPANT.CREATED_ON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return Participant.PARTICIPANT.UPDATED_ON;
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
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getAffiliation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getVerificationToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getOrderNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantStatus component9() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component10() {
        return getCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getUpdatedOn();
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
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getAffiliation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getVerificationToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getOrderNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantStatus value9() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value10() {
        return getCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getUpdatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value3(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value4(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value5(String value) {
        setAffiliation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value6(String value) {
        setVerificationToken(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value7(Integer value) {
        setOrderNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value8(Long value) {
        setEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value9(ParticipantStatus value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value10(Timestamp value) {
        setCreatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord value11(Timestamp value) {
        setUpdatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParticipantRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, Integer value7, Long value8, ParticipantStatus value9, Timestamp value10, Timestamp value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    public void from(IParticipant from) {
        setId(from.getId());
        setFirstName(from.getFirstName());
        setLastName(from.getLastName());
        setEmail(from.getEmail());
        setAffiliation(from.getAffiliation());
        setVerificationToken(from.getVerificationToken());
        setOrderNumber(from.getOrderNumber());
        setEventId(from.getEventId());
        setStatus(from.getStatus());
        setCreatedOn(from.getCreatedOn());
        setUpdatedOn(from.getUpdatedOn());
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ParticipantRecord
     */
    public ParticipantRecord() {
        super(Participant.PARTICIPANT);
    }

    /**
     * Create a detached, initialised ParticipantRecord
     */
    public ParticipantRecord(Long id, String firstName, String lastName, String email, String affiliation, String verificationToken, Integer orderNumber, Long eventId, ParticipantStatus status, Timestamp createdOn, Timestamp updatedOn) {
        super(Participant.PARTICIPANT);

        set(0, id);
        set(1, firstName);
        set(2, lastName);
        set(3, email);
        set(4, affiliation);
        set(5, verificationToken);
        set(6, orderNumber);
        set(7, eventId);
        set(8, status);
        set(9, createdOn);
        set(10, updatedOn);
    }
}
