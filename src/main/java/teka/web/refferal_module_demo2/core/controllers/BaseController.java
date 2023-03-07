package teka.web.refferal_module_demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teka.web.refferal_module_demo2.services.CoreFakePersonsDataService;
import teka.web.refferal_module_demo2.services.FakeHospitalDataService;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private FakeHospitalDataService fakeHospitalDataService;
    @Autowired
    private CoreFakePersonsDataService coreFakePersonsDataService;

    @GetMapping("home")
    public String home() {

        fakeHospitalDataService.generateFakeData(45);

        return "data generated";
    }


    @GetMapping("core")
    public String core() {

        coreFakePersonsDataService.generateFakeData();

        return "data generated";
    }
}
