package pl.michalkruczek.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.michalkruczek.server.dto.CompanyDto;
import pl.michalkruczek.server.model.Company;
import pl.michalkruczek.server.model.User;
import pl.michalkruczek.server.repository.CompanyRepository;
import pl.michalkruczek.server.repository.UserRepository;

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
    @Autowired
    public UserRepository userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCompany(@RequestBody CompanyDto companyDto) throws ParseException {

        Company company = new Company();

        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setNip(companyDto.getNip());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setEmail(companyDto.getEmail());
        company.setUserId(companyDto.getUserId());

        companyRepository.save(company);

        return "Success - add company [" + company.getName() + "].";
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
            companyDto.setUserId(company.getUserId());

            companyDtoList.add(companyDto);
        }

        return companyDtoList;
    }

    @RequestMapping("/user/{login}")
    public List<CompanyDto> allCompanysByUser(@PathVariable String login) {

        Long userId = userRepository.findByLogin(login).getId();

        List<Company> companyList = companyRepository.findByUserId(userId);
        List<CompanyDto> companyDtoList = new ArrayList<CompanyDto>();

        for (Company company : companyList) {
            CompanyDto companyDto = new CompanyDto();
            companyDto.setId(company.getId());
            companyDto.setName(company.getName());
            companyDto.setNip(company.getNip());
            companyDto.setAddress(company.getAddress());
            companyDto.setPhone(company.getPhone());
            companyDto.setEmail(company.getEmail());
            companyDto.setUserId(company.getUserId());

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
        companyDto.setUserId(company.getUserId());

        return companyDto;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateCompany(@PathVariable long id, @RequestBody CompanyDto companyDto) {

        Company company = companyRepository.findOne(id);

        company.setName(companyDto.getName());
        company.setNip(companyDto.getNip());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setEmail(companyDto.getEmail());
        company.setUserId(companyDto.getUserId());

        companyRepository.save(company);

        return "Update company [" + company.getName() + "].";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCompany(@PathVariable long id) {

        String comapnyName = companyRepository.findOne(id).getName();

        companyRepository.delete(id);

        return "Delete company [" + comapnyName + "].";
    }


}
