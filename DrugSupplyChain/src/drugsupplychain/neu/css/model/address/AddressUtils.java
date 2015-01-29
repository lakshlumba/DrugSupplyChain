/*
 * Class : AddressUtils.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 18, 2014, 2:48:51 PM
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
package drugsupplychain.neu.css.model.address;

import drugsupplychain.neu.css.util.ImplConst;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class AddressUtils {
    
    
   public static ArrayList<String> getRegion(){
      ArrayList<String> regionList =  new ArrayList<>();
      regionList.add(ImplConst.AFRICA);      
      regionList.add(ImplConst.NORTHAMERICA);
      regionList.add(ImplConst.SOUTHAMERICA);
      regionList.add(ImplConst.EUROPE);
      regionList.add(ImplConst.ASIA);
      regionList.add(ImplConst.AUSTRALIA);
      regionList.add(ImplConst.ANTARTICA);
      return regionList;
   }
   
   public static ArrayList<String> getCountries(String regionName){
      ArrayList<String> countryList =  new ArrayList<>();
      if(regionName.equalsIgnoreCase(ImplConst.AFRICA)){
          countryList.add(ImplConst.SOUTHAFRICA);
      } else if(regionName.equalsIgnoreCase(ImplConst.NORTHAMERICA)){
          countryList.add(ImplConst.USA);
          countryList.add(ImplConst.CANADA);
      } else if(regionName.equalsIgnoreCase(ImplConst.SOUTHAMERICA)){
          countryList.add(ImplConst.BRAZIL);
      } else if(regionName.equalsIgnoreCase(ImplConst.EUROPE)){
          countryList.add(ImplConst.GERMANY);
          countryList.add(ImplConst.FRANCE);
      } else if(regionName.equalsIgnoreCase(ImplConst.ASIA)){
          countryList.add(ImplConst.INDIA);
          countryList.add(ImplConst.CHINA);
      } else if(regionName.equalsIgnoreCase(ImplConst.AUSTRALIA)){
          countryList.add(ImplConst.NEWZEALAND);
      } else if(regionName.equalsIgnoreCase(ImplConst.ANTARTICA)){
          countryList.add(ImplConst.ANTRA);
      }
      return countryList;
   }
   
   public static ArrayList<String> getStates(String countryName){
      ArrayList<String> stateList =  new ArrayList<>();
      if(countryName.equalsIgnoreCase(ImplConst.SOUTHAFRICA)){
          stateList.add(ImplConst.CAPETOWN);
          stateList.add(ImplConst.DURBAN);
      } else if(countryName.equalsIgnoreCase(ImplConst.USA)){
          stateList.add(ImplConst.MA);
          stateList.add(ImplConst.NY);
      } else if(countryName.equalsIgnoreCase(ImplConst.CANADA)){
          stateList.add(ImplConst.TORANTO);
          stateList.add(ImplConst.ONTARIA);
      } else if(countryName.equalsIgnoreCase(ImplConst.BRAZIL)){
          stateList.add(ImplConst.RIODEJINERIO);
          stateList.add(ImplConst.SAUPAULOS);
      } else if(countryName.equalsIgnoreCase(ImplConst.GERMANY)){
          stateList.add(ImplConst.BERLIN);
          stateList.add(ImplConst.HAMBURG);
      } else if(countryName.equalsIgnoreCase(ImplConst.FRANCE)){
          stateList.add(ImplConst.PARIS);
      } else if(countryName.equalsIgnoreCase(ImplConst.INDIA)){
          stateList.add(ImplConst.DELHI);
          stateList.add(ImplConst.MUMBAI);
      } else if(countryName.equalsIgnoreCase(ImplConst.CHINA)){
          stateList.add(ImplConst.CHENGDU);
          stateList.add(ImplConst.BEIJING);
      } else if(countryName.equalsIgnoreCase(ImplConst.NEWZEALAND)){
          stateList.add(ImplConst.AUKLAND);
          stateList.add(ImplConst.NORTHLAND);
      } else if(countryName.equalsIgnoreCase(ImplConst.ANTRA)){
          stateList.add(ImplConst.MCMORDO);
      }
      return stateList;    
   }
   /**
    * get the list of cities according to the  state name 
    * @param stateName
    * @return 
    */
   public static ArrayList<String> getCities(String stateName){
      ArrayList<String> cityList =  new ArrayList<>();
      if(stateName.equalsIgnoreCase(ImplConst.CAPETOWN)){
          cityList.add(ImplConst.CAPETOWN_CITY1);
          cityList.add(ImplConst.CAPETOWN_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.DURBAN)){
          cityList.add(ImplConst.DURBAN_CITY1);
          cityList.add(ImplConst.DURBAN_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.MA)){
          cityList.add(ImplConst.MA_CITY1);
          cityList.add(ImplConst.MA_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.NY)){
          cityList.add(ImplConst.NY_CITY1);
          cityList.add(ImplConst.NY_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.TORANTO)){
          cityList.add(ImplConst.TORANTO_CITY1);
          cityList.add(ImplConst.TORANTO_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.ONTARIA)){
          cityList.add(ImplConst.ONTARIA_CITY1);
          cityList.add(ImplConst.ONTARIA_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.RIODEJINERIO)){
          cityList.add(ImplConst.RIODEJINERIO_CITY1);
          cityList.add(ImplConst.RIODEJINERIO_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.SAUPAULOS)){
          cityList.add(ImplConst.SAUPAULOS_CITY1);
          cityList.add(ImplConst.SAUPAULOS_CITY1);
      } else if(stateName.equalsIgnoreCase(ImplConst.BERLIN)){
          cityList.add(ImplConst.BERLIN_CITY1);
          cityList.add(ImplConst.BERLIN_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.HAMBURG)){
          cityList.add(ImplConst.HAMBURG_CITY1);
          cityList.add(ImplConst.HAMBURG_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.PARIS)){
          cityList.add(ImplConst.PARIS_CITY1);
          cityList.add(ImplConst.PARIS_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.DELHI)){
          cityList.add(ImplConst.DELHI_CITY1);
          cityList.add(ImplConst.DELHI_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.MUMBAI)){
          cityList.add(ImplConst.MUMBAI_CITY1);
          cityList.add(ImplConst.MUMBAI_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.CHENGDU)){
          cityList.add(ImplConst.CHENGDU_CITY1);
          cityList.add(ImplConst.CHENGDU_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.BEIJING)){
          cityList.add(ImplConst.BEIJING_CITY1);
          cityList.add(ImplConst.BEIJING_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.AUKLAND)){
          cityList.add(ImplConst.AUKLAND_CITY1);
          cityList.add(ImplConst.AUKLAND_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.NORTHLAND)){
          cityList.add(ImplConst.NORTHLAND_CITY1);
          cityList.add(ImplConst.NORTHLAND_CITY2);
      } else if(stateName.equalsIgnoreCase(ImplConst.MCMORDO)){
          cityList.add(ImplConst.MCMORDO_CITY1);
          cityList.add(ImplConst.MCMORDO_CITY2);
      }
      return cityList;
   }
}
