package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import com.bridgelabz.employeepayrollapp.model.MailData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JavaMailSender mailSender;
    List<EmployeeData> employeeDataList = new ArrayList<>();
    @Override
    public List<EmployeeData> getEmployeeData() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeData getEmplyeeDataByID(int empID) {

        return employeeRepository.findById(empID).orElseThrow(() ->new EmployeeException("Employee with ID "+empID+" does not exist"));
    }

    @Override
    public EmployeeData createEmployeeData(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData(employeeDTO);
        log.debug("Emp data :"+employeeData.toString());
        return employeeRepository.save(employeeData);
    }

    @Override
    public EmployeeData updateEmployeeData(int empID, EmployeeDTO employeeDTO) {
        EmployeeData employeeData = this.getEmplyeeDataByID(empID);
        employeeData.updateEmployeeData(employeeDTO);
        return employeeRepository.save(employeeData);
    }

    @Override
    public void deleteEmployeeData(int empID) {
        EmployeeData employeeData = this.getEmplyeeDataByID(empID);
        employeeRepository.delete(employeeData);
    }
    @Override
    public List<EmployeeData> getEmployeeByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }

    /**
     * This method is used to send email using Java mail sender with attachment
     * @param mailData
     * @return
     */
    @Override
    public String sendEmail(MailData mailData) throws MessagingException {
        /**
         * This method is only to send email without attachment
         *         SimpleMailMessage message = new SimpleMailMessage();
         *         message.setFrom("smartsourav33@gmail.com");
         *         message.setTo(mailData.getToEmail());
         *         message.setText(mailData.getBody());
          *         message.setSubject(mailData.getSubject());
         *         mailSender.send(message);
         *         return "Mail has been sent";
         */
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("smartsourav33@gmail.com");
        mimeMessageHelper.setTo(mailData.getToEmail());
        mimeMessageHelper.setText(mailData.getBody());
        mimeMessageHelper.setSubject(mailData.getSubject());
        FileSystemResource fileSystem = new FileSystemResource(new File(mailData.getAttachment()));
        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
        mailSender.send(mimeMessage);
        return "Mail has been sent";
    }
}
