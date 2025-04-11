INSERT INTO SYSTEM.T_USERS (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS) 
VALUES (1005, 'Liam', 'Johnson', 'liam.johnson@example.com', '9898989898', 'CC');

INSERT INTO SYSTEM.T_USERS (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS) 
VALUES (1006, 'Olivia', 'Martin', 'olivia.martin@example.com', '9765432101', 'DD');

INSERT INTO SYSTEM.T_USERS (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS) 
VALUES (1007, 'Noah', 'Anderson', 'noah.anderson@example.com', '9551122334', 'EE');

INSERT INTO SYSTEM.T_USERS (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS) 
VALUES (1008, 'Ava', 'Walker', 'ava.walker@example.com', '9234567890', 'FF');

INSERT INTO SYSTEM.T_PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, MEDICAL_HISTORY, STATUS)
VALUES (3005, 'Liam', 'Johnson', 'Male', TO_DATE('1991-02-10', 'YYYY-MM-DD'), EMPTY_BLOB(), 'Active');

INSERT INTO SYSTEM.T_PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, MEDICAL_HISTORY, STATUS)
VALUES (3006, 'Olivia', 'Martin', 'Female', TO_DATE('1996-07-19', 'YYYY-MM-DD'), EMPTY_BLOB(), 'Active');

INSERT INTO SYSTEM.T_PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, MEDICAL_HISTORY, STATUS)
VALUES (3007, 'Noah', 'Anderson', 'Male', TO_DATE('1985-12-05', 'YYYY-MM-DD'), EMPTY_BLOB(), 'Inactive');

INSERT INTO SYSTEM.T_PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, MEDICAL_HISTORY, STATUS)
VALUES (3008, 'Ava', 'Walker', 'Female', TO_DATE('1993-04-30', 'YYYY-MM-DD'), EMPTY_BLOB(), 'Active');


INSERT INTO SYSTEM.T_DOCTORS (DOCTOR_ID, FIRST_NAME, LAST_NAME, PASSWORD, DEGREE, SPECIALIZATION, REGISTRATION_ID, PHONE, ADDRESS, STATUS, FEES) 
VALUES (5005, 'James', 'Taylor', 'hashed_pass_6', 'MBBS, MS', 'ENT', 'REG234567', '9111122233', 'CC', 'Active', 700);

INSERT INTO SYSTEM.T_DOCTORS (DOCTOR_ID, FIRST_NAME, LAST_NAME, PASSWORD, DEGREE, SPECIALIZATION, REGISTRATION_ID, PHONE, ADDRESS, STATUS, FEES) 
VALUES (5006, 'Emily', 'Thomas', 'hashed_pass_7', 'MBBS', 'Pediatrician', 'REG345678', '9223344556', 'DD', 'Active', 650);

INSERT INTO SYSTEM.T_DOCTORS (DOCTOR_ID, FIRST_NAME, LAST_NAME, PASSWORD, DEGREE, SPECIALIZATION, REGISTRATION_ID, PHONE, ADDRESS, STATUS, FEES) 
VALUES (5007, 'William', 'White', 'hashed_pass_8', 'MBBS, MD', 'Psychiatrist', 'REG456789', '9334455667', 'EE', 'Active', 900);

INSERT INTO SYSTEM.T_DOCTORS (DOCTOR_ID, FIRST_NAME, LAST_NAME, PASSWORD, DEGREE, SPECIALIZATION, REGISTRATION_ID, PHONE, ADDRESS, STATUS, FEES) 
VALUES (5008, 'Sophia', 'Hall', 'hashed_pass_9', 'MBBS, DGO', 'Gynecologist', 'REG567890', '9445566778', 'FF', 'Active', 850);


INSERT INTO SYSTEM.T_LOCATION_DETAIL (LOCATION_ID, NAME, TYPE, ADDRESS)
VALUES (4005, 'CarePlus Clinic', 'Clinic', 'CC');

INSERT INTO SYSTEM.T_LOCATION_DETAIL (LOCATION_ID, NAME, TYPE, ADDRESS)
VALUES (4006, 'Metro Health Hospital', 'Hospital', 'DD');

INSERT INTO SYSTEM.T_LOCATION_DETAIL (LOCATION_ID, NAME, TYPE, ADDRESS)
VALUES (4007, 'Elite Health Center', 'Clinic', 'EE');

