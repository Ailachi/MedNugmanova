INSERT INTO Admin(email, password) VALUES ('elvira', 'pomidor');

INSERT INTO Allergy(name) VALUES ('Citrus'), ('Nuts'), ('Dairy'), ('Fur'), ('Dust');


INSERT INTO Specialty(specName) VALUES ('General Practitioner'), ('Surgeon'), ('Cardiologist'),
                                        ('Dietitian'), ('Gastroenterologist'), ('Dentist'), ('OBGYN');

INSERT INTO patient(name, surname, email, password) VALUES
    ('Elvira', 'Nugmanova', 'elvira@gmail.com', '$2a$12$qdQoGH274ej6gau51qWCjueWq74zutsk.xH/3nAFgSqsy6m1G7Ifm'),
    ('Anuar', 'Borangaziyev', 'anuar@gmail.com', '$2a$12$AJjdlok8l2Oqby79ygIE9OEdXERZzJcP4mlMIwasSEWbhfB2Rph9O'),
    ('Vasya', 'Pupkin', 'vasya@gmail.com', '$2a$12$mgeLcz9q6NLDiATuebz96.KiiHKJBgjesgDfruV0DVJ0be31flBom');

INSERT INTO MedicalRecord(patientId, bloodType) VALUES (1, 'A+'), (2, 'B-'), (3, 'AB-');

INSERT INTO recordAllergy(recordId, allergyId) VALUES (1, 1), (1, 2);

INSERT INTO Doctor(name, surname, email, password, specialtyId) VALUES
    ('Jhon', 'Dorian', 'jd@gmail.com', 'eagle' ,1),
    ('Christopher', 'Turk', 'turk@gmail.com', '$2a$12$q9mO7CE9luMm6BfFIBdaMufYdTlnn83pKLiQ6xctC9DeJgrlMZIcm', 2),
    ('Kirill', 'Svetozarov', 'kirill.s@gmail.com', '$2a$12$GGCqzjZ5M2mGdUDalnflzOhwKqvpSIqGBecsIlTelOE8l81HXuZjy', 3),
    ('Perry', 'Cox', 'perryc@gmail.com', '$2a$12$bbEXbNc79c/z92clohnEtumZl5LW22pRqLAZOz3X0jyNsqrF3Ib9u', 4),
    ('Olga', 'Nugmanova', 'olga.n@gmail.com', '$2a$12$mBoW2oQTdBOPv5tS..mupeAKLGZpcY5EftSO8QcgjEgM7AAgBnU.C', 5),
    ('Ravil', 'Nugmanov', 'ravil.n@gmail.com', '$2a$12$4AthLgOOlAgTGZ4DsDiRAu9Xytgve8QIe8vCPCuHyG.9BTy1D.kBi', 6),
    ('Elliot', 'Reid', 'reid@gmail.com', '$2a$12$jSPA/eEnqTQBpORhc7JfO.Aw26qCnce6qoce.8VCUmpIgLi1qhrN.', 7);

INSERT INTO Appointment(appointdate, diagnosis, prescription, doctorid, patientid, recordid) VALUES
    ('21.05.2022', 'Skin cancer', 'Chemotherapy', 1, 3, 3),
    ('10.05.2022', 'Eczema', 'Cream at night, supplements', 4, 3, 3),
    ('09.05.2022', 'Flu', 'Vitamin C', 1, 1, 1);

INSERT INTO Donor(name, surname, bloodType) VALUES
    ('Elena', 'Kobyleva', 'O-'),
    ('Karima', 'Kinisheva', 'AB+'),
    ('Kevin', 'Kozner', 'B-'),
    ('Rassul', 'Krozhev', 'A+');

INSERT INTO donorshiptype(donorshiptypeid, name) VALUES (1, 'Blood'), (2, 'Eye');

INSERT INTO waitinglist(donorid, patientid, donorshiptypeid) VALUES (null, 1, 1), (null, 2, 1), (null, 3, 2);



