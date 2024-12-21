package com.prx.persistence.general.util;

/**
 * Utility class that contains constants used throughout the persistence layer of the application.
 * This class is final and cannot be instantiated.
 */
public final class ConstantPersistenceApp {

    /** PostgreSQL function to generate UUIDs. */
    public static final String PG_UUID_FUNCTION = "general.uuid_generate_v4()";

    /** The schema name used in the database. */
    public static final String SCHEMA_NAME = "general";

    /** The name of the address table. */
    public static final String ADDRESS_TABLE_NAME = "address";
    /** The name of the contact table. */
    public static final String CONTACT_TABLE_NAME = "contact";
    /** The name of the contact type table. */
    public static final String CONTACT_TYPE_TABLE_NAME = "contact_type";
    /** The name of the feature table. */
    public static final String FEATURE_TABLE_NAME = "feature";
    /** The name of the identification document table. */
    public static final String IDENTIFICATION_DOCUMENT_TABLE_NAME = "identification_document";
    /** The name of the person table. */
    public static final String PERSON_TABLE_NAME = "person";
    /** The name of the role table. */
    public static final String ROLE_TABLE_NAME = "role";
    /** The name of the role feature table. */
    public static final String ROLE_FEATURE_TABLE_NAME = "role_feature";
    /** The name of the application table. */
    public static final String APPLICATION_TABLE_NAME = "application";
    /** The name of the user table. */
    public static final String USER_TABLE_NAME = "user";
    /** The name of the user role table. */
    public static final String APPLICATION_ROLE_USER_TABLE_NAME = "application_role_user";

    /** The column name for the ID field. */
    public static final String ID_CN = "id";
    /** The column name for the name field. */
    public static final String NAME_CN = "name";
    /** The column name for the active field. */
    public static final String ACTIVE_CN = "active";
    /** The column name for the description field. */
    public static final String DESCRIPTION_CN = "description";

    /**
     * Private constructor to prevent instantiation.
     */
    private ConstantPersistenceApp() {
        // Default constructor
    }
}
