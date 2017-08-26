package pl.michalkruczek.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.michalkruczek.server.dto.CompanyDto;
import pl.michalkruczek.server.model.Company;
import pl.michalkruczek.server.repository.CompanyRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikr on 26/08/17.
 */
@RestController
public class CompanyController {

    @Autowired
    public CompanyRepository companyRepository;

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public String addCompany(ModelMap modelMap, @RequestBody CompanyDto companyDto) throws ParseException {

        Company company = new Company();

        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setNip(companyDto.getNip());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setEmail(companyDto.getEmail());

        companyRepository.save(company);

        return "Add Company - Success";
    }

    @RequestMapping("/company")
    public List<CompanyDto> company() {
        List<Company> companyList = companyRepository.findAll();
        List<CompanyDto> companyDtoList = new ArrayList<CompanyDto>();

        for (Company company : companyList) {
            CompanyDto companyDto = new CompanyDto();
            companyDto.setId(company.getId());
            companyDto.setName(company.getName());
            companyDto.setNip(company.getNip());
            companyDto.setAddress(company.getAddress());
            companyDto.setPhone(company.getPhone());
            companyDto.setEmail(company.getEmail());
            companyDtoList.add(companyDto);
        }

        return companyDtoList;
    }

    @RequestMapping("/company/{id}")
    public CompanyDto singleCompany(@PathVariable int id) {
        Company company = companyRepository.findAll().get(id);

            CompanyDto companyDto = new CompanyDto();
            companyDto.setId(company.getId());
            companyDto.setName(company.getName());
            companyDto.setNip(company.getNip());
            companyDto.setAddress(company.getAddress());
            companyDto.setPhone(company.getPhone());
            companyDto.setEmail(company.getEmail());


        return companyDto;
    }

    @RequestMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable long id){
        companyRepository.delete(id);

        return "Delete company - success";
    }

    //TODO - company Update method

}
