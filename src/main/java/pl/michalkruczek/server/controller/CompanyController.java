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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    public CompanyRepository companyRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCompany(@RequestBody CompanyDto companyDto) throws ParseException {

        Company company = new Company();

        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setNip(companyDto.getNip());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setEmail(companyDto.getEmail());

        companyRepository.save(company);

        return "Success - add product [" + company.getName() + "].";
    }

    @RequestMapping("/all")
    public List<CompanyDto> allCompanys() {
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

    @RequestMapping("/{id}")
    public CompanyDto singleCompany(@PathVariable long id) {
        Company company = companyRepository.findOne(id);

        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setNip(company.getNip());
        companyDto.setAddress(company.getAddress());
        companyDto.setPhone(company.getPhone());
        companyDto.setEmail(company.getEmail());

        return companyDto;
    }

    @RequestMapping(value = "/updata/{id}", method = RequestMethod.PUT)
    public String updataCompany(@PathVariable long id, @RequestBody CompanyDto companyDto) {

        Company company = companyRepository.findOne(id);

        company.setName(companyDto.getName());
        company.setNip(companyDto.getNip());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setEmail(companyDto.getEmail());

        companyRepository.save(company);

        return "Updata company [" + company.getName() + "].";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCompany(@PathVariable long id) {

        String comapnyName = companyRepository.findOne(id).getName();

        companyRepository.delete(id);

        return "Delete company [" + comapnyName + "].";
    }


}
