package teka.web.refferal_module_demo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import teka.web.refferal_module_demo2.models.Hospital;
import teka.web.refferal_module_demo2.models.HospitalLevel;
import teka.web.refferal_module_demo2.models.Service;
import teka.web.refferal_module_demo2.repositories.HospitalLevelRepository;
import teka.web.refferal_module_demo2.repositories.HospitalRepository;
import teka.web.refferal_module_demo2.repositories.ServiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@org.springframework.stereotype.Service
public class FakeHospitalDataService {

    private final HospitalRepository hospitalRepository;
    private final HospitalLevelRepository hospitalLevelRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public FakeHospitalDataService(HospitalRepository hospitalRepository,
                                   HospitalLevelRepository hospitalLevelRepository,
                                   ServiceRepository serviceRepository) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalLevelRepository = hospitalLevelRepository;
        this.serviceRepository = serviceRepository;
    }

    private static final int MAX_LEVEL = 6;
    private static final String[] LEVEL_NAMES = {"Community Facilities", "Health Dispensaries", "Health Centres",
            "County Hospitals", "County Referral Hospitals", "National Referral Hospitals"};


    // Generate fake hospital data
    public List<Hospital> generateFakeData(int numHospitals) {


        List<HospitalLevel> hospitalLevels = generateHospitalLevels();
        List<Service> services = generateServicesForLevels(hospitalLevels);



        List<Hospital> hospitals = new ArrayList<>();
        for (int i = 1; i <= numHospitals; i++) {
            Hospital hospital = new Hospital();
            hospital.setName("Hospital " + i);
            hospital.setLevel(getRandomHospitalLevel());
            hospitals.add(hospital);
        }

        // Save hospitals to database
        hospitalRepository.saveAll(hospitals);

        return hospitals;
    }



    // Generate hospital levels
    private List<HospitalLevel> generateHospitalLevels() {
        List<HospitalLevel> hospitalLevels = new ArrayList<>();

        for (int i = 0; i < MAX_LEVEL; i++) {
            HospitalLevel level = new HospitalLevel();
            level.setLevel(i + 1);
            level.setName(LEVEL_NAMES[i]);

            hospitalLevels.add(level);
        }

        //added
        hospitalLevelRepository.saveAll(hospitalLevels);


        return hospitalLevels;
    }



    // Get a random hospital level
    private HospitalLevel getRandomHospitalLevel() {
        Random random = new Random();
        int index = random.nextInt(MAX_LEVEL);
        HospitalLevel level = new HospitalLevel();
        level.setLevel(index + 1);
        level.setName(LEVEL_NAMES[index]);

        return level;
    }



    // Generate services for each hospital level
    private List<Service> generateServicesForLevels(List<HospitalLevel> hospitalLevels) {
        List<Service> services = new ArrayList<>();

        for (HospitalLevel hospitalLevel : hospitalLevels) {
            String hospitalLevelName = hospitalLevel.getName();

            for (String serviceName : getServiceNamesByLevelName(hospitalLevelName)) {
                Service service = new Service();
                service.setName(serviceName);
                service.setLevel(hospitalLevel);
                services.add(service);
            }
        }

        serviceRepository.saveAll(services);

        return services;
    }





    // Get service names for a given hospital level name
    private String[] getServiceNamesByLevelName(String levelName) {
        switch (levelName) {
            case "Community Facilities":
                return new String[] {
                        "Treatment of minor ailments like diarrhea",
                        "Tuberculosis (TB) screening",
                        "Home visits",
                        "Contact tracing of TB patients",
                        "Tracing of TB defaulters",
                        "Screening of malnutrition",
                        "Malaria rapid test",
                        "Blood pressure and blood sugar testing",
                        "HIV testing",
                        "Health talks with pregnant women",
                        "Observations of signs of danger",
                        "Issuance of referral letters to other facilities"
                };
            case "Health Dispensaries":
                return new String[] {
                        "Outpatient services",
                        "VCT services",
                        "Tuberculosis services",
                        "Laboratory Services",
                        "Well baby clinics",
                        "Antenatal and postnatal services",
                        "Pharmacy",
                        "Counseling services",
                        "Curative treatment",
                        "Issuance of referral letters to other facilities"
                };
            case "Health Centres":
                return new String[] {
                        "Maternity in-patient services with a ward",
                        "Curative services",
                        "Laboratory services",
                        "Dental",
                        "Counseling",
                        "Pharmacy",
                        "TB Clinics",
                        "Diabetes and hypertension clinics",
                        "Comprehensive care clinics for patients living with HIV",
                        "Baby well clinics",
                        "Antenatal and postnatal services",
                        "Issuance of referral letters to other facilities"
                };
            case "County Hospitals":
                return new String[] {
                        "Maternity in-patient services with a ward",
                        "Curative services",
                        "Laboratory services",
                        "Dental",
                        "Counseling",
                        "Pharmacy",
                        "TB Clinics",
                        "Diabetes and hypertension clinics",
                        "Comprehensive care clinics for patients living with HIV",
                        "Baby well clinics",
                        "Antenatal and postnatal services",
                        "X-Ray services",
                        "Issuance of referral letters to other facilities"
                };
            case "County Referral Hospitals":
                return new String[] {
                        "Ultrasound",
                        "CT-Scan",
                        "Surgery",
                        "Pharmacy",
                        "Physiotherapy",
                        "Orthopaedics",
                        "Occupational Therapy",
                        "Maternity in-patient services with a ward",
                        "Curative services",
                        "Laboratory services",
                        "Dental",
                        "Counseling",
                        "TB Clinics",
                        "Diabetes and hypertension clinics",
                        "Comprehensive care clinics for patients living with HIV",
                        "Baby well clinics",
                        "Antenatal and postnatal services",
                        "X-Ray services",
                        "Issuance of referral letters to other facilities"
                };
            case "National Referral Hospitals":
                return new String[] {
                        "Ultrasound",
                        "CT-Scan",
                        "Surgery",
                        "Pharmacy",
                        "Physiotherapy",
                        "Orthopaedics",
                        "Occupational Therapy",
                        "Maternity in-patient services with a ward",
                        "Curative services",
                        "Laboratory services",
                        "Dental",
                        "Counseling",
                        "TB Clinics",
                        "Diabetes and hypertension clinics",
                        "Comprehensive care clinics for patients living with HIV",
                        "Baby well clinics",
                        "Antenatal and postnatal services",
                        "Specialized treatments for various medical conditions",
                        "Research and education programs",
                        "Emergency services",
                        "Radiology services",
                        "Anesthesiology services",
                        "Intensive care services",
                        "Surgical specialties",
                        "Pediatrics",
                        "Neonatology",
                        "Oncology",
                        "Cardiology",
                        "Neurology",
                        "Psychiatry",
                        "Rehabilitation services",
                        "Pain management services",
                        "Nutrition and dietetics services",
                        "Social work services",
                        "Chaplaincy services",
                        "Pharmaceutical services",
                        "Blood bank services",
                        "Ambulance services",
                        "Outpatient services",
                        "VCT services",
                        "Home-based care services",
                        "Patient education and support services",
                        "Clinical trials and research programs"
                };
            default:
                return new String[0];

        }
    }

}
