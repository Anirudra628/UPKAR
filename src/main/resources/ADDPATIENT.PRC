create or replace NONEDITIONABLE PROCEDURE ADDPATIENT (
                                       IN_USER_EMAIL IN VARCHAR2,
                                       IN_PATIENT_FNAME IN VARCHAR2,
                                       IN_PATIENT_LNAME IN VARCHAR2,
                                       IN_PATIENT_DOB   IN VARCHAR2,
                                       IN_PATIENT_GNDR   IN VARCHAR2,
                                       IN_RELATIONSHIP  IN VARCHAR2 DEFAULT 'SELF',
                                       SUCCESSCODE      OUT NUMBER
                                        ) AS

V_USER_ID SYSTEM.T_USERS.USER_ID%TYPE;
V_PATIENT_ID SYSTEM.T_PATIENTS.PATIENT_ID%TYPE;
V_USER_PATIENT_ID SYSTEM.T_USER_PATIENTS.USER_PATIENT_ID%TYPE;
ERR_MSG VARCHAR2(200);
V_DOB_DATE DATE;
BEGIN
  V_USER_ID := NULL;
  V_PATIENT_ID:= NULL;
  IF IN_USER_EMAIL IS NOT NULL THEN
        BEGIN
                SELECT TU.USER_ID 
                INTO V_USER_ID 
                FROM SYSTEM.T_USERS TU 
                WHERE TU.EMAIL = IN_USER_EMAIL;
        EXCEPTION WHEN OTHERS THEN
          V_USER_ID := NULL;
        END;

    insert into t_temp_log values ('got user id from ' || V_USER_ID);
        IF V_USER_ID IS NOT NULL THEN
           BEGIN

                     BEGIN
                     SELECT CAST(
                         TO_TIMESTAMP_TZ(
                           REPLACE(IN_PATIENT_DOB, 'IST', 'Asia/Kolkata'),
                           'Dy Mon DD HH24:MI:SS TZR YYYY',
                           'NLS_DATE_LANGUAGE=ENGLISH'
                         ) AS DATE
                       ) into V_DOB_DATE
                     FROM dual;
                        --V_DOB_DATE := TO_DATE(IN_PATIENT_DOB, 'DD/MM/YYYY');
                     EXCEPTION
                        WHEN OTHERS THEN
                        V_DOB_DATE := NULL; -- Or handle error accordingly
                     END;
                 SELECT SYSTEM.UPKAR_SEQUENCE.NEXTVAL
                 INTO V_PATIENT_ID
                  FROM DUAL;
    
                insert into system.t_temp_log values 
                (V_PATIENT_ID|| ' ' ||IN_PATIENT_FNAME || ' ' ||IN_PATIENT_LNAME || ' ' || IN_PATIENT_GNDR || ' ' || V_DOB_DATE || ' ' ||null || ' ' ||'active');
                 
                 INSERT INTO SYSTEM.T_PATIENTS 
                 (
                 PATIENT_ID,
                 FIRST_NAME,
                 LAST_NAME,
                 GENDER,
                 BIRTH_DATE,
                 MEDICAL_HISTORY,
                 STATUS
                 )
                 VALUES
                 (  V_PATIENT_ID,
                    IN_PATIENT_FNAME,
                    IN_PATIENT_LNAME,
                    IN_PATIENT_GNDR,
                    V_DOB_DATE,
                    NULL,
                    'Active'
                  );

                  SUCCESSCODE := 0;  
            EXCEPTION WHEN OTHERS THEN
                  ERR_MSG := SQLERRM;
                  SUCCESSCODE := 100;
            END;
            
            insert into t_temp_log values(err_msg);
            IF SUCCESSCODE = 0 THEN
                 BEGIN
                         SELECT SYSTEM.UPKAR_SEQUENCE.NEXTVAL
                         INTO V_USER_PATIENT_ID
                          FROM DUAL;
                          
                        insert into t_temp_log values('having user id '||v_user_id);

                         INSERT INTO SYSTEM.T_USER_PATIENTS 
                         (
                         USER_PATIENT_ID,
                         USER_ID,
                         PATIENT_ID,
                         RELATIONSHIP
                         )
                         VALUES
                         (  V_USER_PATIENT_ID,
                            V_USER_ID,
                            V_PATIENT_ID,
                            IN_RELATIONSHIP
                          );

                         SUCCESSCODE := 0;  
                EXCEPTION WHEN OTHERS THEN
                         ERR_MSG := SQLERRM;
                         SUCCESSCODE := 100;
                END;
                 insert into t_temp_log values(err_msg);
            

            END IF;

         END IF;

   ELSE
     SUCCESSCODE := 999;
   END IF;

EXCEPTION WHEN OTHERS THEN
   ERR_MSG := SQLERRM;
   SUCCESSCODE := 999;
END ADDPATIENT;
