# Medical Unit application #
# Nugmanova Elvira ITSE-1909R Variant 1#

## _What's included?_ ##

## POSTMAN COLLECTION IS IN THE RESOURCES PACKAGE ##
### ◯  Basic class entities like Patient, Doctor, Admin, etc. ###
### ◯  i18n is added into the bundle messages and implemented in every controller (type a / address to see information in Spanish and English about the controller) ### 
### ◯  Doctor contains postConstruct and preDestroy methods ###
### ◯  Setting default values via doctor.properties in DoctorConfig ### 
### ◯  Native Queries are used in the Patient, Donor and Admin Repository ### 
### ◯  SpEL is used in the Doctor Repository ### 
### ◯  Named Query is used in the Doctor class ### 
### ◯  Scheduled methods are in AdminService (updating waiting list for patients who don't have donors) ### 
### ◯  Reading and Writing HTTP headers in AdminController -> getPatientByEmailAndPassword() and getAllDonorsByBlood() ### 
### ◯  AOP (in a folder AOP) logs every error into a specially made Table called ErrorLog. Mostly applied to Service classes ### 
### ◯  Cache Config is related to patients, donors and doctors Services ### 
### ◯  JSR-349 is used in Patient/Appointment class ### 
### ◯  Transactionality(with properties)/Locking in Admin Service and Doctor Service ### 
### ◯  Auditing is used in Donor class ###
### ◯  ReflectionTestUtils are used in Admin Test ### 
### ◯  Spring Security and Basic Auth is in Security and Configuration packages ### 
### ◯  JMS Service is available in the Doctor and Patient Controller ### 
### ◯  Spring Security and Basic Auth are included ### 
### ◯  Test Line Coverage: 72% ###


## Please, note! ##
## Before running an application create a database named "MedNugmanova" and change password for the postgresql page with your own ##
### Then the application will work without any issues :^) ###
