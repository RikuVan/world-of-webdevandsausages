/*
 * This file is generated by jOOQ.
*/
package meta.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import meta.enums.EventStatus;
import meta.tables.Event;
import meta.tables.records.EventRecord;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class EventDao extends DAOImpl<EventRecord, meta.tables.pojos.Event, Long> {

    /**
     * Create a new EventDao without any configuration
     */
    public EventDao() {
        super(Event.EVENT, meta.tables.pojos.Event.class);
    }

    /**
     * Create a new EventDao with an attached configuration
     */
    public EventDao(Configuration configuration) {
        super(Event.EVENT, meta.tables.pojos.Event.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(meta.tables.pojos.Event object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchById(Long... values) {
        return fetch(Event.EVENT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public meta.tables.pojos.Event fetchOneById(Long value) {
        return fetchOne(Event.EVENT.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByName(String... values) {
        return fetch(Event.EVENT.NAME, values);
    }

    /**
     * Fetch records that have <code>sponsor IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchBySponsor(String... values) {
        return fetch(Event.EVENT.SPONSOR, values);
    }

    /**
     * Fetch records that have <code>contact IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByContact(String... values) {
        return fetch(Event.EVENT.CONTACT, values);
    }

    /**
     * Fetch records that have <code>date IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByDate(Timestamp... values) {
        return fetch(Event.EVENT.DATE, values);
    }

    /**
     * Fetch records that have <code>details IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByDetails(String... values) {
        return fetch(Event.EVENT.DETAILS, values);
    }

    /**
     * Fetch records that have <code>location IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByLocation(String... values) {
        return fetch(Event.EVENT.LOCATION, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByStatus(EventStatus... values) {
        return fetch(Event.EVENT.STATUS, values);
    }

    /**
     * Fetch records that have <code>max_participants IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByMaxParticipants(Integer... values) {
        return fetch(Event.EVENT.MAX_PARTICIPANTS, values);
    }

    /**
     * Fetch records that have <code>registration_opens IN (values)</code>
     */
    public List<meta.tables.pojos.Event> fetchByRegistrationOpens(Timestamp... values) {
        return fetch(Event.EVENT.REGISTRATION_OPENS, values);
    }
}
