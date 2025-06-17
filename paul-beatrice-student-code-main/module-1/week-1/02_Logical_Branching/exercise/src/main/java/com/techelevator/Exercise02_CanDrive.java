package com.techelevator;

import com.techelevator.testing.TestingLibrary;

import java.net.PasswordAuthentication;

public class Exercise02_CanDrive {

    /*
    The problems below ask you to implement the correct logic to answer
    whether someone is allowed to drive based on the provided parameters.
    NOTE: These rules are loosely based off of the real world
    and may be different from the state you live in.
     */

    /*
    A person can drive if they have a permit and are with a licensed passenger.
    Given two boolean values, hasPermit and withLicensedPassenger,
    write an expression that is true if a person can drive.

    Examples:
    canDrive(true, true) ➔ true
    canDrive(true, false) ➔ false
    canDrive(false, true) ➔ false
    canDrive(false, false) ➔ false
     */
    public boolean canDrive(boolean hasPermit, boolean withLicensedPassenger) {
        // hasPermit is true, withLicensedPassenger is true
        if (hasPermit && withLicensedPassenger) {
            return true;
        }
        // either hasPermit is true or withLicensedPassenger is true, but not both are true
        if (hasPermit && !withLicensedPassenger) {
            return false;
        }
        if (!hasPermit && withLicensedPassenger) {
            return false;
        }
        if (!hasPermit && !withLicensedPassenger) {
            return false;
        }
        return false;
    }

    /*
    In some states, the licensed passenger must be of a certain age.
    Implement the logic to return true if the person has a permit and is with a licensed passenger who is 21 or over.

    Examples:
    canDrive(true, true, 22) ➔ true
    canDrive(true, true, 19) ➔ false
    canDrive(false, true, 23) ➔ false
     */
    public boolean canDrive(boolean hasPermit, boolean withLicensedPassenger, int passengerAge) {
        // hasPermit is true, withLicensedPassenger is true, passengerAge GTE 21
        if (hasPermit && withLicensedPassenger && passengerAge >= 21) {
            return true;
        }
        // hasPermit is true, withLicensedPassenger is true, passengerAge LT 21
        if (hasPermit && withLicensedPassenger && passengerAge < 21) {
            return false;
        }
        // either hasPermit is true or withLicensedPassenger is true, but not both are true, passengerAge irrelevant
        if (!hasPermit && withLicensedPassenger && passengerAge < 21 || passengerAge > 21) {
            return false;
        }
        if (hasPermit && !withLicensedPassenger && passengerAge < 21 || passengerAge > 21) {
            return false;
        }
        if (!hasPermit && !withLicensedPassenger && passengerAge < 21 || passengerAge > 21) {
            return false;
        }
        return false;
    }

    /*
    If the licensed passenger is the driver's legal guardian, they only have to be 18 instead of 21.
    Implement the logic to return true if the person has a permit and is with a licensed passenger.
    The licensed passenger only needs to be 18 or older if they're the driver's guardian. Otherwise, the passenger must be 21 or older.

    Examples:
    canDrive(true, true, 22, false) ➔ true
    canDrive(true, true, 19, true) ➔ true
    canDrive(false, true, 23, true) ➔ false
     */
    public boolean canDrive(boolean hasPermit, boolean withLicensedPassenger, int passengerAge, boolean isPassengerOurGuardian) {
        // hasPermit is true, withLicensedPassenger is true, passengerAge GTE 21
        if (hasPermit && withLicensedPassenger && passengerAge >= 21) {
            return true;
        }
        // hasPermit is true, withLicensedPassenger is true, passengerAge GTE 18 and LTE 20, isPassengerOurGuardian is true
        if (hasPermit && withLicensedPassenger && ((passengerAge >=18) && (passengerAge <=20)) && isPassengerOurGuardian) {
            return true;
        }
        // hasPermit is true, withLicensedPassenger is true, passengerAge GTE 18 and LTE 20, isPassengerOurGuardian is false
        if (hasPermit && withLicensedPassenger && ((passengerAge >=18) && (passengerAge <=20)) && !isPassengerOurGuardian) {
            return false;
        }
        // hasPermit is true, withLicensedPassenger is true, passengerAge LTE 18, isPassengerOurGuardian is false
        if (hasPermit && withLicensedPassenger && (passengerAge <18) && !isPassengerOurGuardian) {
            return false;
        }
        return false;

    }
}
