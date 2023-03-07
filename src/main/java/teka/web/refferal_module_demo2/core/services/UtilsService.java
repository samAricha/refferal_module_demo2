//package teka.web.refferal_module_demo2.services;
//
//import teka.web.refferal_module_demo2.models.Hospital;
//import teka.web.refferal_module_demo2.models.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UtilsService {
//
//
//
//
//
//    //THIS DATA IS FOR BACKUP
//
//
//
//
//    private static final String[] LEVEL_1_SERVICES = {"Treatment of minor ailments like diarrhea",
//            "Tuberculosis (TB) screening, home visits, contact tracing of TB patients and tracing of TB defaulters",
//            "Screening of malnutrition", "Malaria rapid test", "Blood pressure and blood sugar testing",
//            "HIV testing", "Health talks with pregnant women and observations of signs of danger",
//            "Issuance of referral letters to other facilities"};
//
//    private static final String[] LEVEL_2_SERVICES = {"Outpatient services", "VCT services", "Tuberculosis services",
//            "Laboratory Services", "Well baby Clinics", "Antenatal and Postnatal services", "Pharmacy",
//            "Counselling services", "Curative treatment", "Issuance of referral letters to other facilities"};
//
//    private static final String[] LEVEL_3_SERVICES = {"Maternity in-patient services with a ward", "Curative services",
//            "Laboratory services", "Dental", "Counselling", "Pharmacy", "TB Clinics", "Diabetes & hypertension clinics",
//            "Comprehensive care clinics for patients living with HIV", "Baby well clinics",
//            "Antenatal and postnatal services", "Issuance of referral letters to other facilities"};
//
//    private static final String[] LEVEL_4_SERVICES = {"X-Ray services", "Issuance of referral letters to other facilities"};
//
//    private static final String[] LEVEL_5_SERVICES = {"Ultrasound", "CT-Scan", "Surgery", "Pharmacy", "Physiotherapy",
//            "Orthopaedics", "Issuance of referral letters to other facilities"};
//
//    private static final String[] LEVEL_6_SERVICES = {"Specialised treatments", "Issuance of referral letters to other facilities"};
//
//
//    // Generate services for each hospital level
//    private List<Service> generateServices(List<Hospital> hospitals) {
//        List<Service> services = new ArrayList<>();
//
//        for (Hospital hospital : hospitals) {
//            String hospitalLevelName = hospital.getLevel().getName();
//
//            for (String serviceName : getServiceNamesByLevelName(hospitalLevelName)) {
//                Service service = new Service();
//                service.setName(serviceName);
//                service.setLevel(hospital.getLevel());
//                services.add(service);
//            }
//        }
//
//        return services;
//    }
//
//
//
//}
