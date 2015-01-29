/*
 * Class : CityLawAgency.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:41:55 PM
 * ---------------------------------------------------------------------------
 * Change History
 * Develper :
 * Reviwer :
 * Changed ON :
 * ---------------------------------------------------------------------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugsupplychain.neu.css.model.organization.lawAgencies;

import drugsupplychain.neu.css.model.distributor.CityDistributor;
import drugsupplychain.neu.css.model.distributor.CityDistributorDirectory;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.OrganizationDirectory;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganization;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganizationDirectory;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganization;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganizationDirectory;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganizationDirectory;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganization;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganizationDirectory;
import drugsupplychain.neu.css.model.organization.other.PatientOrganization;
import drugsupplychain.neu.css.model.organization.other.PatientOrganizationDirectory;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganizationDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.lawagency.CityLawAgencyRole;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class CityLawAgency extends LawAgency {
    private final OrganizationDirectory organizationDirectory;
    private final CityDistributorDirectory cityDistributorDirectory;
    private final ClinicOrganizationDirectory clinicOrganizationDirectory;
    private final DispenceryOrganizationDirectory dispenceryOrganizationDirectory;
    private final DoctorOrganizationDirectory doctorOrganizationDirectory;
    private final HospitalOrganizationDirectory hospitalOrganizationDirectory;
    private final PatientOrganizationDirectory patientOrganizationDirectory;
    private final PharmacyOrganizationDirectory pharmacyOrganizationDirectory;
    /**
     * constructor for initialize CityLawAgency
     */
    public CityLawAgency() {
        super(Type.CITY_FDI.getValue());
        this.organizationDirectory = new OrganizationDirectory();
        this.cityDistributorDirectory = new CityDistributorDirectory();
        this.clinicOrganizationDirectory = new ClinicOrganizationDirectory();
        this.dispenceryOrganizationDirectory = new DispenceryOrganizationDirectory();
        this.doctorOrganizationDirectory = new DoctorOrganizationDirectory();
        this.hospitalOrganizationDirectory = new HospitalOrganizationDirectory();
        this.patientOrganizationDirectory = new PatientOrganizationDirectory();
        this.pharmacyOrganizationDirectory = new PharmacyOrganizationDirectory();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public ClinicOrganizationDirectory getClinicOrganizationDirectory() {
        return clinicOrganizationDirectory;
    }

    public DispenceryOrganizationDirectory getDispenceryOrganizationDirectory() {
        return dispenceryOrganizationDirectory;
    }

    public DoctorOrganizationDirectory getDoctorOrganizationDirectory() {
        return doctorOrganizationDirectory;
    }

    public HospitalOrganizationDirectory getHospitalOrganizationDirectory() {
        return hospitalOrganizationDirectory;
    }

    public PatientOrganizationDirectory getPatientOrganizationDirectory() {
        return patientOrganizationDirectory;
    }

    public PharmacyOrganizationDirectory getPharmacyOrganizationDirectory() {
        return pharmacyOrganizationDirectory;
    }
    /**
     * getCityDistributorDirectory
     * @return 
     */
    public CityDistributorDirectory getCityDistributorDirectory() {
        return cityDistributorDirectory;
    }
       
    /**
     * get the Supported Role
     * @return 
     */
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new CityLawAgencyRole());
       return roles;
    }
    /**
     * 
     * @param type
     * @param organization 
     */
    public void addOrganizationToDirectory(Type type,Organization organization) {        
        if (type.getValue().equals(Type.CLINIC.getValue())){
            clinicOrganizationDirectory.addClinicOrganization((ClinicOrganization)organization);
        } else if (type.getValue().equals(Type.DISPENCERY.getValue())){
            dispenceryOrganizationDirectory.addDispenceryOrganization((DispenceryOrganization)organization);
        } else if (type.getValue().equals(Type.DOCTOR.getValue())){
            doctorOrganizationDirectory.addDoctorOrganization((DoctorOrganization)organization);
        } else if (type.getValue().equals(Type.HOSPITAL.getValue())){
            hospitalOrganizationDirectory.addHospitalOrganization((HospitalOrganization)organization);
        } else if (type.getValue().equals(Type.PATIENT.getValue())){
            patientOrganizationDirectory.addPatientOrganization((PatientOrganization)organization);
        } else if (type.getValue().equals(Type.PHARMACY.getValue())){
            pharmacyOrganizationDirectory.addPharmacyOrganization((PharmacyOrganization)organization);
        } else if (type.getValue().equals(Type.CITY_DISTRIBUTOR.getValue())){
            cityDistributorDirectory.addCityDistributor((CityDistributor)organization);
        }
    }
}
