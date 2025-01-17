package com.example.casestudymodule4.controller;

import com.example.casestudymodule4.model.Company;
import com.example.casestudymodule4.model.ProgramingLanguage;
import com.example.casestudymodule4.service.ext.ICityService;
import com.example.casestudymodule4.service.ext.ICompanyService;
import com.example.casestudymodule4.service.ext.IProgramingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/homes")
public class HomeController
{
    @Autowired
    private ICityService cityService;


    @Autowired
    private ICompanyService companyService;


    @Autowired
    private IProgramingLanguageService programingLanguageService;


    @GetMapping("/cityCount")
    public ResponseEntity<Integer> branchCount()
    {
        return new ResponseEntity<>(cityService.branchCount(), HttpStatus.OK);
    }
    @GetMapping("/companyCount")
    public ResponseEntity<Integer> cityCount()
    {
        return new ResponseEntity<>(companyService.companyCount(), HttpStatus.OK);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> companyList()
    {
        List<Company> companies = (List<Company>) companyService.findAll();

        if (companies.size() == 0)
        {
            return new ResponseEntity<>(companies, HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(companies, HttpStatus.OK);
        }
    }
    @GetMapping("/programmingLanguage")
    public ResponseEntity<List<ProgramingLanguage>> programmingLanguageList()
    {
        List<ProgramingLanguage> programingLanguages = (List<ProgramingLanguage>) programingLanguageService.findAll();

        if (programingLanguages.size() == 0)
        {
            return new ResponseEntity<>(programingLanguages, HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(programingLanguages, HttpStatus.OK);
        }
    }
    @GetMapping("/citiesSearchByName")
    public ResponseEntity<List<String>> cityListByNameSearch(@RequestParam("searchLocation") String cityName)
    {
        List<String> cities = (List<String>) cityService.findAllCitiesBySearchName(cityName);

        if (cities.size() == 0)
        {
            return new ResponseEntity<>(cities, HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(cities, HttpStatus.OK);
        }
    }

}
