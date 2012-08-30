package lab1;

import java.util.Date;

/**
 * In this lab your challenge is to fix the code in both classes to use
 * proper encapsulation and the four other best practices as explained by 
 * your instructor.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.01
 * 
 * 
 * Kyle Raymond was here
 */
public class Employee 
{
    private String firstName;
    private String lastName;
    private String ssn;
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;

    public Employee(String fname, String lname, String ssnid) 
    {
        setFirstName(fname);
        setLastName(lname);
        setSocialSecurityNumber(ssnid);
        //setBirthDate(bday);
    }

    
    //acessor and mutator methods
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String name)
    {
        firstName = name;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String name)
    {
        lastName = name;
    }
    
    public String getSocialSecurityNumber()
    {
        return ssn;
    }
    
    public void setSocialSecurityNumber(String pin)
    {
        ssn = pin;
    }
    
    public Date getBirthDate()
    {
        return birthDate;
    }
    
    public void setBirthDate(Date day)
    {
        birthDate = day;
    }
    
    public Boolean getHR()
    {
        return metWithHr;
    }
    
    public void setHR(boolean anwser)
    {
        metWithHr = anwser;
    }
    
    public Boolean getStaff()
    {
        return metDeptStaff;
    }
    
    public void setStaff(boolean anwser)
    {
        metDeptStaff = anwser;
    }
    
    public Boolean getPolicy()
    {
        return reviewedDeptPolicies;
    }
    
    public void setPolicy(boolean anwser)
    {
        reviewedDeptPolicies = anwser;
    }
    
    public Boolean getMoves()
    {
        return movedIn;
    }
    
    public void setMoves(boolean anwser)
    {
        movedIn = anwser;
    }
    
    public String getCube()
    {
        return cubeId;
    }
    
    public void setCube(String id)
    {
        cubeId = id;
    }
    
    
    public String goForIt(String id)
    {
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(id);
        return getStatus();
    }
    
    
    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalryInfo() 
    {
        setHR(true);
    }

    // Assume this is must be performed second
    private void meetDepartmentStaff() 
    {
        if(getHR()) 
        {
            setStaff(true);
        } 
        else 
        {
            throw new IllegalStateException("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies() 
    {
        if(getHR() && getStaff()) 
        {
            setStaff(true);
        } 
        else 
        {
            throw new IllegalStateException("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    private void moveIntoCubicle(String cubeId) //also, figure out how to properly set cubeId
    {
        if(getHR() && getStaff() && getPolicy()) 
        {
            setCube(cubeId);
            setMoves(true);
        } 
        else 
        {
            throw new IllegalStateException("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }

    }

    private String getStatus() 
    {
        if(getHR() && getStaff()
           && getPolicy() && getMoves()) 
        {
            return "Orientation is complete";
        } 
        else 
        {
            return "Orientation in progress...";
        }
    }
}
