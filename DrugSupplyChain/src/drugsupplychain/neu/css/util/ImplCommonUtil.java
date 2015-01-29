/*
 * Class : ImplCommonUtil.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 1:58:07 AM
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
package drugsupplychain.neu.css.util;

import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.distributor.CityDistributorRole;
import drugsupplychain.neu.css.model.role.distributor.NationalDistributorRole;
import drugsupplychain.neu.css.model.role.distributor.RegionalDistributorRole;
import drugsupplychain.neu.css.model.role.distributor.StateDistributorRole;
import drugsupplychain.neu.css.model.role.lawagency.CityLawAgencyRole;
import drugsupplychain.neu.css.model.role.lawagency.NationalLawAgencyRole;
import drugsupplychain.neu.css.model.role.lawagency.RegionalLawAgencyRole;
import drugsupplychain.neu.css.model.role.lawagency.StateLawAgencyRole;
import drugsupplychain.neu.css.model.role.other.ClinicRole;
import drugsupplychain.neu.css.model.role.other.DispenceryRole;
import drugsupplychain.neu.css.model.role.other.DoctorRole;
import drugsupplychain.neu.css.model.role.other.HospitalRole;
import drugsupplychain.neu.css.model.role.other.PatientRole;
import drugsupplychain.neu.css.model.role.other.PharmacyRole;
import drugsupplychain.neu.css.model.role.pharma.InterPharmaceuticalCompanyRole;
import drugsupplychain.neu.css.model.role.pharma.NationalPharmaceuticalCompanyRole;
import drugsupplychain.neu.css.model.role.pharma.RegionalPharmaceuticalCompanyRole;
import drugsupplychain.neu.css.model.role.pharma.StatePharmaceuticalCompanyRole;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Laksh
 */
public final class ImplCommonUtil {
    
    private static int number = 1000;
    private static int caseNumber = 100;
    private static ArrayList<String> usernamesList = new ArrayList<String>();
    /**
     * generate the License Number
     * @param name
     * @return 
     */
    public static String generateLicencseNumber(String name) {
        number++;
        String lisenceNumber = null;
        if (null != name){ 
            switch(name){
                case ImplConst.CITY_DISTRIBUTOR:
                     lisenceNumber = ImplConst.CDR + String.valueOf(number);
                     break;

                case ImplConst.STATE_DISTRIBUTOR:
                     lisenceNumber = ImplConst.SDR + String.valueOf(number);
                     break;

                case ImplConst.NATIONAL_DISTRIBUTOR:
                     lisenceNumber = ImplConst.NDR + String.valueOf(number);
                     break;

                case ImplConst.REGIONAL_DISTRIBUTOR:
                     lisenceNumber = ImplConst.RDR + String.valueOf(number);
                     break;

                case ImplConst.CITY_PHARMA_CO:
                     lisenceNumber = ImplConst.CPC + String.valueOf(number);
                     break;

                case ImplConst.STATE_PHARMA_CO:
                     lisenceNumber = ImplConst.SPC + String.valueOf(number);
                     break;

                case ImplConst.NATIONAL_PHARMA_CO:
                     lisenceNumber = ImplConst.NPC + String.valueOf(number);
                     break;

                case ImplConst.REGIONAL_PHARMA_CO:
                     lisenceNumber = ImplConst.RPC + String.valueOf(number);
                     break;

                case ImplConst.INTER_PHARMA_CO:
                     lisenceNumber = ImplConst.IPC + String.valueOf(number);
                     break; 

                case ImplConst.CITY_FDI:
                     lisenceNumber = ImplConst.C_FDI + String.valueOf(number);
                     break;

                case ImplConst.STATE_FDI:
                     lisenceNumber = ImplConst.S_FDI + String.valueOf(number);
                     break;

                case ImplConst.NATIONAL_FDI:
                     lisenceNumber = ImplConst.N_FDI + String.valueOf(number);
                     break;

                case ImplConst.REGIONAL_FDI:
                     lisenceNumber = ImplConst.R_FDI + String.valueOf(number);
                     break;

                case ImplConst.PHARMACY:
                     lisenceNumber = ImplConst.PH + String.valueOf(number);
                     break;

                case ImplConst.HOSPITAL:
                     lisenceNumber = ImplConst.HOS + String.valueOf(number);
                     break;

                case ImplConst.CLINIC:
                     lisenceNumber = ImplConst.CL + String.valueOf(number);
                     break;

                case ImplConst.DISPENCERY:
                     lisenceNumber = ImplConst.DI + String.valueOf(number);
                     break;

                case ImplConst.DOCTOR:
                     lisenceNumber = ImplConst.DO + String.valueOf(number);
                     break;

                case ImplConst.LABORTARY:
                     lisenceNumber = ImplConst.LAB + String.valueOf(number);
                     break;
                    
                case ImplConst.MEDICINE:
                     lisenceNumber = ImplConst.MED + String.valueOf(number);
                     break;
                
                default:
                       break;             

            } 
        }   
        return lisenceNumber;
    }
    /**
     * generate case number
     * @param authority
     * @return 
     */
    public static String generateCaseNumber(String authority) {
        caseNumber++;
        String caseID = null;
        switch(authority){
            case ImplConst.CITY_FDI:
                 caseID = ImplConst.CASE_YEAR + ImplConst.C_FDI + String.valueOf(caseNumber);
                 break;
                
            case ImplConst.STATE_FDI:
                 caseID =  ImplConst.CASE_YEAR + ImplConst.S_FDI + String.valueOf(caseNumber);
                 break;
             
            case ImplConst.NATIONAL_FDI:
                 caseID = ImplConst.CASE_YEAR + ImplConst.N_FDI + String.valueOf(caseNumber);
                 break;
             
            case ImplConst.REGIONAL_FDI:
                 caseID = ImplConst.CASE_YEAR + ImplConst.R_FDI + String.valueOf(caseNumber);
                 break;         
            
            default:
                   break;             
        }    
        return caseID;
    }
    
