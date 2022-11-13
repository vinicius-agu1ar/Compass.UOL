package br.com.api.states.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegionValidator implements ConstraintValidator<Region, String>{

    @Override
    public boolean isValid(String nomeRegion, ConstraintValidatorContext cValidatorContext) {
        if(nomeRegion == null){
            return false;
        } 
        if (nomeRegion.equalsIgnoreCase("Norte")){
            return true;
        } else if(nomeRegion.equalsIgnoreCase("Nordeste")){
            return true;
        } else if(nomeRegion.equalsIgnoreCase("Centro-Oeste")){
            return true;
        } else if(nomeRegion.equalsIgnoreCase("Sul")){
            return true;
        } else if(nomeRegion.equalsIgnoreCase("Sudeste")){
            return true;
        } else {
            return false;
        }

    }

}
