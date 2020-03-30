package org.sid;

import org.sid.dao.PatientRepository;
import org.sid.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class MvcTpApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(MvcTpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DateFormat dateFormat=new SimpleDateFormat();
        patientRepository.save(new Patient(null,"Anas",dateFormat.parse("03/06/1998"),false));
        patientRepository.save(new Patient(null,"Somoeone",dateFormat.parse("04/07/1999"),false));
        patientRepository.save(new Patient(null,"Personne",dateFormat.parse("05/08/2000"),false));
        patientRepository.findAll().forEach(patient -> {
            System.out.printf(patient.toString());
        });
    }
}
