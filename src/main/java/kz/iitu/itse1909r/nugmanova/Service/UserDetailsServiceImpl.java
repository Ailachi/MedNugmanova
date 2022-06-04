package kz.iitu.itse1909r.nugmanova.Service;


import kz.iitu.itse1909r.nugmanova.Database.Admin;
import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.Repository.AdminRepository;
import kz.iitu.itse1909r.nugmanova.Repository.DoctorRepository;
import kz.iitu.itse1909r.nugmanova.Repository.DonorRepository;
import kz.iitu.itse1909r.nugmanova.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private DoctorRepository doctorRepository;
    private AdminRepository adminRepository;
    private PatientRepository patientRepository;
    private DonorRepository donorRepository;


    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Autowired
    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Autowired
    public void setDonorRepository(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }


    public UserDetailsServiceImpl(){}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient = patientRepository.getPatientByEmail(username);
        Admin admin = adminRepository.getAdminByEmail(username);
        Doctor doctor = doctorRepository.findDoctorByEmail(username);


        UserDetails ud = null;
        if (doctor != null) {
            ud = getUserDetails(doctor.getEmail(), doctor.getPassword(), "DOCTOR");
        }
        else if (patient != null) {
            ud = getUserDetails(patient.getEmail(), patient.getPassword(), "PATIENT");
        }
        else if (admin != null) {
            ud = getUserDetails(admin.getEmail(), admin.getPassword(), "ADMIN");
        }
        else {
            throw new UsernameNotFoundException("GET OUTTA HERE, SON!");
        }
        return ud;
    }

    public UserDetails getUserDetails(String email, String password, String role) {
        return org.springframework.security.core.userdetails.User.withUsername(email)
                .password(password)
                .authorities(role).build();
    }
}
