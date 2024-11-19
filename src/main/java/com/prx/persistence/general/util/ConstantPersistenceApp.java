package com.prx.persistence.general.util;

public final class ConstantPersistenceApp {

    public static final String PG_UUID_FUNCTION = "general.uuid_generate_v4()";

    public static final String SCHEMA_NAME = "general";

    public static final String ADDRESS_TABLE_NAME = "address";
    public static final String CONTACT_TABLE_NAME = "contact";
    public static final String CONTACT_TYPE_TABLE_NAME = "contact_type";
    public static final String FEATURE_TABLE_NAME = "feature";
    public static final String IDENTIFICATION_DOCUMENT_TABLE_NAME = "identification_document";
    public static final String PERSON_TABLE_NAME = "person";
    public static final String ROLE_TABLE_NAME = "role";
    public static final String ROLE_FEATURE_TABLE_NAME = "role_feature";
    public static final String SERVICE_TABLE_NAME ="service";
    public static final String USER_TABLE_NAME = "user";
    public static final String USER_ROLE_TABLE_NAME ="user_role";

    public static final String ID_CN = "id";
    public static final String NAME_CN = "name";
    public static final String ACTIVE_CN = "active";
    public static final String DESCRIPTION_CN = "description";

    private ConstantPersistenceApp() {
        //Default constructor
    }
}
