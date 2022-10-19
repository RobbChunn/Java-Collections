package com.cooksys.ftd.assignments.collections.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TODO: Implement this class
 *  <br><br>
 *  A manager is a type of employee that can be a superior to another employee.
 *  <br>
 *  A manager should have a name, and, optionally, a manager superior to them.
 */
public class Manager implements Employee {

    // TODO: Does this class need private fields? If so, add them here
private Manager manager;
private String name;
/**
     * TODO: Implement this constructor.
     *
     * @param name the name of the manager to be created
     */
    public Manager(String name) {
        this.name = name;
    }



    /**
     *  TODO: Implement this constructor.
     *
     * @param name the name of the manager to be created
     * @param manager the direct manager of the manager to be created
     */
    public Manager(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }


    /**
     * TODO: Implement this getter.
     *
     * @return the name of the manager
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return {@code true} if this manager has a manager, or {@code false} otherwise
     */
    @Override
    public boolean hasManager() {
       if(manager == null){
           return false;
       }else{
           return true;
       }

    }

    /**
     * TODO: Implement this getter.
     *
     * @return the manager of this manager, or {@code null} if it has none
     */
    @Override
    public Manager getManager() {
        return this.manager;

    }

    /**
     * TODO: Implement this method.
     *  <br><br>
     *  Retrieves the manager's chain of command as a {@code List<Manager>}, starting with their direct {@code Manager},
     *  followed by that {@code Manager}'s {@code Manager}, and so on, until the top of the hierarchy is reached.
     *  <br><br>
     *  The returned list should never be or contain {@code null}.
     *  <br><br>
     *  If the manager does not have a {@code Manager}, an empty
     *  {@code List<Manager>} should be returned.
     *
     * @return a {@code List<Manager>} that represents the manager's chain of command,
     */
    @Override
    public List<Manager> getChainOfCommand() {
        ArrayList ManagerChain = new ArrayList();
       Manager currentManager = this.manager;
        while(currentManager != null){
            //add the manager to the list you fucking idiot
            ManagerChain.add(currentManager);
            currentManager = currentManager.getManager();
        }
        return ManagerChain;
    }

    // TODO: Does this class need custom .equals() and .hashcode() methods? If so, implement them here.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager1 = (Manager) o;
        return Objects.equals(manager, manager1.manager) && Objects.equals(name, manager1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager, name);
    }

    // TODO [OPTIONAL]: Consider adding a custom .toString() method here if you want to debug your code with System.out.println() statements

}