    /**
     * check if username exist in the list
     * @param username
     * @return 
     */
    public static boolean isUserNameExist(String username){
        return usernamesList.contains(username);
    }
    /**
     * add user name to the list
     * @param username 
     */
    public static void updateUserNameList(String username){
        usernamesList.add(username);
    }
    /**
     * get the todays date
     * @return 
     */
    public static String getTodaysDate(){        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ImplConst.SIMPLE_DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        return simpleDateFormat.format(calendar.getTime());
    }
    
    /**
     * get the String date
     * @param calendar
     * @return 
     */
    public static String getFormattedDate(Calendar calendar){        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ImplConst.SIMPLE_DATE_FORMAT);
        return simpleDateFormat.format(calendar.getTime());
    }
    /**
     * get the String date
     * @param date
     * @return 
     */
    public static String getFormattedDate(Date date){        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ImplConst.SIMPLE_DATE_FORMAT);
        return simpleDateFormat.format(date);
    }
    
    /**
     * get the todays date
     * @return 
     */
    public static Date getTodaysDateBYDATE(){        
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
    
    /**
     * get the priority value
     * @param priorityIndicator
     * @return 
     */
    public static String getPriorityValue(int priorityIndicator){
        String priority = ImplConst.PRIORITY_LOW;       
        if(priorityIndicator >= 0 && priorityIndicator < 25 ){
            priority = ImplConst.PRIORITY_LOW;
        } else if(priorityIndicator >= 25 && priorityIndicator < 50){
            priority = ImplConst.PRIORITY_MEDIUM;
        } else if(priorityIndicator >= 50 && priorityIndicator < 75){
            priority = ImplConst.PRIORITY_HIGH;
        } else if(priorityIndicator == 75){
            priority = ImplConst.PRIORITY_CRITICAL;
        }
        return priority;
    }
    /**
     * 
     * @param type
     * @return 
     */
    public static Role getOrganizationRole(Type type){
        if (type.getValue().equals(Type.CLINIC.getValue())){
           return (new ClinicRole());
        } else if (type.getValue().equals(Type.DISPENCERY.getValue())){
           return (new DispenceryRole());
        } else if (type.getValue().equals(Type.DOCTOR.getValue())){
           return (new DoctorRole());
        } else if (type.getValue().equals(Type.HOSPITAL.getValue())){
           return (new HospitalRole());
        } else if (type.getValue().equals(Type.PATIENT.getValue())){
           return (new PatientRole());
        } else if (type.getValue().equals(Type.PHARMACY.getValue())){
           return (new PharmacyRole());
        } else if (type.getValue().equals(Type.CITY_DISTRIBUTOR.getValue())){
           return (new CityDistributorRole());
        } else if (type.getValue().equals(Type.STATE_DISTRIBUTOR.getValue())){
           return (new StateDistributorRole());
        } else if (type.getValue().equals(Type.NATIONAL_DISTRIBUTOR.getValue())){
           return (new NationalDistributorRole());
        } else if (type.getValue().equals(Type.REGIONAL_DISTRIBUTOR.getValue())){
           return (new RegionalDistributorRole());
        } else if (type.getValue().equals(Type.STATE_PHARMA_CO.getValue())){
           return (new StatePharmaceuticalCompanyRole());
        } else if (type.getValue().equals(Type.NATIONAL_PHARMA_CO.getValue())){
           return (new NationalPharmaceuticalCompanyRole());
        } else if (type.getValue().equals(Type.REGIONAL_PHARMA_CO.getValue())){
           return (new RegionalPharmaceuticalCompanyRole());
        } else if (type.getValue().equals(Type.INTER_PHARMA_CO.getValue())){
           return (new InterPharmaceuticalCompanyRole());
        } else if (type.getValue().equals(Type.CITY_FDI.getValue())){
           return (new CityLawAgencyRole());
        } else if (type.getValue().equals(Type.STATE_FDI.getValue())){
           return (new StateLawAgencyRole());
        } else if (type.getValue().equals(Type.NATIONAL_FDI.getValue())){
           return (new NationalLawAgencyRole());
        } else if (type.getValue().equals(Type.REGIONAL_FDI.getValue())){
           return (new RegionalLawAgencyRole());
        }         
        return null;
    }
    
}