INSERT INTO SYSTEM.T_LOCATION_DETAIL (LOCATION_ID, NAME, TYPE, ADDRESS)
VALUES (4008, 'Wellbeing Hospital', 'Hospital', 'FF');



INSERT INTO SYSTEM.T_SLOT_MASTER_DATA (SLOT_ID, SLOT_DATE, START_TIME, END_TIME, SLOT_STATUS)
VALUES (6005, TO_DATE('2025-04-14', 'YYYY-MM-DD'), TO_TIMESTAMP('09:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('10:00:00', 'HH24:MI:SS'), 'Available');

INSERT INTO SYSTEM.T_SLOT_MASTER_DATA (SLOT_ID, SLOT_DATE, START_TIME, END_TIME, SLOT_STATUS)
VALUES (6006, TO_DATE('2025-04-15', 'YYYY-MM-DD'), TO_TIMESTAMP('10:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('11:00:00', 'HH24:MI:SS'), 'Booked');

INSERT INTO SYSTEM.T_SLOT_MASTER_DATA (SLOT_ID, SLOT_DATE, START_TIME, END_TIME, SLOT_STATUS)
VALUES (6007, TO_DATE('2025-04-16', 'YYYY-MM-DD'), TO_TIMESTAMP('11:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('12:00:00', 'HH24:MI:SS'), 'Available');

INSERT INTO SYSTEM.T_SLOT_MASTER_DATA (SLOT_ID, SLOT_DATE, START_TIME, END_TIME, SLOT_STATUS)
VALUES (6008, TO_DATE('2025-04-17', 'YYYY-MM-DD'), TO_TIMESTAMP('12:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('13:00:00', 'HH24:MI:SS'), 'Available');

INSERT INTO SYSTEM.T_APPOINTMENTS (APPOINTMENT_ID, PATIENT_ID, BOOKED_BY_USER_ID, DOCTOR_ID, SLOT_ID, LOCATION_ID, APPOINTMENT_DATE, STATUS)
VALUES (7005, 3005, 1005, 5005, 6005, 4005, TO_DATE('2025-04-14', 'YYYY-MM-DD'), 'Confirmed');

INSERT INTO SYSTEM.T_APPOINTMENTS (APPOINTMENT_ID, PATIENT_ID, BOOKED_BY_USER_ID, DOCTOR_ID, SLOT_ID, LOCATION_ID, APPOINTMENT_DATE, STATUS)
VALUES (7006, 3006, 1006, 5006, 6006, 4006, TO_DATE('2025-04-15', 'YYYY-MM-DD'), 'Pending');

INSERT INTO SYSTEM.T_APPOINTMENTS (APPOINTMENT_ID, PATIENT_ID, BOOKED_BY_USER_ID, DOCTOR_ID, SLOT_ID, LOCATION_ID, APPOINTMENT_DATE, STATUS)
VALUES (7007, 3007, 1007, 5007, 6007, 4007, TO_DATE('2025-04-16', 'YYYY-MM-DD'), 'Cancelled');

INSERT INTO SYSTEM.T_APPOINTMENTS (APPOINTMENT_ID, PATIENT_ID, BOOKED_BY_USER_ID, DOCTOR_ID, SLOT_ID, LOCATION_ID, APPOINTMENT_DATE, STATUS)
VALUES (7008, 3008, 1008, 5008, 6008, 4008, TO_DATE('2025-04-17', 'YYYY-MM-DD'), 'Confirmed');

INSERT INTO SYSTEM.T_USER_PATIENTS (USER_PATIENT_ID, USER_ID, PATIENT_ID, RELATIONSHIP)
VALUES (8007, 1005, 3005, 'Self');

INSERT INTO SYSTEM.T_USER_PATIENTS (USER_PATIENT_ID, USER_ID, PATIENT_ID, RELATIONSHIP)
VALUES (8008, 1006, 3006, 'Self');

INSERT INTO SYSTEM.T_USER_PATIENTS (USER_PATIENT_ID, USER_ID, PATIENT_ID, RELATIONSHIP)
VALUES (8009, 1007, 3007, 'Spouse');

INSERT INTO SYSTEM.T_USER_PATIENTS (USER_PATIENT_ID, USER_ID, PATIENT_ID, RELATIONSHIP)
VALUES (8010, 1008, 3008, 'Spouse');



commit;