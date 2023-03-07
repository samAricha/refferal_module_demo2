package teka.web.refferal_module_demo2.services;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.web.refferal_module_demo2.models.Hospital;
import teka.web.refferal_module_demo2.models.HospitalLevel;
import teka.web.refferal_module_demo2.models.users.Person;
import teka.web.refferal_module_demo2.models.users.Physician;
import teka.web.refferal_module_demo2.models.users.Secretary;
import teka.web.refferal_module_demo2.models.utils.Encounter;
import teka.web.refferal_module_demo2.models.utils.Observation;
import teka.web.refferal_module_demo2.repositories.HospitalRepository;
import teka.web.refferal_module_demo2.repositories.users.PersonRepository;
import teka.web.refferal_module_demo2.repositories.users.PhysicianRepository;
import teka.web.refferal_module_demo2.repositories.users.SecretaryRepository;
import teka.web.refferal_module_demo2.repositories.utils.EncounterRepository;
import teka.web.refferal_module_demo2.repositories.utils.ObservationRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class CoreFakePersonsDataService {


    private final PersonRepository personRepository;
    private final PhysicianRepository physicianRepository;
    private final SecretaryRepository secretaryRepository;
    private final HospitalRepository hospitalRepository;
    private final EncounterRepository encounterRepository;
    private final ObservationRepository observationRepository;
    private final Faker faker;

    @Autowired
    public CoreFakePersonsDataService(PersonRepository personRepository,
                               PhysicianRepository physicianRepository,
                               SecretaryRepository secretaryRepository,
                               HospitalRepository hospitalRepository,
                               EncounterRepository encounterRepository,
                               ObservationRepository observationRepository) {
        this.personRepository = personRepository;
        this.physicianRepository = physicianRepository;
        this.secretaryRepository = secretaryRepository;
        this.hospitalRepository = hospitalRepository;
        this.encounterRepository = encounterRepository;
        this.observationRepository = observationRepository;
        this.faker = new Faker();
    }


    public void generateFakeData() {
        List<Hospital> hospitals = new ArrayList<>();
        hospitals = hospitalRepository.findAll();
        // Generate hospitals
//        List<Hospital> hospitals = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Hospital hospital = new Hospital();
//            hospitalRepository.save(hospital);
//            hospitals.add(hospital);
//        }

        // Generate persons
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Person person = new Person();
            person.setUsername(faker.name().username());
            person.setIdNumber((int)faker.number().randomNumber());
            person.setGender(faker.options().option("Male", "Female"));
            personRepository.save(person);
            persons.add(person);
        }

        // Generate physicians
        List<Physician> physicians = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Physician physician = new Physician();
            physician.setPerson(persons.get(faker.number().numberBetween(0, persons.size())));
            physician.setSpeciality(faker.options().option("Cardiologist", "Neurologist", "Pediatrician"));
            physicianRepository.save(physician);
            physicians.add(physician);
        }

        // Generate secretaries
        List<Secretary> secretaries = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Secretary secretary = new Secretary();
            secretary.setPerson(persons.get(faker.number().numberBetween(0, persons.size())));
            secretary.setPosition(faker.options().option("Receptionist", "Secretary"));
            secretaryRepository.save(secretary);
            secretaries.add(secretary);
        }

        // Generate encounters and observations
        for (int i = 0; i < 200; i++) {
            Person patient = persons.get(faker.number().numberBetween(0, persons.size()));
            Hospital hospital = hospitals.get(faker.number().numberBetween(0, hospitals.size()));
            Physician physician = physicians.get(faker.number().numberBetween(0, physicians.size()));
            //setting up encounter
            Encounter encounter = new Encounter();
            encounter.setPatient(patient);
            encounter.setHospital(hospital);
            encounter.setPhysician(physician);
            encounterRepository.save(encounter);
            //setting up observation
            for (int j = 0; j < faker.number().numberBetween(1, 10); j++) {
                Observation observation = new Observation();
                observation.setPerson(patient);
                observation.setEncounter(encounter);
                observation.setObservation(faker.lorem().word());
                observationRepository.save(observation);
            }
        }
    }


}
